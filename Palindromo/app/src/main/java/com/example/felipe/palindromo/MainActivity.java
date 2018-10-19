package com.example.felipe.palindromo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.felipe.palindromo.Domain.Palindromo;
import com.example.felipe.palindromo.Domain.PalindromoK;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_palin;
    private TextView tv_resp;
    private Button btn_verif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_verif = findViewById(R.id.btn_verif);

        btn_verif.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tv_resp = findViewById(R.id.tv_resp);
        ed_palin = findViewById(R.id.ed_palin);
        String resposta;
        //Palindromo palindromo = new Palindromo(ed_palin.getText().toString());
        PalindromoK palindromo = new PalindromoK(ed_palin.getText().toString());
        if(palindromo.getConteudo().isEmpty()){
            resposta = "Favor preenher a caixa de texto";
        }else {

            if(palindromo.ehPalindromo()){
                resposta = " É Palindromo";
            }else {
                resposta = " Não É Palindromo";
            }
        }

        tv_resp.setText(palindromo.getConteudo() + resposta);
    }
}