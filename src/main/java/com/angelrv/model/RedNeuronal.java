package com.angelrv.model;

import java.util.ArrayList;

public class RedNeuronal {

    private int numInputs;
    private int numOutputs;
    private int numCapasOcultas;
    private int numNeuronasCapa;

    private ArrayList<Capa> capas;
    
    public RedNeuronal(int numInputs, int numOutputs, int numCapasOcultas, int numNeuronasCapa) {
        this.numInputs = numInputs;
        this.numOutputs = numOutputs;
        this.numCapasOcultas = numCapasOcultas;
        this.numNeuronasCapa = numNeuronasCapa;
        this.crearCapas();
    }

    private void crearCapas() {
        // Capas ocultas
        int numEntradas = this.numInputs;
        for (int i = 0; i < this.numCapasOcultas; i++) {
            this.capas.add(new Capa(this.numNeuronasCapa, numEntradas, Capa.NEURONA_OCULTA));
            numEntradas =  this.capas.get(this.capas.size()-1).getNumNeuronas();
        }
        // Capa de Salida
        this.capas.add(new Capa(this.numOutputs, this.capas.get(this.capas.size()-1).getNumNeuronas(), Capa.NEURONA_SALIDA));
    }

    public void entrenar(ArrayList<Double> inputs, ArrayList<Double> targets) {
        // recorrer la red
        ArrayList<Double> outputs = inputs;
        for (int i = 0; i < this.capas.size(); i++) {
            this.capas.get(i).addInputs(outputs);
            outputs = this.capas.get(i).getOutputs();
        }
        //Agregar los targets
        this.capas.get(this.capas.size() - 1).setTarget(targets);
        // propagación hacia atras
        ArrayList<ArrayList<Double>> errIxWs = this.capas.get(this.capas.size() - 1).getErrIxWs();
        this.capas.get(this.capas.size() - 1).actualizarPesosBayas();
        for (int i = this.capas.size() - 2; i >= 0; i--) {
            this.capas.get(i).setErrIxWs(errIxWs);
            errIxWs = this.capas.get(i).getErrIxWs();
            this.capas.get(i).actualizarPesosBayas();
        }
    }
}
