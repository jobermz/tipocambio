package pe.bbva.tipocambio.comun.util;

import pe.bbva.tipocambio.business.core.dto.ResponseDTO;

public class Util {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponseDTO returnResponseSuccessful(Object response) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(Constantes.CODE_RESPONSE_SUCCESS);
		responseDTO.setStatus(true);
		responseDTO.setMessage(Constantes.MSG_RESPONSE_SUCCESS);
		responseDTO.setBody(response);
		return responseDTO;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponseDTO returnResponseProblem(String mensaje) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(Constantes.CODE_RESPONSE_ERROR);
		responseDTO.setStatus(false);
		responseDTO.setMessage(mensaje);
		return responseDTO;
	}
	
}
