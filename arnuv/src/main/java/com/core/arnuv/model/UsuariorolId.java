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
public class UsuariorolId implements Serializable {
    private static final long serialVersionUID = 3807884012728558778L;
    @Comment("Codigo de rol")
    @Column(name = "idrol", nullable = false)
    private Integer idrol;

    @Comment("Codigo de usuario.")
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariorolId entity = (UsuariorolId) o;
        return Objects.equals(this.idrol, entity.idrol) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrol, idusuario);
    }

}
