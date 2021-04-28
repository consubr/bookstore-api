package br.com.davefernandes.bookstore.resources.exceptions;

import java.util.Date;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.davefernandes.bookstore.services.exceptions.DataIntegrityViolationException;
import br.com.davefernandes.bookstore.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), new Date(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), new Date(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e,
			ServletRequest request) {
		ValidationError error = new ValidationError(System.currentTimeMillis(), new Date(), HttpStatus.BAD_REQUEST.value(),
				"Atenção! Erro na validação dos Campos!");
		
		for (FieldError fe : e.getBindingResult().getFieldErrors()) {
			error.addErrors(fe.getField(), fe.getDefaultMessage());
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
