package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Edge(label = "EXCLUDES")
@Data
public class AttributeExcludesRelationship {

  @Id
  @GeneratedValue
  Long id;

  @EdgeFrom
  private PromotionRule startNode;

  @EdgeTo
  private AttributeType endNode;
}
