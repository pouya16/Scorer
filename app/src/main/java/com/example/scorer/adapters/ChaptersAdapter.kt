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
import com.example.scorer.database.Chapters
import com.example.scorer.database.Game
import com.google.android.material.card.MaterialCardView
class ChaptersAdapter(private val context: Context, chaptersList: HashMap<Int,Chapters>):
    RecyclerView.Adapter<ChaptersAdapter.ChaptersViewHolder>() {

    val chapters = chaptersList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_chapters_card, parent, false)
        return ChaptersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {
        holder.txtLevel.text = (position + 1).toString()
        var progress = 0
        if(chapters.containsKey((position+1))){
            progress = chapters.get((position+1))!!.current_level
        }
        holder.txtProgress.text = "$progress %"
        holder.mainCard.setOnClickListener{
            if(chapters.containsKey((position+1))){
                SharedDatas.chapter = chapters.get((position + 1))!!
            }else{
                val chaptersDao = AppDataBase.getDatabase(context).chapterDao()
                val chapter = Chapters(0,SharedDatas.game.id,(position + 1),100,1)
                SharedDatas.chapter = chapter
                chapters.put(chapter.chap_number,chapter)
                chaptersDao.insert(chapter)
            }
            holder.mainCard.findNavController().navigate(R.id.action_chaptersFragment_to_gamesFragment)
        }

    }

    override fun getItemCount(): Int {
        return SharedDatas.chapters
    }


    inner class ChaptersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtLevel: TextView = itemView.findViewById(R.id.txt_level)
        val txtProgress: TextView = itemView.findViewById(R.id.txt_progress)
        val mainCard: MaterialCardView = itemView.findViewById(R.id.main_card)

    }
}