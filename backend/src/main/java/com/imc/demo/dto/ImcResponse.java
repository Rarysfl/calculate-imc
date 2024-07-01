package com.imc.demo.dto;

public class ImcResponse {
    private double imc;
    private String message;
    private String classification;

    public ImcResponse(double imc, String message, String classification) {
        this.imc = imc;
        this.message = message;
        this.classification = classification;
    }

    // Getters
    public double getImc() {
        return imc;
    }

    public String getMessage() {
        return message;
    }

    public String getClassification() {
        return classification;
    }
}
