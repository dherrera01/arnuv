package com.core.arnuv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Usuariosession;

@Repository
public interface IUsuarioSesionRepository extends JpaRepository<Usuariosession, Integer> {

	@Query("Select us from Usuariosession us where us.activo= ?1")
	List<Usuariosession> buscarPorEstado(Boolean estado);
}
