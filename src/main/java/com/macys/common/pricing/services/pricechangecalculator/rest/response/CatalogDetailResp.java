package com.macys.common.pricing.services.pricechangecalculator.rest.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CatalogDetailResp extends GenericResponseEntity{

  String catalogName;
  String departmentName;
  String styleName;
  String colorName;
}

