package com.macys.common.pricing.services.pricechangecalculator.service;


import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.macys.common.pricing.services.pricechangecalculator.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemCrudService extends AbstractCrudService<ItemRepository, Item> {

}
