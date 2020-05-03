package com.currency.exchangerateservice.client;

import com.currency.exchangerateservice.config.ExchangeRateClientConfig;
import com.currency.exchangerateservice.dto.FXRatesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${exchange.rate.name}", url = "${exchange.rate.url}", configuration = ExchangeRateClientConfig.class)
public interface ExchangeRateClient {

    @GetMapping
    FXRatesResponse getExchangeRates(@RequestParam("base") String from, @RequestParam("symbols") String to);

}
