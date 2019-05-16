package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import lombok.Data;

@Edge(label="ITEM_ATTRIBUTE")
@Data
public class ItemAttributeRelationship {


  @GeneratedValue
  Long id;

  @EdgeFrom
  private AttributeType startNode;

  @EdgeTo
  private Category endNode;
}
