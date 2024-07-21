package com.sahil.CurrencyConverter.controller;

import com.sahil.CurrencyConverter.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam String baseCurrency,
                                  @RequestParam String targetCurrency,
                                  @RequestParam double amount,
                                  Model model) {
        try {
            double exchangeRate = exchangeRateService.getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;
            model.addAttribute("convertedAmount", String.format("%.2f", convertedAmount) + " " + targetCurrency);
        } catch (RuntimeException e) {
            model.addAttribute("error", "Failed to fetch exchange rate. Please try again later.");
        }
        return "index";
    }
}
