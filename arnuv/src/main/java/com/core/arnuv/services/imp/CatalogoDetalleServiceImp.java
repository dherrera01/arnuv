package com.core.arnuv.services.imp;

import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.repository.ICatalogoDetalleRepository;
import com.core.arnuv.repository.ICatalogoRepository;
import com.core.arnuv.service.ICatalogoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CatalogoDetalleServiceImp implements ICatalogoDetalleService {

	@Autowired
	private ICatalogoRepository repoCatalogo;

	@Autowired
	private ICatalogoDetalleRepository repo;

	@Override
	public List<CatalogoDetalle> listarPorCatalogo(int idCatalogo) {
		return repo.buscarPorIdCatalogo(idCatalogo);
	}

	@Override
	public CatalogoDetalle insertarCatalogoDetalle(CatalogoDetalle data) {
		return repo.save(data);
	}

	@Override
	public CatalogoDetalle actualizarCatalogoDetalle(CatalogoDetalle data) {
		CatalogoDetalle existeCatalogo = repo.findById(data.getId()).orElse(null);
		existeCatalogo.setNombre(data.getNombre());
		existeCatalogo.setActivo(data.getActivo());
		return repo.save(existeCatalogo);
	}

	@Override
	public CatalogoDetalle buscarPorId(int idCatalogo, String idDetalle) {
		return repo.buscarPorId(idCatalogo, idDetalle);
	}
}
