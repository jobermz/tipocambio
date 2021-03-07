package pe.bbva.tipocambio.business.core.dto;

import java.io.Serializable;

public class ResponseCotizarDto implements Serializable {
	private Double monto;
	private Double montoTipoCambio;
	
	private String monedaOrigen;
	private String monedaDestino;
	private Double tipoCambio;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontoTipoCambio() {
		return montoTipoCambio;
	}
	public void setMontoTipoCambio(Double montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
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
	
}
