package pe.bbva.tipocambio.business.seguridad.service.impl;

import org.springframework.stereotype.Service;
import pe.bbva.tipocambio.business.seguridad.dto.ResponseInternal;
import pe.bbva.tipocambio.business.seguridad.dto.ResponseUsuarioDTO;
import pe.bbva.tipocambio.business.seguridad.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Override
	public ResponseInternal<ResponseUsuarioDTO> login(String identificador, String password, String ip, String tokenV3) {
		ResponseInternal<ResponseUsuarioDTO> responseInternal = new ResponseInternal<>();
		ResponseUsuarioDTO usuarioDTO = new ResponseUsuarioDTO();
		usuarioDTO.setUsuarioNombre("admin");
		responseInternal.setStatus(true);
		responseInternal.setBody(usuarioDTO);
		return responseInternal;
	}
	
//	@Override
//	public ResponseInternal<ResponseUsuarioDTO> login(String identificador, String password, String ip, String tokenV3) {
//		ResponseInternal<ResponseUsuarioDTO> responseInternal = new ResponseInternal<>();
//		ResponseUsuarioDTO usuarioDTO = null;
//		Usuario usuario =  null;
//		try {
//			
//			
//			boolean validarRecaptcha = true;//isValid(tokenV3);
//			if(validarRecaptcha) {
//				
//				String tipoIndentif = Util.getTipoIdentificador(identificador);
//				usuario = usuarioInterface.obtenerUsuarioPorTipo(identificador,tipoIndentif);
//				if(usuario!=null) {
//					if(usuario.getUsuarioEstado() == Constantes.ESTADO_ACTIVO && usuario.getUsuarioVerificarExistencia() == Constantes.EXISTENCIA_ACTIVO ) {
//						//obtener perfil 
//						Perfil perfil = perfilInterface.consultarPerfilPorId(usuario.getPerfilId());
//						//validar si el usuario se puede logear por canal (celular, email, usuario)
//						String returnAut = validarTipoAutenticacion(usuario.getPerfilId(), tipoIndentif);
//						if(returnAut.equals(Constantes.PROCESO_OK)) {
//							//validar el tipo de conexion.
//							boolean _paseBD = false;
//							TipoConexion tipCon = tipoConexionInterface.getTipoConexionByIdConexion(perfil.getConexionId());
//							if(tipCon.getConexionNombre().equals(Constantes.TIPOCONEXION_BD)) {
//								_paseBD = true;
//							}else if(tipCon.getConexionNombre().equals(Constantes.TIPOCONEXION_LDAP)) {
//								//obtenemos la configuracion LDAP
//								ConfiguracionLdap configuracion = configuracionLdapInterface.getConfiguracionLdapById(tipCon.getLdapId());
//								if(configuracion!=null) {
//									LdapAuth ldapAuth = new LdapAuth("server", "dn", "tipoAutth", configuracion.getLdapUserAdmin(), configuracion.getLdapPassword());
//									if(ldapAuth.isAutenticado()){
//							            _paseBD = true;
//							        }
//							        else{
//							            responseInternal.setStatus(false);
//										responseInternal.setMessage("USUARIO NO SE PUDO AUTENTIFICAR EN LDAP");
//							        }
//								}else {
//									responseInternal.setStatus(false);
//									responseInternal.setMessage("NO SE ENCONTRO CONFIURACION DE LDAP");
//								}
//								
//							}else {
//								responseInternal.setStatus(false);
//								responseInternal.setMessage("TIPO DE CONEXION NO DEFINIDA");
//							}
//							
//							if(_paseBD){
//									
//										boolean _pase = false;
//										//validar el estado del banco o comercio asociado
//										String resupValida = usuarioInterface.validarEstadoComercioBanco(usuario.getUsuarioId(), usuario.getPerfilId());
//										if(resupValida.equals(Constantes.PROCESO_OK)){
//											_pase = true;
//										}else {
//											_pase = false;
//											responseInternal.setStatus(false);
//											responseInternal.setMessage(resupValida);
//										}
//										
//										
//										if(_pase) {
//											UsuarioCredenciales usuCrede = usuarioCredencialesInterface.getByIdUsuario(usuario.getUsuarioId());
//											if(usuCrede!=null) {
//												//desencriptamos 
//												AES_Encryption algoritDesc = new AES_Encryption();
//												password = algoritDesc.getAESDecrypt(password);
//												byte[] hashPassword = HashGenerator.getHash(password, usuCrede.getCredencialesSalto());
//												String valorSaveLog = null;
//												
//												if(HashGenerator.isEqualHash(usuCrede.getCredencialesPassword(), hashPassword)){
//													usuarioDTO = new ResponseUsuarioDTO();
//													usuarioDTO.setUsuarioEmail(usuario.getUsuarioEmail());
//													usuarioDTO.setUsuarioCelular(usuario.getUsuarioCelular());
//													usuarioDTO.setUsuarioId(usuario.getUsuarioId());
//													usuarioDTO.setUsuarioNombre(usuario.getUsuarioNombre());
//													//usuarioDTO.setPassword(usuCrede.getCredencialesSalto());
//													usuarioDTO.setIpPerfil(perfil.getId());
//													responseInternal.setStatus(true);
//													responseInternal.setBody(usuarioDTO);
//													valorSaveLog = saveUsuarioLogin(usuario.getUsuarioId(), ip, Constantes.USUARIOLOGIN_INTENTO_EXITO, perfil.getId());
//													System.out.println("retorno de save usuario login es " + valorSaveLog);
//												}else {
//													responseInternal.setStatus(false);
//													responseInternal.setMessage("CONTRASEÑA INCORRECTA");
//													valorSaveLog = saveUsuarioLogin(usuario.getUsuarioId(), ip, Constantes.USUARIOLOGIN_INTENTO_FALLIDO, perfil.getId());
//													System.out.println("el mensaje de respuesta es " + valorSaveLog);
//												}
//												
//												if(!valorSaveLog.equals( Constantes.PROCESO_OK)) {
//														responseInternal.setMessage(valorSaveLog);
//												}
//												
//												/*
//												if(valorSaveLog.equals( Constantes.PROCESO_OK) || valorSaveLog.equals( Constantes.CAMBIO_CLAVE)) {
//													responseInternal.setMessage(valorSaveLog);
//												}else {
//													responseInternal.setStatus(false);
//													responseInternal.setMessage(valorSaveLog);
//												}
//												*/
//											}
//										}
//							}
//						}else {
//							responseInternal.setStatus(false);
//							responseInternal.setMessage(returnAut);
//						}
//					}else {
//						responseInternal.setStatus(false);
//						responseInternal.setMessage("EL USUARIO ESTA INACTIVO");
//					}		
//				}else {
//					responseInternal.setStatus(false);
//					responseInternal.setMessage("NO SE ENCONTRO USUARIO");
//				}
//				
//			}else {
//				responseInternal.setStatus(false);
//				responseInternal.setMessage("ACTIVIDAD SOSPECHOSA");
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return responseInternal;
//	}
//	
//	/**
//	 * Metodo que se encarga de registrar en la carpeta usuariolin
//	 */
//	public String saveUsuarioLogin(Integer idUsuairo, String ip, String tipoRegistro, Integer idPerfil) {
//		String valorRetun = "";
//		try {
//			valorRetun = usuarioLoginInterface.validarUsuarioLogin(idUsuairo, ip, tipoRegistro, idPerfil);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return valorRetun;
//	}
//	
//	/**
//	 * Metodo para validar que tipode autentificacion puede realizar el usuario por email, usuario, o por correo.
//	 * @param idPerfil
//	 * @param tipoAutentificacion
//	 * @return
//	 */
//	public String validarTipoAutenticacion(Integer idPerfil, String tipoAutentificacion) {
//		System.out.println("los valores que se mandan son " + idPerfil);
//		System.out.println("los valores que se mandan son " + tipoAutentificacion);
//		String valorReturn = "NO ESTA PERMITIDO AUTENTIFICAR POR " + tipoAutentificacion;
//		String resp = parametrosInterface.getByIdPerfil(idPerfil, tipoAutentificacion);
//		if(resp.equals(Constantes.PROCESO_OK)) {
//			valorReturn = resp;
//		}
//		return valorReturn;
//	}
//	
//	
//	private static final String RECAPTCHA_SERVICE_URL = "https://www.google.com/recaptcha/api/siteverify";
//	private static final String SECRET_KEY = "6LcqAF4aAAAAALevn7yqbpUW080OmXNnLdX86T21";
//	public static boolean isValid(String clientRecaptchaResponse) throws IOException, ParseException {
//		if (clientRecaptchaResponse == null || "".equals(clientRecaptchaResponse)) {
//			return false;
//		}
//
//		URL obj = new URL(RECAPTCHA_SERVICE_URL);
//		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//		con.setRequestMethod("POST");
//		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//		//add client result as post parameter
//		String postParams =
//				"secret=" + SECRET_KEY +
//				"&response=" + clientRecaptchaResponse;
//
//		// send post request to google recaptcha server
//		con.setDoOutput(true);
//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		wr.writeBytes(postParams);
//		wr.flush();
//		wr.close();
//
//		int responseCode = con.getResponseCode();
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		//Parse JSON-response
//		JSONParser parser = new JSONParser();
//		JSONObject json = (JSONObject) parser.parse(response.toString());
//
//		Boolean success = (Boolean) json.get("success");
//		Double score = (Double) json.get("score");
//
//		//result should be sucessfull and spam score above 0.5
//		return (success && score >= 0.5);
//	}

}
