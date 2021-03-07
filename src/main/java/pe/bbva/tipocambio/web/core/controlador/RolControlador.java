package pe.bbva.tipocambio.web.core.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.bbva.tipocambio.business.core.dto.ResponseDTO;
import pe.bbva.tipocambio.business.core.dto.RolDto;
import pe.bbva.tipocambio.business.core.service.RolService;
import pe.bbva.tipocambio.comun.util.Util;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RolControlador {
	
	@Autowired
	private RolService rolService;
	
//	@GetMapping("/consultarRolesPorPerfilSinAsignar/{idPerfil}")
//	public ResponseEntity<ResponseDTO<List<RolDto>>> consultarRolesPorPerfilSinAsignar(@PathVariable("idPerfil") Integer idPerfil) {
//		List<RolDto> roles = rolService.consultarRolesPorPerfilSinAsignar(idPerfil);
//		ResponseDTO<List<RolDto>> responseDTO = null;
//		if(roles != null) {
//			System.out.println("entro en ok " +  roles.size());
//			responseDTO = Util.returnResponseSuccessful(roles);
//		} else {
//			System.out.println("entro en no ok ");
//			responseDTO = Util.returnResponseProblem("No se encontraron roles");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}

	@GetMapping("/consultarRolesPorPerfil/{idPerfil}")
	public ResponseEntity<ResponseDTO<List<RolDto>>> consultarRolesPorPerfil(@PathVariable("idPerfil") Integer idPerfil) {
		List<RolDto> roles = rolService.consultarRolesPorPerfil(idPerfil);
		ResponseDTO<List<RolDto>> responseDTO = null;
		if(roles != null) {
			System.out.println("entro en ok " +  roles.size());
			responseDTO = Util.returnResponseSuccessful(roles);
		} else {
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se encontraron roles");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@GetMapping("/consultar")
	public ResponseEntity<ResponseDTO<List<RolDto>>> consultar() {
		List permisos = rolService.consultarRoles();
		ResponseDTO<List<RolDto>> responseDTO = null;
		if(permisos != null) {
			System.out.println("entro en ok " +  permisos.size());
			responseDTO = Util.returnResponseSuccessful(permisos);
		} else {
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se encontro el perfil");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@GetMapping("/consultar/{idRol}")
	public ResponseEntity<ResponseDTO<RolDto>> consultarPorId(@PathVariable("idRol") Integer idRol) {
		RolDto rolDto = rolService.consultarRolPorId(idRol);
		ResponseDTO<RolDto> responseDTO = null;
		if(rolDto != null) {
			responseDTO = Util.returnResponseSuccessful(rolDto);
		} else {
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se encontro el perfil");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@PostMapping("/registrar")
	public ResponseEntity<ResponseDTO<String>> registrar(@RequestBody RolDto rolDto) {
		ResponseDTO<String> responseDTO = null;
		try {
			rolService.registrarRol(rolDto);
			responseDTO = Util.returnResponseSuccessful("Ok");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se pudo registrar el rol");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<ResponseDTO<String>> actualizar(@RequestBody RolDto rolDto) {
		ResponseDTO<String> responseDTO = null;
		try {
			rolService.actualizarRol(rolDto);
			responseDTO = Util.returnResponseSuccessful("Ok");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se pudo actualizar el permiso");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

//	@PostMapping("/actualizarPerfilDeRol")
//	public ResponseEntity<ResponseDTO<String>> actualizarPerfilDeRol(@RequestBody RequestRolPerfilDto requestRolPerfilDto) {
//		ResponseDTO<String> responseDTO = null;
//		try {
//			rolService.actualizarPerfilDeRol(requestRolPerfilDto);
//			responseDTO = Util.returnResponseSuccessful("Ok");
//		} catch(Exception ex) {
//			ex.printStackTrace();
//			System.out.println("entro en no ok ");
//			responseDTO = Util.returnResponseProblem("No se pudo actualizar el rol");
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
//	}

	@GetMapping("/eliminar/{id}")
	public ResponseEntity<ResponseDTO<String>> eliminar(@PathVariable("id") Integer idRol) {
		ResponseDTO<String> responseDTO = null;
		try {
			rolService.eliminarRol(idRol);
			responseDTO = Util.returnResponseSuccessful("Ok");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("entro en no ok ");
			responseDTO = Util.returnResponseProblem("No se pudo eliminar el rol");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}
}
