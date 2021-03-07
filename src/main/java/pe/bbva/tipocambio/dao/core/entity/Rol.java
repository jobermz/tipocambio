package pe.bbva.tipocambio.dao.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
    		name = "Rol.SP_QUERY_ROL_POR_PERFIL",
    		procedureName = "ADMIN_COPI_RED.SP_QUERY_ROL_POR_PERFIL",
    		resultClasses = { Rol.class },
    		parameters = {
    				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PERFIL_ID", type = Integer.class),
    				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "l_cursor", type = void.class)
    				}),
    @NamedStoredProcedureQuery(
    		name = "Rol.SP_QUERY_ROLES_DE_USUARIO",
    		procedureName = "ADMIN_COPI_RED.SP_QUERY_ROLES_DE_USUARIO",
    				resultClasses = { Rol.class },
    		parameters = {
    				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO_ID", type = Integer.class),
    				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "l_cursor", type = void.class)
    				}),
    
    })
@Entity
@Table(name = "SEC_ROL")
public class Rol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROL_ID")
	private Integer id;
	
	@Column(name = "ROL_DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ROL_NOMBRE")
	private String nombre;
	
	@Column(name = "ROL_ESTADO")
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

}
