package com.angelrv.model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Neurona {
    
    private double B;
    private ArrayList<Double> pesos;
    private ArrayList<Double> inputs;
    private double W1;
    private double W2;
    private double X1;
    private double X2;
    private double suma;
    private double output;

    public Neurona(int numEntradas) {
        this.B = new Random().nextDouble();
        this.pesos = new ArrayList<Double>();
        this.inputs = new ArrayList<Double>();
        for (int i = 0; i < numEntradas; i++) {
            this.pesos.add(new Random().nextDouble());
        }
    }

    public Neurona(double B, double W1, double W2) {
        this.B = B;
        this.W1 = W1;
        this.W2 = W2;
    }

    /**
     * suma Ponderada "b + x1w1 + x2w2"
     * @return
     */
    private void sumaPondera() {
        this.suma = this.B + (this.X1 * this.W1) + (this.X2 * this.W2);
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
        this.W1 = this.W1 - 0.6 * this.error(this.X1, target);
        this.W2 = this.W2 - 0.6 * this.error(this.X2, target);
    }

    /**
     * Evalua los datos de entrada
     * @param X1
     * @param X2
     */
    public void evaluar(double X1, double X2) {
        this.X1 = X1;
        this.X2 = X2;
        this.sumaPondera();
        this.funcionActivacion();
    }

    public double getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return  "\nX1 = " + this.X1 + 
                "\nX2 = " + this.X2 + 
                "\nB = " + this.B +
                "\nW1 = " + this.W1 + 
                "\nW2 = " + this.W2 +
                "\nOutput = " + this.output;
    }
}
