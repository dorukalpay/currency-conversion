package com.currency.conversionservice.service;

import com.currency.conversionservice.dto.conversion.ConversionListRequest;
import com.currency.conversionservice.dto.conversion.ConversionListResponse;
import com.currency.conversionservice.dto.conversion.ConversionRequest;
import com.currency.conversionservice.dto.conversion.ConversionResponse;

public interface ConversionService {

    ConversionResponse convert(ConversionRequest request);

    ConversionListResponse listConversions(ConversionListRequest request);
}
