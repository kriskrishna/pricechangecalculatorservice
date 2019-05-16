package com.macys.common.pricing.services.pricechangecalculator.controller;


import java.util.List;

import com.macys.common.pricing.services.pricechangecalculator.rest.request.CatalogDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemLocationReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.PromotionReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.CatalogDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.GenericResponseEntity;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.ItemDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.PromotionDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.service.CatalogControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.ItemControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.PromotionControllerService;
import com.macys.common.pricing.services.pricechangecalculator.service.PromotionRuleControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Neo4jController.ENDPOINT)
public class Neo4jController extends GenericController<ItemLocationReq, GenericResponseEntity> {
  public static final String ENDPOINT = "neo4j-services";

  @Autowired
  CatalogControllerService catalogControllerService;

  @Autowired
  ItemControllerService itemControllerService;

  @Autowired
  PromotionControllerService promotionControllerService;

  @Autowired
  PromotionRuleControllerService promotionRuleControllerService;

  /*@GetMapping(name = "/{itemId}/{locationId}")
  public ResponseEntity<ItemLocationResp> getRules(@PathVariable String itemId, @PathVariable String locationId) {
    return getGenericResponseFor(ItemLocationResp.builder().itemId(itemId).locationId(locationId).build());
  }*/

  @PutMapping(value = "/{catalog}/{department}/{style}/{color}")
  public ResponseEntity<GenericResponseEntity> upsert(@PathVariable String catalog, @PathVariable String department,
      @PathVariable String style, @PathVariable(name="color", required = false) String color) {
    CatalogDetailResp detailResp = catalogControllerService.upsert(catalog, department, style, color);
    return getGenericResponseFor(detailResp);
  }


  @PutMapping(value = "/catalog")
  public ResponseEntity<GenericResponseEntity> createCatalogEntries(@RequestBody CatalogDetailReq catalogDetailReq) {
    CatalogDetailResp detailResp = catalogControllerService.createCatalog(catalogDetailReq);
    return getGenericResponseFor(detailResp);
  }

  @PutMapping(value = "/item")
  public ResponseEntity<GenericResponseEntity> createItem(@RequestBody ItemDetailReq itemDetailReq) {
    ItemDetailResp detailResp = itemControllerService.createItem(itemDetailReq);
    return getGenericResponseFor(detailResp);
  }

  /**
   * Apply promotion at item category level
   * @param promoName
   * @param catalog
   * @param department
   * @param style
   * @param color
   * @return
   */
  @PutMapping(value = "/promotion/{promoName}/{catalog}/{department}/{style}/{styleColor}")
  public ResponseEntity<GenericResponseEntity> applyItemPromotions(@PathVariable String promoName,
   @PathVariable String catalog, @PathVariable String department,
      @PathVariable String style, @PathVariable(name="color", required = false) String color) {
    PromotionDetailResp detailResp = promotionRuleControllerService.applyItemPromotions(promoName, catalog, department, style, color);
    return getGenericResponseFor(detailResp);
  }


  @PutMapping(value = "/promotion/attributes")
  public ResponseEntity<GenericResponseEntity> applyItemAttributePromotions(
      @RequestBody PromotionReq promotionReq) {
    PromotionDetailResp detailResp = promotionControllerService.applyItemAttributePromotions(promotionReq);
    return getGenericResponseFor(detailResp);
  }


  @GetMapping(value = "/promotion/{catalog}/{department}/{style}/{color}/{vendor}/{material}")
  public ResponseEntity<List<String>> getPromotions(
      @PathVariable String catalog, @PathVariable String department,
      @PathVariable String style, @PathVariable String color,
      @PathVariable String vendor, @PathVariable String material) {
    List<String> detailResp = promotionControllerService.getPromotions(catalog, department,
        style, color, vendor, material);
    return ResponseEntity.ok().body(detailResp);
  }
}
