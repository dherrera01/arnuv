package com.core.arnuv.services.imp;

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.repository.IUsuarioDetalleRepository;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

@Service
@Component
public class UsuarioDetalleServiceImp implements IUsuarioDetalleService {

	@Autowired
	private IUsuarioDetalleRepository repo;

	@Override
	public List<Usuariodetalle> listarTodosUsuariosDetalle() {
		return repo.findAll();
	}

	@Override
	public Usuariodetalle insertarUsuarioDetalle(Usuariodetalle data) {
		return repo.save(data);
	}

	@Override
	public Usuariodetalle actualizarUsuarioDetalle(Usuariodetalle data) {
		Usuariodetalle existeUsuarioDetalle = repo.findById(data.getIdusuario()).orElse(null);
		existeUsuarioDetalle.setIdpersona(data.getIdpersona());
		existeUsuarioDetalle.setIdusuarioing(data.getIdusuarioing());
		existeUsuarioDetalle.setIdusuariomod(data.getIdusuariomod());
		existeUsuarioDetalle.setIdusuarioaprobacion(data.getIdusuarioaprobacion());
		existeUsuarioDetalle.setFechaingreso(data.getFechaingreso());
		existeUsuarioDetalle.setFechamodificacion(data.getFechamodificacion());
		existeUsuarioDetalle.setFechaaprobacion(data.getFechaaprobacion());
		existeUsuarioDetalle.setEstado(data.getEstado());
		existeUsuarioDetalle.setPassword(data.getPassword());
		existeUsuarioDetalle.setCambiopassword(data.getCambiopassword());
		existeUsuarioDetalle.setObservacion(data.getObservacion());
		return repo.save(existeUsuarioDetalle);
	}

	@Override
	public Usuariodetalle buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Usuariodetalle buscarPorEmail(String email) {
		return repo.buscarPorEmail(email);
	}

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return repo.buscarPorUsername(username)
						.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
			}
		};
	}

	@Override
	public boolean eliminar(Usuariodetalle data) {
		repo.delete(data);
		return true;
	}

	public String generarRandomPassword(int length) {
		String caracteresPosibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		Random random = new Random();

		StringBuilder stringBuilder = new StringBuilder();

		// Generar caracteres aleatorios y construir la cadena
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(caracteresPosibles.length());
			char caracterAleatorio = caracteresPosibles.charAt(index);
			stringBuilder.append(caracterAleatorio);
		}

		return stringBuilder.toString();
	}

	@Override
	public String encriptarPassword(String password) {
		return Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8)
				.toString();
	}

}
