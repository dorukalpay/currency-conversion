package com.currency.conversionservice.service.impl;

import com.currency.conversionservice.client.ExchangeRateClient;
import com.currency.conversionservice.dto.conversion.*;
import com.currency.conversionservice.dto.exchangerate.ExchangeRateDTO;
import com.currency.conversionservice.dto.exchangerate.ExchangeRateResponse;
import com.currency.conversionservice.entity.Conversion;
import com.currency.conversionservice.mapper.ConversionMapper;
import com.currency.conversionservice.repository.ConversionRepository;
import com.currency.conversionservice.service.ConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ConversionServiceImpl implements ConversionService {

    private final ConversionRepository conversionRepository;

    private final ConversionMapper conversionMapper;

    private final ExchangeRateClient exchangeRateClient;

    public ConversionServiceImpl(ConversionRepository conversionRepository, ConversionMapper conversionMapper, ExchangeRateClient exchangeRateClient) {
        this.conversionRepository = conversionRepository;
        this.conversionMapper = conversionMapper;
        this.exchangeRateClient = exchangeRateClient;
    }

    @Override
    public ConversionResponse convert(ConversionRequest request) {
        BigDecimal exchangeRate = getExchangeRate(request.getSourceCurrency(), request.getTargetCurrency());

        BigDecimal convertedAmount = convertAmount(request.getAmount(), exchangeRate);

        Conversion conversion = saveConversion(request.getSourceCurrency(), request.getTargetCurrency(), request.getAmount(), convertedAmount, exchangeRate);

        return ConversionResponse.builder()
                .conversion(conversionMapper.entityToDTO(conversion))
                .build();
    }

    @Override
    public ConversionListResponse listConversions(ConversionListRequest request) {
        log.info("Getting conversions. Source Currency: {}, Target Currency: {} ,  Min. Date: {}, Max. Date: {} , ", request.getSourceCurrency(), request.getTargetCurrency(), request.getMinDate(), request.getMaxDate());
        List<Conversion> conversions = conversionRepository.findBySourceAndTargetAndDate(request.getSourceCurrency(), request.getTargetCurrency(), request.getMinDate(), request.getMaxDate());

        List<ConversionDTO> conversionsDTO = conversions.stream().map(conversionMapper::entityToDTO).collect(Collectors.toList());

        return ConversionListResponse.builder()
                .conversions(conversionsDTO)
                .build();
    }

    private BigDecimal getExchangeRate(String sourceCurrency, String targetCurrency) {
        log.info("Getting Exchange Rate. Source Currency: {}, Target Currency: {}", sourceCurrency, targetCurrency);
        ExchangeRateResponse exchangeRateResponse = exchangeRateClient.getExchangeRates(sourceCurrency, targetCurrency);

        ExchangeRateDTO exchangeRateDTO = exchangeRateResponse.getExchangeRate();

        return exchangeRateDTO.getExchangeRate();
    }

    private BigDecimal convertAmount(BigDecimal amount, BigDecimal exchangeRate) {
        log.info("Converting amount. Amount: {}, Exchange Rate: {}", amount, exchangeRate);
        return amount.multiply(exchangeRate).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private Conversion saveConversion(String sourceCurrency, String targetCurrency, BigDecimal sourceAmount, BigDecimal convertedAmount, BigDecimal exchangeRate) {
        Conversion conversion = new Conversion();
        conversion.setSourceCurrency(sourceCurrency);
        conversion.setTargetCurrency(targetCurrency);
        conversion.setSourceAmount(sourceAmount);
        conversion.setConvertedAmount(convertedAmount);
        conversion.setExchangeRate(exchangeRate);

        log.info("Saving conversion. Source Currency: {}, Target Currency: {} , Source Amount: {} , Converted AMount: {} ", sourceCurrency, targetCurrency, sourceAmount, convertedAmount);
        return conversionRepository.save(conversion);
    }

}
