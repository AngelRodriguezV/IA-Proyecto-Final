package com.angelrv.model;

import java.util.ArrayList;

public class Capa {
    
    private int numNeuronas;
    private int numEntradas;
    private ArrayList<Neurona> neuronas;

    public Capa(int numNeuronas, int numEntradas) {
        this.numNeuronas = numNeuronas;
        this.numEntradas = numEntradas;
        this.neuronas = new ArrayList<Neurona>();
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.add(new Neurona(1));
        }
    }

    public double getOutput(int index) {
        return this.neuronas.get(index).getOutput();
    }
}
