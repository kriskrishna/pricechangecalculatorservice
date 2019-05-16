package com.macys.common.pricing.services.pricechangecalculator.rest.response;


import java.util.List;

import com.macys.common.pricing.services.pricechangecalculator.rest.dto.PromotionRules;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemLocationResp {

  String itemId;
  String locationId;
  List<PromotionRules> promotionRulesList;
}

