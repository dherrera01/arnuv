package com.core.arnuv.services.imp;

import com.core.arnuv.model.Usuariosession;
import com.core.arnuv.repository.IUsuarioSesionRepository;
import com.core.arnuv.service.IUsuarioSesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UsuarioSesionServiceImp implements IUsuarioSesionService {

	@Autowired
	private IUsuarioSesionRepository repo;

	@Override
	public List<Usuariosession> listarUsuariosSesionActivos() {
		return repo.buscarPorEstado(true);
	}

	@Override
	public List<Usuariosession> listarUsuariosSesionInactivos() {
		return repo.buscarPorEstado(false);
	}

	@Override
	public List<Usuariosession> listarTodosUsuariosSesion() {
		return repo.findAll();
	}

	@Override
	public Usuariosession insertarUsuarioSesion(Usuariosession data) {
		return repo.save(data);
	}

	@Override
	public Usuariosession actualizarUsuarioSesion(Usuariosession data) {
		Usuariosession existeUsuarioSesion = repo.findById(data.getIdusuario()).orElse(null);
		existeUsuarioSesion.setNumerointentos(data.getNumerointentos());
		existeUsuarioSesion.setIdsession(data.getIdsession());
		existeUsuarioSesion.setFechainicio(data.getFechainicio());
		existeUsuarioSesion.setFechasalida(data.getFechasalida());
		existeUsuarioSesion.setActivo(data.getActivo());
		existeUsuarioSesion.setEstado(data.getEstado());
		existeUsuarioSesion.setUseragent(data.getUseragent());
		existeUsuarioSesion.setIptermialremoto(data.getIptermialremoto());
		existeUsuarioSesion.setUsuariodetalle(data.getUsuariodetalle());
		return repo.save(existeUsuarioSesion);
	}

	@Override
	public Usuariosession buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}
}
