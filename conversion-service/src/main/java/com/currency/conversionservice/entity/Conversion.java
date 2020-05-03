package com.currency.conversionservice.entity;

import com.currency.conversionservice.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "conversions")
public class Conversion extends BaseEntity {

    private String sourceCurrency;

    private String targetCurrency;

    private BigDecimal sourceAmount;

    private BigDecimal convertedAmount;

    private BigDecimal exchangeRate;
}
