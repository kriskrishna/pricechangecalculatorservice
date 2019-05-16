package com.macys.common.pricing.services.pricechangecalculator.service;

import org.jboss.resteasy.spi.BadRequestException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<E, R, ID> {

    Flux<R> getAll();

    //E getOne(ID id) throws NotFoundException;

    Mono<E> createOrUpate(E entity) throws BadRequestException;

    //E update(ID id, E entity) throws NotFoundException, BadRequestException;

    //E delete(ID id) throws NotFoundException;
}