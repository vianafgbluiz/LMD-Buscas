package com.vianafgluiz.lmd.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private Set<Vertice> vertices;
    private Set<Aresta> arestas;
    private Map<Vertice, Set<Aresta>> adjacentes;

    public Grafo(){
        this.vertices = new HashSet<>();
        this.arestas = new HashSet<>();
        this.adjacentes = new HashMap<>();
    }

    public void addVertice(String label){
        this.vertices.add(new Vertice(label));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addAresta(Aresta e){
        if(arestas.add(e)){
            this.adjacentes.putIfAbsent(e.getV1(), new HashSet<Aresta>());
            this.adjacentes.putIfAbsent(e.getV2(), new HashSet<Aresta>());

            this.adjacentes.get(e.getV1()).add(e);
            this.adjacentes.get(e.getV2()).add(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addAresta(String v1Label, String v2Label){
        this.addAresta(new Aresta(new Vertice(v1Label), new Vertice(v2Label)));
    }

    public List<Vertice> buscaLargura(int noA, int noB) {
        return null;
    }

    public Set<Vertice> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Aresta> getArestas() {
        return Collections.unmodifiableSet(arestas);
    }

    public Map<Vertice, Set<Aresta>> getAdjacentes() {
        return Collections.unmodifiableMap(adjacentes);
    }
}
