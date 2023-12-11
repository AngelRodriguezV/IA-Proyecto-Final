package com.angelrv.model;

import java.util.ArrayList;

public class Iris {
    
    private int id;
    private double sepalLengthCm;
    private double sepalWidthCm;
    private double petalLengthCm;
    private double petalWidthCm;
    private String species;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSepalLengthCm(double sepalLengthCm) {
        this.sepalLengthCm = sepalLengthCm;
    }

    public double getSepalLengthCm() {
        return sepalLengthCm;
    }

    public void setSepalWidthCm(double sepalWidthCm) {
        this.sepalWidthCm = sepalWidthCm;
    }

    public double getSepalWidthCm() {
        return sepalWidthCm;
    }

    public void setPetalLengthCm(double petalLengthCm) {
        this.petalLengthCm = petalLengthCm;
    }

    public double getPetalLengthCm() {
        return petalLengthCm;
    }

    public void setPetalWidthCm(double petalWidthCm) {
        this.petalWidthCm = petalWidthCm;
    }

    public double getPetalWidthCm() {
        return petalWidthCm;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public ArrayList<Double> getTargets() {
        ArrayList<Double> targets = new ArrayList<>();
        switch (this.species) {
            case "Iris-setosa":
                targets.add(0.0);
                targets.add(1.0);
                break;
            case "Iris-versicolor":
                targets.add(1.0);
                targets.add(0.0);
                break;
            case "Iris-virginica":
                targets.add(1.0);
                targets.add(1.0);
                break;
        }
        return targets;
    }

    public ArrayList<Double> getInputs() {
        ArrayList<Double> inputs = new ArrayList<>();
        inputs.add(this.sepalLengthCm);
        inputs.add(this.sepalWidthCm);
        inputs.add(this.petalLengthCm);
        inputs.add(this.petalWidthCm);
        return inputs;
    }
}
