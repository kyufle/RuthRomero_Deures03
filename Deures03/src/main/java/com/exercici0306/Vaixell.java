package com.exercici0306;

import java.util.ArrayList;

public class Vaixell implements Transportable {
    protected String nom;
    protected double capacitat;
    protected ArrayList<Carrega> carrega;

    public Vaixell(String nom, double capacitat) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.carrega = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCapacitat() {
        return capacitat;
    }
   
    public void setCapacitat(double capacitat) {
        this.capacitat = capacitat;
    }

    public void afegirCarrega(Carrega c) {
        carrega.add(c);
    }

    public ArrayList<Carrega> getCarregues() {
        return carrega;
    }

    @Override
    public double getPesTotal() {
        double pesTotal = 0;
        for (Carrega pes : carrega){
            pesTotal += pes.getPes();
        }
        return pesTotal;
    }

    @Override
    public String toString() {
        return "Vaixell[nom="+nom+", capacitat="+capacitat+", pesActual="+getPesTotal()+"]";
    }
}
