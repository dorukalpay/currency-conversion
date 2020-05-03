package com.currency.exchangerateservice.controller;

import com.currency.exchangerateservice.dto.ExchangeRateResponse;
import com.currency.exchangerateservice.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public ExchangeRateResponse getExchangeRates(@RequestParam String sourceCurrency, @RequestParam String targetCurrency) {
        return exchangeRateService.getExchangeRates(sourceCurrency, targetCurrency);
    }
}
