package com.macys.common.pricing.services.pricechangecalculator.rest.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PromotionDetailResp extends GenericResponseEntity{

  String catalogLevel;
  String catalogLeveName;
  String name;
}

