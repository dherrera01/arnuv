package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
@Comment("Tabla que almacena el detalle de la mascota")
@Entity
@Table(name = "mascotadetalle")
public class MascotaDetalle {
	@Id
    @Comment("Codigo de la mascota")
    @Column(name = "idmascota")
    private Long id;

    @ManyToOne()
    @Comment("Codigo de personas")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idpersona")
    @ToString.Exclude
    private Personadetalle idpersona;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "idcatalogorasa", referencedColumnName = "iddetalle"),
            @JoinColumn(name = "iddetallerasa", referencedColumnName = "idcatalogo")
    })
    @Comment("Codigo de catalogo")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ToString.Exclude
    private CatalogoDetalle catalogodetalle;

    @Comment("Nombre de la mascota")
    @Column(name = "nombre", length = 120)
    private String nombre;

    @Comment("Edad de la mascota")
    @Column(name = "edad", precision = 2)
    private Integer edad;

}
