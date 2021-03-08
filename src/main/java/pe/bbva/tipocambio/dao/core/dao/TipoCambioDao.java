package pe.bbva.tipocambio.dao.core.dao;

import java.util.List;

import pe.bbva.tipocambio.dao.core.entity.TipoCambio;

public interface TipoCambioDao {
	public void iniciarDB();
	public TipoCambio consultarUltimaCotizacion(String monedaOrigen, String monedaDestino);
	public List<TipoCambio> consultar();
	public void guardar(TipoCambio rol);
}
