package com.angelrv.test;

import com.angelrv.model.Neurona;

public class testNeurona1 {
    
    public static void main(String[] args) {
        Neurona n1 = new Neurona(1, 0, 0);
        n1.evaluar(0.5);
        System.out.println(n1);
    }
}
