package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Usuariosession;

public interface IUsuarioSesionService {
	List<Usuariosession> listarUsuariosSesionActivos();

	List<Usuariosession> listarUsuariosSesionInactivos();

	List<Usuariosession> listarTodosUsuariosSesion();

	public Usuariosession insertarUsuarioSesion(Usuariosession data);

	public Usuariosession actualizarUsuarioSesion(Usuariosession data);

	public Usuariosession buscarPorId(int id);
}
