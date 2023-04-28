package com.example.scorer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.Scorer.R
import com.example.scorer.SharedDatas
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.Game
import com.example.scorer.database.GameDao
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class SettingFragment : Fragment() {

    var i = 0
    lateinit var appDataBase: AppDataBase
    lateinit var gameDao: GameDao
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDataBase = AppDataBase.getDatabase(requireContext())
        gameDao = appDataBase.gameDao()

        val textInputLayoutName = view.findViewById<TextInputLayout>(R.id.textInputLayoutName)
        val editTextName = textInputLayoutName.editText


        val textInputLayoutBVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutBVar)
        val editTextBVar = textInputLayoutBVar.editText

        val textInputLayoutRVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutRVar)
        val editTextRVar = textInputLayoutRVar.editText

        val textInputLayoutSVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutSVar)
        val editTextSVar = textInputLayoutSVar.editText

        val textInputLayoutTVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutTVar)
        val editTextTVar = textInputLayoutTVar.editText

        val textInputLayoutZVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutZVar)
        val editTextZVar = textInputLayoutTVar.editText

        val textInputLayoutBackVar = view.findViewById<TextInputLayout>(R.id.textInputLayoutBackVar)
        val editTextBackVar = textInputLayoutBackVar.editText


        view.findViewById<MaterialButton>(R.id.btn_continue).setOnClickListener {
            if(i == 0){
                if (editTextName?.text.isNullOrEmpty()) {
                    textInputLayoutName.error = "Name is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutName.error = null
                }

                if (editTextBVar?.text.isNullOrEmpty()) {
                    textInputLayoutBVar.error = "BVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutBVar.error = null
                }

                if (editTextRVar?.text.isNullOrEmpty()) {
                    textInputLayoutRVar.error = "RVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutRVar.error = null
                }

                if (editTextSVar?.text.isNullOrEmpty()) {
                    textInputLayoutSVar.error = "SVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutSVar.error = null
                }

                if (editTextZVar?.text.isNullOrEmpty()) {
                    textInputLayoutZVar.error = "ZVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutZVar.error = null
                }

                if (editTextTVar?.text.isNullOrEmpty()) {
                    textInputLayoutTVar.error = "TVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutTVar.error = null
                }

                if (editTextBackVar?.text.isNullOrEmpty()) {
                    textInputLayoutBackVar.error = "BackVar is required"
                    return@setOnClickListener
                } else {
                    textInputLayoutBackVar.error = null
                }


                val game = Game(
                    0, editTextName!!.text.toString(),
                    0,
                    editTextBVar!!.text.toString().toInt(),
                    editTextRVar!!.text.toString().toInt(),
                    editTextSVar!!.text.toString().toInt(),
                    editTextTVar!!.text.toString().toInt(),
                    editTextZVar!!.text.toString().toInt(),
                    editTextBackVar!!.text.toString().toInt(),
                )
                SharedDatas.game = game
                gameDao.insert(game)
                findNavController().navigate(R.id.action_settingFragment_to_chaptersFragment)
            }
        }


    }
}