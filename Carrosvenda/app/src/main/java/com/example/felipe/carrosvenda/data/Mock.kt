package com.example.felipe.carrosvenda.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.felipe.carrosvenda.R
import com.example.felipe.carrosvenda.domain.Acessorio
import com.example.felipe.carrosvenda.domain.Carro
import com.example.felipe.carrosvenda.domain.Marca
import com.example.felipe.carrosvenda.domain.Motor
import java.util.*

class Mock {
    private fun gerarMoto(): Motor{
        val modelos = arrayOf("V-Tec","Rocan","Zar-T")
        val cilindros = arrayOf(4,4,8)
        val marcas = arrayOf("Wolkswagen","Ford","GM")
        val randIndex = Random().nextInt(3)

        return Motor(modelos[randIndex],cilindros[randIndex],marcas[randIndex])
    }

    private fun gerarAcessorio(): Acessorio{
        val acessorios = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
        val precos = arrayOf(2500f, 5600f, 8000f, 980f)
        val randIndex = Random().nextInt(4)

        return Acessorio(acessorios[randIndex],precos[randIndex])
    }


    private fun gerarlistarAcessorio(): List<Acessorio>{

        val acessorios = LinkedList<Acessorio>()
        val randIndex = Random().nextInt(3) + 1

        while (acessorios.size < randIndex){
            val aux = gerarAcessorio()

            if(aux !in acessorios){
                acessorios.add(aux)
            }
        }
        return acessorios
    }

    private fun inAcessorios(acessorio: Acessorio, acessorios: List<Acessorio>):Boolean{
        for(aux in acessorios)
            if(aux.nome == acessorio.nome)
                return true
            return false
    }

    private fun gerarBitmap(resources: Resources, imagemRes:Int): Bitmap{
        return BitmapFactory.decodeResource(resources,imagemRes)
    }

    fun gerarCarro(resources: Resources): List<Carro>{

        var carros = listOf(
            Carro(
                "Impala",
                2014,
                Marca("Chevrolet", R.drawable.chevrolet_logo),
                gerarMoto(),
                89_997f,
                gerarlistarAcessorio(),
                gerarBitmap(resources,R.drawable.chevrolet_impala)
            ),
            Carro(
                    "Evoque",
            2017,
            Marca("Land Rover", R.drawable.land_rover_logo),
            gerarMoto(),
            228_500f,
            gerarlistarAcessorio(),
            gerarBitmap(resources,R.drawable.land_rover_evoque)
            ),

            Carro(
                "Toureg",
                    2017,
                Marca("Wolkswagen", R.drawable.volkswagen_logo),
                gerarMoto(),
                327_793f,
                gerarlistarAcessorio(),
                gerarBitmap(resources,R.drawable.volkswagen_toureg)
            ),

            Carro(
                "Fusion",
                2017,
                Marca("Ford", R.drawable.ford_logo),
                gerarMoto(),
                98_650f,
                gerarlistarAcessorio(),
                gerarBitmap(resources,R.drawable.ford_fusion)
            ),
            Carro(
                "Taurus",
                2016,
                Marca("Ford", R.drawable.ford_logo),
                gerarMoto(),
                113_985f,
                gerarlistarAcessorio(),
                gerarBitmap(resources,R.drawable.ford_taurus)
            )
        )
        return carros
    }

}