package com.exercici0302;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestec {
    Llibre llibre;
    String dataPrestec;
    String dataRetorn;

    public Prestec(Llibre llibre, String dataPrestec, String dataRetorn) {
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataRetorn;
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    public String getDataPrestec() {
        return dataPrestec;
    }

    public void setDataPrestec(String dataPrestec) {
        this.dataPrestec = dataPrestec;
    }

    public String getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(String dataRetorn) {
        this.dataRetorn = dataRetorn; 
    }

    public boolean estaEnTermini() {
        DateTimeFormatter dataFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataRetornFormateada = LocalDate.parse(dataRetorn,dataFormateada);
        LocalDate hoy = LocalDate.now();
        return !hoy.isAfter(dataRetornFormateada);
    }
}



