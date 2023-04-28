package com.example.scorer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Scorer.R
import com.example.scorer.SharedDatas
import com.example.scorer.adapters.ChaptersAdapter
import com.example.scorer.adapters.GameAdapter
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.Chapters
import com.example.scorer.database.ChaptersDao


class ChaptersFragment : Fragment() {

    lateinit var appDataBase: AppDataBase
    lateinit var chaptersDao: ChaptersDao
    lateinit var chaptersHash: HashMap<Int, Chapters>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDataBase = AppDataBase.getDatabase(requireContext())
        chaptersDao = appDataBase.chapterDao()

        var chapters = chaptersDao.getChapterByGame(SharedDatas.game.id)

        chaptersHash = HashMap()
        for (chapter in chapters){
            chaptersHash.put(chapter.chap_number,chapter)
        }


        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)

        val chapterAdapter = ChaptersAdapter(requireContext(),chaptersHash)

        recyclerView.adapter = chapterAdapter


        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)


    }

}