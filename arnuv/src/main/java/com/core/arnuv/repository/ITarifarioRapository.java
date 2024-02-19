package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Tarifario;

@Repository
public interface ITarifarioRapository extends JpaRepository<Tarifario, Long> {

}
