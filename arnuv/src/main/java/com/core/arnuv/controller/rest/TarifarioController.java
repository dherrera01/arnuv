package com.core.arnuv.controller.rest;

import java.util.List;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.request.TarifarioRequest;
import com.core.arnuv.response.TarifarioResponse;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.core.arnuv.model.Tarifario;
import com.core.arnuv.service.ITarifarioService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/tarifarios")
@TableGenerator(name = "Tarifario")
public class TarifarioController {

	@Autowired
	private ITarifarioService servicioTarifario;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<List<Tarifario>> listar() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioTarifario.listarTarifarios();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Tarifario data) {
		Object entity;
		try {
			entity = servicioTarifario.insertarTarifario(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody TarifarioRequest tarifario) throws Exception {
		var entity = servicioTarifario.actualizarTarifario(tarifario.mapearDato(tarifario, Tarifario.class));
		TarifarioResponse resp = new TarifarioResponse();
		resp.mapearDato(entity, TarifarioResponse.TarifarioDto.class);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable Long id) throws Exception {
		var entity = servicioTarifario.buscarPorId(id);
		TarifarioResponse resp = new TarifarioResponse();
		resp.mapearDato(entity, TarifarioResponse.TarifarioDto.class, "paseos");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
