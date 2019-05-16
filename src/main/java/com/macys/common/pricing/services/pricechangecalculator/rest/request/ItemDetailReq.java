package com.macys.common.pricing.services.pricechangecalculator.rest.request;


import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetailReq {

  String itemId;
  String color;
  String style;
  String department;
  String catalog;
  String desc;
  Map<String, String> itemAttributes;

}
