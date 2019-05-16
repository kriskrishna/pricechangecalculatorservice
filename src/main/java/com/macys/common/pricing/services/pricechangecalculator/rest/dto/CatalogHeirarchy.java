package com.macys.common.pricing.services.pricechangecalculator.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CatalogHeirarchy {

  private String catalog;
  private String department;
  private String style;
  private String color;
  private String catalogLevel;
  private String catalogLevelValue;

  public CatalogHeirarchy(String catalogName, String department, String style) {
    this.catalog = catalogName;
    this.department = department;
    this.style = style;
    invoke();
  }

  private void invoke() {
    catalogLevel = "CATALOG";
    catalogLevelValue = catalog;
  /*if (styleColor != null) {
    catalogLevel = "COLOR";
    catalogLevelValue = styleColor;
  } else */
    if (style != null) {
      catalogLevel = "STYLE";
      catalogLevelValue = style;
    } else if (department != null) {
      catalogLevel = "DEPARTMENT";
      catalogLevelValue = department;
    }
  }

  public String getCatalogElementFor(String type) {
    if ("CATALOG".equals(type)) {
      return catalog;
    } else if ("DEPARTMENT".equals(type)) {
      return department;
    } else if ("STYLE".equals(type)) {
      return style;
    } else if ("COLOR".equals(type)) {
      return color;
    }
    return "";
  }
}
