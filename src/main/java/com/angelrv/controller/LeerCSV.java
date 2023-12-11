package com.angelrv.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.angelrv.model.Diabetes;
import com.angelrv.model.Iris;

public class LeerCSV {
    
    public static ArrayList<Iris> leerIris(String ruta) {
        ArrayList<Iris> iris = new ArrayList<Iris>();
        String linea = "";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                Iris new_iris = new Iris();
                new_iris.setId((int)Integer.parseInt(campos[0]));
                new_iris.setSepalLengthCm((double)Double.parseDouble(campos[1]));
                new_iris.setSepalWidthCm((double)Double.parseDouble(campos[2]));
                new_iris.setPetalLengthCm((double)Double.parseDouble(campos[3]));
                new_iris.setPetalWidthCm((double)Double.parseDouble(campos[4]));
                new_iris.setSpecies(campos[5]);
                iris.add(new_iris);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return iris;
    }

    public static ArrayList<Diabetes> leerDiavetes(String ruta) {
        ArrayList<Diabetes> diabetes = new ArrayList<Diabetes>();
        String linea = "";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                Diabetes new_diabetes = new Diabetes();
                new_diabetes.setPregnancies(Double.parseDouble(campos[0]));
                new_diabetes.setGlucose(Double.parseDouble(campos[1]));
                new_diabetes.setBloodPressure(Double.parseDouble(campos[2]));
                new_diabetes.setSkinThickness(Double.parseDouble(campos[3]));
                new_diabetes.setInsulin(Double.parseDouble(campos[4]));
                new_diabetes.setBMI(Double.parseDouble(campos[5]));
                new_diabetes.setDiabetesPedigreeFunction(Double.parseDouble(campos[6]));
                new_diabetes.setAge(Double.parseDouble(campos[7]));
                new_diabetes.setOutcome(Double.parseDouble(campos[8]));
                diabetes.add(new_diabetes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return diabetes;
    }

}
