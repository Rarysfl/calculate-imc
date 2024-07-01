package com.imc.demo.service;

import org.springframework.stereotype.Service;
import com.imc.demo.dto.ImcRequest;
import com.imc.demo.dto.ImcResponse;

@Service
public class ImcService {
//    public double calcularImc(double alturaEmCm, double pesoKg) {
//        double alturaEmMetros = alturaEmCm / 100.0;
//        return pesoKg / (alturaEmMetros * alturaEmMetros);
//    }

    public ImcResponse calcularImc(double alturaEmCm, double pesoKg) {
        double alturaEmMetros = alturaEmCm / 100.0;
        double imc = pesoKg / (alturaEmMetros * alturaEmMetros);
        String message;
        String classification;

        imc = Math.round(imc * 100.0) / 100.0;

        if (imc < 18.5) {
            message = "Cuidado! Você está abaixo do peso ideal!";
            classification = "underweight";
        } else if (imc >= 18.5 && imc <= 25) {
            message = "Parabéns, você está no peso ideal!";
            classification = "normal";
        } else if (imc > 25 && imc <= 30) {
            message = "Cuidado! Você está com sobrepeso!";
            classification = "overweight";
        } else if (imc > 30 && imc <= 35) {
            message = "Cuidado! Você está com obesidade moderada!";
            classification = "obesity";
        } else if (imc > 35 && imc <= 40) {
            message = "Cuidado! Você está com obesidade severa!";
            classification = "severe-obesity";
        } else {
            message = "Cuidado! Você está com obesidade mórbida!";
            classification = "morbid-obesity";
        }

        return new ImcResponse(imc, message, classification);
    }
}
