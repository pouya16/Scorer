package com.example.scorer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Scorer.R
import com.example.scorer.adapters.GameAdapter
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.Game

class MainFragment : Fragment() {


    private lateinit var gameAdapter: GameAdapter
    private lateinit var gameList: List<Game>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  =  inflater.inflate(R.layout.fragment_main, container, false)


        // Set up the RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)

        // Load the game data from the database and update the RecyclerView
        gameList = AppDataBase.getDatabase(requireContext()).gameDao().getAllGames()
        gameAdapter = GameAdapter(requireContext(),gameList)
        recyclerView.adapter = gameAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        return  view
    }

}