package com.vianafgluiz.lmd.Algoritimos;

import android.util.Log;

import com.vianafgluiz.lmd.Models.Aresta;
import com.vianafgluiz.lmd.Models.Grafo;
import com.vianafgluiz.lmd.Models.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuscaLargura {
    private final Set<Vertice> vertices;
    private final Set<Aresta> arestas;
    private Map<Vertice, Set<Aresta>> adjacentes;

    private Set<Integer> visitados;
    private List<Vertice> fila;

    public BuscaLargura(Grafo grafo) {
        this.vertices = new HashSet<>(grafo.getVertices());
        this.arestas = new HashSet<>(grafo.getArestas());
        this.adjacentes = new HashMap<>(grafo.getAdjacentes());
    }


    public LinkedList<Integer> start(Vertice origem, Vertice destino) {
        LinkedList<Integer> path = new LinkedList<>();

        this.visitados = new HashSet<>();
        this.fila = new ArrayList<>();

        visitados.add(Integer.valueOf(origem.getLabel()));
        fila.add(origem);
        int incremento = 0;

        while (true) {
            /*Recupero o proximo elemento da minha fila*/
            Vertice breakpoint = fila.get(incremento);

            /*Verifico se é o breakpoint (destino)*/
            if(breakpoint.getLabel().equals(destino.getLabel()))
                break;

            /*Se não for, adicionar a lista de visitados e recuperar os vizinhos Aptos e adicionar na fila*/
            List<Vertice> vizinhos = vizinhosAptos(breakpoint);
            fila.addAll(vizinhos);

            /*Incrementar*/
            incremento++;
        }

        for (int i = 0; i < fila.size(); i++) {
            path.add(Integer.valueOf(fila.get(i).getLabel()));
        }

        return path;
    }


    private List<Vertice> vizinhosAptos(Vertice vertice){
        Set<Vertice> vizinhos = new HashSet<>();
        for (Aresta aresta : arestas) {
            if (aresta.getV1().getLabel().equals(vertice.getLabel()) && !isSettled(Integer.valueOf(aresta.getV2().getLabel()))) {
                vizinhos.add(aresta.getV2());
                visitados.add(Integer.valueOf(aresta.getV2().getLabel()));
            }
            else if(aresta.getV2().getLabel().equals(vertice.getLabel()) && !isSettled(Integer.valueOf(aresta.getV1().getLabel()))){
                vizinhos.add(aresta.getV1());
                visitados.add(Integer.valueOf(aresta.getV1().getLabel()));
            }
        }
        return new ArrayList<>(vizinhos);
    }


    private boolean isSettled(Integer vertex) {
        return this.visitados.contains(vertex);
    }

}
