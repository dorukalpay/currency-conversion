package com.currency.conversionservice.repository.Impl;

import com.currency.conversionservice.entity.Conversion;
import com.currency.conversionservice.repository.ConversionRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConversionRepositoryCustomImpl implements ConversionRepositoryCustom {

    private EntityManager entityManager;

    public ConversionRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Conversion> findBySourceAndTargetAndDate(String sourceCurrency, String targetCurrency, LocalDate minDate, LocalDate maxDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Conversion> criteriaQuery = criteriaBuilder.createQuery(Conversion.class);

        Root<Conversion> conversionRoot = criteriaQuery.from(Conversion.class);
        List<Predicate> predicates = new ArrayList<>();

        if (sourceCurrency != null) {
            predicates.add(criteriaBuilder.equal(conversionRoot.get("sourceCurrency"), sourceCurrency));
        }
        if (targetCurrency != null) {
            predicates.add(criteriaBuilder.equal(conversionRoot.get("targetCurrency"), targetCurrency));
        }
        if (minDate != null) {
            predicates.add(criteriaBuilder.greaterThan(conversionRoot.get("dateTime"), minDate.atStartOfDay()));
        }
        if (maxDate != null) {
            predicates.add(criteriaBuilder.lessThan(conversionRoot.get("dateTime"), maxDate.plusDays(1).atStartOfDay()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Conversion> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
