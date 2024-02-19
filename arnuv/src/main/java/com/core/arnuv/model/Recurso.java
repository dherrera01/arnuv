package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Comment("Tabla que almacena los recursos del sistema.")
@Entity
@Table(name = "recursos")
public class Recurso {
    @EmbeddedId
    private RecursoId id;

    @MapsId("idmodulo")
    @ManyToOne()
    @Comment("Codigo del modulo")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idmodulo")
    @ToString.Exclude
    private Modulo idmodulo;

    @Comment("Nombre del recurso")
    @Column(name = "nombre", length = 200)
    private String nombre;

    @Comment("ruta de acceso de la aplicacion en flutter")
    @Column(name = "ruta", length = 300)
    private String ruta;

    @OneToMany(mappedBy = "recursos")
    private List<Opcionespermiso> opcionespermisos;

}
