package com.core.arnuv.controller.rest;

import java.util.List;

import com.core.arnuv.jwt.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.arnuv.model.MascotaDetalle;
import com.core.arnuv.request.MascotaDetalleRequest;
import com.core.arnuv.response.MascotaDetalleReponse;
import com.core.arnuv.service.IMascotaDetalleService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/mascotas")
@TableGenerator(name = "Mascota")
public class MascotaDetalleController {

	@Autowired
	private IMascotaDetalleService servicioMascota;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<List<MascotaDetalle>> listarMascotaDetalle() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioMascota.listarMascotasDetalle();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearMascota(@RequestBody MascotaDetalle data) {
		Object entity;
		try {
			entity = servicioMascota.insertarMascotaDetalle(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarMascota(@RequestBody MascotaDetalleRequest mascotaDetalle) throws Exception {
		var entity = servicioMascota.actualizarMascotaDetalle(mascotaDetalle.mapearDato(mascotaDetalle, MascotaDetalle.class));
		MascotaDetalleReponse resp = new MascotaDetalleReponse();
		resp.mapearDato(entity, MascotaDetalleReponse.MascotaDetalleDto.class, "catalogodetalle");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarMascotaPorId(@PathVariable Long id) throws Exception {
		var entity = servicioMascota.buscarPorId(id);
		MascotaDetalleReponse resp = new MascotaDetalleReponse();
		resp.mapearDato(entity, MascotaDetalleReponse.MascotaDetalleDto.class,  "catalogodetalle");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
