package pe.bbva.tipocambio.business.core.service;

import java.util.List;
import pe.bbva.tipocambio.business.core.dto.RolDto;

public interface RolService {
	public int consultarRoles3();

	public List<RolDto> consultarRoles();
	public List<RolDto> consultarRolesPorPerfil(Integer idPerfil);
	public RolDto consultarRolPorId(Integer idRol);
	public void actualizarRol(RolDto rolDto);
	public void registrarRol(RolDto rolDto);
	public void eliminarRol(Integer id);
}
