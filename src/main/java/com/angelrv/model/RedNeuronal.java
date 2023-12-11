package com.angelrv.model;

import java.util.ArrayList;

public class RedNeuronal {

    private int numInputs;
    private int numOutputs;
    private ArrayList<Integer> topologia;

    private ArrayList<Capa> capas;
    
    public RedNeuronal(int numInputs, int numOutputs, ArrayList<Integer> topologia) {
        this.numInputs = numInputs;
        this.numOutputs = numOutputs;
        this.topologia = topologia;
        this.capas = new ArrayList<Capa>();
        this.crearCapas();
    }

    private void crearCapas() {
        // Capas ocultas
        int numEntradas = this.numInputs;
        for (int i = 0; i < this.topologia.size(); i++) {
            this.capas.add(new Capa(this.topologia.get(i), numEntradas, Capa.NEURONA_OCULTA));
            numEntradas =  this.topologia.get(i);
        }
        // Capa de Salida
        this.capas.add(new Capa(this.numOutputs, numEntradas, Capa.NEURONA_SALIDA));
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
            //System.out.println(i + " " + this.capas.get(i).getNumNeuronas() + " " + this.capas.get(i).getNumEntradas());
            this.capas.get(i).setErrIxWs(errIxWs);
            errIxWs = this.capas.get(i).getErrIxWs();
            this.capas.get(i).actualizarPesosBayas();
        }
    }

    public ArrayList<Double> predecir(ArrayList<Double> inputs) {
        ArrayList<Double> outputs = inputs;
        for (int i = 0; i < this.capas.size(); i++) {
            this.capas.get(i).addInputs(outputs);
            outputs = this.capas.get(i).getOutputs();
        }
        return outputs;
    }

    public Double getErrTotal(ArrayList<Double> targets) {
        return this.capas.get(this.capas.size() - 1).getErrorTotal(targets);
    }
}
