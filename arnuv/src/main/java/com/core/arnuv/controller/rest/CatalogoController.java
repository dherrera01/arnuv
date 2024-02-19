package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Catalogo;
import com.core.arnuv.request.CatalogoRequest;
import com.core.arnuv.response.CatalogoResponse;
import com.core.arnuv.service.ICatalogoService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/catalogos")
public class CatalogoController {

	@Autowired
	private ICatalogoService servicioCatalogo;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getCatalogos() throws Exception {
		var entity = servicioCatalogo.listarTodosCatalogos();
		CatalogoResponse resp = new CatalogoResponse();
		resp.setListaDto(entity, CatalogoResponse.CatalogoDto.class, "catalogodetalles" );
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearCatalogo(@RequestBody CatalogoRequest catalogo) throws Exception {
		var entity = servicioCatalogo.insertarCatalogo(catalogo.mapearDato(catalogo, Catalogo.class));
		CatalogoResponse resp = new CatalogoResponse();
		resp.mapearDato(entity, CatalogoResponse.CatalogoDto.class,  "catalogodetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarCatalogo(@RequestBody CatalogoRequest catalogo) throws Exception {
		var entity = servicioCatalogo.actualizarCatalogo(catalogo.mapearDato(catalogo, Catalogo.class));
		CatalogoResponse resp = new CatalogoResponse();
		resp.mapearDato(entity, CatalogoResponse.CatalogoDto.class,  "catalogodetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarCatalogoPorId(@PathVariable int id) throws Exception {
		var entity = servicioCatalogo.buscarPorId(id);
		CatalogoResponse resp = new CatalogoResponse();
		resp.mapearDato(entity, CatalogoResponse.CatalogoDto.class,  "catalogodetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
