package com.portfolio.hipoteca_api.service;

// IMPORTS
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.portfolio.hipoteca_api.dto.CuotaMensual;
import com.portfolio.hipoteca_api.dto.HipotecaRequest;
import com.portfolio.hipoteca_api.dto.HipotecaResponse;

@Service
public class HipotecaService {

    public HipotecaResponse calcularHipoteca(HipotecaRequest request) {
        
        double p = request.capital();
        double interesAnual = request.interesAnual();
        int anios = request.anios();

        int n = anios * 12; 
        double r = (interesAnual / 100) / 12; 

        double cuotaMensualReal;

        if (r == 0) {
            cuotaMensualReal = p / n; 
        } else {
            double factor = Math.pow(1 + r, n);
            cuotaMensualReal = p * (r * factor) / (factor - 1);
        }

        double totalPagado = cuotaMensualReal * n;
        double totalIntereses = totalPagado - p;

        //CUADRO DE AMORTIZACIÓN
        List<CuotaMensual> cuadro = new ArrayList<>();
        double deudaPendiente = p;

        for (int i = 1; i <= n; i++) {
            double interesesDelMes = deudaPendiente * r;
            double principalDelMes = cuotaMensualReal - interesesDelMes;
            deudaPendiente = deudaPendiente - principalDelMes;

            if (deudaPendiente < 0) deudaPendiente = 0;

            cuadro.add(new CuotaMensual(
                i,
                Math.round(principalDelMes * 100.0) / 100.0,
                Math.round(interesesDelMes * 100.0) / 100.0,
                Math.round(deudaPendiente * 100.0) / 100.0
            ));
        }

        return new HipotecaResponse(
            Math.round(cuotaMensualReal * 100.0) / 100.0, 
            Math.round(totalIntereses * 100.0) / 100.0, 
            Math.round(totalPagado * 100.0) / 100.0,
            cuadro 
        );
    }
}