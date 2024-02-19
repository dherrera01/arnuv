package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Paseo;

@Repository
public interface IPaseoRepository extends JpaRepository<Paseo, String> {

}
