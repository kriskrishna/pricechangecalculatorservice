package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTypeRepository
    extends AbstractRepository<AttributeType> {

}
