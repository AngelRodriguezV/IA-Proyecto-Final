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
        // Capa de entrada
        this.capas.add(new Capa(this.numInputs, 1));
        // Capas ocultas
        for (int i = 0; i < this.numCapasOcultas; i++) {
            this.capas.add(new Capa(this.numNeuronasCapa, this.capas.get(this.capas.size()-1).getNumNeuronas()));
        }
        // Capa de Salida
        this.capas.add(new Capa(this.numOutputs, this.capas.get(this.capas.size()-1).getNumNeuronas()));
    }

    public void entrenar(ArrayList<Double> inputs, ArrayList<Double> targets) {
        this.capas.get(0).addInputs(inputs);
        this.capas.get(this.capas.size()-1).addTargets(targets);
        // recorrer la red
        ArrayList<Double> outputs = this.capas.get(0).getOutputs();
        for (int i = 1; i < this.capas.size(); i++) {
            this.capas.get(i).addInputs(outputs);
            outputs = this.capas.get(i).getOutputs();
        }
        // propagación hacia atras
        ArrayList<ArrayList<Double>> errores;
        errores = this.capas.get(this.capas.size()-1).getErrorInputado_x_Ws();
        for (int i = this.capas.size()-1; i > 0; i--) {
            errores = this.capas.get(i).updatePesos(errores);
        }
    }
}
