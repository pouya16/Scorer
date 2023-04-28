package com.example.scorer.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.Scorer.R
import com.example.scorer.SharedDatas
import com.example.scorer.database.AppDataBase
import com.example.scorer.database.Chapters
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class GamesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var chapter = SharedDatas.chapter

        view.findViewById<TextView>(R.id.txt_level).text = chapter.current_level.toString() + "  مرحله "
        view.findViewById<TextView>(R.id.txt_score).text = SharedDatas.total_score.toString() + "  امتیاز "

        view.findViewById<MaterialCardView>(R.id.card_e).setOnClickListener{
            showEditDialog(requireContext(),view.findViewById(R.id.txt_e),chapter)
        }

        view.findViewById<MaterialButton>(R.id.btn_yes).setOnClickListener{
            showConfirmationDialog("آیا مطمین هستید؟ ",chapter,view)
        }

        view.findViewById<MaterialButton>(R.id.btn_no).setOnClickListener{
            if(chapter.current_level == 0||chapter.current_level - SharedDatas.back_val<0){

            }else{
                chapter.current_level = chapter.current_level - SharedDatas.back_val
                view.findViewById<TextView>(R.id.txt_level).text = chapter.current_level.toString() + "  مرحله "
                SharedDatas.perform_no(chapter.current_level)
                AppDataBase.getDatabase(requireContext()).chapterDao().update(chapter)
                AppDataBase.getDatabase(requireContext()).gameDao().update(SharedDatas.game)

                view.findViewById<TextView>(R.id.txt_score).text = SharedDatas.total_score.toString() + "  امتیاز "
            }
        }



    }


    fun showEditDialog(context: Context, textView: TextView,chapter:Chapters) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("تنظیم E")

        val input = EditText(context)
        input.inputType = InputType.TYPE_CLASS_NUMBER
        input.setText(textView.text)

        builder.setView(input)

        builder.setPositiveButton("OK") { dialog, _ ->
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                textView.text = text
                chapter.e_variable = text.toInt()
                AppDataBase.getDatabase(requireContext()).chapterDao().update(chapter)

            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    fun showConfirmationDialog(message: String,chapter: Chapters,view:View) {
        val builder = AlertDialog.Builder(context)

        // Set the message and title of the dialog
        builder.setMessage(message)
            .setTitle("Confirmation")

        // Add the Yes button
        builder.setPositiveButton("Yes") { _, _ ->
            // This code will be executed when the user clicks the Yes button
            if(chapter.current_level<SharedDatas.level){
                SharedDatas.perform_yes(chapter.current_level)
                chapter.current_level++
                view.findViewById<TextView>(R.id.txt_level).text = chapter.current_level.toString() + "  مرحله "
                AppDataBase.getDatabase(requireContext()).chapterDao().update(chapter)
                AppDataBase.getDatabase(requireContext()).gameDao().update(SharedDatas.game)
                view.findViewById<TextView>(R.id.txt_score).text = SharedDatas.total_score.toString() + "  امتیاز "
            }
        }

        // Add the No button
        builder.setNegativeButton("No") { dialog, _ ->
            // This code will be executed when the user clicks the No button
            dialog.cancel()
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.show()
    }




}