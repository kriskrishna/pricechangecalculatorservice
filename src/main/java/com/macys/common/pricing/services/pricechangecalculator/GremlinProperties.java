package com.macys.common.pricing.services.pricechangecalculator;


import org.apache.tinkerpop.gremlin.driver.ser.Serializers;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("gremlin")
public class GremlinProperties {
    private String endpoint;    

    private int port;

    private String username;

    private String password;
    
    private boolean sslEnabled;

    private boolean telemetryAllowed = true;
    
    private String serializer = Serializers.GRAPHSON.toString();
}