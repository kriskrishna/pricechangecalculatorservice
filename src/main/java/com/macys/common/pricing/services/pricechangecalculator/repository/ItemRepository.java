package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
    extends AbstractRepository<Item> {
  
  

}
