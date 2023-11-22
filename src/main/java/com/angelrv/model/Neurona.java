package com.angelrv.model;

import java.lang.Math;

public class Neurona {
    
    private double B1;
    private double W1;
    private double W2;
    private double X1;
    private double X2;
    private double suma;
    private double output;

    private Neurona(double B1, double W1, double W2) {
        this.B1 = B1;
        this.W1 = W1;
        this.W2 = W2;
    }

    /**
     * Funcion de Activación 1 / (1 + e ^ sum)
     * @return
     */
    public void funcionActivacion() {
        this.output = 1 / (1 + Math.pow(Math.E, -this.suma));
    }

    /**
     * suma Ponderada "b + x1w1 + x2w2"
     * @return
     */
    public void sumaPondera() {
        this.suma = this.B1 + (this.X1 * this.W1) + (this.X2 * this.W2);
    }

    /**
     * Derivada del error total dx(ErrorTotal)/dx(w)
     * @param input w
     * @param target
     * @return
     */
    public double error(double input, double target) {
        return (this.output - target) * (this.output * (1 - this.output)) * input;
    }

    public void errorTotal(double target) {
        this.W1 = this.W1 - 0.6 - this.error(this.X1, target);
        this.W2 = this.W2 - 0.6 - this.error(this.X2, target);
    }
    
    public void setX1(double x1) {
        X1 = x1;
    }
    
    public void setX2(double x2) {
        X2 = x2;
    }
}
