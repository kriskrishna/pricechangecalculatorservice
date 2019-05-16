package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.Pricing;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends GremlinRepository<Pricing, String> {
}