package com.angelrv.test;

import com.angelrv.model.Capa;

public class testCapa {
    public static void main(String[] args) {
        Capa capaEntrada = new Capa(2, 2, 0.25, 0.1, 0.2, 0.25, 0.3, 0.4);
        capaEntrada.setInput(0, 0.1, 0.5);
        capaEntrada.setInput(1, 0.1, 0.5);
        System.out.print("\nCapa de Entrada");
        System.out.println(capaEntrada);
        Capa capaSalida = new Capa(2, 2, 0.35, 0.5, 0.6, 0.35, 0.7, 0.8);
        capaSalida.setInput(0, capaEntrada.getOutput(0), capaEntrada.getOutput(1));
        capaSalida.setInput(1, capaEntrada.getOutput(0), capaEntrada.getOutput(1));
        System.out.print("\nCapa de Salida");
        System.out.print(capaSalida);
    }
}
