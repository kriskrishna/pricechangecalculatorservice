package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import lombok.Data;


@Edge(label="HAS_PROMOTION_RULES")
@Data
//OLD CAN BE REMOVED
public class PromotionRuleRelationship {


  @GeneratedValue
  Long id;

  @EdgeFrom
  private PromotionRule startNode;

  @EdgeTo
  private Category catalogEndNode;
}
