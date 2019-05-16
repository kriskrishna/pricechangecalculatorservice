package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Edge(label="SUBCATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//public class SubCategoryRole<S,E> {
public class SubCategoryRelationship {


  @GeneratedValue
  Long id;

  @EdgeFrom
  private Category catalogStartNode;

  @EdgeTo
  private Category catalogEndNode;
}
