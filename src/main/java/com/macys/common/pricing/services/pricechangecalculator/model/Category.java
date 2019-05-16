package com.macys.common.pricing.services.pricechangecalculator.model;

import java.util.List;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Vertex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Vertex
@Data
@AllArgsConstructor
@Builder
public class Category {
    
  @GeneratedValue
  Long id;
  
  
  private String type;

  private String name;

  @EdgeTo
  List<Category> children;

  //Introduced for option#4
  @EdgeSet
  List<AttributeType> attributeTypes;

  @EdgeSet
  private List<PromotionRule> includes;

  @EdgeSet
  private List<PromotionRule> excludes;

}
