package pe.bbva.tipocambio.dao.core.dao.impl;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Component;
import pe.bbva.tipocambio.dao.core.dao.RolDao;
import pe.bbva.tipocambio.dao.core.entity.Rol;
import pe.bbva.tipocambio.dao.core.repository.RolRepository;

@Component
public class RolDaoImpl implements RolDao {
	private RolRepository rolRepository;
	private EntityManager em;
	public RolDaoImpl(RolRepository rolRepository, EntityManager entityManager) {
		this.rolRepository = rolRepository;
		this.em = entityManager;
	}

	public List<Rol> consultarRol() {
		return (List<Rol>)rolRepository.findAll();
	}

	public List<Rol> consultarRolPorPerfil(Integer idPerfil) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Rol.SP_QUERY_ROL_POR_PERFIL");
		query.setParameter("P_PERFIL_ID", idPerfil);
		List<Rol> listRol = query.getResultList();
		return listRol;
	}
	public List<Rol> consultarRolPorUsuario(Integer idUsuario) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Rol.SP_QUERY_ROLES_DE_USUARIO");
		query.setParameter("P_USUARIO_ID", idUsuario);
		List<Rol> listRol = query.getResultList();
		return listRol;
	}
	public void guardarRol(Rol rol) {
		rolRepository.save(rol);;
	}

	public void eliminarRol(Integer id) {
		rolRepository.deleteById(id);
	}
	
	public Rol consultarRolPorId(Integer id) {
		List<Rol> list = (List<Rol>) rolRepository.findAllById(Arrays.asList(new Integer[] {id}));
		return list.size() > 0 ? list.get(0) : null;
	}
	
}
