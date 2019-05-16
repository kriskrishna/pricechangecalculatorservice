package com.macys.common.pricing.services.pricechangecalculator.rest.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemLocationReq {

  String itemId;
  String locationId;

}
