package com.sahil.CurrencyConverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class ExchangeRateService {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + baseCurrency;
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        if (response != null && response.getRates().containsKey(targetCurrency)) {
            return response.getRates().get(targetCurrency);
        } else {
            throw new RuntimeException("Failed to fetch exchange rate for " + baseCurrency + " to " + targetCurrency);
        }
    }

    private static class ExchangeRateResponse {
        private String base;
        private Map<String, Double> rates;

        // Getters and Setters

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public Map<String, Double> getRates() {
            return rates;
        }

        public void setRates(Map<String, Double> rates) {
            this.rates = rates;
        }
    }
}
