package com.sahil.CurrencyConverter.model;

import lombok.Data;

@Data
public class CurrencyConversion {
    private String baseCurrency;
    private String targetCurrency;
    private double amount;
    private double convertedAmount;
}

