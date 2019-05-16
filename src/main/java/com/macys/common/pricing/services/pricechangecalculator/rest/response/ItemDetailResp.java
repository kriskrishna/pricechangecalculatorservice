package com.macys.common.pricing.services.pricechangecalculator.rest.response;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemDetailResp extends GenericResponseEntity{

  String catalogName;
  String departmentName;
  String styleName;
  String colorName;
  String itemId;
  Map<String, String> itemAttributes;
}

