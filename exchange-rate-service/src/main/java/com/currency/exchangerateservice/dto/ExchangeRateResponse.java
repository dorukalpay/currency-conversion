package com.currency.exchangerateservice.dto;

import com.currency.exchangerateservice.dto.base.BaseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRateResponse extends BaseDTO {

    private ExchangeRateDTO exchangeRate;

}
