package com.angelrv.model;

public interface NeuronaI {

    public void sumaPonderada();

    public void funcionActivacion();

    public void erroTotal(double target);

    public void evaluar(double... input);

    public double getOutput();
    
}