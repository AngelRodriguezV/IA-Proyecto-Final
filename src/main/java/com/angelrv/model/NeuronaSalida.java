package com.angelrv.model;

import java.util.ArrayList;

public class NeuronaSalida extends Neurona{

    private double target;

    public NeuronaSalida(int numEntradas, double target) {
        super(numEntradas);
        this.target = target;
    }
    
    @Override
    public double derivadaFuncionCoste() {
        return this.funcionActivacion() - this.target;
    }

    @Override
    public double errorImputado() {
        return this.derivadaFuncionCoste() * this.derivadaFuncionActivacion();
    }

    @Override
    public void calcularError() {
        ArrayList<Double> errorW = new ArrayList<>();
        double errorImputado = this.errorImputado();
        for (Double input : this.inputs) {
            errorW.add(errorImputado * input);
        }
    }
}
