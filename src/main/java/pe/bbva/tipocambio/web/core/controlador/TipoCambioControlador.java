package pe.bbva.tipocambio.web.core.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.bbva.tipocambio.business.core.dto.RequestCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseCotizarDto;
import pe.bbva.tipocambio.business.core.dto.ResponseDTO;
import pe.bbva.tipocambio.business.core.dto.ResponseTipoCambioDto;
import pe.bbva.tipocambio.business.core.dto.RequestTipoCambioDto;
import pe.bbva.tipocambio.business.core.service.TipoCambioService;
import pe.bbva.tipocambio.comun.util.Util;

@RestController
@RequestMapping("/api/tipoCambio")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TipoCambioControlador {
	
	@Autowired
	private TipoCambioService tipoCambioService;

	@PostConstruct
	public void loadIfInMemory() throws Exception {
		System.out.println("TipoCambioControlador.loadIfInMemory() AAAAAAAAA");
		tipoCambioService.iniciarDB();
		System.out.println("TipoCambioControlador.loadIfInMemory() FFFFFFFFF");
	}
	
	@PostMapping("/cotizar")
	public ResponseEntity<ResponseDTO<ResponseCotizarDto>> cotizar(@RequestBody RequestCotizarDto requestCotizarDto) {
		ResponseCotizarDto responseCotizarDto = tipoCambioService.cotizarTipoCambio(requestCotizarDto);
		ResponseDTO<ResponseCotizarDto> responseDTO = null;
		if(responseCotizarDto != null) {
			responseDTO = Util.returnResponseSuccessful(responseCotizarDto);
		} else {
			responseDTO = Util.returnResponseProblem("No se encontro el perfil");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@GetMapping("/consultar")
	public ResponseEntity<ResponseDTO<List<ResponseTipoCambioDto>>> consultar() {
		List tipoCambioList = tipoCambioService.consultar();
		ResponseDTO<List<ResponseTipoCambioDto>> responseDTO = null;
		if(tipoCambioList != null) {
			responseDTO = Util.returnResponseSuccessful(tipoCambioList);
		} else {
			responseDTO = Util.returnResponseProblem("No se encontro el perfil");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<ResponseDTO<String>> actualizar(@RequestBody RequestTipoCambioDto tipoCambioDto) {
		ResponseDTO<String> responseDTO = null;
		try {
			tipoCambioService.actualizar(tipoCambioDto);
			responseDTO = Util.returnResponseSuccessful("Ok");
		} catch(Exception ex) {
			ex.printStackTrace();
			responseDTO = Util.returnResponseProblem("No se pudo actualizar el permiso");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

//	@GetMapping("/consultar/{idRol}")
//	public ResponseEntity<ResponseDTO<ResponseTipoCambioDto>> consultarPorId(@PathVariable("idRol") Integer idRol) {
//		ResponseTipoCambioDto tipoCambioDto = tipoCambioService.consultarPorId(idRol);
//		ResponseDTO<ResponseTipoCambioDto> responseDTO = null;
//		if(tipoCambioDto != null) {
//			responseDTO = Util.returnResponseSuccessful(tipoCambioDto);
//		} else {
//			responseDTO = Util.returnResponseProblem("No se encontro el perfil");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
//
//	@PostMapping("/registrar")
//	public ResponseEntity<ResponseDTO<String>> registrar(@RequestBody RequestTipoCambioDto tipoCambioDto) {
//		ResponseDTO<String> responseDTO = null;
//		try {
//			tipoCambioService.registrar(tipoCambioDto);
//			responseDTO = Util.returnResponseSuccessful("Ok");
//		} catch(Exception ex) {
//			ex.printStackTrace();
//			responseDTO = Util.returnResponseProblem("No se pudo registrar el tipoCambio");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}

//	@DeleteMapping("/eliminar/{id}")
//	public ResponseEntity<ResponseDTO<String>> eliminar(@PathVariable("id") Integer idRol) {
//		ResponseDTO<String> responseDTO = null;
//		try {
//			tipoCambioService.eliminar(idRol);
//			responseDTO = Util.returnResponseSuccessful("Ok");
//		} catch(Exception ex) {
//			ex.printStackTrace();
//			responseDTO = Util.returnResponseProblem("No se pudo eliminar el tipoCambio");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
}
