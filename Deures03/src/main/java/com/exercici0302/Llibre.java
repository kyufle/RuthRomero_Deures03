package com.exercici0302;

public class Llibre {
    String titol;
    Autor autor;
    int anyPublicacio;

    public Llibre(String titol, Autor autor, int anyPublicacio) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;

    }

    public String getTitol() {
        return this.titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Autor getAutor() { //verificar que esto este bien 
        Autor rst = new Autor("", "");
        return rst;
    }

    public void setAutor(Autor autor) {
        this.autor=autor; 
    }

    public int getAnyPublicacio() {
        return this.anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }
}
