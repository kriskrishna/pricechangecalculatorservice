package com.macys.common.pricing.services.pricechangecalculator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.macys.common.pricing.services.pricechangecalculator.repository.ItemRepository;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemLocationReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.PromotionReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.GenericResponseEntity;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.ItemDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.PromotionDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.service.CatalogControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.ItemControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.PromotionControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.PromotionRuleControllerService;

@RestController
@RequestMapping(value = MacysOptionsController.ENDPOINT)
public class MacysOptionsController extends GenericController<ItemLocationReq, GenericResponseEntity> {
  public static final String ENDPOINT = "neo4j-services";

  @Autowired
  CatalogControllerService catalogControllerService;

  @Autowired
  ItemControllerService itemControllerService;

  @Autowired
  PromotionControllerService promotionControllerService;

  @Autowired
  PromotionRuleControllerService promotionRuleControllerService;
  
  @Autowired
  ItemRepository repo;


  @PutMapping(value = "/promotion/option-3/attributes")
  public ResponseEntity<GenericResponseEntity> applyItemAttributePromotions(
      @RequestBody PromotionReq promotionReq) {
    PromotionDetailResp detailResp = promotionControllerService.applyPromotions(promotionReq);
    return getGenericResponseFor(detailResp);
  }

  @PutMapping(value = "/item/option-3")
  public ResponseEntity<GenericResponseEntity> createItem(@RequestBody ItemDetailReq itemDetailReq) {
    ItemDetailResp detailResp = catalogControllerService.createItemAndRelatedAttributes(itemDetailReq);
    return getGenericResponseFor(detailResp);
  }

  @PutMapping(value = "/promotion/option-4/attributes")
  public ResponseEntity<GenericResponseEntity> applyItemAttributePromotionsOption4(
      @RequestBody PromotionReq promotionReq) {
    PromotionDetailResp detailResp = promotionControllerService.applyPromotionsOption4(promotionReq);
    return getGenericResponseFor(detailResp);
  }

  @PutMapping(value = "/item/option-4")
  public ResponseEntity<GenericResponseEntity> createItemOption4(@RequestBody ItemDetailReq itemDetailReq) {
    ItemDetailResp detailResp = catalogControllerService.createItemAndRelatedAttributesOption4(itemDetailReq);
    return getGenericResponseFor(detailResp);
  }
  
      @GetMapping(value = "/item/upc/{upc}")
      public long getItemByUpc(@PathVariable String upc) {
          
          return repo.edgeCount();
      }
}
