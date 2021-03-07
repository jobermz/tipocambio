package pe.bbva.tipocambio.business.core.dto;

public class ResponseDTO<A> {

	private boolean status;
	
	private int code;
	
	private String message;
	
	private A body;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public A getBody() {
		return body;
	}

	public void setBody(A body) {
		this.body = body;
	}
	
	
}
