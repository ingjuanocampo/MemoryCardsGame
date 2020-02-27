package juanocampo.test.memoryflipgame.view.game.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType
import juanocampo.test.memoryflipgame.view.base.delegate.DelegateAdapter

class GameCardDelegateAdapter(private val onGameCardSelected: (GameCardViewType)-> Unit): DelegateAdapter<GameCardDelegateAdapter.ViewHolder, GameCardViewType> {


    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(parent, onGameCardSelected)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, viewType: GameCardViewType) {
        viewHolder.bind(viewType)
    }

    class ViewHolder(
        viewGroup: ViewGroup, private val onGameCardSelected: (GameCardViewType)-> Unit
    ) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.game_card_item,
                viewGroup,
                false
            )
        ) {

        val cardImage: ImageView = itemView.findViewById(R.id.cardImage)

        fun bind(gameOptionViewType: GameCardViewType) {
            cardImage.setImageResource(gameOptionViewType.getImageResource())
            itemView.setOnClickListener {
                onGameCardSelected(gameOptionViewType)
            }
        }

    }
}