package com.core.arnuv.service;

import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.model.Usuariorol;

import java.util.List;

public interface IUsuarioRolService {

	List<Usuariorol> listarTodosUsuariosRol();

	public Usuariorol insertarUsuarioRol(Usuariorol data);

	public Usuariorol buscarPorId(int idrol, int idusuario);

	List<Usuariorol>  buscarPorRol(int idrol);

	public boolean eliminar(Usuariorol data);
}
