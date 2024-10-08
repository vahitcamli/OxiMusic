package com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails {
	public BusinessProblemDetails() {
		setTitle("Business Rule Violation");
		setType("http://mydomain.com/exceptions/business");
		setStatus("400");
	}
}
