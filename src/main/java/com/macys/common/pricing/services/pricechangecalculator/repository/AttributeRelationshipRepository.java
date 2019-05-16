package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeIncludesRelationship;
import com.macys.common.pricing.services.pricechangecalculator.model.AttributeRelationship;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRelationshipRepository
    extends GremlinRepository<AttributeRelationship, String> {
  
  

}
