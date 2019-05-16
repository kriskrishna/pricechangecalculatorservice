package com.macys.common.pricing.services.pricechangecalculator.repository;

import com.macys.common.pricing.services.pricechangecalculator.model.Item;
import com.macys.common.pricing.services.pricechangecalculator.model.Promotion;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository
    extends AbstractRepository<Promotion> {

    static String MATCHING_PROMOTION_QUERY_STRING="Match (d:CatalogElement{type:'DEPARTMENT',name:'{department}'}) <-[:INCLUDES]- (p:Promotion)-[:INCLUDES]->(v:AttributeType{type:'VENDOR'})"
            + " WHERE v.name <> '{vendor}' "
            + " WITH collect(p) as exclVendorProms"
            + " Match (d:CatalogElement{type:'DEPARTMENT',name:'{department}'}) <-[:INCLUDES]- (p:Promotion)-[:INCLUDES]->(m:AttributeType{type:'MATERIAL'})"
            + " WHERE m.name <> '{material}'"
            + " WITH collect(p) as exclMaterialProms, exclVendorProms"
            + " Match (d:CatalogElement{type:'DEPARTMENT',name:'{department}'})<-[:SUBCATEGORY]-(s:CatalogElement{type:'STYLE'}) <-[:SUBCATEGORY]-(c:CatalogElement{type:'COLOR'})<-[:INCLUDES]-(p)"
            + " WHERE c.name <> '{color}' "
            + " WITH collect(p) as exclColorPromos,exclMaterialProms, exclVendorProms"
            + " Match (d:CatalogElement{type:'DEPARTMENT',name:'{department}'})<-[:SUBCATEGORY]-(s:CatalogElement{type:'STYLE'})<-[:INCLUDES]-(p)"
            + " WHERE s.name <> '{style}'"
            + " WITH collect(p) as exclStyleProms, exclColorPromos,exclMaterialProms, exclVendorProms"
            + " Match  (c:CatalogElement{name:'{color}',type:'COLOR'}) - [:SUBCATEGORY] -> (s:CatalogElement{name:'{style}',type:'STYLE'}) - [:SUBCATEGORY] -> (d:CatalogElement{name:'{department}', type:'DEPARTMENT'}) "
            + " <- [:INCLUDES]- (p:Promotion)"
            + " WITH s,c,d,p,exclColorPromos, exclStyleProms,exclMaterialProms, exclVendorProms, collect(p) as allMatchingPromos"
            + " WHERE"
            + " NOT ((s) <-[:EXCLUDES] - (p) OR (c) <-[:EXCLUDES] - (p)) "
            + " AND"
            + "   NOT ( (:AttributeType{type:'MATERIAL', name:'{material}'})-[:EXCLUDES]-(p) OR "
            + "   (:AttributeType{type:'VENDOR', name:'{vendor}'})-[:EXCLUDES]-(p) )"
            + " AND"
            + "   NONE (i in allMatchingPromos WHERE i in  exclColorPromos)"
            + " AND "
            + "   NONE (i in allMatchingPromos WHERE i in  exclStyleProms)"
            + " AND "
            + "   NONE (i in allMatchingPromos WHERE i in  exclVendorProms)"
            + " AND "
            + "   NONE (i in allMatchingPromos WHERE i in  exclMaterialProms)"
            + " return p.name";

    //@Query("MATCH (e:Promotion) WHERE e.name = {name}  RETURN e")
    Promotion findByName(@Param("name") String name);
    
    
    

    //@Query(MATCHING_PROMOTION_QUERY_STRING)
  /*  List<String> getMatchingPromotions(@Param("department") String department, @Param("style") String style, @Param("color") String color,
                                       @Param("vendor") String vendor, @Param("material") String material);
*/}


