package com.currency.exchangerateservice.service;

import com.currency.exchangerateservice.dto.ExchangeRateResponse;

public interface ExchangeRateService {

    ExchangeRateResponse getExchangeRates(String sourceCurrency, String targetCurrency);
}
