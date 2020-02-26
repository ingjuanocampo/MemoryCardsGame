package juanocampo.test.memoryflipgame.view.lobby.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.presentation.entities.GameOptionViewType
import juanocampo.test.memoryflipgame.view.base.delegate.DelegateAdapter

class LobbyDelegateAdapter(private val onGameSettingSelected: (GameOptionViewType)-> Unit): DelegateAdapter<LobbyDelegateAdapter.ViewHolder, GameOptionViewType> {


    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(parent, onGameSettingSelected)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, viewType: GameOptionViewType) {
        viewHolder.bind(viewType)
    }

    class ViewHolder(
        viewGroup: ViewGroup, private val onGameSettingSelected: (GameOptionViewType)-> Unit
    ) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.lobby_setting_item,
                viewGroup,
                false
            )
        ) {

        private val settingsTitleItem: TextView = itemView.findViewById(R.id.settingsTitleItem)

        fun bind(gameOptionViewType: GameOptionViewType) {
            settingsTitleItem.text = gameOptionViewType.description
            itemView.setOnClickListener {
                onGameSettingSelected(gameOptionViewType)
            }
        }

    }
}