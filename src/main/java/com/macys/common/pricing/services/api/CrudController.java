package com.macys.common.pricing.services.api;

import com.macys.common.pricing.services.api.exception.BadRequestException;
import com.macys.common.pricing.services.api.exception.NotFoundException;
import com.macys.common.pricing.services.api.exception.PriceRestClientException;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudController<E, R, ID> {

    //ResponseEntity<List<E>> getAll();

    Flux<R> getAll() throws NotFoundException;

    //ResponseEntity<E> getOne(@PathVariable("id") ID id) throws NotFoundException;

    Mono<Object> post(@RequestBody E entity) throws PriceRestClientException, BadRequestException;

   // ResponseEntity<E> put(@PathVariable("id") ID id, @RequestBody E entity) throws NotFoundException, BadRequestException;

   // ResponseEntity<E> delete(@PathVariable("id") ID id) throws NotFoundException;
}