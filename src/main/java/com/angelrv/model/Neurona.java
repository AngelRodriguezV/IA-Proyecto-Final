package com.angelrv.model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Neurona {
    
    private double B;
    private ArrayList<Double> pesos;
    private ArrayList<Double> inputs;
    private int numEntradas;
    private double suma;
    private double output;

    public Neurona(int numEntradas) {
        this.numEntradas = numEntradas;
        this.B = new Random().nextDouble();
        this.pesos = new ArrayList<Double>();
        this.inputs = new ArrayList<Double>();
        for (int i = 0; i < numEntradas; i++) {
            this.pesos.add(new Random().nextDouble());
        }
    }

    public Neurona(int numEntradas, double B, double ... pesos) {
        if (numEntradas != pesos.length) {
            throw new IllegalArgumentException("La cantidad de pesos no coinciden con el numero de entradas.");
        }
        this.numEntradas = numEntradas;
        this.B = B;
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
        this.suma = this.B;
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
     * Derivada del error total dx(ErrorTotal)/dx(w)
     * @param input w
     * @param target
     * @return
     */
    private double error(double input, double target) {
        return (this.output - target) * (this.output * (1 - this.output)) * input;
    }

    /**
     * Función para reducir el error
     * @param target
     */
    public void errorTotal(double target) {
        for (int i = 0; i < this.numEntradas; i++) {
            this.pesos.set(i, this.pesos.get(i) - 0.6 * this.error(this.pesos.get(i), target));
        }
    }

    /**
     * Evalua los datos de entrada
     * @param X1
     * @param X2
     */
    public void evaluar(double... input) {
        if (this.numEntradas != input.length) {
            throw new IllegalArgumentException("La cantidad de valores no coinciden con el tamaño establecido.");
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
        return  "\nOutput = " + this.output;
    }
}
