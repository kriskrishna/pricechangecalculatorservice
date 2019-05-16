/*
package com.macys.common.pricing.services.pricechangecalculator.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDataManagement;



@Component
public class ValidationHandler {

  public Errors isValidRequest(PriceDataManagement request) {
    Validator validator = new PriceChangeInstructionValidator();
    Errors errors = new BeanPropertyBindingResult(request, PriceDataManagement.class.getName());
    validator.validate(request, errors);
    return errors;
  }
}
*/
