package com.M1;

import java.util.List;

public class Videojuegos {

    // 1. atributos
    public Long codeBar;
    public String nombre;
    public String plataforma;
    public Integer pegi;
    public Double precio;
    public Boolean multijugador;
    public List<String> ubicacion;
    public Integer stock;

    // 2. constructores


    public Videojuegos() {
    }


    public Videojuegos(Long codeBar, String nombre, String plataforma, Integer pegi, Double precio, Boolean multijugador, List<String> ubicacion, Integer stock) {
        this.codeBar = codeBar;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.pegi = pegi;
        this.precio = precio;
        this.multijugador = multijugador;
        this.ubicacion = ubicacion;
        this.stock = stock;
    }

    public Long getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(Long codeBar) {
        this.codeBar = codeBar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getMultijugador() {
        return multijugador;
    }

    public void setMultijugador(Boolean multijugador) {
        this.multijugador = multijugador;
    }

    public List<String> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<String> ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Videojuegos{" +
                "codeBar='" + codeBar + '\'' +
                ", nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", pegi=" + pegi +
                ", precio=" + precio +
                ", multijugador=" + multijugador +
                ", ubicacion=" + ubicacion +
                ", stock=" + stock +
                '}';
    }
}


