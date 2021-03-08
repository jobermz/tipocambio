package pe.bbva.tipocambio.business.core.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bbva.tipocambio.business.core.dto.RequestCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseTipoCambioDto;
import pe.bbva.tipocambio.business.core.dto.RequestTipoCambioDto;
import pe.bbva.tipocambio.business.core.service.TipoCambioService;
import pe.bbva.tipocambio.dao.core.dao.TipoCambioDao;
import pe.bbva.tipocambio.dao.core.entity.TipoCambio;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioDao tipoCambioDao;
	
	public void iniciarDB() {
		tipoCambioDao.iniciarDB();
	}

	public ResponseCotizarDto cotizarTipoCambio(RequestCotizarDto dto) {
		TipoCambio tc = tipoCambioDao.consultarUltimaCotizacion(dto.getMonedaOrigen(), dto.getMonedaDestino());

		ResponseCotizarDto res = new ResponseCotizarDto();
		BeanUtils.copyProperties(dto, res);
		
		res.setTipoCambio(tc.getTipoCambio());
		res.setMontoTipoCambio(new BigDecimal(dto.getMonto() * tc.getTipoCambio()).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		
		return res;
	}
	public List<ResponseTipoCambioDto> consultar() {
		List<TipoCambio> list = tipoCambioDao.consultar();
		
		ResponseTipoCambioDto tipoCambioDto = null;
		List<ResponseTipoCambioDto> listRS = new ArrayList<ResponseTipoCambioDto>();
		for(TipoCambio tipoCambio:list) {
			tipoCambioDto = new ResponseTipoCambioDto();
			BeanUtils.copyProperties(tipoCambio, tipoCambioDto);
			listRS.add(tipoCambioDto);
		}
		return listRS;
	}
	
	public void actualizar(RequestTipoCambioDto tipoCambioDto) {
		TipoCambio tipoCambio = new TipoCambio();
		BeanUtils.copyProperties(tipoCambioDto, tipoCambio);
		tipoCambio.setId(null);
		tipoCambio.setFecha(new Timestamp(new Date().getTime()));
		tipoCambioDao.guardar(tipoCambio);
	}
	
}
