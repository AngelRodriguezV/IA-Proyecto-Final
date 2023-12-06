package com.angelrv.model;

public class FuncionNS implements NeuronaFunciones{
    
    private double target;

    @Override
    public double errorImputado(Neurona neurona) {
        return (neurona.funcionActivacion() - this.target) * neurona.derivadaFuncionActivacion();
    }


    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }
}
