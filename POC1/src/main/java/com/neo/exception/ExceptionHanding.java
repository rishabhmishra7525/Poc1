package com.neo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@ControllerAdvice
@Slf4j
public class ExceptionHanding {

	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public String sqlExceptionHandler( Exception ex) {
		log.info("sqlExceptionHandler -", ex);
		return "Date must be fallow DD/MM/YYYY formate";
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NumberFormatException.class)
	public String numberFormateException( Exception ex) {
		log.info("sqlExceptionHandler -", ex);
		return "Number formate ";
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String nullFormateException( Exception ex) {
		log.info("sqlExceptionHandler -", ex);
		return "Null Pointer Exception";
	}
	
	
}
