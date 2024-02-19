package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Modulo;
import com.core.arnuv.request.ModuloRequest;
import com.core.arnuv.response.ModuloResponse;
import com.core.arnuv.service.IModuloService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

	@Autowired
	private IModuloService servicioModulo;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> listar() throws Exception {
		var entity = servicioModulo.listarModulos();
		ModuloResponse resp = new ModuloResponse();
		resp.setListaDto(entity, ModuloResponse.ModuloDto.class, "recursos" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crear(@RequestBody ModuloRequest data) throws Exception {
		var entity = servicioModulo.insertarModulo(data.mapearDato(data, Modulo.class, "id"));
		ModuloResponse resp = new ModuloResponse();
		resp.mapearDato(entity, ModuloResponse.ModuloDto.class,  "recursos");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizar(@RequestBody ModuloRequest modulo) throws Exception {
		var entity = servicioModulo.actualizarModulo(modulo.mapearDato(modulo, Modulo.class));
		ModuloResponse resp = new ModuloResponse();
		resp.mapearDato(entity, ModuloResponse.ModuloDto.class, "recursos");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable int id) throws Exception {
		var entity = servicioModulo.buscarPorId(id);
		ModuloResponse resp = new ModuloResponse();
		resp.mapearDato(entity, ModuloResponse.ModuloDto.class,  "recursos");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
