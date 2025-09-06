package fr.ipi_lyon.udev_2019.lcb.web.rest.controller.error_handling;

import java.sql.SQLException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
public class GeneralErrorAdvice extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ApiError> allException(Exception e)
	{
		ApiError api = new ApiError();
		api.setCode("E42");
		e.printStackTrace();
		api.setMessage("Erreur de serveur : "+e.getClass().toString());
		return ResponseEntity.status(500).body(api);
	}
}
