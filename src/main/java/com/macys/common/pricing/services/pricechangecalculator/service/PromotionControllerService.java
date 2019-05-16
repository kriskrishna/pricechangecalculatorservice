package com.macys.common.pricing.services.pricechangecalculator.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.macys.common.pricing.services.pricechangecalculator.model.Category;
import com.macys.common.pricing.services.pricechangecalculator.model.Promotion;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.PromoTypeRequest;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.PromotionReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.PromotionDetailResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PromotionControllerService extends GenericControllerService<String, String, Promotion, PromotionCrudService> {

  @Autowired
  CatalogElementCrudService catalogCrudService;

  @Autowired
  AttributeTypeCrudService attributeTypeCrudService;

  @Autowired
  CatalogHierarchyHelper catalogHierarchyHelper;


  private List<String> catalogElementNames = Arrays.asList("DEPARTMENT", "DIVMASTERSTYLE", "CLASS", "SUBCLASS", "VENDOR", "MARKSTYLE");

  public PromotionDetailResp applyItemAttributePromotions(PromotionReq promotionReq) {
    applyPromotionsForCatalog(promotionReq);
    return applyPromotionsForItemAttributes(promotionReq);
  }

  private PromotionDetailResp applyPromotionsForItemAttributes(PromotionReq promotionReq) {
    Promotion promotionRule = crudService.get(promotionReq.getName());
    if (promotionRule == null ) {
      crudService.create(promotionReq.getName(), Promotion.builder().name(promotionReq.getName())
          .excludes(new ArrayList<>()).includes(new ArrayList<>()).build());
    }
    List<PromoTypeRequest> attributes = promotionReq.getPromoTypeRequestList().stream().filter(e -> !catalogHierarchyHelper.getCatalogHierarchy().contains(e.getType()))
        .filter( e -> !e.getType().equalsIgnoreCase("ITEM"))
        .collect(Collectors.toList());
    for (PromoTypeRequest e: attributes) {
      AttributeType element = attributeTypeCrudService.get(e.getType(), e.getName());
      if (element == null) {
        element = attributeTypeCrudService.create(e.getType(), e.getName(), AttributeType.builder().type(e.getType()).name(e.getName()).build());
      }
      if (e.getPromoTypeCondition().equals("EXCLUDES")) {
        if (promotionRule.getExcludes() == null) promotionRule.setExcludes(new ArrayList());
        promotionRule.getExcludes().add(element);
      } else {
        if (promotionRule.getIncludes() == null) promotionRule.setIncludes(new ArrayList());
        promotionRule.getIncludes().add(element);
      }
      crudService.update(promotionRule.getName(), promotionRule);
    }
    return PromotionDetailResp.builder().name(promotionReq.getName()).build();
  }

/*  private PromotionDetailResp applyPromotionsForVendor(PromotionReq promotionReq) {
    PromotionRule promotionRule = crudService.get(promotionReq.getName());
    if (promotionRule == null ) {
      crudService.create(promotionReq.getName(), PromotionRule.builder().name(promotionReq.getName())
          .excludes(new ArrayList<>()).includes(new ArrayList<>()).build());
    }
    List<PromoTypeRequest> attributes = promotionReq.getPromoTypeRequestList().stream().filter(e -> !catalogHierarchyHelper.getCatalogHierarchy().contains(e.getType()))
        .collect(Collectors.toList());
    boolean atAttributeLevel = attributes.stream().anyMatch(e -> e.getType().equalsIgnoreCase("ATTRIBUTE"));
    Vendor vendor = null;
    for (PromoTypeRequest e: attributes) {
      if (e.getType().equals("VENDOR")){
        vendor = saveVendorPromo(atAttributeLevel, e, promotionRule);
      } else if (e.getType().equals("ATTRIBUTE")) {
        AttributeType element = attributeTypeCrudService.get(e.getType(), e.getName());
        if (element == null) {
          element = attributeTypeCrudService.create(e.getName(), AttributeType.builder().type(e.getType()).name(e.getName()).build());
        }
        //TOOD null check and order
        vendor.getAttributes().add(element);
        vendorCrudService.update(vendor.getName(), vendor);
        if (e.getPromoTypeCondition().equals("EXCLUDES")) {
          promotionRule.getExcludes().add(element);
        } else {
          promotionRule.getIncludes().add(element);
        }
        promotionCrudService.update(promotionRule.getName(), promotionRule);

      } else {
        log.warn("Unknown type {}" , e);
      }
    }
    return PromotionDetailResp.builder().name(promotionReq.getName()).build();
  }

  private Vendor saveVendorPromo(boolean atAttributeLevel, PromoTypeRequest promoTypeRequest, PromotionRule promotionRule) {
    Vendor vendor = vendorCrudService.get(promoTypeRequest.getType(), promoTypeRequest.getName());
    if (vendor == null) {
      vendor = vendorCrudService.create(promoTypeRequest.getName(), Vendor.builder().name(promoTypeRequest.getName())
          .attributes(new ArrayList<>()).excludes(new ArrayList<>()).includes(new ArrayList<>()).build());
    }
    if (!atAttributeLevel) {
      if ("EXCLUDES".equals(promoTypeRequest.getPromoTypeCondition())) {
        promotionRule.getExcludes().add(vendor);
      } else {
        promotionRule.getIncludes().add(vendor);
      }
      promotionCrudService.update(promotionRule.getName(), promotionRule);

    }
    return vendor;
  }*/

  private void applyPromotionsForCatalog(PromotionReq promotionReq) {
    Promotion promotionRule = crudService.get(promotionReq.getName());
    if (promotionRule == null ) {
      promotionRule = crudService.create(promotionReq.getName(), Promotion.builder().name(promotionReq.getName())
          .excludes(new ArrayList<>()).includes(new ArrayList<>()).build());
    }
    for (PromoTypeRequest e : promotionReq.getPromoTypeRequestList()) {
      if (catalogHierarchyHelper.getCatalogHierarchy().contains(e.getType())) {
        Category element = catalogCrudService.get(e.getType(), e.getName());
        if (element != null) {
          if ("EXCLUDES".equals(e.getPromoTypeCondition())) {
            if (promotionRule.getExcludes() == null) promotionRule.setExcludes(new ArrayList());
            promotionRule.getExcludes().add(element);
          } else {
            if (promotionRule.getIncludes() == null) promotionRule.setIncludes(new ArrayList());
            promotionRule.getIncludes().add(element);
          }
        }
      }
    }
    crudService.update(promotionReq.getName(), promotionRule);
  }

  public List<String> getPromotions(String catalog, String department, String style, String color,
      String vendor, String material) {
    return crudService.getPromotions(department, style, color, vendor, material);
  }

  public PromotionDetailResp applyPromotions(PromotionReq promotionReq) {
    Promotion promotion = Promotion.builder().name(promotionReq.getName()).build();
    Map<String, List<Category>> relations = promotionReq.getPromoTypeRequestList().stream()
        .collect(Collectors.groupingBy(PromoTypeRequest::getPromoTypeCondition, Collectors.mapping(
            this::getCatalogElement, Collectors.toList()
        )));
    relations.entrySet().forEach(e -> {
      if ("INCLUDES".equals(e.getKey())) {
        promotion.setIncludes(e.getValue());
      } else promotion.setExcludes(e.getValue());
    });
    crudService.create(promotionReq.getName(), promotion);
    return PromotionDetailResp.builder().name(promotionReq.getDesc()).build();
  }

  private Category getCatalogElement(PromoTypeRequest promoTypeRequest) {
    return catalogCrudService.get(promoTypeRequest.getType(), promoTypeRequest.getName());
  }

  public PromotionDetailResp applyPromotionsOption4(PromotionReq promotionReq) {
    Promotion promotion = Promotion.builder().name(promotionReq.getName()).build();
    Map<String, List<Object>> relations = promotionReq.getPromoTypeRequestList().stream()
        .collect(Collectors.groupingBy(PromoTypeRequest::getPromoTypeCondition, Collectors.mapping(
            this::getElement, Collectors.toList()
        )));
    relations.entrySet().forEach(e -> {
      if ("INCLUDES".equals(e.getKey())) {
        promotion.setIncludes(e.getValue());
      } else promotion.setExcludes(e.getValue());
    });
    crudService.create(promotionReq.getName(), promotion);
    return PromotionDetailResp.builder().name(promotionReq.getDesc()).build();
  }

  private Object getElement(PromoTypeRequest promoTypeRequest) {
    if (catalogElementNames.contains(promoTypeRequest.getType())) {
      return catalogCrudService.get(promoTypeRequest.getType(), promoTypeRequest.getName());
    } else {
      return attributeTypeCrudService.get(promoTypeRequest.getType(), promoTypeRequest.getName());
    }
  }
}
