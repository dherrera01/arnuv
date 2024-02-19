package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Rol;
import com.core.arnuv.model.Seguridadpolitica;
import com.core.arnuv.request.RolRequest;
import com.core.arnuv.response.RolResponse;
import com.core.arnuv.service.IRolService;
import com.core.arnuv.service.ISeguridadPoliticaService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService servicioRol;

	@Autowired
	private ISeguridadPoliticaService servicioSeguridadPolitica;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getRoles() throws Exception {
		var entity = servicioRol.listarTodosRoles();
		RolResponse resp = new RolResponse();
		resp.setListaDto(entity, RolResponse.RolDto.class, "usuariorols" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearRol(@RequestBody RolRequest rolrequest) throws Exception {
		Seguridadpolitica seguridad = servicioSeguridadPolitica.buscarPorId(rolrequest.getIdpolitica().getId());
		Rol rol = rolrequest.mapearDato(rolrequest, Rol.class, "idpolitica");
		rol.setIdpolitica(seguridad);

		var entity = servicioRol.insertarRol(rol);
		RolResponse resp = new RolResponse();
		resp.mapearDato(entity, RolResponse.RolDto.class, "opcionespermisos", "usuariorols" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarRol(@RequestBody RolRequest rolrequest) throws Exception {
		Seguridadpolitica seguridad = servicioSeguridadPolitica.buscarPorId(rolrequest.getIdpolitica().getId());
		Rol rol = rolrequest.mapearDato(rolrequest, Rol.class);
		rol.setIdpolitica(seguridad);
		var entity = servicioRol.actualizarRol(rol);
		RolResponse resp = new RolResponse();
		resp.mapearDato(entity, RolResponse.RolDto.class, "opcionespermisos", "usuariorols" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarRolPorId(@PathVariable int id) throws Exception {
		var entity = servicioRol.buscarPorId(id);
		RolResponse resp = new RolResponse();
		resp.mapearDato(entity, RolResponse.RolDto.class,  "opcionespermisos", "usuariorols" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
