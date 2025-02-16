package com.exercici0302;

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
        Llibre rst = new Llibre("", new Autor("", ""), 0);
        return rst;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    public String getDataPrestec() {
        return this.dataPrestec;
    }

    public void setDataPrestec(String dataPrestec) {
        this.dataPrestec = dataPrestec;
    }

    public String getDataRetorn() {
        return this.dataRetorn;
    }

    public void setDataRetorn(String dataRetorn) {
        this.dataRetorn = dataRetorn; 
    }

    public boolean estaEnTermini() { // mirar si tiene que ser con la fecha de hoy
        String[] dataPrestecSenseEspais = dataPrestec.split("/");
        String[] dataRetornSenseEspais = dataRetorn.split("/");

        return false;
    }
}



