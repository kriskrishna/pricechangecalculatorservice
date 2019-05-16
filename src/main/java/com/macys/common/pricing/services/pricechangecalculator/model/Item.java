package com.macys.common.pricing.services.pricechangecalculator.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
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
public class Item {

    @GeneratedValue
    Long id;

    private String name;

    // @EdgeSet
    // List<AttributeType> attributes;
    @EdgeFrom
    Attribute attribute;
    
    @EdgeFrom
    Category parent;

    String brand;
    int brandId;
    int classNumber;
    int collectionsId;
    int colorNumber;
    BigDecimal cost;
    String country;
    BigDecimal currentOwnedPrice;
    BigDecimal currentTicketedPrice;
    Date dateCreated;
    Date dateModified;
    int departmentNumber;
    String digitizedFlag;
    BigDecimal firstOwnedPrice;
    BigDecimal firstTicketPrice;
    String groupLevel;
    String label;
    BigDecimal lastOwnedPrice;
    BigDecimal lastTicketedPrice;
    String marketingId;
    String marketingIdStatusCode;
    int markstyleNumber;
    BigInteger masterstyleNumber;
    int minOrderQty;
    int minTransferQty;
    BigDecimal msrp;
    String multiOf;
    String parentProductId;
    String pid;
    String priceLevel;
    String productGroup;
    String replenishFlag;
    int sizeNumber;
    Date skuDiscontinuedDate;
    String skuType;
    int subclassNumber;
    int transferPackQty;
    String uccId;
    String v2c;
    Date vendorDiscontinuedDate;
    int vendorNumber;
    String vstyle;

}
