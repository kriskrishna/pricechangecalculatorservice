package com.macys.common.pricing.services.pricechangecalculator.model;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.Graph;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Graph(collection = "pricing")
@Data
@AllArgsConstructor
public class Pricing {

    @Id
    private String id;

    public Pricing() {
        this.edges = new ArrayList<Object>();
        this.vertexes = new ArrayList<Object>();
    }

    @EdgeSet
    @Getter
    private List<Object> edges;

    @VertexSet
    @Getter
    private List<Object> vertexes;
}
