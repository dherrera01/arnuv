package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.Tarifario;
import com.core.arnuv.repository.ITarifarioRapository;
import com.core.arnuv.service.ITarifarioService;

@Service
@Component
public class TarifarioServiceImp implements ITarifarioService {

	@Autowired
	private ITarifarioRapository repo;

	@Override
	public List<Tarifario> listarTarifarios() {
		return repo.findAll();
	}

	@Override
	public Tarifario insertarTarifario(Tarifario data) {
		return repo.save(data);
	}

	@Override
	public Tarifario actualizarTarifario(Tarifario data) {
		Tarifario existeTarifario = repo.findById(data.getId()).orElse(null);
		existeTarifario.setNombre(data.getNombre());
		existeTarifario.setTiempo(data.getTiempo());
		existeTarifario.setPrecio(data.getPrecio());
		existeTarifario.setActivo(data.getActivo());
		return repo.save(existeTarifario);
	}

	@Override
	public Tarifario buscarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}
}
