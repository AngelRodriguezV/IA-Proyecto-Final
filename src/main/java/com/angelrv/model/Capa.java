package com.angelrv.model;

import java.util.ArrayList;

public class Capa {

    public static final int NEURONA_OCULTA = 1;
    public static final int NEURONA_SALIDA = 2;
    
    private int numNeuronas;
    private int numEntradas;
    private ArrayList<Neurona> neuronas;
    private int tipoNeurona;

    public Capa(int numNeuronas, int numEntradas, int tipoNeurona) {
        this.numNeuronas = numNeuronas;
        this.numEntradas = numEntradas;
        this.tipoNeurona = tipoNeurona;
        this.neuronas = new ArrayList<Neurona>();
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.add(new Neurona(this.numEntradas));
        }
    }

    //------------------------------------------------------------------------------
    public void addInputs(ArrayList<Double> inputs) {
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.get(i).setInputs(inputs);
        }
    }

    public ArrayList<Double> getOutputs() {
        ArrayList<Double> outputs = new ArrayList<Double>();
        for (Neurona neurona : this.neuronas) {
            outputs.add(neurona.funcionActivacion());
        }
        return outputs;
    }

    public void setTarget(ArrayList<Double> targets) {
        for (int i = 0; i < this.numNeuronas; i++) {
            this.neuronas.get(i).setnF(new FuncionNS(targets.get(i)));
        }
    }

    public ArrayList<ArrayList<Double>> getErrIxWs() {
        ArrayList<ArrayList<Double>> errIxWs = new ArrayList<>();
        for (int i = 0; i < this.numEntradas; i++) {
            errIxWs.add(new ArrayList<Double>());
        }
        for (int i = 0; i < this.numNeuronas; i++) {
            for (int j = 0; j < this.numEntradas; j++) {
                errIxWs.get(j).add(this.neuronas.get(i).errorImputado() * this.neuronas.get(i).getPesos(j));
            }
        }
        return errIxWs;
    }

    public void setErrIxWs(ArrayList<ArrayList<Double>> errIxWs) {
        for (int i = 0; i < this.numNeuronas; i++) {
            if (this.tipoNeurona == NEURONA_SALIDA) {
                this.neuronas.get(i).setnF(new FuncionNO(errIxWs.get(i)));
            } else {
                this.neuronas.get(i).setnF(new FuncionNO(errIxWs.get(i)));
            }
        }
    }

    public void actualizarPesosBayas() {
        for (Neurona neurona : this.neuronas) {
            neurona.actualizarPesos();
            neurona.actualizarBayas();
        }
    }

    public int getNumNeuronas() {
        return this.numNeuronas;
    }

    public int getNumEntradas() {
        return this.numEntradas;
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
