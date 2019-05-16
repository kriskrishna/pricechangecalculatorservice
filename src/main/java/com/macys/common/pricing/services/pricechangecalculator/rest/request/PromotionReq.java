package com.macys.common.pricing.services.pricechangecalculator.rest.request;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionReq {
  String name;
  String desc;
  List<PromoTypeRequest> promoTypeRequestList;
}
