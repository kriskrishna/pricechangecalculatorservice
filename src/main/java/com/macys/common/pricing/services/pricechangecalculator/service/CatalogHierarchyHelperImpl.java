package com.macys.common.pricing.services.pricechangecalculator.service;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CatalogHierarchyHelperImpl implements CatalogHierarchyHelper {

  @Override
  public List<String> getCatalogHierarchy() {
    String[] hierarchy = {"CATALOG", "DEPARTMENT", "STYLE", "COLOR"};
    log.debug("Hierarchy of catalog elements {} ", Arrays.asList(hierarchy));
    return Arrays.asList(hierarchy);
  }

  @Override
  public String getNextHierarchy(String hierarchyElemetName) {
    List<String> catalogHierarchy = getCatalogHierarchy();
    for (int i =0 ; i < catalogHierarchy.size(); i ++) {
      if ( catalogHierarchy.get(i).equalsIgnoreCase(hierarchyElemetName)
          && (i+1) < catalogHierarchy.size()) {
        log.debug("Next in hierarchy after {} is {}", hierarchyElemetName, catalogHierarchy.get(i+1));
        return catalogHierarchy.get(i+1);
      }
    }
    return "";
  }

  @Override
  public String getPreviousHierarchy(String hierarchyElemetName) {
    List<String> catalogHierarchy = getCatalogHierarchy();
    for (int i =0 ; i < catalogHierarchy.size(); i ++) {
      if ( catalogHierarchy.get(i).equalsIgnoreCase(hierarchyElemetName)
          && (i-1) >= 0) {
        log.debug("Previous in hierarchy after {} is {}", hierarchyElemetName, catalogHierarchy.get(i-1));
        return catalogHierarchy.get(i-1);
      }
    }
    return "";
  }

  @Override
  public String getLowestHierarchy() {
    List<String> catalogHierarchy = getCatalogHierarchy();
    return catalogHierarchy.get(catalogHierarchy.size()-1);
  }

  @Override
  public String getHighestHierarchy() {
    return getCatalogHierarchy().get(0);
  }
}
