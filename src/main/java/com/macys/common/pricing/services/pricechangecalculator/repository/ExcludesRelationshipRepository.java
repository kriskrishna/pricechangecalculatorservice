package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeIncludesRelationship;
import com.macys.common.pricing.services.pricechangecalculator.model.ExcludesRelationship;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcludesRelationshipRepository
    extends GremlinRepository<ExcludesRelationship, String> {
  
  

}
