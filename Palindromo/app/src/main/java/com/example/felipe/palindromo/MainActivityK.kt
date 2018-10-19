package com.example.felipe.palindromo

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

fun String.ehPalindromo(): String {
    return if (this.isEmpty()) {
        "Por Favor Preencha a caixa de texto! "
    } else {
        if (this.toLowerCase() == this.toLowerCase().reversed())
            "${this.toLowerCase()} é palindromo"
        else
            "${this.toLowerCase()} não é palindromo"
    }
}
class MainActivityK : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
        btn_verif.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //Se feito com uma classe model
      /* val palindromo = PalindromoK (ed_palin.text.toString())

        tv_resp.text =if(palindromo.conteudo.isEmpty()) {
                "Por Favor Preencha a caixa de texto! "
            }else{
                if(palindromo.ehPalindromo())
                    "${palindromo.conteudo} é palindromo"
                else
                    "${palindromo.conteudo} não é palindromo"*/
        tv_resp.text = ed_palin.text.toString().ehPalindromo()

        }



    }


