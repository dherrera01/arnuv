package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Personadetalle;

public interface IPersonaDetalleService {

	List<Personadetalle> listarTodosPersonaDetalle();

	public Personadetalle insertarPersonaDetalle(Personadetalle data);

	public Personadetalle actualizarPersonaDetalle(Personadetalle data);

	public Personadetalle buscarPorId(int id);

	public Personadetalle buscarPorIdentificacion(String identificacion);

	public boolean eliminar(Personadetalle data);

}
