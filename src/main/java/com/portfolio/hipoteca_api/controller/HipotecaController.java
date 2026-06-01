package com.portfolio.hipoteca_api.controller;

// IMPORTS
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.hipoteca_api.dto.HipotecaRequest;
import com.portfolio.hipoteca_api.dto.HipotecaResponse;
import com.portfolio.hipoteca_api.service.HipotecaService;


@RestController
@RequestMapping("/api/hipoteca")
@CrossOrigin(origins = "*")
public class HipotecaController {
    
    private final HipotecaService hipotecaService;

    public HipotecaController(HipotecaService hipotecaService) {
        this.hipotecaService = hipotecaService;
    }

    @PostMapping("/calcular")
    public HipotecaResponse calcular(@RequestBody HipotecaRequest request) {
        return hipotecaService.calcularHipoteca(request);
    }

}
