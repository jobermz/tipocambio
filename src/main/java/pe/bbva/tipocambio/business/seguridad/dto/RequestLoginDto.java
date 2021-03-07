package pe.bbva.tipocambio.business.seguridad.dto;

import java.io.Serializable;

public class RequestLoginDto implements Serializable {

	private String identificador;
	private String password;
	private String ip;
	private String tokenGoogleV3;
	
	
	public String getTokenGoogleV3() {
		return tokenGoogleV3;
	}
	public void setTokenGoogleV3(String tokenGoogleV3) {
		this.tokenGoogleV3 = tokenGoogleV3;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
