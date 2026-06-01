package com.portfolio.hipoteca_api.dto;

public record CuotaMensual(
    int mes,
    double principal,
    double intereses,
    double capitalPendiente
) {}
