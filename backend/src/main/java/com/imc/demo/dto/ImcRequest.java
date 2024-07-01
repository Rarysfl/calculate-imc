package com.imc.demo.dto;

public class ImcRequest {
    private double alturaCm;
    private double pesoKg;

    // Construtor vazio necessário para a deserialização JSON
    public ImcRequest() {}

    // Getters e Setters
    public double getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(double alturaCm) {
        this.alturaCm = alturaCm;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
}
