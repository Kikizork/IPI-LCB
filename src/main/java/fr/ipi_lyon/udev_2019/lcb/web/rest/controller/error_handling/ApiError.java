package fr.ipi_lyon.udev_2019.lcb.web.rest.controller.error_handling;

public class ApiError {
	private String message;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
