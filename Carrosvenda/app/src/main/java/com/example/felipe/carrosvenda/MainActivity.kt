package com.example.felipe.carrosvenda

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.felipe.carrosvenda.adapter.CarrosAdapter
import com.example.felipe.carrosvenda.data.Mock
import com.example.felipe.carrosvenda.domain.Carro
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val carros = ArrayList<Carro>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carros.addAll(
            savedInstanceState?.getParcelableArrayList(Carro.Companion.CARROS) ?:
            Mock().gerarCarro(resources))
        initRecycle()
    }

    private fun initRecycle(){
        rv_carros.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this)
        rv_carros.layoutManager = mLayoutManager

        val divider = DividerItemDecoration(
            this,mLayoutManager.orientation)
        rv_carros.addItemDecoration(divider)

        val adapter = CarrosAdapter(this,carros)
        rv_carros.adapter = adapter

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelableArrayList(Carro.Companion.CARROS,carros)
        super.onSaveInstanceState(outState)

    }
}
