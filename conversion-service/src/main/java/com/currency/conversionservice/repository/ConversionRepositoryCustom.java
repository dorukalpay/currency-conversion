package com.currency.conversionservice.repository;

import com.currency.conversionservice.entity.Conversion;

import java.time.LocalDate;
import java.util.List;

public interface ConversionRepositoryCustom {

    List<Conversion> findBySourceAndTargetAndDate(String sourceCurrency, String targetCurrency, LocalDate minDate, LocalDate maxDate);
}
