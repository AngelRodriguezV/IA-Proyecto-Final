package com.angelrv.test;

import com.angelrv.model.Capa;

public class testCapa {
    public static void main(String[] args) {
        /**
         * los pesos se agregan de la siguiente manera b1, w1, w2, b2, w3, w4, ..., bn, wn-1, wn
         */
        Capa capaEntrada = new Capa(2, 2, 0.25, 0.1, 0.2, 0.25, 0.3, 0.4);
        capaEntrada.setInput(0, 0.1, 0.5);
        capaEntrada.setInput(1, 0.1, 0.5);
        System.out.print("\n Capa de Entrada");
        System.out.println(capaEntrada);
        Capa capaSalida = new Capa(2, 2, 0.35, 0.5, 0.6, 0.35, 0.7, 0.8);
        capaSalida.setInput(0, capaEntrada.getOutput(0), capaEntrada.getOutput(1));
        capaSalida.setInput(1, capaEntrada.getOutput(0), capaEntrada.getOutput(1));
        System.out.print("\nCapa de Salida");
        System.out.print(capaSalida);
    }
}
