package com.angelrv.model;

import java.util.ArrayList;

public class FuncionNO implements NeuronaFunciones{
    
    private ArrayList<Double> ErrIxWs;

    @Override
    public double errorImputado(Neurona n) {
        double errI = 0;
        for (Double errIxW : ErrIxWs) {
            errI += (errIxW * n.derivadaFuncionActivacion());
        }
        return errI;
    }

    public void setErrIxWs(ArrayList<Double> errIxWs) {
        ErrIxWs = errIxWs;
    }

    public ArrayList<Double> getErrIxWs() {
        return ErrIxWs;
    }
}
