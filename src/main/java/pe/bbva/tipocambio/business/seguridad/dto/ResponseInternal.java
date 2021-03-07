package pe.bbva.tipocambio.business.seguridad.dto;

public class ResponseInternal<A> {

	private boolean status;
	
	private String message;
	
	private A body;
	
	public ResponseInternal() {
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
