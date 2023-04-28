package com.example.scorer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.Scorer.R
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.GameDao
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class StartFragment : Fragment() {


    private lateinit var gameDao: GameDao
    private lateinit var appDatabase: AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_start, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDatabase = AppDataBase.getDatabase(requireContext())
        gameDao = appDatabase.gameDao()

        val savedGames = gameDao.getAllGames()

        view.findViewById<MaterialButton>(R.id.btn_continue).setOnClickListener{
            if(savedGames.isNotEmpty()){
                findNavController().navigate(R.id.action_startFragment_to_mainFragment)
            }else{
                findNavController().navigate(R.id.action_startFragment_to_settingFragment)
            }
        }

        view.findViewById<MaterialButton>(R.id.btn_start).setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_settingFragment)
        }


    }

}