package com.macys.common.pricing.services.pricechangecalculator.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericControllerService<T, N, D, S extends GenericCrudService<T, N ,D>> {

  @Autowired
  protected S crudService;

  public D findByName(T t, N n){
    return crudService.get(t, n);
  }

  public D create(T t, N n, D d){
    return crudService.create(t, n, d);
  }

  public D update(T t, N n, D d){
    return crudService.update(n, d);
  }

  public void delete(T t, N n){
    crudService.delete(t, n);
  }
}
