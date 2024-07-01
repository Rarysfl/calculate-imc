package com.imc.demo.controller;

import com.imc.demo.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import com.imc.demo.dto.ImcRequest;
import com.imc.demo.dto.ImcResponse;

@RestController
@RequestMapping("/api")
public class ImcController {
    private final ImcService imcService;

    @Autowired
    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcularImc(@RequestBody ImcRequest imcRequest) {
        ImcResponse imcResponse = imcService.calcularImc(imcRequest.getAlturaCm(), imcRequest.getPesoKg());
        return ResponseEntity.ok(imcResponse);
    }


    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("API está online e operacional!");
    }
}
