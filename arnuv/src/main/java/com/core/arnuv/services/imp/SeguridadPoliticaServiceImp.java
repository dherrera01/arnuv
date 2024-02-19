package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.Seguridadpolitica;
import com.core.arnuv.repository.ISeguridadPoliticaRepository;
import com.core.arnuv.service.ISeguridadPoliticaService;

@Service
@Component
public class SeguridadPoliticaServiceImp implements ISeguridadPoliticaService {

	@Autowired
	private ISeguridadPoliticaRepository repo;

	@Override
	public List<Seguridadpolitica> listarSeguridadPoliticas() {
		return repo.findAll();
	}

	@Override
	public Seguridadpolitica insertarSeguridadPolitica(Seguridadpolitica data) {
		return repo.save(data);
	}

	@Override
	public Seguridadpolitica actualizarSeguridadPolitica(Seguridadpolitica data) {
		Seguridadpolitica existeSeguridadPolitica = repo.findById(data.getId()).orElse(null);
		existeSeguridadPolitica.setLongitud(data.getLongitud());
		existeSeguridadPolitica.setIntentos(data.getIntentos());
		existeSeguridadPolitica.setNumeros(data.getNumeros());
		existeSeguridadPolitica.setEspeciales(data.getEspeciales());
		existeSeguridadPolitica.setMinusculas(data.getMinusculas());
		existeSeguridadPolitica.setMayusculas(data.getMayusculas());
		existeSeguridadPolitica.setTiemporegeraciontoken(data.getTiemporegeraciontoken());
		return repo.save(existeSeguridadPolitica);
	}

	@Override
	public Seguridadpolitica buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}
}
