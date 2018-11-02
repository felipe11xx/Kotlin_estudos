package com.example.felipe.todohawk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar

import com.example.felipe.todohawk.domain.ToDo
import com.example.felipe.todohawk.fragment.TaskDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list = ArrayList<ToDo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        fab.setOnClickListener{
            initTaskDialog()
        }

        initRecycler()
    }

    private fun initRecycler(){
        rv_todo.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this)
        rv_todo.layoutManager =mLayoutManager

        val divider = DividerItemDecoration(
            this,
            mLayoutManager.orientation)
            rv_todo.addItemDecoration(divider)

        val adapter = ToDoAdapter(this,list)
        rv_todo.adapter = adapter
    }

    private fun initTaskDialog(){
        val fm = supportFragmentManager
        val ft =fm.beginTransaction()
        val fragAnterior = fm.findFragmentByTag(TaskDialogFragment.KEY)

        if(fragAnterior != null){
            ft.remove(fragAnterior)
        }
        ft.addToBackStack(null)

        val dialog = TaskDialogFragment()
        dialog.show(ft,TaskDialogFragment.KEY)
    }

    fun addToList(toDo: ToDo){
        list.add(toDo)
        rv_todo.adapter!!.notifyItemInserted(list.size)
    }

    fun removeFromList(position:Int){
        list.removeAt(position)
        rv_todo.adapter!!.notifyItemRemoved(position)
    }
}
