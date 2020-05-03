package com.currency.exchangerateservice.service.impl;

import com.currency.exchangerateservice.client.ExchangeRateClient;
import com.currency.exchangerateservice.dto.ExchangeRateDTO;
import com.currency.exchangerateservice.dto.ExchangeRateResponse;
import com.currency.exchangerateservice.dto.FXRatesResponse;
import com.currency.exchangerateservice.mapper.ExchangeRateMapper;
import com.currency.exchangerateservice.repository.ExchangeRateRepository;
import com.currency.exchangerateservice.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateClient exchangeRateClient;

    private final ExchangeRateRepository exchangeRateRepository;

    private final ExchangeRateMapper exchangeRateMapper;

    public ExchangeRateServiceImpl(ExchangeRateClient exchangeRateClient, ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateClient = exchangeRateClient;
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    @Override
    public ExchangeRateResponse getExchangeRates(String sourceCurrency, String targetCurrency) {
        log.info("Getting exchange rate. Source Currency: {}, Target Currency: {} ", sourceCurrency, targetCurrency);
        FXRatesResponse response = exchangeRateClient.getExchangeRates(sourceCurrency, targetCurrency);

        ExchangeRateDTO exchangeRateDTO = ExchangeRateDTO.builder()
                .sourceCurrency(sourceCurrency)
                .targetCurrency(targetCurrency)
                .exchangeRate(response.getRates().get(targetCurrency))
                .build();

        log.info("Saving exchange rates. Source Currency: {}, Target Currency: {}, Exchange Rate: {} ", sourceCurrency, targetCurrency, response.getRates());
        exchangeRateRepository.save(exchangeRateMapper.dtoToEntity(exchangeRateDTO));

        return ExchangeRateResponse.builder()
                .exchangeRate(exchangeRateDTO)
                .build();
    }
}
