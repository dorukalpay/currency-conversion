package com.currency.conversionservice.mapper;

import com.currency.conversionservice.dto.conversion.ConversionDTO;
import com.currency.conversionservice.entity.Conversion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ConversionMapper {

    Conversion dtoToEntity(ConversionDTO dto);

    @Mappings({
            @Mapping(target = "conversionDate", source = "entity.dateTime"),
    })
    ConversionDTO entityToDTO(Conversion entity);
}
