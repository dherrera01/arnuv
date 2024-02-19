package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Rol;

public interface IRolService {

	List<Rol> listarRolesActivos();

	List<Rol> listarRolesInactivos();

	List<Rol> listarTodosRoles();

	public Rol insertarRol(Rol data);

	public Rol actualizarRol(Rol data);

	public Rol buscarPorId(int id);
}
