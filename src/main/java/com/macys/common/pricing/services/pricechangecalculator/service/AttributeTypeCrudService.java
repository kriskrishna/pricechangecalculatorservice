package com.macys.common.pricing.services.pricechangecalculator.service;


import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.macys.common.pricing.services.pricechangecalculator.repository.AttributeTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AttributeTypeCrudService extends AbstractCrudService<AttributeTypeRepository, AttributeType> {

  public AttributeType create(String type, String name, AttributeType data) {
    AttributeType element = repository.findByName(type, name);
    if (element != null) log.warn("Record already exits name: {} detail: {}", name, element);
    return update(name, data);
  }

  public AttributeType get(String type, String name) {
    return repository.findByName(type, name);
  }

}
