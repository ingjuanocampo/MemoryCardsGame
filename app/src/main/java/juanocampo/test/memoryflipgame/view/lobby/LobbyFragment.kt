package juanocampo.test.memoryflipgame.view.lobby

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.presentation.entities.GameOptionViewType
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.OptionError
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.OptionSaved
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.OptionsLoaded
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.LobbyViewModel
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.factory.LobbyViewModelFactory
import juanocampo.test.memoryflipgame.view.base.fragment.BaseFragment
import juanocampo.test.memoryflipgame.view.game.MemoryGameActivity
import juanocampo.test.memoryflipgame.view.lobby.adapter.LobbyAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class LobbyFragment : BaseFragment() {

    companion object {
        fun newInstance() = LobbyFragment()
    }

    @Inject
    lateinit var mainViewModelFactory: LobbyViewModelFactory

    private lateinit var viewModel: LobbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, mainViewModelFactory).get(LobbyViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSettings.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = LobbyAdapter { onSettingSelected(it) }
        rvSettings.adapter = adapter

        viewModel.lobbyScreenStatusLiveData.observe(
            this,
            Observer {
                when(it) {
                    is OptionsLoaded -> {
                        adapter.addItems(it.options)
                    }
                    is OptionSaved -> {
                        startActivity(Intent(requireContext(), MemoryGameActivity::class.java))
                    }
                    is OptionError -> {
                        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }

            })

        viewModel.loadOptions()
    }

    private fun onSettingSelected(gameOption: GameOptionViewType) {
        viewModel.saveOption(gameOption.id)
    }


}
