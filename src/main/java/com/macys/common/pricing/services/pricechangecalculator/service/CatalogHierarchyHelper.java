package com.macys.common.pricing.services.pricechangecalculator.service;

import java.util.List;

public interface CatalogHierarchyHelper {

  List<String> getCatalogHierarchy();

  String getNextHierarchy(String hierarchyElemetName);

  String getPreviousHierarchy(String hierarchyElemetName);

  String getHighestHierarchy();

  String getLowestHierarchy();
}
