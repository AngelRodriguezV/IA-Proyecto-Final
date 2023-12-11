package com.angelrv.model;

public class FuncionNS implements NeuronaFunciones{
    
    private Double target;

    public FuncionNS(Double target) {
        this.target = target;
    }

    @Override
    public Double errorImputado(Neurona neurona) {
        return (neurona.funcionActivacion() - this.target) * neurona.derivadaFuncionActivacion();
    }


    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }
}
