package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Recurso;
import com.core.arnuv.model.RecursoId;
import com.core.arnuv.request.RecursosRequest;
import com.core.arnuv.response.RecursosResponse;
import com.core.arnuv.service.IModuloService;
import com.core.arnuv.service.IRecursoService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recursos")
public class RecursosController {

	@Autowired
	private IRecursoService servicioRecurso;

	@Autowired
	private IModuloService servicioModulo;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> listar() throws Exception {
		var entity = servicioRecurso.listarTodos();
		RecursosResponse resp = new RecursosResponse();
		resp.setListaDto(entity, RecursosResponse.RecursosDto.class, "opcionespermisos","idmodulo" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crear(@RequestBody RecursosRequest data) throws Exception {
		var recursoId = new RecursoId();
		recursoId.setIdmodulo(data.getIdmodulo());
		recursoId.setIdrecurso(data.getIdrecurso());
		var moduloEntity = servicioModulo.buscarPorId(data.getIdmodulo());

		var recursoEntity = data.mapearDato(data, Recurso.class, "idrecurso","idmodulo");
		recursoEntity.setId(recursoId);
		recursoEntity.setIdmodulo(moduloEntity);

		var entity = servicioRecurso.insertar(recursoEntity);
		RecursosResponse resp = new RecursosResponse();
		resp.mapearDato(entity, RecursosResponse.RecursosDto.class,  "opcionespermisos");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizar(@RequestBody RecursosRequest data) throws Exception {
		var recursoId = new RecursoId();
		recursoId.setIdmodulo(data.getIdmodulo());
		recursoId.setIdrecurso(data.getIdrecurso());
		var moduloEntity = servicioModulo.buscarPorId(data.getIdmodulo());

		var recursoEntity = data.mapearDato(data, Recurso.class, "idrecurso","idmodulo");
		recursoEntity.setId(recursoId);
		recursoEntity.setIdmodulo(moduloEntity);

		var entity = servicioRecurso.actualizar(recursoEntity);
		RecursosResponse resp = new RecursosResponse();
		resp.mapearDato(entity, RecursosResponse.RecursosDto.class,  "opcionespermisos");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{idrecurso}/{idmodulo}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable int idrecurso, @PathVariable int idmodulo) throws Exception {
		var recursoId = new RecursoId();
		recursoId.setIdmodulo(idmodulo);
		recursoId.setIdrecurso(idrecurso);
		var entity = servicioRecurso.buscarPorId(recursoId);
		RecursosResponse resp = new RecursosResponse();
		resp.mapearDato(entity, RecursosResponse.RecursosDto.class,  "recursos");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscarporidmodulo/{idmodulo}")
	public ResponseEntity<RespuestaComun> buscarPorIdModulo( @PathVariable int idmodulo) throws Exception {
		var entity = servicioRecurso.bucarPorIdmodulo(idmodulo);
		RecursosResponse resp = new RecursosResponse();
		resp.setListaDto(entity, RecursosResponse.RecursosDto.class, "opcionespermisos","idmodulo" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
