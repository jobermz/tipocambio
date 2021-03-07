package pe.bbva.tipocambio.web.seguridad.controlador;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pe.bbva.tipocambio.business.core.dto.ResponseDTO;
import pe.bbva.tipocambio.business.seguridad.dto.RequestLoginDto;
import pe.bbva.tipocambio.business.seguridad.dto.ResponseInternal;
import pe.bbva.tipocambio.business.seguridad.dto.ResponseUsuarioDTO;
import pe.bbva.tipocambio.business.seguridad.service.LoginService;
import pe.bbva.tipocambio.comun.util.Constantes;
import pe.bbva.tipocambio.comun.util.Util;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/api/seguridad")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class SeguridadController {
	
	@Autowired
	private LoginService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO<ResponseUsuarioDTO>> login(@RequestBody RequestLoginDto loginDto) throws Exception {
		ResponseDTO<ResponseUsuarioDTO> responseDTO = null;
		ResponseUsuarioDTO usuarioDTO = new ResponseUsuarioDTO();
		ResponseInternal<ResponseUsuarioDTO> response = usuarioService.login(loginDto.getIdentificador(), loginDto.getPassword(), loginDto.getIp(), loginDto.getTokenGoogleV3());
		System.out.println("el mensjae de respuesta es " +  response.getMessage());
		System.out.println("isStatus " +  response.isStatus());
		if(response.isStatus()) {
			
			usuarioDTO = (ResponseUsuarioDTO) response.getBody();
			if(usuarioDTO!=null) {
				String token = getJWTToken(loginDto.getIdentificador());
				usuarioDTO.setToken(token);			
			}
			responseDTO = Util.returnResponseSuccessful(usuarioDTO);
		}else {
			responseDTO = Util.returnResponseProblem(response.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	private String getJWTToken(String usuario) {
		String secretKey = Constantes.SECRET_KEY;
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("USER_ROLE");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(usuario)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
//	@PostMapping("/cambiarPassword")
//	public ResponseEntity<ResponseDTO<String>> cambiarPassword(@RequestBody RequestPasswordCambioDTO request) throws Exception {
//		//TODO retirar esto
//		AES_Encryption algoritDesc = new AES_Encryption();
//		String passwordNEW = algoritDesc.getAES(request.getPasswordNuevo());
//		request.setPasswordNuevo(passwordNEW);
//		
//		ResponseDTO<String> responseDTO = null;
//		String responsePassword = passwordCambioService.cambioPassword(request);
//		if(responsePassword.equals(Constantes.PROCESO_OK)) {
//			String retorno = Constantes.PROCESO_OK;
//			responseDTO = Util.returnResponseSuccessful(retorno);
//		}else {
//			responseDTO = Util.returnResponseProblem(responsePassword);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
	
//	@PostMapping("/validarClave")
//	public ResponseEntity<ResponseDTO<String>> validarPassword(@RequestBody RequestValidarClaveDto request) throws Exception {
//		
//		//TODO retirar esto
//		AES_Encryption algoritDesc = new AES_Encryption();
//		String passwordOLD = algoritDesc.getAES(request.getPasswordOld());
//		request.setPasswordOld(passwordOLD);
//		
//		ResponseDTO<String> responseDTO = null;
//		String responsePassword = passwordCambioService.validarPassword(request);
//		if(responsePassword.equals(Constantes.PROCESO_OK)) {
//			String retorno = Constantes.PROCESO_OK;
//			responseDTO = Util.returnResponseSuccessful(retorno);
//		}else {
//			responseDTO = Util.returnResponseProblem("No coincide la clave");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
//	
//	@PostMapping("/validarNUltimasClave")
//	public ResponseEntity<ResponseDTO<String>> validarNUltimasClave(@RequestBody RequestValidarNClavesDto request) throws Exception {
//		
//		//TODO retirar esto
//		AES_Encryption algoritDesc = new AES_Encryption();
//		String passwordNew = algoritDesc.getAES(request.getPasswordNew());
//		request.setPasswordNew(passwordNew);
//		
//		ResponseDTO<String> responseDTO = null;
//		String responsePassword = passwordCambioService.validarNUltimasClave(request);
//		System.out.println( "llego controller " + responsePassword);
//		if(responsePassword.equals(Constantes.PROCESO_OK)) {
//			String retorno = Constantes.PROCESO_OK;
//			responseDTO = Util.returnResponseSuccessful(retorno);
//		}else {
//			responseDTO = Util.returnResponseProblem(responsePassword);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
//	
//	@PostMapping("/recordarPassword")
//	public ResponseEntity<ResponseDTO<String>> recordarPassword(@RequestBody String identificador) throws Exception {
//		System.out.println("llego el identificador " + identificador);
//		ResponseDTO<String> responseDTO = null;
//		String responsePassword = recordarPasswordService.recordarPassword(identificador);
//		if(responsePassword.equals(Constantes.PROCESO_OK)) {
//			String retorno = Constantes.PROCESO_OK;
//			responseDTO = Util.returnResponseSuccessful(retorno);
//		}else {
//			responseDTO = Util.returnResponseProblem(responsePassword);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}
//	
//	
	
	/*SERVICIO TEMPORAL*/
//	@PostMapping("/insertarClaveIdUsuario")
//	public String insertarCLvepassword() {
//		
//		passwordCambioService.insertarPassword();
//		
//		return "ok";
//	}
	
	/*SERVICIO TEMPORAL*/
//	@PostMapping("/generarToken")
//	public ResponseUsuarioDTO login(@RequestParam("usuario") String usuario) {
//		ResponseUsuarioDTO user = new ResponseUsuarioDTO();
//		//String token = getJWTToken(usuario);
//		//user.setToken(token);	
//		return user;
//	}

}
