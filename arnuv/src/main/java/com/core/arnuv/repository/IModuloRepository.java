package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Modulo;

@Repository
public interface IModuloRepository extends JpaRepository<Modulo, Integer> {

}
