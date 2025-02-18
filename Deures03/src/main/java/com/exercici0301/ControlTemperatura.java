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

    public String getNomZona() {
        return nomZona;
    }
    
    public double getTemperatura() {
        return temperatura;
    }

    public void ajustaTemperatura(double novaTemperatura) {
        temperaturaTotal -= this.temperatura;
        this.temperatura= novaTemperatura;
        temperaturaTotal += novaTemperatura;
    }

    public static double getTemperaturaMitjana() {
        if (comptadorZones == 0){
            return 0.0;
        }
        return temperaturaTotal/comptadorZones;
    }
}

