package com.macys.common.pricing.services.pricechangecalculator.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Vertex;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Vertex
@Data
@AllArgsConstructor
@Builder
public class Promotion<T>{

  @GeneratedValue
  Long id;


  private String name;

  private String desc;

  @EdgeSet
  private List<T> includes;

  @EdgeSet
  private List<T> excludes;

  @EdgeSet
  private List<Category> catalogElements;
}
