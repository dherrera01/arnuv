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
public class RecursoId implements Serializable {
    private static final long serialVersionUID = 2376371612793041769L;
    @Comment("Codigo de recurso")
    @Column(name = "idrecurso", nullable = false)
    private Integer idrecurso;

    @Comment("Codigo del modulo")
    @Column(name = "idmodulo", nullable = false)
    private Integer idmodulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecursoId entity = (RecursoId) o;
        return Objects.equals(this.idmodulo, entity.idmodulo) &&
                Objects.equals(this.idrecurso, entity.idrecurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmodulo, idrecurso);
    }

}
