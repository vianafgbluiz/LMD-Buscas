package com.vianafgluiz.lmd.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.vianafgluiz.lmd.Algoritimos.BuscaLargura;
import com.vianafgluiz.lmd.Algoritimos.BuscaProfundidade;
import com.vianafgluiz.lmd.Models.Grafo;
import com.vianafgluiz.lmd.Models.Vertice;
import com.vianafgluiz.lmd.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Grafo grafo = new Grafo();
    private MaterialEditText editNoInicial, editNoFinal;
    private List<ImageView> imagesList = new ArrayList<>();
    private Stack<Integer> listaNos = new Stack<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Inicializar*/
        editNoInicial = findViewById(R.id.editNoInicial);
        editNoFinal = findViewById(R.id.editNoFinal);
        FloatingActionButton fabMostrar = findViewById(R.id.floatingActionButton);

        final int choice = getIntent().getIntExtra("SEARCHCHOICE", 0);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnLimpar = findViewById(R.id.btnLimpar);

        this.initImages();
        this.createGrafo();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int noA = Integer.valueOf(String.valueOf(editNoInicial.getText()));
                int noB = Integer.valueOf(String.valueOf(editNoFinal.getText()));

                /*Busca em Largura*/
                if(choice == 1) {
                    /*Cria como nulo a Origem e o Destino*/
                    Vertice origemCalculo = null;
                    Vertice destinoCalculo = null;

                    /*Define a origem e o destino no grafo*/
                    for(Vertice vertice : grafo.getVertices()){
                        if(vertice.getLabel().equals(String.valueOf(noA))){
                            origemCalculo = vertice;
                        }
                        if(vertice.getLabel().equals(String.valueOf(noB))){
                            destinoCalculo = vertice;
                        }
                    }
                    LinkedList<Integer> buscaLargura = new BuscaLargura(grafo).start(origemCalculo, destinoCalculo);
                    revertGraph(buscaLargura);
                    Toast.makeText(MainActivity.this, "Já foi finalizado!", Toast.LENGTH_LONG).show();
                }

                /*Busca em Profundidade*/
                if(choice == 2) {
                    /*Cria como nulo a Origem e o Destino*/
                    Vertice origemCalculo = null;
                    Vertice destinoCalculo = null;

                    /*Define a origem e o destino no grafo*/
                    for(Vertice vertice : grafo.getVertices()){
                        if(vertice.getLabel().equals(String.valueOf(noA))){
                            origemCalculo = vertice;
                        }
                        if(vertice.getLabel().equals(String.valueOf(noB))){
                            destinoCalculo = vertice;
                        }
                    }
                    LinkedList<Integer> buscaProfundidade = new BuscaProfundidade(grafo).start(origemCalculo, destinoCalculo);
                    revertGraph(buscaProfundidade);
                    Toast.makeText(MainActivity.this, "Já foi finalizado!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ImageView image: imagesList) {
                    image.setImageResource(R.drawable.icon_inicial);
                }
            }
        });

        fabMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!listaNos.empty()) {
                    int value = listaNos.pop();
                    ImageView image = imagesList.get(value - 1);
                    image.setImageResource(R.drawable.icon_visitado);
                } else {
                    Toast.makeText(MainActivity.this, "Já foi exibido todos os nós", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void revertGraph(LinkedList<Integer> nodes) {
        int inc;
        StringBuilder x = new StringBuilder();

        for (inc = nodes.size(); inc > 0; inc--) {

            int valor = nodes.get(inc - 1);
            x.append(String.valueOf(valor)).append(" | ");
            listaNos.push(valor);

        }

        Log.d("ListaFinal", String.valueOf(x));
    }

    private void initImages() {
        imagesList.add((ImageView) findViewById(R.id.imgOne));
        imagesList.add((ImageView) findViewById(R.id.imgTwo));
        imagesList.add((ImageView) findViewById(R.id.imgThree));
        imagesList.add((ImageView) findViewById(R.id.imgFour));
        imagesList.add((ImageView) findViewById(R.id.imgFive));
        imagesList.add((ImageView) findViewById(R.id.imgSix));
        imagesList.add((ImageView) findViewById(R.id.imgSeven));
        imagesList.add((ImageView) findViewById(R.id.imgEight));
        imagesList.add((ImageView) findViewById(R.id.imgNine));
        imagesList.add((ImageView) findViewById(R.id.imgTen));
        imagesList.add((ImageView) findViewById(R.id.imgEleven));
        imagesList.add((ImageView) findViewById(R.id.imgTwelve));
        imagesList.add((ImageView) findViewById(R.id.imgThirteen));
        imagesList.add((ImageView) findViewById(R.id.imgFourteen));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createGrafo() {
        this.grafo.addVertice("1");
        this.grafo.addVertice("2");
        this.grafo.addVertice("3");
        this.grafo.addVertice("4");
        this.grafo.addVertice("5");
        this.grafo.addVertice("6");
        this.grafo.addVertice("7");
        this.grafo.addVertice("8");
        this.grafo.addVertice("9");
        this.grafo.addVertice("10");
        this.grafo.addVertice("11");
        this.grafo.addVertice("12");
        this.grafo.addVertice("13");
        this.grafo.addVertice("14");

        this.grafo.addAresta("1", "2");
        this.grafo.addAresta("3", "4");
        this.grafo.addAresta("5", "6");
        this.grafo.addAresta("8", "9");
        this.grafo.addAresta("9", "10");
        this.grafo.addAresta("13", "14");
        this.grafo.addAresta("1", "8");
        this.grafo.addAresta("8", "11");
        this.grafo.addAresta("2", "5");
        this.grafo.addAresta("3", "6");
        this.grafo.addAresta("10", "14");
        this.grafo.addAresta("6", "10");

        this.grafo.addAresta("4", "7");
        this.grafo.addAresta("7", "12");
    }
}
