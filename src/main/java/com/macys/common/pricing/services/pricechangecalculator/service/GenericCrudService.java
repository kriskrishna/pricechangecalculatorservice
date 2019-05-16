package com.macys.common.pricing.services.pricechangecalculator.service;

public interface GenericCrudService<T,N,D> {

  D create(T type, N name, D data);

  D update(N name, D data);

  Iterable<D> getAll();

  D get(T type, N name);

  void delete(T type, N name);

}
