package com.angelrv.model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Neurona implements NeuronaFunciones {
    
    protected int numEntradas;
    protected double b;
    protected HashMap<Integer, Integer> relacion;
    protected ArrayList<Double> pesos;
    protected ArrayList<Double> inputs;

    public Neurona(int numEntradas) {
        this.numEntradas = numEntradas;
        this.relacion = new HashMap<Integer, Integer>();
        this.pesos = new ArrayList<Double>();
        this.inputs = new ArrayList<Double>();
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return b;
    }

    /**
    public void addPesos(int key, double w) {
        this.pesos.add(w);
        this.relacion.put(key, this.pesos.size()-1);
    }

    public double getPesos(int key) {
        return this.pesos.get(key);
    }
    */
    public void setInputs(ArrayList<Double> inputs) {
        if (this.numEntradas != inputs.size()) {
            throw new IllegalArgumentException("La cantidad de inputs no coinciden con el numero de estradas.");
        }
        this.inputs = inputs;
    }

    public void setTarget(double target) {
        // pendiente
    }

    @Override
    public double sumaPonderada() {
        double suma = this.b;
        for (int i = 0; i < this.numEntradas; i++) {
            suma += (this.inputs.get(i) * this.pesos.get(i));
        }
        return suma;
    }

    @Override
    public double funcionActivacion() {
        return 1 / (1 + Math.pow(Math.E, -this.sumaPonderada()));
    }

    @Override
    public double derivadaFuncionActivacion() {
        return this.funcionActivacion() * (1 - this.funcionActivacion());
    }

    @Override
    public double errorImputado() {
        // TODO Auto-generated method stub
        return 0;
    }
}
