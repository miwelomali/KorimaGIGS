package com.example.eva1_11_listarestaurantes;

public class Restaurante {
    private int Imagen;
    private String Nombre;
    private String Comida;
    private String Locacion;
    private Double Rating;

    public Restaurante(){
        Imagen = R.drawable.f2;
        Nombre = "Taller del chef";
        Comida = "Restaunrate Japones";
        Locacion = "Colonia Centro";
        Rating = 4.0;
    }

    public Restaurante(int imagen, String nombre, String comida, String locacion, Double rating) {
        Imagen = imagen;
        Nombre = nombre;
        Comida = comida;
        Locacion = locacion;
        Rating = rating;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getComida() {
        return Comida;
    }

    public void setComida(String comida) {
        Comida = comida;
    }

    public String getLocacion() {
        return Locacion;
    }

    public void setLocacion(String locacion) {
        Locacion = locacion;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }
}
