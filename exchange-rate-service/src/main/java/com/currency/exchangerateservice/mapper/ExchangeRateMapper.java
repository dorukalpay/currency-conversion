package com.currency.exchangerateservice.mapper;

import com.currency.exchangerateservice.dto.ExchangeRateDTO;
import com.currency.exchangerateservice.entity.ExchangeRate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ExchangeRateMapper {

    @Mappings({
            @Mapping(target = "rate", source = "dto.exchangeRate"),
    })
    ExchangeRate dtoToEntity(ExchangeRateDTO dto);

    ExchangeRateDTO entityToDTO(ExchangeRate entity);
}
