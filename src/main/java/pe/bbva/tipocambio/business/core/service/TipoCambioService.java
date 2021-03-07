package pe.bbva.tipocambio.business.core.service;

import java.util.List;

import pe.bbva.tipocambio.business.core.dto.RequestCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseTipoCambioDto;
import pe.bbva.tipocambio.business.core.dto.RequestTipoCambioDto;

public interface TipoCambioService {
	public void iniciarDB();
	public ResponseCotizarDto cotizarTipoCambio(RequestCotizarDto dto);
	public List<ResponseTipoCambioDto> consultar();
	public ResponseTipoCambioDto consultarPorId(Integer idRol);
	public void actualizar(RequestTipoCambioDto dto);
	public void registrar(RequestTipoCambioDto dto);
	public void eliminar(Integer id);
}
