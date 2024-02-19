package com.core.arnuv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class OpcionespermisoId implements Serializable {
    private static final long serialVersionUID = 2039766857737220112L;
    @Comment("Codigo de rol")
    @Column(name = "idrol", nullable = false)
    private Integer idrol;

    @Comment("Codigo de opcion permiso")
    @Column(name = "idopcion", nullable = false)
    private Long idopcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OpcionespermisoId entity = (OpcionespermisoId) o;
        return Objects.equals(this.idrol, entity.idrol) &&
                Objects.equals(this.idopcion, entity.idopcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrol, idopcion);
    }

}
