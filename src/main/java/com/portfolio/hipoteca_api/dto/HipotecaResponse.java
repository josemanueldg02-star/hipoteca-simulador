package com.portfolio.hipoteca_api.dto;

public record HipotecaResponse(
    double cuotaMensual,
    double totalInteres,
    double totalPagado
) {}
