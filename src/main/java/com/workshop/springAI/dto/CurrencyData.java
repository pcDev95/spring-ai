package com.workshop.springAI.dto;

public record CurrencyData(String country, String currency, String symbol, String code, String asOnDate, String usdRate,
        String notFoundMessage) {
}
