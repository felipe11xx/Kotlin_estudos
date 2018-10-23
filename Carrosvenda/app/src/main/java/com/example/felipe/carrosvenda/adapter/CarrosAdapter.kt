package com.example.felipe.carrosvenda.adapter

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.example.felipe.carrosvenda.R
import com.example.felipe.carrosvenda.bold
import com.example.felipe.carrosvenda.domain.Carro
import com.example.felipe.carrosvenda.getPrecoHuman
import org.w3c.dom.Text
import java.text.FieldPosition

class CarrosAdapter(
    private val context: Context,
    private val carros: List<Carro>):
    RecyclerView.Adapter<CarrosAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): CarrosAdapter.ViewHolder {

        val v = LayoutInflater.from(context)
            .inflate(R.layout.item_carro,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return carros.size
    }

    override fun onBindViewHolder(holder:  ViewHolder, position: Int) {
        holder.setData(carros[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var ivImagem: ImageView
        var ivLogo: ImageView
        var tvModelo: TextView
        var tvMarca : TextView
        var tvMotor: TextView
        var tvAcessorios: TextView
        var tvPreco: TextView

        init {
            ivImagem = itemView.findViewById(R.id.iv_imagem) as ImageView
            ivLogo = itemView.findViewById(R.id.iv_logo) as ImageView
            tvAcessorios = itemView.findViewById(R.id.tv_acessorios) as TextView
            tvMarca = itemView.findViewById(R.id.tv_marca) as TextView
            tvModelo =  itemView.findViewById(R.id.tv_modelo) as TextView
            tvMotor = itemView.findViewById(R.id.tv_motor) as TextView
            tvPreco = itemView.findViewById(R.id.tv_preco) as TextView
        }

        fun setData(carro: Carro){
            ivImagem.setImageBitmap(carro.imagem)
            ivLogo.setImageResource(carro.marca.logo)
            tvMarca.text="${carro.marca.nome} - ${carro.ano}"
            tvMotor.text= "Motor: ".bold().append(" ${carro.motor.modelo}(${carro.motor.cilindro})-${carro.motor.marca}")
            tvAcessorios.text = "Acessorios".bold().append(": ${carro.getAcessoriosFormatted()}")
            tvPreco.text = carro.preco.getPrecoHuman()
            tvModelo.text = carro.modelo
        }

    }

}