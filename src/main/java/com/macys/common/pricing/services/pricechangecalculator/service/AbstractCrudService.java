package com.macys.common.pricing.services.pricechangecalculator.service;


import com.macys.common.pricing.services.pricechangecalculator.repository.AbstractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class AbstractCrudService<R extends AbstractRepository, M> implements GenericCrudService<String, String, M> {

  @Autowired
  R repository;

  @Override
  public M create(String type, String name, M data) {
    M element = (M) repository.findByName(type, name);
    if (element != null) log.warn("Record already exits name: {} detail: {}", name, element);
    return update(name, data);
  }

  @Override
  public M update(String name, M data) {
    return (M) repository.save(data);
  }

  @Override
  public Iterable<M> getAll() {
    return repository.findAll();
  }

  @Override
  public M get(String type, String name) {
    return (M) repository.findByName(type, name);
  }

  @Override
  public void delete(String type, String name) {
    repository.delete(repository.findByName(type, name));
  }

}
