package com.angelrv.model;

import java.util.ArrayList;

public abstract class Nodo {
    
    protected ArrayList<Nodo> nodosInt;
    protected ArrayList<Nodo> nodosOut;

    public Nodo() {
        this.nodosInt = new ArrayList<Nodo>();
        this.nodosOut = new ArrayList<Nodo>();
    }

    public void addNodoEntrada(Nodo nodo) {
        this.nodosInt.add(nodo);
    }

    public void addNodoSalida(Nodo nodo) {
        this.nodosOut.add(nodo);
    }
}
