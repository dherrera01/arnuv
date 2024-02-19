package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.model.UsuariorolId;
import com.core.arnuv.request.UsuarioRolRequest;
import com.core.arnuv.response.UsuarioRolResponse;
import com.core.arnuv.service.IRolService;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.core.arnuv.service.IUsuarioRolService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario-rol")
public class UsuarioRolController {

	@Autowired
	private IRolService servicioRol;

	@Autowired
	private IUsuarioDetalleService servicioUsuarioDetalle;

	@Autowired
	private IUsuarioRolService servicioUsuarioRol;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getUsuariosRol() throws Exception {
		var entity = servicioUsuarioRol.listarTodosUsuariosRol();
		UsuarioRolResponse resp = new UsuarioRolResponse();
		resp.setListaDto(entity, UsuarioRolResponse.UsuarioRolDto.class,  "idrol","idusuario");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearUsuarioRol(@RequestBody UsuarioRolRequest usuarioRol) throws Exception {
		UsuariorolId usuariorolId = new UsuariorolId();
		usuariorolId.setIdusuario(usuarioRol.getIdusuario());
		usuariorolId.setIdrol(usuarioRol.getIdrol());
		var rolentity = servicioRol.buscarPorId(usuarioRol.getIdrol());
		var usuariodetalleentity = servicioUsuarioDetalle.buscarPorId(usuarioRol.getIdusuario());

		var usuariorolentity = usuarioRol.mapearDato(usuarioRol, Usuariorol.class, "idrol","idusuario");
		usuariorolentity.setIdrol(rolentity);
		usuariorolentity.setIdusuario(usuariodetalleentity);
		usuariorolentity.setId(usuariorolId);

		var entity = servicioUsuarioRol.insertarUsuarioRol(usuariorolentity);
		UsuarioRolResponse resp = new UsuarioRolResponse();
		resp.mapearDato(entity, UsuarioRolResponse.UsuarioRolDto.class,  "catalogodetalles");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idrol}/{idusuario}")
	public ResponseEntity<RespuestaComun> buscarUsuarioRolPorId(@PathVariable int idrol, @PathVariable int idusuario) throws Exception {
		var entity = servicioUsuarioRol.buscarPorId(idrol, idusuario);
		UsuarioRolResponse resp = new UsuarioRolResponse();
		resp.mapearDato(entity, UsuarioRolResponse.UsuarioRolDto.class,  "idrol", "idusuario" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{idrol}")
	public ResponseEntity<RespuestaComun> buscarUsuarioRol(@PathVariable int idrol) throws Exception {
		var entity = servicioUsuarioRol.buscarPorRol(idrol);
		UsuarioRolResponse resp = new UsuarioRolResponse();
		resp.setListaDto(entity, UsuarioRolResponse.UsuarioRolDto.class,  "idrol","idusuario");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
