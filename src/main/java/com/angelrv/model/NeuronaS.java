package com.angelrv.model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class NeuronaS {
    
    private double b; // sesgo
    private int numEntradas; // numero de entradas
    private ArrayList<Double> pesos; //pesos
    private ArrayList<Double> inputs; // inputs
    private double suma;
    private double output;

    public NeuronaS(int numEntradas) {
        this.numEntradas = numEntradas;
        this.b = new Random().nextDouble();
        this.pesos = new ArrayList<Double>();
        this.inputs = new ArrayList<Double>();
        for (int i = 0; i < numEntradas; i++) {
            this.pesos.add(new Random().nextDouble());
        }
    }

    public NeuronaS(int numEntradas, double b, double ... pesos) {
        if (numEntradas != pesos.length) {
            throw new IllegalArgumentException("La cantidad de pesos no coinciden con el numero de entradas.");
        }
        this.numEntradas = numEntradas;
        this.b = b;
        this.pesos = new ArrayList<Double>();
        this.inputs = new ArrayList<Double>();
        for (double d : pesos) {
            this.pesos.add(d);
        }
    }

    /**
     * suma Ponderada "b + x1w1 + .. + xnwn"
     * @return
     */
    private void sumaPondera() {
        this.suma = this.b;
        for (int i = 0; i < numEntradas; i++) {
            this.suma += (this.inputs.get(i) * this.pesos.get(i));
        }
    }

    /**
     * Funcion de Activación 1 / (1 + e ^ sum)
     * @return
     */
    private void funcionActivacion() {
        this.output = 1 / (1 + Math.pow(Math.E, -this.suma));
    }

    /**
     * Derivada de la Funcion de Coste
     */
    public double derivadaFuncionCoste(double target) {
        return this.output - target;
    }

    /**
     * Derivada de la Funcion de Activación
     */
    public double derivadaFuncionActivacion() {
        return this.output * (1 - this.output);
    }

    public double errorImputado(double target) {
        return this.derivadaFuncionCoste(target) * this.derivadaFuncionActivacion();
    }

    public double errorBayas(double target) {
        return this.errorImputado(target);
    }

    public double errorCosteW(int i, double target) {
        return this.errorImputado(target) * this.inputs.get(i);
    }
    
    /**
     * Evalua los datos de entrada
     * @param X1
     * @param X2
     */
    public void evaluar(double... input) {
        if (this.numEntradas != input.length) {
            throw new IllegalArgumentException("La cantidad de inputs no coinciden con el tamaño establecido.");
        }
        for (double d : input) {
            this.inputs.add(d);
        }
        this.sumaPondera();
        this.funcionActivacion();
    }

    public double getOutput() {
        return output;
    }

    @Override
    public String toString() {
        String cad = "";
        for (int i = 0; i < this.numEntradas; i++) {
            cad += "\n  w"+i+": "+this.pesos.get(i)+",  x"+i+": "+this.inputs.get(i);
        }
        cad += "\n  b: "+this.b+"\n  Output = " + this.output;
        return cad;
    }
}
