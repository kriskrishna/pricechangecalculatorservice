/*
package com.macys.common.pricing.services.pricechangecalculator.controller;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macys.common.pricing.services.api.AbstractController;
import com.macys.common.pricing.services.api.CrudController;
import com.macys.common.pricing.services.api.exception.BadRequestException;
import com.macys.common.pricing.services.api.exception.NotFoundException;
import com.macys.common.pricing.services.api.exception.PriceRestClientException;
import com.macys.common.pricing.services.pricechangecalculator.model.PermPriceInstructionsEntity;
import com.macys.common.pricing.services.pricechangecalculator.model.PermPriceInstructionsKey;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDataManagement;
import com.macys.common.pricing.services.pricechangecalculator.service.PricingService;
import com.macys.common.pricing.services.pricechangecalculator.validator.ValidationHandler;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pricechangewriter")
@RefreshScope
@Log
public class PricingController extends AbstractController
		implements CrudController<PriceDataManagement, PermPriceInstructionsEntity, PermPriceInstructionsKey> {

	private final PricingService pricingService;

	private final ValidationHandler validator;

	public PricingController(PricingService pricingService, ValidationHandler validator) {
		this.pricingService = pricingService;
		this.validator = validator;
	}

	@PostMapping(path = "/perm-instructions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Object> post(@RequestBody PriceDataManagement pricingInfo)
			throws PriceRestClientException, BadRequestException {

		log.info("Request received - Validation in progress..");
		Errors errors = validator.isValidRequest(pricingInfo);
		if (errors.hasErrors()) {
			Map<String, Set<String>> errorsMap = errors.getFieldErrors().stream().collect(Collectors.groupingBy(
					FieldError::getField, Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())));
			log.info("Validation failed..");
			return Mono.just(errors.getFieldErrors().toString())
					.map(data -> new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST));
			// .map(data -> badRequest(data));
		} else {
			log.info("Records were created or updated..");
			return pricingService.createOrUpate(pricingInfo)
					*/
/*
					 * .map(savedPriceInstructions -> new ResponseEntity<>(
					 * "Perm price change records were created or updated", HttpStatus.CREATED));
					 *//*

					.map(savedPriceInstructions -> created("Perm price change records were created or updated"));
		}
	}

	// Suppressing this endpoint in production using actuator framework
	@GetMapping("/retrieve")
	public Flux<PermPriceInstructionsEntity> getAll() throws NotFoundException{
		log.info("Retrieving all saved records..");
		Flux<PermPriceInstructionsEntity> data = pricingService.getAll();
		return data;
	}

}
*/
