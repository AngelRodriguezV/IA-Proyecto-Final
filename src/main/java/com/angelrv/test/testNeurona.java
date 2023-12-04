package com.angelrv.test;

import com.angelrv.model.NeuronaS;

public interface testNeurona {
    
    public static void main(String[] args) {
        NeuronaS n1 = new NeuronaS(2, 0.35, 0.5, 0.6);
        //n1.evaluar(0.5890, 0.6177);
        System.out.println(n1.hashCode());
        //n1.errorTotal(0.05);
        //System.out.println("\nCalculando error");
        //System.out.println(n1);
    }
}
