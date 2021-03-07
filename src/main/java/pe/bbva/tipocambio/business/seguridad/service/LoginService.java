package pe.bbva.tipocambio.business.seguridad.service;

import pe.bbva.tipocambio.business.seguridad.dto.ResponseInternal;
import pe.bbva.tipocambio.business.seguridad.dto.ResponseUsuarioDTO;

public interface LoginService {

	public ResponseInternal<ResponseUsuarioDTO> login(String identificador, String password, String ip, String tokenGoogleV3);
	
}
