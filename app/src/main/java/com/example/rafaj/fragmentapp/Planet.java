package com.example.rafaj.fragmentapp;

public class Planet {

    private String planetas;
    private int imagen;
    private String edad;
    private String tamaño;

    public Planet(){

    }

    public Planet(String planetas, int imagen, String edad, String tamaño) {
        this.planetas = planetas;
        this.imagen = imagen;
        this.edad = edad;
        this.tamaño = tamaño;
    }

    public String getPlanetas() {
        return planetas;
    }

    public void setPlanetas(String planetas) {
        this.planetas = planetas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}