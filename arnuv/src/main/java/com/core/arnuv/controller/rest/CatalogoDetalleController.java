package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.request.CatalogoDetalleRequest;
import com.core.arnuv.response.CatalogoDetalleResponse;
import com.core.arnuv.service.ICatalogoDetalleService;
import com.core.arnuv.service.ICatalogoService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/catalogo-detalle")
public class CatalogoDetalleController {

	@Autowired
	private ICatalogoService servicioCatalogo;

	@Autowired
	private ICatalogoDetalleService servicioCatalogoDetalle;

	@Autowired
	private JwtServiceImpl serviceJwt;

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearCatalogoDetalle(@RequestBody CatalogoDetalleRequest catalogo) throws Exception {
		CatalogoDetalle catalogoDetalle = catalogo.mapearDato(catalogo, CatalogoDetalle.class, "mascotaDetalles","personadetalles");
		var catalogoEntity = servicioCatalogo.buscarPorId(catalogoDetalle.getId().getIdcatalogo());
		catalogoDetalle.setIdcatalogo(catalogoEntity);
		var entity = servicioCatalogoDetalle.insertarCatalogoDetalle(catalogoDetalle);
		CatalogoDetalleResponse resp = new CatalogoDetalleResponse();
		resp.mapearDato(entity, CatalogoDetalleResponse.CatalogoDetalleDto.class,  "mascotaDetalles","personadetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarCatalogoDetalle(@RequestBody CatalogoDetalleRequest catalogo) throws Exception {
		var entity = servicioCatalogoDetalle.actualizarCatalogoDetalle(catalogo.mapearDato(catalogo, CatalogoDetalle.class));
		CatalogoDetalleResponse resp = new CatalogoDetalleResponse();
		resp.mapearDato(entity, CatalogoDetalleResponse.CatalogoDetalleDto.class,  "mascotaDetalles","personadetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/listarCatalogo/{idcatalogo}")
	public ResponseEntity<RespuestaComun> buscarCatalogoDetallePorId(@PathVariable int idcatalogo) throws Exception {
		var lentity = servicioCatalogoDetalle.listarPorCatalogo(idcatalogo);
		CatalogoDetalleResponse resp = new CatalogoDetalleResponse();
		resp.setListaDto(lentity, CatalogoDetalleResponse.CatalogoDetalleDto.class,  "mascotaDetalles","personadetalles");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
