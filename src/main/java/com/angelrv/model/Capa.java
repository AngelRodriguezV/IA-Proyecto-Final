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

    /**
     * 
     * @param numNeuronas
     * @param numEntradas
     * @param pesos los pesos se agregan de la siguiente manera b1, w1, w2, b2, w3, w4, ..., bn, wn-1, wn
     */
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
            this.neuronas.add(new NeuronaS(this.numEntradas, pesos[apuntador], Arrays.copyOfRange(pesos, apuntador+1, apuntador+1+this.numEntradas)));
        }
    }

    //------------------------------------------------------------------------------
    public void addInputs(ArrayList<Double> inputs) {
        for (Neurona n : this.neuronas) {
            n.setInputs(inputs);
        }
    }

    public void addTargets(ArrayList<Double> targets) {
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.get(i).setTarget(targets.get(i));
        }
    }

    public ArrayList<Double> getOutputs() {
        ArrayList<Double> outputs = new ArrayList<Double>();
        for (Neurona neurona : this.neuronas) {
            outputs.add(neurona.funcionActivacion());
        }
        return outputs;
    }

    public ArrayList<ArrayList<Double>> getErrorInputado_x_Ws() {
        ArrayList<ArrayList<Double>> datos = new ArrayList<>();
        for (int i = 0; i < this.numEntradas; i++) {
            datos.add(new ArrayList<Double>());
        }
        for (int i = 0; i < this.numNeuronas; i++) {
            for (int j = 0; j < this.numEntradas; j++) {
                datos.get(j).add(null);
                this.neuronas.errorImputado() * this.neuronas.getPeso(i);
            }
        }
        return new ArrayList<ArrayList<Double>>();
    }

    public ArrayList<ArrayList<Double>> updatePesos(ArrayList<ArrayList<Double>> errores) {
        return new ArrayList<ArrayList<Double>>();
    }

    public void propagacionError(double target) {
        for (Neurona neurona : neuronas) {
            //neurona.errorTotal(target);
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
