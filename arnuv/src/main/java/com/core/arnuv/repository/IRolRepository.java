package com.core.arnuv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

	@Query("Select r from Rol r where r.activo= ?1")
	List<Rol> buscarPorEstado(Boolean estado);
}
