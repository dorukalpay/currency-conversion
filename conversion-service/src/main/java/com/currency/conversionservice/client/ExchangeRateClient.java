package com.currency.conversionservice.client;

import com.currency.conversionservice.config.ExchangeRateClientConfig;
import com.currency.conversionservice.dto.exchangerate.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${exchange.rate.name}", configuration = ExchangeRateClientConfig.class)
public interface ExchangeRateClient {

    @GetMapping("/rates")
    ExchangeRateResponse getExchangeRates(@RequestParam String sourceCurrency, @RequestParam String targetCurrency);
}
