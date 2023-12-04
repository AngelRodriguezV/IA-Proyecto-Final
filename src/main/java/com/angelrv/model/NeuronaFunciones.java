package com.angelrv.model;

public interface NeuronaFunciones {

    public double sumaPonderada();

    public double funcionActivacion();

    public double derivadaFuncionCoste();

    public double derivadaFuncionActivacion();
    
    public double errorImputado();

    public void calcularError();
}