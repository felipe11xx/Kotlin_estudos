package com.example.felipe.palindromo.Domain;

public class Palindromo {
    private String conteudo;

    public Palindromo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean ehPalindromo(){
        String invertido = new StringBuilder(conteudo).reverse().toString();

        return invertido.equalsIgnoreCase(conteudo);
    }

    public String getConteudo() {
        return conteudo.toLowerCase();
    }


}
