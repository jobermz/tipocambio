package pe.bbva.tipocambio.business.core.dto;

import java.io.Serializable;

public class RolDto implements Serializable {
	private static final long serialVersionUID = -5290801860720485245L;
	private Integer id;
	private Integer perfilId;
	private String descripcion;
	private String nombre;
	private String estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setEstadoBoolean(boolean estado) {
		this.estado = estado ? "1" : "0";
	}
	
	public Integer getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}
	
}
