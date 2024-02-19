package com.core.arnuv.service;

import com.core.arnuv.model.Usuariodetalle;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioDetalleService {

	List<Usuariodetalle> listarTodosUsuariosDetalle();

	public Usuariodetalle insertarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle actualizarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle buscarPorId(int id);

	public Usuariodetalle buscarPorEmail(String email);

	UserDetailsService userDetailsService();

	public boolean eliminar(Usuariodetalle data);

	public String generarRandomPassword(int length);

	public String encriptarPassword(String password) throws Exception;

}
