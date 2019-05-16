package com.macys.common.pricing.services.pricechangecalculator.service;


import java.util.List;
import java.util.stream.Collectors;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.macys.common.pricing.services.pricechangecalculator.model.Category;
import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.CatalogDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.ItemDetailResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemControllerService extends GenericControllerService<String, String, Item, ItemCrudService> {

  @Autowired
  CatalogControllerService catalogControllerService;

  @Autowired
  AttributeTypeCrudService attributeTypeCrudService;

  public ItemDetailResp createItem(ItemDetailReq itemDetailReq) {
    Category root = catalogControllerService.upsertCatalog(getCatalogReq(itemDetailReq));
    List<AttributeType> attributes = itemDetailReq.getItemAttributes().entrySet().stream().map(e -> {
      return attributeTypeCrudService.create(e.getKey(), e.getValue(), AttributeType.builder().type(e.getKey()).name(e.getValue()).build());
    }).collect(Collectors.toList());

    Item item = Item.builder().name(itemDetailReq.getItemId()).parent(getItemRelatedNode(itemDetailReq))
                /* .attributes(attributes) */.build();
    crudService.create("ITEM", itemDetailReq.getItemId(), item);
    return ItemDetailResp.builder().itemId(itemDetailReq.getItemId()).colorName(itemDetailReq.getColor()).build();
  }


  private Category getItemRelatedNode(ItemDetailReq itemDetailReq) {
    return catalogControllerService.getNode("COLOR", itemDetailReq.getColor());
  }

  private CatalogDetailReq getCatalogReq(ItemDetailReq itemDetailReq) {
    return CatalogDetailReq.builder().catalog(itemDetailReq.getCatalog())
        .color(itemDetailReq.getColor()).department(itemDetailReq.getDepartment())
        .itemId(itemDetailReq.getItemId()).style(itemDetailReq.getStyle()).build();
  }
  
}
