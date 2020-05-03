package com.currency.conversionservice.dto.conversion;

import com.currency.conversionservice.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResponse extends BaseDTO {

    private ConversionDTO conversion;

}
