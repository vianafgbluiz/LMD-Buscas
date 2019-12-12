package com.vianafgluiz.lmd.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.vianafgluiz.lmd.Models.Grafo;
import com.vianafgluiz.lmd.R;

public class MenuActivity extends AppCompatActivity {




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnIniciar = findViewById(R.id.btnIniciar);



        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, EscolhaActivity.class));
            }
        });
    }


}
