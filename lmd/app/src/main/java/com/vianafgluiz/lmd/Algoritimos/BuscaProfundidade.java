package com.vianafgluiz.lmd.Algoritimos;

import android.util.Log;

import com.vianafgluiz.lmd.Models.Aresta;
import com.vianafgluiz.lmd.Models.Grafo;
import com.vianafgluiz.lmd.Models.Vertice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BuscaProfundidade {
    private final Set<Vertice> vertices;
    private final Set<Aresta> arestas;
    private Map<Vertice, Set<Aresta>> adjacentes;

    private Stack<Vertice> pilha;
    private Set<Integer> visitados;
    private LinkedList<Integer> path;

    public BuscaProfundidade(Grafo grafo) {
        this.vertices = new HashSet<>(grafo.getVertices());
        this.arestas = new HashSet<>(grafo.getArestas());
        this.adjacentes = new HashMap<>(grafo.getAdjacentes());
        this.pilha = new Stack<>();
    }

    public LinkedList<Integer> start(Vertice origem, Vertice destino) {
        this.path = new LinkedList<>();
        this.visitados = new HashSet<>();
        this.pilha = new Stack<>();

        /*Adiciono o no Origem na pilha*/
        pilha.push(origem);
        visitados.add(Integer.valueOf(origem.getLabel()));
        path.add(Integer.valueOf(origem.getLabel()));


        while (!pilha.isEmpty()) {
            /*Recupero o ultimo elemento inserido na minha pilha*/
            Vertice breakpoint = pilha.pop();

            /*Verifico se é o breakpoint (destino)*/
            if(breakpoint.getLabel().equals(destino.getLabel()))
                break;

            /*Se não for, adicionar a lista de visitados e recuperar os vizinhos Aptos e adicionar na pilha*/
            List<Vertice> vizinhos = vizinhosAptos(breakpoint);
        }
        return path;
    }

    private List<Vertice> vizinhosAptos(Vertice vertice){
        Set<Vertice> vizinhos = new HashSet<>();
        for (Aresta aresta : arestas) {
            if (aresta.getV1().getLabel().equals(vertice.getLabel()) && !isSettled(Integer.valueOf(aresta.getV2().getLabel()))) {
                pilha.push(aresta.getV2());
                visitados.add(Integer.valueOf(aresta.getV2().getLabel()));
                path.add(Integer.valueOf(aresta.getV2().getLabel()));
            }
            else if(aresta.getV2().getLabel().equals(vertice.getLabel()) && !isSettled(Integer.valueOf(aresta.getV1().getLabel()))){
                pilha.push(aresta.getV1());
                visitados.add(Integer.valueOf(aresta.getV1().getLabel()));
                path.add(Integer.valueOf(aresta.getV1().getLabel()));
            }
        }

        return new ArrayList<>(vizinhos);
    }

    private boolean isSettled(Integer vertex) {
        return this.visitados.contains(vertex);
    }

}
