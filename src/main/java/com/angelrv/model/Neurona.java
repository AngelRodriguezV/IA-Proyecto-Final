package com.angelrv.model;

import java.util.ArrayList;

public class Neurona {
    
    private int numEntradas;
    private double b;
    private ArrayList<Double> pesos;
    private ArrayList<Double> inputs;
    private NeuronaFunciones nF;

    public Neurona(int numEntradas) {
        this.numEntradas = numEntradas;
        this.inputs = new ArrayList<Double>();
        this.pesos = new ArrayList<Double>();
        this.b = Math.random();
        for (int i = 0; i < this.numEntradas; i++) {
            this.pesos.add(Math.random());
        }
    }

    public void setnF(NeuronaFunciones nF) {
        this.nF = nF;
    }

    public NeuronaFunciones getnF() {
        return nF;
    }

    public double getB() {
        return b;
    }

    public double getPesos(int index) {
        return this.pesos.get(index);
    }

    public void setInputs(ArrayList<Double> inputs) {
        if (this.numEntradas != inputs.size()) {
            throw new IllegalArgumentException("La cantidad de inputs no coinciden con el numero de estradas.");
        }
        this.inputs = inputs;
    }

    public double sumaPonderada() {
        double suma = this.b;
        for (int i = 0; i < this.numEntradas; i++) {
            suma += (this.inputs.get(i) * this.pesos.get(i));
        }
        return suma;
    }

    public double funcionActivacion() {
        return 1 / (1 + Math.pow(Math.E, -this.sumaPonderada()));
    }

    public double derivadaFuncionActivacion() {
        return this.funcionActivacion() * (1 - this.funcionActivacion());
    }

    public double errorImputado() {
        return nF.errorImputado(this);
    }

    public ArrayList<Double> getErrIxW() {
        ArrayList<Double> errIxW = new ArrayList<>();
        for (Double peso : this.pesos) {
            errIxW.add(this.errorImputado() * peso);
        }
        return errIxW;
    }

    public void actualizarPesos() {
        for (int i = 0; i < this.numEntradas; i++) {
            this.pesos.set(i,this.pesos.get(i) - (0.6 * this.errorImputado() * this.inputs.get(i)));
        }
    }

    public void actualizarBayas() {
        this.b = this.b - (0.6 * this.errorImputado());
    }
}
