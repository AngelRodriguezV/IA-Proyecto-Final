package com.angelrv.test;

import java.util.ArrayList;

import com.angelrv.controller.LeerCSV;
import com.angelrv.model.Diabetes;
import com.angelrv.model.RedNeuronal;

public class test2 {
    
    public static void main(String[] args) {
         ArrayList<Diabetes> diabetes = LeerCSV.leerDiavetes("D:\\Usuarios\\veng\\Documentos\\development\\IA-Proyecto-Final\\src\\main\\resources\\diabetes.csv");
        ArrayList<Integer> topologia = new ArrayList<>();
        topologia.add(8);
        topologia.add(16);
        topologia.add(24);
        topologia.add(16);
        topologia.add(8);
        topologia.add(4);
        topologia.add(21);
        RedNeuronal rn = new RedNeuronal(8, 1, topologia);
        int cont = 0;
        
        double error = 0.0;
        do {
            for (int i = 0; i < 507; i++) {
                rn.entrenar(diabetes.get(i).getInputs(), diabetes.get(i).getTargets());
                System.out.println(rn.getErrTotal(diabetes.get(i).getTargets()));
                error = rn.getErrTotal(diabetes.get(i).getTargets());
                cont++;
            }
        } while (error > 0.00000001);
        System.out.println("Numero de datos entrenados: " + cont);
        
        for (int i = 508; i < diabetes.size(); i++) {
            ArrayList<Double> r = rn.predecir(diabetes.get(i).getInputs());
            System.out.println(r.get(0));
        }
    }
}
