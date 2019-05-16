package com.macys.common.pricing.services.pricechangecalculator.service;


import java.util.ArrayList;
import java.util.List;

import com.macys.common.pricing.services.pricechangecalculator.model.Category;
import com.macys.common.pricing.services.pricechangecalculator.model.PromotionRule;
import com.macys.common.pricing.services.pricechangecalculator.rest.dto.CatalogHeirarchy;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.PromotionDetailResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PromotionRuleControllerService extends GenericControllerService<String, String, PromotionRule, PromotionRuleCrudService> {

  @Autowired
  CatalogElementCrudService catalogCrudService;

  public PromotionDetailResp applyItemPromotions(String promoName, String catalogName, String departmentName,
                                                 String styleName, String styleColor) {
    CatalogHeirarchy catalogHeirarchy = new CatalogHeirarchy(catalogName, departmentName, styleName);
    String catalogLevel = catalogHeirarchy.getCatalogLevel();
    String catalogElementName = catalogHeirarchy.getCatalogLevelValue();
    Category catalogElement = catalogCrudService.get(catalogLevel, catalogElementName);
    List<PromotionRule> l = new ArrayList<>();
    l.add(PromotionRule.builder().name(promoName).build());
    catalogElement.setIncludes(l);
    catalogCrudService.update(catalogElement.getName(),catalogElement);
    return PromotionDetailResp.builder().catalogLevel(catalogLevel).catalogLeveName(catalogElementName).name(promoName).build();
  }

}
