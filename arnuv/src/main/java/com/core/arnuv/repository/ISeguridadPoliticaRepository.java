package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Seguridadpolitica;

@Repository
public interface ISeguridadPoliticaRepository extends JpaRepository<Seguridadpolitica, Integer> {

}
