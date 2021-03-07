package pe.bbva.tipocambio.business.seguridad.dto;

import java.io.Serializable;

public class ResponseUsuarioDTO implements Serializable {

	private Integer usuarioId;
	private String usuarioNombre;
	private String token;
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
}
