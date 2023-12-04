package com.angelrv.model;

public class NeuronaOculta extends Neurona{

    public NeuronaOculta(int numEntradas) {
        super(numEntradas);
    }

    @Override
    public double derivadaFuncionCoste() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double errorImputado() {
        return this.derivadaFuncionActivacion();
    }


    @Override
    public void calcularError() {
        // TODO Auto-generated method stub
        
    }
}
