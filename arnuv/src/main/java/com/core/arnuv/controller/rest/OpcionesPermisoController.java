package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;
import com.core.arnuv.model.RecursoId;
import com.core.arnuv.request.OpcionesPermisoRequest;
import com.core.arnuv.response.OpcionesPermisoResponse;
import com.core.arnuv.service.IOpcionesPermisoService;
import com.core.arnuv.service.IRecursoService;
import com.core.arnuv.service.IRolService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opciones-permiso")
public class OpcionesPermisoController {

	@Autowired
	private IRolService servicioRol;

	@Autowired
	private IRecursoService servicioRecurso;

	@Autowired
	private IOpcionesPermisoService servicioOpcionPermiso;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> listar() throws Exception {
		var entity = servicioOpcionPermiso.listarTodos();
		OpcionesPermisoResponse resp = new OpcionesPermisoResponse();
		resp.setListaDto(entity, OpcionesPermisoResponse.OpcionesPermisoDto.class );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crear(@RequestBody OpcionesPermisoRequest data) throws Exception {
		var recursoId = new RecursoId();
		recursoId.setIdmodulo(data.getIdmodulo());
		recursoId.setIdrecurso(data.getIdrecurso());

		var recursoEntity = servicioRecurso.buscarPorId(recursoId);
		if (recursoEntity != null) recursoEntity.getIdmodulo().setRecursos(null);

		var rolEntity = servicioRol.buscarPorId(data.getIdrol());
		if (rolEntity != null) rolEntity.getIdpolitica().setRols(null);

		var opcionPermisoEntity = data.mapearDato(data, Opcionespermiso.class);
		OpcionespermisoId opcionespermisoId = new OpcionespermisoId();
		opcionespermisoId.setIdrol(data.getIdrol());
		opcionespermisoId.setIdopcion(data.getIdopcion());

		opcionPermisoEntity.setId(opcionespermisoId);
		opcionPermisoEntity.setRecursos(recursoEntity);
		opcionPermisoEntity.setIdrol(rolEntity);

		var entity = servicioOpcionPermiso.insertar(opcionPermisoEntity);
		OpcionesPermisoResponse resp = new OpcionesPermisoResponse();
		resp.mapearDato(entity, OpcionesPermisoResponse.OpcionesPermisoDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizar(@RequestBody OpcionesPermisoRequest data) throws Exception {
		var recursoId = new RecursoId();
		recursoId.setIdmodulo(data.getIdmodulo());
		recursoId.setIdrecurso(data.getIdrecurso());
		var recursoEntity = servicioRecurso.buscarPorId(recursoId);

		var rolEntity = servicioRol.buscarPorId(data.getIdrol());

		var opcionPermisoEntity = data.mapearDato(data, Opcionespermiso.class);
		OpcionespermisoId opcionespermisoId = new OpcionespermisoId();
		opcionespermisoId.setIdrol(data.getIdrol());
		opcionespermisoId.setIdopcion(data.getIdopcion());

		opcionPermisoEntity.setId(opcionespermisoId);
		opcionPermisoEntity.setRecursos(recursoEntity);
		opcionPermisoEntity.setIdrol(rolEntity);

		var entity = servicioOpcionPermiso.actualizar(opcionPermisoEntity);
		OpcionesPermisoResponse resp = new OpcionesPermisoResponse();
		resp.mapearDato(entity, OpcionesPermisoResponse.OpcionesPermisoDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{idrol}/{idopcion}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable int idrol, @PathVariable Long idopcion) throws Exception {
		var opcionespermisoId = new OpcionespermisoId();
		opcionespermisoId.setIdrol(idrol);
		opcionespermisoId.setIdopcion(idopcion);
		var entity = servicioOpcionPermiso.buscarPorId(opcionespermisoId);
		OpcionesPermisoResponse resp = new OpcionesPermisoResponse();
		resp.mapearDato(entity, OpcionesPermisoResponse.OpcionesPermisoDto.class);
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscaporrol/{idrol}")
	public ResponseEntity<RespuestaComun> listarPorRol(@PathVariable int idrol) throws Exception {
		var entity = servicioOpcionPermiso.buscarIdRol(idrol);
		OpcionesPermisoResponse resp = new OpcionesPermisoResponse();
		resp.setListaDto(entity, OpcionesPermisoResponse.OpcionesPermisoDto.class );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
