package com.portfolio.hipoteca_api.dto;

public record HipotecaRequest (
    double capital,
    double interesAnual,
    int anios
    
 ) {}
