package com.exercici0301;

public class ControlTemperatura {
    private static double temperaturaTotal;
    private static int comptadorZones;
    private String nomZona;
    private double temperatura;

    public ControlTemperatura(String nomZona, double temperatura) {
        this.nomZona = nomZona;
        this.temperatura = temperatura;
        temperaturaTotal += temperatura;
        comptadorZones++;
    }

    public double getTemperatura() {
        return 0.0;
    }

    public void ajustaTemperatura(double novaTemperatura) {
        temperaturaTotal -= temperatura;
        novaTemperatura = temperatura;
        temperaturaTotal += novaTemperatura;
    }

    public static double getTemperaturaMitjana() {
        return temperaturaTotal/comptadorZones;
    }
}

