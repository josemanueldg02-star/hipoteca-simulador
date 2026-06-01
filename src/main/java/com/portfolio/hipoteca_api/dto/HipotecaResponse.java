package com.portfolio.hipoteca_api.dto;

// IMPORTS
import java.util.List;

public record HipotecaResponse(
    double cuotaMensual,
    double totalInteres,
    double totalPagado,
    List<CuotaMensual> cuadroAmortizacion
) {}
