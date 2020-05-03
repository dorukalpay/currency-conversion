package com.currency.conversionservice.dto.conversion;

import com.currency.conversionservice.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversionListRequest extends BaseDTO {

    private String sourceCurrency;

    private String targetCurrency;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxDate;

}
