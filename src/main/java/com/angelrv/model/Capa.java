package com.angelrv.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Capa {
    
    private int numNeuronas;
    private int numEntradas;
    private ArrayList<Neurona> neuronas;

    public Capa(int numNeuronas, int numEntradas) {
        this.numNeuronas = numNeuronas;
        this.numEntradas = numEntradas;
        this.neuronas = new ArrayList<Neurona>();
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.add(new Neurona(this.numEntradas));
        }
    }

    public Capa(int numNeuronas, int numEntradas, double... pesos) {
        if ((numNeuronas*(numEntradas+1)) != pesos.length) {
            throw new IllegalArgumentException("La cantidad de Pesos no coinciden con el numero de pesos + 1 para cada neurona");
        }
        this.numNeuronas = numNeuronas;
        this.numEntradas = numEntradas;
        this.neuronas = new ArrayList<Neurona>();
        this.establecerPesos(pesos);
    }

    private void establecerPesos(double... pesos) {
        for (int i = 0; i < this.numNeuronas; i++) {
            int apuntador = i * (this.numEntradas+1);
            this.neuronas.add(new Neurona(this.numEntradas, pesos[apuntador], Arrays.copyOfRange(pesos, apuntador+1, apuntador+1+this.numEntradas)));
        }
    }

    public void setInput(int index, double... inputs) {
        if (this.numEntradas != inputs.length) {
            throw new IllegalArgumentException("La cantidad de Inputs no coinciden con el numero de entradas.");
        }
        this.neuronas.get(index).evaluar(inputs);
    }

    public double getOutput(int index) {
        return this.neuronas.get(index).getOutput();
    }

    public void propagacionError(double target) {
        for (Neurona neurona : neuronas) {
            neurona.errorTotal(target);
        }
    }

    public int getNumNeuronas() {
        return numNeuronas;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    @Override
    public String toString() {
        String cad = "";
        for (int i = 0; i < this.numNeuronas; i++) {
            cad += "\n Neurona " + i;
            cad += this.neuronas.get(i);
        }
        return cad;
    }
}
