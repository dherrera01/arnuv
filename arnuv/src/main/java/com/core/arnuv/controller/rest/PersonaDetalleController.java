package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.request.PersonaDetalleRequest;
import com.core.arnuv.response.PersonaDetalleResponse;
import com.core.arnuv.service.ICatalogoDetalleService;
import com.core.arnuv.service.IPersonaDetalleService;
import com.core.arnuv.utils.ArnuvNotFoundException;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("personas")
public class PersonaDetalleController {

	@Autowired
	private ICatalogoDetalleService servicioCatalogoDetalle;

	@Autowired
	private IPersonaDetalleService servicioPersonaDetalle;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getPersonasDetalle() throws Exception {
		var entity = servicioPersonaDetalle.listarTodosPersonaDetalle();
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.setListaDto(entity, PersonaDetalleResponse.PersonaDetalleDto.class, "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearCatalogo(@RequestBody PersonaDetalleRequest persona) throws Exception {
		var catDetEntity = servicioCatalogoDetalle.buscarPorId(persona.getIdcatalogoidentificacion(), persona.getIddetalleidentificacion());
		Personadetalle personadetalle = persona.mapearDato(persona, Personadetalle.class, "idcatalogoidentificacion", "iddetalleidentificacion");
		personadetalle.setCatalogodetalle(catDetEntity);
		Personadetalle entity = null;
		try {
			entity = servicioPersonaDetalle.insertarPersonaDetalle(personadetalle);
		} catch (DataIntegrityViolationException e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage().split("Detail:")[1].split("]")[0]);
		}
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarCatalogo(@RequestBody PersonaDetalleRequest persona) throws Exception {
		var catDetEntity = servicioCatalogoDetalle.buscarPorId(persona.getIdcatalogoidentificacion(), persona.getIddetalleidentificacion());
		Personadetalle pd = persona.mapearDato(persona, Personadetalle.class);
		pd.setCatalogodetalle(catDetEntity);
		Personadetalle entity = null;
		try {
			entity = servicioPersonaDetalle.actualizarPersonaDetalle(pd);
		} catch (DataIntegrityViolationException e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage().split("Detail:")[1].split("]")[0]);
		}
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPersonaDetallePorId(@PathVariable int id) throws Exception {
		var entity = servicioPersonaDetalle.buscarPorId(id);
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscaridentificacion/{identificacion}")
	public ResponseEntity<RespuestaComun> buscarPorIdentificacion(@PathVariable String identificacion) throws Exception {
		var entity = servicioPersonaDetalle.buscarPorIdentificacion(identificacion);
		if (entity == null) {
			throw new ArnuvNotFoundException("La persona con identificación {0} no existe", identificacion);
		}
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
