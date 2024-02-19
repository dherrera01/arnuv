package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Seguridadpolitica;
import com.core.arnuv.request.SeguridadPoliticaRequest;
import com.core.arnuv.response.SeguridadPoliticaResponse;
import com.core.arnuv.service.ISeguridadPoliticaService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguridad-politica")
public class SeguridadPoliticaController {

	@Autowired
	private ISeguridadPoliticaService servicioSeguridadPolitica;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getSeguridadPolitica() throws Exception {
		var entity = servicioSeguridadPolitica.listarSeguridadPoliticas();
		SeguridadPoliticaResponse resp = new SeguridadPoliticaResponse();
		resp.setListaDto(entity, SeguridadPoliticaResponse.SeguridadPoliticaDto.class, "rols" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearCatalogo(@RequestBody SeguridadPoliticaRequest data) throws Exception {
		var entity = servicioSeguridadPolitica.insertarSeguridadPolitica(data.mapearDato(data, Seguridadpolitica.class));
		SeguridadPoliticaResponse resp = new SeguridadPoliticaResponse();
		resp.mapearDato(entity, SeguridadPoliticaResponse.SeguridadPoliticaDto.class,  "rols");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarSeguridadPolitica(@RequestBody SeguridadPoliticaRequest data) throws Exception {
		var entity = servicioSeguridadPolitica.actualizarSeguridadPolitica(data.mapearDato(data, Seguridadpolitica.class));
		SeguridadPoliticaResponse resp = new SeguridadPoliticaResponse();
		resp.mapearDato(entity, SeguridadPoliticaResponse.SeguridadPoliticaDto.class,  "rols");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarSeguridadPolitcaPorId(@PathVariable int id) throws Exception {
		var entity = servicioSeguridadPolitica.buscarPorId(id);
		SeguridadPoliticaResponse resp = new SeguridadPoliticaResponse();
		resp.mapearDato(entity, SeguridadPoliticaResponse.SeguridadPoliticaDto.class,  "rols");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
