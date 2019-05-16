package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.macys.common.pricing.services.pricechangecalculator.model.MacyItem;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacyItemRepository
    extends GremlinRepository<MacyItem, String> {
  
  

}
