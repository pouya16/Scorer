package com.example.scorer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.Scorer.R
import com.example.scorer.SharedDatas
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.Game
import com.google.android.material.card.MaterialCardView

class GameAdapter(private val context: Context,gameLists: List<Game>):
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    var gameList = gameLists

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_games_card, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gameList[position]
        holder.bind(game)
        holder.mainCard.setOnClickListener{
            SharedDatas.game = game
            SharedDatas.insertGameData(game)
            holder.mainCard.findNavController().navigate(R.id.action_mainFragment_to_chaptersFragment)

        }

        holder.deleteBtn.setOnClickListener{
            AppDataBase.getDatabase(context).gameDao().delete(game)
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }


    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.game_name)
        private val scoreTextView: TextView = itemView.findViewById(R.id.game_score)
        val deleteBtn: ImageButton = itemView.findViewById(R.id.btn_delete)
        val mainCard: MaterialCardView = itemView.findViewById(R.id.main_card)

        fun bind(game: Game) {
            nameTextView.text = game.name
            scoreTextView.text = game.b_var.toString()
        }
    }
}