package pe.bbva.tipocambio.business.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResponseTipoCambioDto implements Serializable {
	private static final long serialVersionUID = -5290801860720485245L;
	private Integer id;
	private String monedaOrigen;
	private String monedaDestino;
	private Double tipoCambio;
	private Timestamp fecha;
	
	private SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getFecha() {
		return simple.format(fecha);
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}
