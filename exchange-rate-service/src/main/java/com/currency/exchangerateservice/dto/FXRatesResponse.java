package com.currency.exchangerateservice.dto;

import com.currency.exchangerateservice.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FXRatesResponse extends BaseDTO {

    private String base;

    private Map<String, BigDecimal> rates;
}
