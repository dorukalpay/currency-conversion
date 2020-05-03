package com.currency.conversionservice.dto.exchangerate;

import com.currency.conversionservice.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse extends BaseDTO {

    private ExchangeRateDTO exchangeRate;

}
