package com.currency.conversionservice.entity.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dateTime;

    @PrePersist
    protected void onPrePersist() {
        this.dateTime = LocalDateTime.now();
    }
}
