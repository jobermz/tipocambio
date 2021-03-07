package pe.bbva.tipocambio.business.core.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.bbva.tipocambio.business.core.dto.RolDto;
import pe.bbva.tipocambio.business.core.service.RolService;
import pe.bbva.tipocambio.dao.core.dao.RolDao;
import pe.bbva.tipocambio.dao.core.entity.Rol;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDao rolDao;

	public int consultarRoles3() {
		return 5 + 6;
	}
	public List<RolDto> consultarRoles() {
		List<Rol> list = rolDao.consultarRol();
		
		RolDto rolDto = null;
		List<RolDto> listRS = new ArrayList<RolDto>();
		try {
			for(Rol rol:list) {
				rolDto = new RolDto();
				BeanUtils.copyProperties(rolDto, rol);
				listRS.add(rolDto);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return listRS;
	}
	public List<RolDto> consultarRolesPorPerfil(Integer idPerfil) {
		List<Rol> list = rolDao.consultarRolPorPerfil(idPerfil);
		RolDto rolDto = null;
		List<RolDto> listRS = new ArrayList<RolDto>();
		try {
			for(Rol rol:list) {
				rolDto = new RolDto();
				BeanUtils.copyProperties(rolDto, rol);
				listRS.add(rolDto);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return listRS;
	}
	public RolDto consultarRolPorId(Integer idRol) {
		Rol rol = rolDao.consultarRolPorId(idRol);
		
		RolDto rolDto		= new RolDto();
		try {
			if(rol != null) {
				BeanUtils.copyProperties(rolDto, rol);
			} else {
				return null;
			}
		} catch (IllegalAccessException | InvocationTargetException  e) {
			e.printStackTrace();
		}
		return rolDto;
	}

	public void actualizarRol(RolDto rolDto) {
		Rol rol = new Rol();
		try {
			BeanUtils.copyProperties(rol, rolDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		rolDao.guardarRol(rol);
	}
	
	public void registrarRol(RolDto rolDto) {
		Rol rol = new Rol();
		try {
			BeanUtils.copyProperties(rol, rolDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		rolDao.guardarRol(rol);
	}
	
	public void eliminarRol(Integer id) {
		rolDao.eliminarRol(id);
	}
	
}
