package com.currency.conversionservice.dto.conversion;

import com.currency.conversionservice.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionListResponse extends BaseDTO {

    private List<ConversionDTO> conversions;
}
