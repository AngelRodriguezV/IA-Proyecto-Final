package com.angelrv.model;

public class RedNeuronal {

    private Capa capaEntrada;
    private Capa capaOculta;
    private Capa capaSalida;
    
    public RedNeuronal() {
        this.capaEntrada = new Capa(2, 1);
        this.capaOculta = new Capa(2, 2);
        this.capaSalida = new Capa(2, 2);
    }

    
}
