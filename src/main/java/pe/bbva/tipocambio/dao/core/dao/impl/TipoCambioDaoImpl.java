package pe.bbva.tipocambio.dao.core.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import pe.bbva.tipocambio.dao.core.dao.TipoCambioDao;
import pe.bbva.tipocambio.dao.core.entity.TipoCambio;
import pe.bbva.tipocambio.dao.core.repository.TipoCambioRepository;

@Component
public class TipoCambioDaoImpl implements TipoCambioDao {
	private TipoCambioRepository tipoCambioRepository;
	private EntityManager em;
	private DataSource datasource;
	private ApplicationContext applicationContext;
	public TipoCambioDaoImpl(TipoCambioRepository tipoCambioRepository, EntityManager entityManager, DataSource datasource, ApplicationContext applicationContext) {
		this.tipoCambioRepository = tipoCambioRepository;
		this.em = entityManager;
		this.datasource = datasource;
		this.applicationContext = applicationContext;
	}
	public void iniciarDB() {
		String SAMPLE_DATA = "classpath:sample_data_h2.sql";
		Resource resource = applicationContext.getResource(SAMPLE_DATA);
		try {
			ScriptUtils.executeSqlScript(datasource.getConnection(), resource);
		} catch (ScriptException | SQLException e) {
			e.printStackTrace();
		}
	}
	public TipoCambio consultarUltimaCotizacion(String monedaOrigen, String monedaDestino) {
		List<TipoCambio> listTipoCambio = tipoCambioRepository.consultarUltimaCotizacion(monedaOrigen, monedaDestino);
		return listTipoCambio.size() > 0 ? listTipoCambio.get(0) : null;
	}

	public List<TipoCambio> consultar() {
		return (List<TipoCambio>)tipoCambioRepository.findAll();
	}

	public void guardar(TipoCambio tipoCambio) {
		tipoCambioRepository.save(tipoCambio);
	}

	public void eliminar(Integer id) {
		tipoCambioRepository.deleteById(id);
	}
	
	public TipoCambio consultarPorId(Integer id) {
		List<TipoCambio> list = (List<TipoCambio>) tipoCambioRepository.findAllById(Arrays.asList(new Integer[] {id}));
		return list.size() > 0 ? list.get(0) : null;
	}
	
}
