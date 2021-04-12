package com.example.parcial1casa;

import java.io.Serializable;

public class Productos implements Serializable {

   private String Nombre;
    private int Codigo;
    private int Valor;
    private String Iva;
    private String Categoria;

    public Productos() {
    }

    public Productos(String nombre, int codigo, int valor, String iva, String categoria) {
        Nombre = nombre;
        Codigo = codigo;
        Valor = valor;
        Iva = iva;
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "Nombre='" + Nombre + '\'' +
                ", Codigo=" + Codigo +
                ", Valor=" + Valor +
                ", Iva='" + Iva + '\'' +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public String getIva() {
        return Iva;
    }

    public void setIva(String iva) {
        Iva = iva;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}

