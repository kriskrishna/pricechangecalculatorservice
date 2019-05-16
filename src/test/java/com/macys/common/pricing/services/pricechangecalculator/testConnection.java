/*
 * package com.macys.common.pricing.services.pricechangecalculator;
 * 
 * import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.
 * GraphTraversalSource; import org.junit.Test;
 * 
 * import com.datastax.driver.dse.DseCluster; import
 * com.datastax.driver.dse.DseSession; import
 * com.datastax.driver.dse.graph.GraphOptions; import
 * com.datastax.dse.graph.api.DseGraph;
 * 
 * public class testConnection {
 * 
 * @Test public void test() { DseCluster dseCluster =
 * DseCluster.builder().addContactPoint("11.208.32.162") .withGraphOptions(new
 * GraphOptions().setGraphName("pricing")).build(); DseSession dseSession =
 * dseCluster.connect(); GraphTraversalSource g =
 * DseGraph.traversal(dseSession); dseSession .executeGraph(DseGraph
 * .statementFromTraversal(g.V().has("item", "upc",
 * 1234).has("operatingDivision", 1).outE()))
 * .all().stream().forEach(System.out::println); }
 * 
 * }
 */