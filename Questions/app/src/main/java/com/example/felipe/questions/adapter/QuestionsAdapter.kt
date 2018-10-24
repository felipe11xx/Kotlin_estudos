package com.example.felipe.questions.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.felipe.questions.R
import com.example.felipe.questions.domain.Question

class QuestionsAdapter(
    private val context: Context,
    private val questions: List<Question>): RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(context).inflate(R.layout.item_question,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.setData(questions[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var ivUser: ImageView
        var tvQuestion: TextView
        init {
            ivUser= itemView.findViewById(R.id.iv_user)
            tvQuestion = itemView.findViewById(R.id.tv_question)
        }

        fun setData(question: Question){
            ivUser.setImageResource(question.userImage)
            tvQuestion.text = question.question
        }

    }
}