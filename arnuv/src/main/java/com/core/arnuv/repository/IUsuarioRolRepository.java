package com.core.arnuv.repository;

import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.model.UsuariorolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRolRepository extends JpaRepository<Usuariorol, UsuariorolId> {

    @Query("select u from Usuariorol u where u.id.idrol =?1 and u.id.idusuario =?2")
    Usuariorol buscarbyid(int idrol, int idusuario);

    @Query("select u from Usuariorol u where u.id.idrol =?1")
    List<Usuariorol> buscarPorRol(int idrol);

}
