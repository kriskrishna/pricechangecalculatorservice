package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.Promotion;
import com.macys.common.pricing.services.pricechangecalculator.model.PromotionRule;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRuleRepository
    extends AbstractRepository<PromotionRule> {
  
  

}
