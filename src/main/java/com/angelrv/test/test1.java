package com.angelrv.test;

import java.util.ArrayList;

import com.angelrv.controller.LeerCSV;
import com.angelrv.model.Iris;
import com.angelrv.model.RedNeuronal;

public class test1 {
 
    public static void main(String[] args) {
        ArrayList<Iris> iris = LeerCSV.leerIris("D:\\Usuarios\\veng\\Documentos\\development\\IA-Proyecto-Final\\src\\main\\resources\\Iris.csv");
        ArrayList<Integer> topologia = new ArrayList<>();
        topologia.add(8);
        topologia.add(16);
        topologia.add(24);
        topologia.add(16);
        topologia.add(8);
        topologia.add(4);
        topologia.add(21);
        RedNeuronal rn = new RedNeuronal(4, 2, topologia);
        int cont = 0;
        // 0 - 49 Iris-setosa
        // 50 - 99 Iris-versicolor
        // 100 - 149 Iris-virginica
        
        double error = 0.0;
        do {
            for (int i = 0; i < 34; i++) {
                rn.entrenar(iris.get(i).getInputs(), iris.get(i).getTargets());
                System.out.println(rn.getErrTotal(iris.get(i).getTargets()));
                error = rn.getErrTotal(iris.get(i).getTargets());
            }
            for (int i = 50; i < 84; i++) {
                rn.entrenar(iris.get(i).getInputs(), iris.get(i).getTargets());
                System.out.println(rn.getErrTotal(iris.get(i).getTargets()));
                error = rn.getErrTotal(iris.get(i).getTargets());
            }
            for (int i = 100; i < 134; i++) {
                rn.entrenar(iris.get(i).getInputs(), iris.get(i).getTargets());
                System.out.println(rn.getErrTotal(iris.get(i).getTargets()));
                error = rn.getErrTotal(iris.get(i).getTargets());
            }
        } while (error > 0.0000001);
        System.out.println("Numero de datos entrenados: " + cont);
        
        ArrayList<Double> r = rn.predecir(iris.get(99).getInputs());
        //System.out.println(Math.round(r.get(0)));
        //System.out.println(Math.round(r.get(1)));
        System.out.println(r.get(0));
        System.out.println(r.get(1));
        System.out.println(iris.get(99).getSpecies());
    }
    
}
