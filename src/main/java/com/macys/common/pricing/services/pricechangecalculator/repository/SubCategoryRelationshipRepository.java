package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.PromotionRuleRelationship;
import com.macys.common.pricing.services.pricechangecalculator.model.SubCategoryRelationship;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRelationshipRepository
    extends GremlinRepository<SubCategoryRelationship, String> {
  
  

}
