package pe.bbva.tipocambio.dao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pe.bbva.tipocambio.dao.core.entity.TipoCambio;

public interface TipoCambioRepository extends CrudRepository<TipoCambio, Integer>, JpaSpecificationExecutor<TipoCambio>, Repository<TipoCambio, Integer> {
	
	@Query("SELECT tipoCambio FROM TipoCambio tipoCambio WHERE UPPER(tipoCambio.monedaOrigen) = UPPER(:monedaOrigen) AND UPPER(tipoCambio.monedaDestino) = UPPER(:monedaDestino) ORDER BY fecha DESC")
	@Transactional(readOnly = true)
	List<TipoCambio> consultarUltimaCotizacion(@Param("monedaOrigen") String monedaOrigen, @Param("monedaDestino") String monedaDestino);
	
}
