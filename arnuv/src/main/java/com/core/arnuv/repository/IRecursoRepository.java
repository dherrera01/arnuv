package com.core.arnuv.repository;

import com.core.arnuv.model.Recurso;
import com.core.arnuv.model.RecursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecursoRepository extends JpaRepository<Recurso, RecursoId> {

    @Query("select r from Recurso r where r.id.idmodulo = ?1")
    List<Recurso> bucarPorIdmodulo(int idmodulo);
}
