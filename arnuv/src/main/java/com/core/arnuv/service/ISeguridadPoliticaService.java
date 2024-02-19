package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Seguridadpolitica;

public interface ISeguridadPoliticaService {
	List<Seguridadpolitica> listarSeguridadPoliticas();

	public Seguridadpolitica insertarSeguridadPolitica(Seguridadpolitica data);

	public Seguridadpolitica actualizarSeguridadPolitica(Seguridadpolitica data);

	public Seguridadpolitica buscarPorId(int id);
}
