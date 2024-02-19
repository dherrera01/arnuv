package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Usuariosession;
import com.core.arnuv.request.UsuarioSessionRequest;
import com.core.arnuv.response.UsuarioSessionResponse;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.core.arnuv.service.IUsuarioSesionService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario-sesion")
public class UsuarioSesionController {
	
	@Autowired
	private IUsuarioSesionService servicioUsuarioSesion;

	@Autowired
	private IUsuarioDetalleService servicioUsuarioDetalle;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getUsuariosSesion() throws Exception {
		var entity = servicioUsuarioSesion.listarTodosUsuariosSesion();
		UsuarioSessionResponse resp = new UsuarioSessionResponse();
		resp.setListaDto(entity, UsuarioSessionResponse.UsuarioSesionDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearUsuarioSesion(@RequestBody UsuarioSessionRequest sesion) throws Exception {
		var usuariodetalleentity = servicioUsuarioDetalle.buscarPorId(sesion.getIdusuario());
		Usuariosession sesionentity = sesion.mapearDato(sesion, Usuariosession.class,"idusuario");
		sesionentity.setUsuariodetalle(usuariodetalleentity);
		var entity = servicioUsuarioSesion.insertarUsuarioSesion(sesionentity);
		UsuarioSessionResponse resp = new UsuarioSessionResponse();
		resp.mapearDato(entity, UsuarioSessionResponse.UsuarioSesionDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarUsuarioSesion(@RequestBody UsuarioSessionRequest sesion) throws Exception {
		var usuariodetalleentity = servicioUsuarioDetalle.buscarPorId(sesion.getIdusuario());
		Usuariosession sesionentity = sesion.mapearDato(sesion, Usuariosession.class,"idusuario");
		sesionentity.setUsuariodetalle(usuariodetalleentity);
		var entity = servicioUsuarioSesion.actualizarUsuarioSesion(sesionentity);
		UsuarioSessionResponse resp = new UsuarioSessionResponse();
		resp.mapearDato(entity, UsuarioSessionResponse.UsuarioSesionDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarUsuarioSesionPorId(@PathVariable int id) throws Exception {
		var entity = servicioUsuarioSesion.buscarPorId(id);
		UsuarioSessionResponse resp = new UsuarioSessionResponse();
		resp.mapearDato(entity, UsuarioSessionResponse.UsuarioSesionDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
