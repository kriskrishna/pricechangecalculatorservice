package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Vertex;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.aspectj.asm.internal.Relationship;

@Vertex
@Data
@AllArgsConstructor
@Builder
public class MacyItem {


  @GeneratedValue
  Long id;

  private String name;

  private String type;

  @EdgeTo
  List<AttributeType> attributes;


  @EdgeFrom
  Category parent;

}
