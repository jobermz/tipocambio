package pe.bbva.tipocambio.comun.util;

public class Constantes {
	
	private Constantes() {
	}
	
	//JWT
	public static final String SECRET_KEY = "JQWENGIOO4FD56XFSF5ZCZ24GSDF54SD65";
	
	//ESTADO DEL SISTEMA
	public static final Integer ESTADO_ACTIVO = 1;
	public static final Integer ESTADO_INACCTIVO = 0;
	public static final String PROCESO_OK = "OK";
	public static final String CAMBIO_CLAVE = "CAMBIOCLAVE"; 
	
	//PERFILES
	public static final Integer PERFIL_BANCO = 1;
	public static final Integer PERFIL_COMERCIO = 2;
	public static final Integer PERFIL_REDEBAN = 3;
	
	//ESTADO BLOGEO - USUARIOLOGIN
	public static final String USUARIOLOGIN_INTENTO_EXITO = "1";
	public static final String USUARIOLOGIN_INTENTO_FALLIDO = "0";
	public static final char USUARIOLOGIN_BLOQUEADO = '1';
	public static final char USUARIOLOGIN_NO_BLOQUEADO = '0';
	public static final char USUARIOLOGIN_CAMBIO_CLAVE_SI = '0';
	public static final char USUARIOLOGIN_CAMBIO_CLAVE_NO = '1';
	
	//PARA EL SERVICIO DE RESPUESTA
	public static final int CODE_RESPONSE_SUCCESS = 10000;
	public static final String MSG_RESPONSE_SUCCESS = "Proceso ejecutado con éxito.";
	public static final int CODE_RESPONSE_ERROR = 20000;

	//Constanntes para la indentificacion
	public static final String IDENTIFICADOR_USUARIO = "USUARIO";
	public static final String IDENTIFICADOR_EMAIL= "CORREO";
	public static final String IDENTIFICADOR_CELULAR= "CELULAR";
	
	//TIPO DE CONEXION
	public static final String TIPOCONEXION_BD = "BD";
	public static final String TIPOCONEXION_LDAP = "LDAP";
	
	
	//USUARIO
	public static final char EXISTENCIA_ACTIVO = '1';
	
}
