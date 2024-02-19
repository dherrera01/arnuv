package com.core.arnuv.repository;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;
import com.core.arnuv.model.Usuariorol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IOpcionesPermisoRepository extends JpaRepository<Opcionespermiso, OpcionespermisoId> {

    @Query(value = "select o.nombre, o.idopcion from opcionespermisos o where o.idrol = :idrol and o.activo = 1 and o.mostar = 1 and o.nombre is not null",nativeQuery = true)
    List<Object[]> buscarTitulosMenu(@Param("idrol") int idrol);

    @Query(value = "select o.idrol, o.idopcion, o.idmodulo, o.idrecurso, r.nombre, r.ruta, o.crear, o.editar, o.eliminar from opcionespermisos o inner join recursos r on r.idrecurso = o.idrecurso and r.idmodulo = o.idmodulo\n" +
            "         where idrol = :idrol and activo = 1 and mostar = 1 and idopcionpadre = :idopcionpadre ",nativeQuery = true)
    List<Object[]> buscarItemMenu(@Param("idrol") int idrol, @Param("idopcionpadre") Long idopcionpadre);

    @Query("select u from Opcionespermiso u where u.id.idrol =?1")
    List<Opcionespermiso> buscarPorRol(int idrol);
}
