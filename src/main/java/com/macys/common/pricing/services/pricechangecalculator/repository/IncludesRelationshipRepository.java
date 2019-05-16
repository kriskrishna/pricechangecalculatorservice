package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.ExcludesRelationship;
import com.macys.common.pricing.services.pricechangecalculator.model.IncludesRelationship;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncludesRelationshipRepository
    extends GremlinRepository<IncludesRelationship, String> {
  
  

}
