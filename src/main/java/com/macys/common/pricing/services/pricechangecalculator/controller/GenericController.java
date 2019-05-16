package com.macys.common.pricing.services.pricechangecalculator.controller;

import org.springframework.http.ResponseEntity;

public class GenericController<I, O> {

  public ResponseEntity<O> getGenericResponseFor(O response){
    return ResponseEntity.ok().body(response);
  }

}
