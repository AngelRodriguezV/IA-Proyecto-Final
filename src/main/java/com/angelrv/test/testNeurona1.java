package com.angelrv.test;

import com.angelrv.model.NeuronaS;

public class testNeurona1 {
    
    public static void main(String[] args) {
        NeuronaS n1 = new NeuronaS(1, 0, 0);
        n1.evaluar(0.5);
        System.out.println(n1);
    }
}
