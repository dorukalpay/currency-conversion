package com.currency.exchangerateservice.dto;

import com.currency.exchangerateservice.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateDTO extends BaseDTO {

    private String sourceCurrency;

    private String targetCurrency;

    private BigDecimal exchangeRate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
}
