package com.macys.common.pricing.services.pricechangecalculator.service;


import com.macys.common.pricing.services.pricechangecalculator.model.Category;
import com.macys.common.pricing.services.pricechangecalculator.repository.CatalogElementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatalogElementCrudService extends AbstractCrudService<CatalogElementRepository, Category> {

}
