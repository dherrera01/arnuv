package com.core.arnuv.services.imp;

import com.core.arnuv.model.Catalogo;
import com.core.arnuv.repository.ICatalogoRepository;
import com.core.arnuv.service.ICatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CatalogoServiceImp implements ICatalogoService {

	@Autowired
	private ICatalogoRepository repo;

	@Override
	public List<Catalogo> listarCatalogosActivos() {
		return repo.buscarPorEstado(true);
	}

	@Override
	public List<Catalogo> listarCatalogosInactivos() {
		return repo.buscarPorEstado(false);
	}

	@Override
	public List<Catalogo> listarTodosCatalogos() {
		return repo.findAll();
	}

	@Override
	public Catalogo insertarCatalogo(Catalogo data) {
		return repo.save(data);
	}

	@Override
	public Catalogo actualizarCatalogo(Catalogo data) {
		Catalogo existeCatalogo = repo.findById(data.getId()).orElse(null);
		existeCatalogo.setNombre(data.getNombre());
		existeCatalogo.setActivo(data.getActivo());
		return repo.save(existeCatalogo);
	}

	@Override
	public Catalogo buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}
}
