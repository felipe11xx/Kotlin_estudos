package com.example.felipe.questions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.felipe.questions.adapter.QuestionsAdapter
import com.example.felipe.questions.data.Mock
import com.example.felipe.questions.domain.Question
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var questions = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions.addAll(Mock.generateQuestionList())
        initRecycler()
    }

    private fun initRecycler(){
        rv_questions.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this)
        rv_questions.layoutManager = mLayoutManager

        val divider = DividerItemDecoration(this, mLayoutManager.orientation)
        rv_questions.addItemDecoration(divider)

        val adapter = QuestionsAdapter(this, questions)
        rv_questions.adapter = adapter
    }
}
