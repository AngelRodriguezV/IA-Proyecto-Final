package com.angelrv.test;

import com.angelrv.model.Neurona;

public interface testNeurona {
    
    public static void main(String[] args) {
        Neurona n1 = new Neurona(0.35, 0.5, 0.6);
        n1.setX1(0.5890);
        n1.setX2(0.6177);
        n1.sumaPondera();
        n1.funcionActivacion();
        System.err.println(n1);
        n1.errorTotal(0.05);
        System.err.println("Calculando error");
        System.err.println(n1);
    }
}
