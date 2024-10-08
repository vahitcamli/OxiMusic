package com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.problemDetails;

import java.util.Map;

import lombok.Data;

@Data
public class ValidationProblemDetails extends ProblemDetails {
	public ValidationProblemDetails() {
		setTitle("Validation Rule Violation");
		setDetail("Validation Problem");
		setType("http://mydomain.com/exceptions/validation");
		setStatus("400");
	}

	private Map<String, String> errors;
}
