package com.core.arnuv.service;

import com.core.arnuv.model.Catalogo;

import java.util.List;

/**
 * Interfaz de metodos que expone el servicio
 */
public interface ICatalogoService {

	List<Catalogo> listarCatalogosActivos();

	List<Catalogo> listarCatalogosInactivos();

	List<Catalogo> listarTodosCatalogos();

	public Catalogo insertarCatalogo(Catalogo data);

	public Catalogo actualizarCatalogo(Catalogo data);

	public Catalogo buscarPorId(int id);
}
