package com.core.arnuv.controller.rest;

import java.util.List;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.request.PaseoRequest;
import com.core.arnuv.response.PaseoResponse;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.core.arnuv.model.Paseo;
import com.core.arnuv.service.IPaseoService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/paseos")
@TableGenerator(name = "Paseo")
public class PaseoController {

	@Autowired
	private IPaseoService servicioPase;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<List<Paseo>> listar() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioPase.listarPaseos();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Paseo data) {
		Object entity;
		try {
			entity = servicioPase.insertarPaseo(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody PaseoRequest paseo) throws Exception {
		var entity = servicioPase.actualizarPaseo(paseo.mapearDato(paseo, Paseo.class));
		PaseoResponse resp = new PaseoResponse();
		resp.mapearDato(entity, PaseoResponse.PaseoDto.class);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable String id) throws Exception {
		var entity = servicioPase.buscarPorId(id);
		PaseoResponse resp = new PaseoResponse();
		resp.mapearDato(entity, PaseoResponse.PaseoDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
