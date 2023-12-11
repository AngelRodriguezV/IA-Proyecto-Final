package com.angelrv.model;

import java.util.ArrayList;

public class Diabetes {
    private double Pregnancies;
    private double Glucose;
    private double BloodPressure;
    private double SkinThickness;
    private double Insulin;
    private double BMI;
    private double DiabetesPedigreeFunction;
    private double Age;
    private double Outcome;

    public void setPregnancies(double pregnancies) {
        Pregnancies = pregnancies;
    }

    public void setGlucose(double glucose) {
        Glucose = glucose;
    }

    public void setBloodPressure(double bloodPressure) {
        BloodPressure = bloodPressure;
    }

    public void setSkinThickness(double skinThickness) {
        SkinThickness = skinThickness;
    }

    public void setInsulin(double insulin) {
        Insulin = insulin;
    }

    public void setBMI(double bMI) {
        BMI = bMI;
    }

    public void setDiabetesPedigreeFunction(double diabetesPedigreeFunction) {
        DiabetesPedigreeFunction = diabetesPedigreeFunction;
    }

    public void setAge(double age) {
        Age = age;
    }

    public void setOutcome(double outcome) {
        Outcome = outcome;
    }

    
    public ArrayList<Double> getTargets() {
        ArrayList<Double> targets = new ArrayList<>();
        targets.add(this.Outcome);
        return targets;
    }

    public ArrayList<Double> getInputs() {
        ArrayList<Double> inputs = new ArrayList<>();
        inputs.add(this.Pregnancies);
        inputs.add(this.Glucose);
        inputs.add(this.BloodPressure);
        inputs.add(this.SkinThickness);
        inputs.add(this.Insulin);
        inputs.add(this.BMI);
        inputs.add(this.DiabetesPedigreeFunction);
        inputs.add(this.Age);
        return inputs;
    }

}
