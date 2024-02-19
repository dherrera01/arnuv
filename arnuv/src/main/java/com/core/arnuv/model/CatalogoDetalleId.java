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
public class CatalogoDetalleId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Comment("Codigo de catalogo")
    @Column(name = "idcatalogo")
    private Integer idcatalogo;

    @Comment("Codigo de catalogo detalle")
    @Column(name = "iddetalle", length = 3)
    private String iddetalle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CatalogoDetalleId entity = (CatalogoDetalleId) o;
        return Objects.equals(this.idcatalogo, entity.idcatalogo) &&
                Objects.equals(this.iddetalle, entity.iddetalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcatalogo, iddetalle);
    }

}
