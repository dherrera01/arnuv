package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.Modulo;
import com.core.arnuv.repository.IModuloRepository;
import com.core.arnuv.service.IModuloService;

@Service
@Component
public class ModuloServiceImp implements IModuloService {

	@Autowired
	private IModuloRepository repo;

	@Override
	public List<Modulo> listarModulos() {
		return repo.findAll();
	}

	@Override
	public Modulo insertarModulo(Modulo data) {
		return repo.save(data);
	}

	@Override
	public Modulo actualizarModulo(Modulo data) {
		Modulo existeModulo = repo.findById(data.getId()).orElse(null);
        existeModulo.setNombre(data.getNombre());
		existeModulo.setActivo(data.getActivo());
		return repo.save(existeModulo);
	}

	@Override
	public Modulo buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

}
