package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.MascotaDetalle;

@Repository
public interface IMascotaDetalleRepository extends JpaRepository<MascotaDetalle, Long>{

}
