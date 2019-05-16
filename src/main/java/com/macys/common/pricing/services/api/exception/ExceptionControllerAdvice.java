package com.macys.common.pricing.services.api.exception;

import com.macys.common.pricing.services.api.AbstractController;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/***
 * ControllerAdvice
 *
 * @author Kris Krishna - Cognizant
 *
 *         Specialization of {@link Component @Component} for classes that
 *         declare {@link ExceptionHandler @ExceptionHandler},
 *         {@link InitBinder @InitBinder}, or
 *         {@link ModelAttribute @ModelAttribute} methods to be shared across
 *         multiple {@code @Controller} classes.
 *
 *         <p>
 *         Classes with {@code @ControllerAdvice} can be declared explicitly as
 *         Spring beans or auto-detected via classpath scanning. All such beans
 *         are sorted via
 *         {@link org.springframework.core.annotation.AnnotationAwareOrderComparator
 *         AnnotationAwareOrderComparator}, i.e. based on
 *         {@link org.springframework.core.annotation.Order @Order} and
 *         {@link org.springframework.core.Ordered Ordered}, and applied in that
 *         order at runtime. For handling exceptions, an
 *         {@code @ExceptionHandler} will be picked on the first advice with a
 *         matching exception handler method. For model attributes and
 *         {@code InitBinder} initialization, {@code @ModelAttribute} and
 *         {@code @InitBinder} methods will also follow
 *         {@code @ControllerAdvice} order.
 *
 *         <p>
 *         Note: For {@code @ExceptionHandler} methods, a root exception match
 *         will be preferred to just matching a cause of the current exception,
 *         among the handler methods of a particular advice bean. However, a
 *         cause match on a higher-priority advice will still be preferred to a
 *         any match (whether root or cause level) on a lower-priority advice
 *         bean. As a consequence, please declare your primary root exception
 *         mappings on a prioritized advice bean with a corresponding order!
 *
 *         <p>
 *         By default the methods in an {@code @ControllerAdvice} apply globally
 *         to all Controllers. Use selectors {@link #annotations()},
 *         {@link #basePackageClasses()}, and {@link #basePackages()} (or its
 *         alias {@link #value()}) to define a more narrow subset of targeted
 *         Controllers. If multiple selectors are declared, OR logic is applied,
 *         meaning selected Controllers should match at least one selector. Note
 *         that selector checks are performed at runtime and so adding many
 *         selectors may negatively impact performance and add complexity.
 *
 *
 */

@ControllerAdvice
@Generated
public class ExceptionControllerAdvice extends AbstractController {


	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> NotFoundExceptionHandler(Exception ex) {
		ApiError err = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
		return this.notFound(err);
	}

	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ApiError> EntityExistsExceptionHandler(Exception ex) {
		ApiError err = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), new Date());
		return this.conflict(err);
	}

	/*@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> BadRequestExceptionHandler(BadRequestException ex) {
		ApiError err = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), new Date());
		return this.badRequest(err);
	}*/

	/**
	 * Handler for all the MethodArgumentNotValidException exception from the
	 * service
	 *
	 * @param ex
	 * @return corresponding response entity with APIError format.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		ApiError err = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), new Date());
		return this.badRequest(err);
	}

	@ExceptionHandler(PriceRestClientException.class)
	public ResponseEntity<ApiError> ERERestClientExceptionHandler(PriceRestClientException ex) {

		ApiError err = ex.getEnclosedError();
		if (err == null) {
			err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), new Date());
		}

		return this.errorFound(err);
	}

}
