package com.core.arnuv.repository;

import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.model.CatalogoDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatalogoDetalleRepository extends JpaRepository<CatalogoDetalle, CatalogoDetalleId> {

	@Query("Select t from CatalogoDetalle t where t.id.idcatalogo= ?1")
	List<CatalogoDetalle> buscarPorIdCatalogo(int idCatalogo);

	@Query("Select t from CatalogoDetalle t where t.id.idcatalogo= ?1 and t.id.iddetalle= ?2")
	CatalogoDetalle buscarPorId(int idCatalogo, String idDetalle);
}
