package com.core.arnuv.services.imp;

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.repository.IPersonaDetalleRepository;
import com.core.arnuv.service.IPersonaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PersonaDetalleServiceImp implements IPersonaDetalleService {

	@Autowired
	private IPersonaDetalleRepository repo;
	
	@Override
	public List<Personadetalle> listarTodosPersonaDetalle() {
		return repo.findAll();
	}

	@Override
	public Personadetalle insertarPersonaDetalle(Personadetalle data) {
		return repo.save(data);
	}

	@Override
	public Personadetalle actualizarPersonaDetalle(Personadetalle data) {
		Personadetalle existePersonaDetalle= repo.findById(data.getId()).orElse(null);
		existePersonaDetalle.setIdusuarioing(data.getIdusuarioing());
		existePersonaDetalle.setIdusuariomod(data.getIdusuariomod());
		existePersonaDetalle.setFechaingreso(data.getFechaingreso());
		existePersonaDetalle.setFechamodificacion(data.getFechamodificacion());
		existePersonaDetalle.setNombres(data.getNombres());
		existePersonaDetalle.setApellidos(data.getApellidos());
		existePersonaDetalle.setIdentificacion(data.getIdentificacion());
		existePersonaDetalle.setCelular(data.getCelular());
		existePersonaDetalle.setEmail(data.getEmail());
		existePersonaDetalle.setCatalogodetalle(data.getCatalogodetalle());
		return repo.save(existePersonaDetalle);
	}

	@Override
	public Personadetalle buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Personadetalle buscarPorIdentificacion(String identificacion) {
		return repo.buscarPorIdentificacion(identificacion);
	}

	@Override
	public boolean eliminar(Personadetalle data) {
		repo.delete(data);
		return true;
	}
}
