package com.example.felipe.palindromo.Domain

data class PalindromoK (var _conteudo: String){
 val conteudo: String = _conteudo
     get(){
         return field.toLowerCase()
     }

    fun ehPalindromo(): Boolean{
        return conteudo == conteudo.reversed()
    }
}