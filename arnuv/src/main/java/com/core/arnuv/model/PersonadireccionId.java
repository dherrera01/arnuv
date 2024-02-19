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
public class PersonadireccionId implements Serializable {
    private static final long serialVersionUID = -7469976486808679531L;
    @Comment("Codigo de direccion.")
    @Column(name = "iddireccion", nullable = false)
    private Long iddireccion;

    @Comment("Codigo de personas")
    @Column(name = "idpersona", nullable = false)
    private Long idpersona;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonadireccionId entity = (PersonadireccionId) o;
        return Objects.equals(this.iddireccion, entity.iddireccion) &&
                Objects.equals(this.idpersona, entity.idpersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddireccion, idpersona);
    }

}
