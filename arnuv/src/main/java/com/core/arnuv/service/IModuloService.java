package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Modulo;

public interface IModuloService {
	List<Modulo> listarModulos();

	public Modulo insertarModulo(Modulo data);
	
	public Modulo actualizarModulo(Modulo data);

	public Modulo buscarPorId(int id);
}
