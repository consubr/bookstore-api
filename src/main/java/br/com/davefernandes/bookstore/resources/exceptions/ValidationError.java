package br.com.davefernandes.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Date data, Integer status, String error) {
		super(data, status, error);
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Date data, Integer status, String error) {
		super(timestamp, data, status, error);
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	

}
