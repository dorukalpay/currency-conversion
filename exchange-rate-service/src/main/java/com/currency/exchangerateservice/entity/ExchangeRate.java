package com.currency.exchangerateservice.entity;

import com.currency.exchangerateservice.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "exchange_rates")
public class ExchangeRate extends BaseEntity {

    private String sourceCurrency;

    private String targetCurrency;

    private String rate;

}

