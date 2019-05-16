package com.macys.common.pricing.services.pricechangecalculator.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoTypeRequest {

  String type;
  String name;
  String promoTypeCondition;
}
