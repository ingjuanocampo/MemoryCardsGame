package juanocampo.test.memoryflipgame.view.game

import android.os.Bundle
import android.widget.Toast
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

class MemoryGameActivity : BaseActivity() {

    private lateinit var adapter: GameCardAdapter
    private lateinit var viewModel: GameViewModel

    @Inject
    lateinit var gameViewModelFactory: GameViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        viewModel = ViewModelProviders.of(this, gameViewModelFactory).get(GameViewModel::class.java)

        adapter = GameCardAdapter { onSelectedGameCard(it) }

        recyclerGameCards.adapter = adapter

        viewModel.gameScreenStatusLiveData.observe(this, Observer {
            when (it) {
                is GameLoaded -> {
                    val manager = GridLayoutManager(baseContext, it.grid.first)
                    recyclerGameCards.layoutManager = manager
                    adapter.addItems(it.gameList)
                }
                is WonGameScreen -> {
                    Toast.makeText(baseContext, "Won the game!", Toast.LENGTH_SHORT).show()
                    viewModel.clearGame()
                }
                is MatchScreen -> {
                    adapter.addItems(it.gameList)
                }
                is NonMatchScreen -> {
                    adapter.addItems(it.gameList)
                }
                is FlipedScreen -> adapter.addItems(it.gameList)
                is GameEndScreen -> finish()
                else -> {
                    Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.loadGame()

    }

    private fun onSelectedGameCard(gameCardViewType: GameCardViewType) {
        adapter.items.removeAt(gameCardViewType.index)
        gameCardViewType.isRevealed = true
        adapter.items.add(gameCardViewType.index, gameCardViewType)
        adapter.notifyItemChanged(gameCardViewType.index)
        viewModel.flipCard(gameCardViewType.index)
    }
}