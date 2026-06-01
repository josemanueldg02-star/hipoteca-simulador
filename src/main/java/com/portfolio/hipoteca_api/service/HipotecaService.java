// Cuota = P * [ r * (1 + r)^n ] / [ (1 + r)^n - 1 ]   --> FÓRMULA BANCARIA
package com.portfolio.hipoteca_api.service;

// IMPORTS
import org.springframework.stereotype.Service;
import com.portfolio.hipoteca_api.dto.HipotecaRequest;
import com.portfolio.hipoteca_api.dto.HipotecaResponse;

@Service
public class HipotecaService {

    public HipotecaResponse calcularHipoteca(HipotecaRequest request) {

        double p = request.capital();
        double interesAnual = request.interesAnual();
        int anios = request.anios();

        // Preparación de datos (Convertir años a meses y el interés anual a mensual).
        int n = anios *12;
        double r = (interesAnual / 100) / 12;

        double cuotaMensual;

        // Fórmula del banco.
        if (r == 0) {
            cuotaMensual = p/n;
        } else {
            // Para el sistema Francés.
            double factor = Math.pow(1 + r, n);
            cuotaMensual = p* (r * factor) / (factor - 1);
        }

        // Calculo de totales.
        double totalPagado = cuotaMensual * n;
        double totalIntereses = totalPagado - p;

        // Redondeo a 2 decimales.
        cuotaMensual = Math.round(cuotaMensual * 100.0) / 100.0;
        totalIntereses = Math.round(totalIntereses * 100.0) / 100.0;
        totalPagado = Math.round(totalPagado * 100.0) / 100.0;

        return new HipotecaResponse(cuotaMensual, totalIntereses, totalPagado);
    }
    
}
