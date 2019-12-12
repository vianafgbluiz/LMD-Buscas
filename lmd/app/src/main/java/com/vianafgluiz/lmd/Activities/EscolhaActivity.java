package com.vianafgluiz.lmd.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vianafgluiz.lmd.Models.Grafo;
import com.vianafgluiz.lmd.R;

public class EscolhaActivity extends AppCompatActivity {

    private Grafo grafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        Button btnLargura = findViewById(R.id.btnLargura);
        Button btnProfundidade = findViewById(R.id.btnProfundidade);

        btnLargura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolhaActivity.this, MainActivity.class);
                intent.putExtra("SEARCHCHOICE", 1);
                startActivity(intent);
            }
        });

        btnProfundidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolhaActivity.this, MainActivity.class);
                intent.putExtra("SEARCHCHOICE", 2);
                startActivity(intent);
            }
        });

    }


}
