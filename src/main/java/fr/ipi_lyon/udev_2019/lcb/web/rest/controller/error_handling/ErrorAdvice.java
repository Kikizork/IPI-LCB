package fr.ipi_lyon.udev_2019.lcb.web.rest.controller.error_handling;

import java.sql.SQLException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiError> sqlException(Exception e)
	{
		ApiError api = new ApiError();
		api.setCode("E01");
		api.setMessage(e.getMessage());
		e.printStackTrace();
		return ResponseEntity.status(403).body(api);		
	}	
}
