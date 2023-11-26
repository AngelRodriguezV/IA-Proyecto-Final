package com.angelrv.model;

import java.util.ArrayList;

public class RedNeuronal {

    private Capa capaEntrada;
    private ArrayList<Capa> capasOcultas;
    private Capa capaSalida;

    private int numEntradas;
    private int numSalidas;
    private int numCapasOcultas;
    private int numEntradasCapasOcultas;
    
    public RedNeuronal(int numEntradas, int numSalidas, int numCapasOcultas, int numEntradasCapasOcultas) {
        this.numEntradas = numEntradas;
        this.numSalidas = numSalidas;
        this.numCapasOcultas = numCapasOcultas;
        this.numEntradasCapasOcultas = numEntradasCapasOcultas;
        this.capasOcultas = new ArrayList<Capa>();
    }

    public void addInputs(double... inputs) {
        if (this.numEntradas != inputs.length) {
            
        }
    }

    public void addOutputs(double... outputs) {
        if (this.numSalidas != outputs.length) {
            
        }
    }
}
