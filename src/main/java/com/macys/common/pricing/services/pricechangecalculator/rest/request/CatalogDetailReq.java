package com.macys.common.pricing.services.pricechangecalculator.rest.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDetailReq {

  String itemId;
  String color;
  String style;
  String department;
  String catalog;

}
