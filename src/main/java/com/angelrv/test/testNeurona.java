package com.angelrv.test;

import com.angelrv.model.Neurona;

public interface testNeurona {
    
    public static void main(String[] args) {
        Neurona n1 = new Neurona(0.35, 0.5, 0.6);
        n1.evaluar(0.5890, 0.6177);
        System.err.println(n1);
        n1.errorTotal(0.05);
        System.err.println("Calculando error");
        System.err.println(n1);
    }
}
