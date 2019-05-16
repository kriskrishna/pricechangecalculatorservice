package com.macys.common.pricing.services.pricechangecalculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.macys.common.pricing.services.pricechangecalculator.model.AttributeType;
import com.macys.common.pricing.services.pricechangecalculator.model.Category;
import com.macys.common.pricing.services.pricechangecalculator.model.SubCategoryRelationship;
import com.macys.common.pricing.services.pricechangecalculator.rest.dto.CatalogHeirarchy;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.CatalogDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.request.ItemDetailReq;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.CatalogDetailResp;
import com.macys.common.pricing.services.pricechangecalculator.rest.response.ItemDetailResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatalogControllerService extends GenericControllerService<String, String, Category, CatalogElementCrudService> {

  @Autowired
  CatalogHierarchyHelper catalogHierarchyHelper;

  private List<String> catalogElementNames = Arrays.asList("DEPARTMENT", "DIVMASTERSTYLE", "CLASS", "SUBCLASS", "VENDOR", "MARKSTYLE");

  public CatalogDetailResp upsert(String catalogName, String departmentName, String styleName, String styleColor) {
    Category catalog = crudService.get("CATALOG", catalogName);
    if (catalog == null) {
      catalog = Category.builder().type("CATALOG").name(catalogName).build();
      catalog = crudService.create("CATALOG", catalogName, catalog);
    }

    Category department = crudService.get("DEPARTMENT", departmentName);
    if (department == null) {
      department = Category.builder().type("DEPARTMENT").name(departmentName).build();
      department = crudService.create("DEPARTMENT", departmentName, department);
      SubCategoryRelationship role = new SubCategoryRelationship();
      role.setCatalogEndNode(catalog);
      role.setCatalogStartNode(department);
      List<Category> departmentRel = catalog.getChildren() == null ? new ArrayList<Category>() : catalog.getChildren();
      departmentRel.add(department);
      catalog.setChildren(departmentRel);
      crudService.update(catalogName, catalog);
    }


    Category style = crudService.get("STYLE", styleName);
    if (style == null) {
      style = Category.builder().type("STYLE").name(styleName).build();
      style = crudService.create("STYLE", styleName, style);
      SubCategoryRelationship role = new SubCategoryRelationship();
      role.setCatalogEndNode(department);
      role.setCatalogStartNode(style);
      List<Category> styleRel = department.getChildren() == null ? new ArrayList<Category>() : department.getChildren();
      styleRel.add(style);
      department.setChildren(styleRel);
      crudService.update(departmentName, department);
    }
    return CatalogDetailResp.builder().catalogName(catalogName).departmentName(departmentName).styleName(styleName).colorName(styleColor).build();
  }

  public CatalogDetailResp createCatalog(CatalogDetailReq catalogDetailReq) {
    upsertCatalog(catalogDetailReq);

    return CatalogDetailResp.builder().catalogName(catalogDetailReq.getCatalog())
        .departmentName(catalogDetailReq.getDepartment()).styleName(catalogDetailReq.getStyle())
        .colorName(catalogDetailReq.getColor()).build();
  }

  public Category upsertCatalog(CatalogDetailReq catalogDetailReq) {
    CatalogHeirarchy catalogHeirarchy = CatalogHeirarchy.builder().style(catalogDetailReq.getStyle())
        .catalog(catalogDetailReq.getCatalog()).color(catalogDetailReq.getColor()).department(catalogDetailReq.getDepartment())
        .build();
    return updateElements(catalogHeirarchy, catalogHierarchyHelper.getHighestHierarchy(), null);
  }

  private Category updateElements(CatalogHeirarchy catalogHeirarchy, String type, Category parentElem) {
    String name = catalogHeirarchy.getCatalogElementFor(type);
    Category element = crudService.get(type, name);
    if (element == null) {
      element = Category.builder().type(type).name(name).children(new ArrayList<>())
          .includes(new ArrayList<>()).excludes(new ArrayList<>()).build();
      //element = crudService.create(type, name, element);
    }
    String nextType = catalogHierarchyHelper.getNextHierarchy(type);
    String previousType = catalogHierarchyHelper.getPreviousHierarchy(type);
    if (!catalogHierarchyHelper.getHighestHierarchy().equalsIgnoreCase(type)) {
      //CatalogElement parentElem = crudService.get(previousType, catalogHeirarchy.getCatalogElementFor(previousType));
      if (parentElem != null) {
        log.debug("parent: {} {} {}, child {} {} {}", parentElem.getType(), parentElem.getName(), parentElem, element.getType(), element.getName(), element);
        /*SubCategoryRelationship role = new SubCategoryRelationship();
        role.setCatalogStartNode(element);
        role.setCatalogEndNode(parentElem);
        List<CatalogElement> children = parentElem.getChildren();
        if (children == null) children = new ArrayList<CatalogElement>();
        children.add(element);
        parentElem.setChildren(children);*/
        if (parentElem.getChildren() == null) parentElem.setChildren(new ArrayList<>());
        parentElem.getChildren().add(element);
        //crudService.update(parentElem.getName(), parentElem);
      } else {
        log.warn("Couldn't find parent of type:{} name{}: with Parent: {} {} ",
            type, name, nextType, catalogHeirarchy.getCatalogElementFor(previousType));
      }
    }
    if (nextType != null && nextType != "") {
      updateElements(catalogHeirarchy, nextType, element);
    }
    if (previousType == null || previousType == ""){
      return crudService.update(element.getName(), element);
    }
    return element;
  }

  public Category getNode(String type, String name) {
    return crudService.get(type, name);
  }


  public ItemDetailResp createItemAndRelatedAttributes(ItemDetailReq itemDetailReq) {
    Category item = crudService.create("ITEM", itemDetailReq.getItemId(), buildCatalogElementNetwork(itemDetailReq));
    return ItemDetailResp.builder().itemId(item.getName()).build();
  }

  private Category buildCatalogElementNetwork(ItemDetailReq itemDetailReq) {
    return Category.builder().type("ITEM").name(itemDetailReq.getItemId())
        .children(getRelatedNodes(itemDetailReq.getItemAttributes())).build();
  }

  private List<Category> getRelatedNodes(Map<String, String> itemAttributes) {
    return itemAttributes.entrySet().stream().map(e -> {
      return Category.builder().type(e.getKey()).name(e.getValue()).build();
    }).collect(Collectors.toList());
  }

  public ItemDetailResp createItemAndRelatedAttributesOption4(ItemDetailReq itemDetailReq) {
    Category item = crudService.create("ITEM", itemDetailReq.getItemId(), buildCatalogElementNetworkOption4(itemDetailReq));
    return ItemDetailResp.builder().itemId(item.getName()).build();
  }

  private Category buildCatalogElementNetworkOption4(ItemDetailReq itemDetailReq) {
    return Category.builder().type("ITEM").name(itemDetailReq.getItemId())
      .children(getCatalogElements(itemDetailReq.getItemAttributes()))
        .attributeTypes(getItemAttributes(itemDetailReq.getItemAttributes())).build();
  }
  private List<Category> getCatalogElements(Map<String, String> itemAttributes) {
    return itemAttributes.entrySet().stream().filter(e ->isCatalogElement(e.getKey())).map(e -> {
    return Category.builder().type(e.getKey()).name(e.getValue()).build();
  }).collect(Collectors.toList());
  }

  private boolean isCatalogElement(String key) {
    return catalogElementNames.contains(key);
  }

  private List<AttributeType> getItemAttributes(Map<String, String> itemAttributes) {
    return itemAttributes.entrySet().stream().filter(e ->!isCatalogElement(e.getKey())).map(e -> {
    return AttributeType.builder().type(e.getKey()).name(e.getValue()).build();
  }).collect(Collectors.toList());
  }


}
