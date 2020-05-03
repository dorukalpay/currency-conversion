package com.currency.conversionservice.dto.conversion;

import com.currency.conversionservice.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversionRequest extends BaseDTO {

    @NotBlank
    private String sourceCurrency;

    @NotBlank
    private String targetCurrency;

    @NotNull
    private BigDecimal amount;

}
