package com.macys.common.pricing.services.pricechangecalculator.service;

import com.macys.common.pricing.services.pricechangecalculator.model.Promotion;
import com.macys.common.pricing.services.pricechangecalculator.repository.PromotionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Slf4j
@Service
public class PromotionCrudService extends AbstractCrudService<PromotionRepository, Promotion> {

  public Promotion create(String name, Promotion data) {
    Promotion element = repository.findByName(name);
    if (element != null) log.warn("Record already exits name: {} detail: {}", name, element);
    return update(name, data);
  }

  public Promotion get(String name) {
    return repository.findByName(name);
  }

  public List<String> getPromotions(String department, String style, String color, String vendor, String material){
    return Arrays.asList("BOUNCE");
    //return repository.getMatchingPromotions(department, style, color, vendor, material);
  }
}