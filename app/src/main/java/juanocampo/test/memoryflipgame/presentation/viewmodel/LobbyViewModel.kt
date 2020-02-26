package juanocampo.test.memoryflipgame.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import juanocampo.test.domain.state.SuccessState
import juanocampo.test.domain.usecase.LoadOptionUseCase
import juanocampo.test.domain.usecase.SaveSelectedGameOptionUseCase
import juanocampo.test.memoryflipgame.presentation.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class LobbyViewModel(private val loadOptionUseCase: LoadOptionUseCase,
                     private val saveSelectedGameOptionUseCase: SaveSelectedGameOptionUseCase): ViewModel(),
    CoroutineScope {

    private val job: Job = Job()

    val lobbyScreenStatusLiveData = MutableLiveData<LobbyScreenStatus>()

    fun loadOptions() = launch {
         when(val optionsResult = loadOptionUseCase()) {
             is SuccessState -> {
                 val mapped = optionsResult.data.map {
                     GameOptionViewType("${it.gridOption.first} x ${it.gridOption.second}", it.id) }
                 lobbyScreenStatusLiveData.postValue(OptionsLoaded(mapped))
             }
             else -> {
                 lobbyScreenStatusLiveData.postValue(OptionError)
             }
         }
    }

    fun saveOption(selectedOptionId: Int) = launch {
        saveSelectedGameOptionUseCase(selectedOptionId)
        lobbyScreenStatusLiveData.postValue(OptionSaved)
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}