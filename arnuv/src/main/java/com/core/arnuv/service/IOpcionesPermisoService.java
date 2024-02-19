package com.core.arnuv.service;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;

import java.util.List;
import java.util.Map;

/**
 * Interfaz de metodos que expone el servicio
 */
public interface IOpcionesPermisoService {

	List<Opcionespermiso> listarTodos();

	public Opcionespermiso insertar(Opcionespermiso data);

	public Opcionespermiso actualizar(Opcionespermiso data);

	public Opcionespermiso buscarPorId(OpcionespermisoId id);

	List<Map<String, Object>> buscarTitulosMenu(int idrol);

	List<Map<String, Object>> buscarItemMenu(int idrol, Long idopcionpadre);

	List<Opcionespermiso> buscarIdRol(int idrol);

}
