package com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.problemDetails.BusinessProblemDetails;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.problemDetails.ValidationProblemDetails;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ BusinessException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BusinessProblemDetails handleBusinessException(BusinessException exception) {
		BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
		businessProblemDetails.setDetail(exception.getMessage());
		return businessProblemDetails;
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> validationErrors = new HashMap<>();

		exception.getBindingResult().getFieldErrors().stream()
				.map(error -> validationErrors.put(error.getField(), error.getDefaultMessage())).toList();

		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setErrors(validationErrors);

		return validationProblemDetails;
	}
}
