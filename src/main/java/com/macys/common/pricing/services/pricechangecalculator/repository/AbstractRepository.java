package com.macys.common.pricing.services.pricechangecalculator.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import com.macys.common.pricing.services.pricechangecalculator.model.*;
import org.springframework.stereotype.Repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

@NoRepositoryBean
public interface AbstractRepository<T> extends GremlinRepository<T, String> {

  //@Query("MATCH (e:CatalogElement) WHERE e.name = {name}  AND e.type = {type} RETURN e")
  T findByName(@Param("type") String type, @Param("name") String name);
 
}