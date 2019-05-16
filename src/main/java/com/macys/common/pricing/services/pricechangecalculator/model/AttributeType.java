package com.macys.common.pricing.services.pricechangecalculator.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.microsoft.spring.data.gremlin.annotation.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.aspectj.asm.internal.Relationship;
import org.springframework.data.annotation.Id;


@Data
@Vertex
@AllArgsConstructor
@Builder
public class AttributeType{

  @Id
  @GeneratedValue
  Long id;

  private String type;

  private String name;

  @EdgeTo
  private List<Category> items;

  @EdgeTo
  private List<PromotionRule> includes;

  @EdgeTo
  private List<PromotionRule> excludes;

}
