package com.macys.common.pricing.services.pricechangecalculator.model;

import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Edge(label = "ATTRIBUTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeRelationship {
    @GeneratedValue
    Long id;
    @EdgeFrom
    private AttributeType startNode;

    @EdgeTo
    private Item endNode;
}
