package pe.bbva.tipocambio.dao.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pe.bbva.tipocambio.dao.core.entity.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer>, JpaSpecificationExecutor<Rol>, Repository<Rol, Integer>{

}
