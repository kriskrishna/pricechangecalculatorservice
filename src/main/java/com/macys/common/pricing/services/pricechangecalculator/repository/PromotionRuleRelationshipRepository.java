package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.ItemAttributeRelationship;
import com.macys.common.pricing.services.pricechangecalculator.model.PromotionRuleRelationship;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRuleRelationshipRepository
    extends GremlinRepository<PromotionRuleRelationship, String> {
  
  

}
