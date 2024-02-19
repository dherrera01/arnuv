package com.core.arnuv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Embeddable
public class UsuariodetallehistorialId implements Serializable {
    private static final long serialVersionUID = 535951177572465521L;
    @Comment("Codigo de usuario.")
    @Column(name = "idusuario", nullable = false, length = 20)
    private String idusuario;

    @Comment("Fecha Hisotrial")
    @Column(name = "fechahistoria", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechahistoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariodetallehistorialId entity = (UsuariodetallehistorialId) o;
        return Objects.equals(this.fechahistoria, entity.fechahistoria) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechahistoria, idusuario);
    }

}
