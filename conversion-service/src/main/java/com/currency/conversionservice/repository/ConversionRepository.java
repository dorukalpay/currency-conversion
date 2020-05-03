package com.currency.conversionservice.repository;

import com.currency.conversionservice.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConversionRepository extends JpaRepository<Conversion, Long>, ConversionRepositoryCustom, JpaSpecificationExecutor<Conversion> {

}
