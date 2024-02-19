package com.core.arnuv.services.imp;

import com.core.arnuv.model.Recurso;
import com.core.arnuv.model.RecursoId;
import com.core.arnuv.repository.IRecursoRepository;
import com.core.arnuv.service.IRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class RecursoServiceImp implements IRecursoService {

	@Autowired
	private IRecursoRepository repo;


	@Override
	public List<Recurso> listarTodos() {
		return repo.findAll();
	}

	@Override
	public List<Recurso> bucarPorIdmodulo(int idmodulo) {
		return repo.bucarPorIdmodulo(idmodulo);
	}

	@Override
	public Recurso insertar(Recurso data) {
		return repo.save(data);
	}

	@Override
	public Recurso actualizar(Recurso data) {
		Recurso existe = repo.findById(data.getId()).orElse(null);
		existe.setNombre(data.getNombre());
		existe.setRuta(data.getRuta());
		return repo.save(existe);
	}

	@Override
	public Recurso buscarPorId(RecursoId id) {
		return repo.findById(id).orElse(null);
	}
}
