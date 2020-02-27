package juanocampo.test.memoryflipgame.view.game

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType
import juanocampo.test.memoryflipgame.presentation.viewmodel.*
import juanocampo.test.memoryflipgame.presentation.viewmodel.game.GameViewModel
import juanocampo.test.memoryflipgame.presentation.viewmodel.game.factory.GameViewModelFactory
import juanocampo.test.memoryflipgame.view.base.activity.BaseActivity
import juanocampo.test.memoryflipgame.view.game.adapter.GameCardAdapter
import kotlinx.android.synthetic.main.game_activity.*
import javax.inject.Inject

class MemoryGameActivity: BaseActivity() {

    private lateinit var adapter: GameCardAdapter
    private lateinit var viewModel: GameViewModel

    @Inject
    lateinit var gameViewModelFactory: GameViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        viewModel = ViewModelProviders.of(this, gameViewModelFactory).get(GameViewModel::class.java)

        recyclerGameCards.layoutManager = GridLayoutManager(this, 2)

        adapter = GameCardAdapter { onSelectedGameCard(it) }

        recyclerGameCards.adapter = adapter

        viewModel.gameScreenStatusLiveData.observe(this, Observer {
            when(it) {
                is GameLoaded -> {
                    adapter.addItems(it.gameList)
                }
                is WonGameScreen -> { }
                is MatchScreen -> { }
                is NonMatchScreen -> {

                }
                else  -> { }
             }
        })

        viewModel.loadGame()

    }

    private fun onSelectedGameCard(gameCardViewType: GameCardViewType) {
        viewModel.flipCard(adapter.items.indexOf(gameCardViewType))
    }


}