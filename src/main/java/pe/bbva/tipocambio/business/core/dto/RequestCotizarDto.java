package pe.bbva.tipocambio.business.core.dto;

import java.io.Serializable;

public class RequestCotizarDto implements Serializable {
	private String monedaOrigen;
	private String monedaDestino;
	private Double monto;
	
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
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}
