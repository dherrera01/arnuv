package com.core.arnuv.repository;

import com.core.arnuv.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatalogoRepository extends JpaRepository<Catalogo, Integer> {

	@Query("Select t from Catalogo t where t.activo= ?1")
	List<Catalogo> buscarPorEstado(Boolean estado);
}
