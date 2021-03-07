package pe.bbva.tipocambio.dao.core.dao;

import java.util.List;

import pe.bbva.tipocambio.dao.core.entity.Rol;

public interface RolDao {
	public List<Rol> consultarRol();
	public List<Rol> consultarRolPorPerfil(Integer idPerfil);
	public List<Rol> consultarRolPorUsuario(Integer idUsuario);
	public void guardarRol(Rol rol);
	public void eliminarRol(Integer id);
	public Rol consultarRolPorId(Integer id);
}
