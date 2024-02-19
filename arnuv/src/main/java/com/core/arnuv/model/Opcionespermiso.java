package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;

@Data
@Comment("Tabla que almacena los menus de opciones del sistema")
@Entity
@Table(name = "opcionespermisos")
public class Opcionespermiso {
    @EmbeddedId
    private OpcionespermisoId id;

    @MapsId("idrol")
    @ManyToOne()
    @Comment("Codigo de rol")
    @JoinColumn(name = "idrol")
    @ToString.Exclude
    private Rol idrol;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "idrecurso", referencedColumnName = "idrecurso"),
            @JoinColumn(name = "idmodulo", referencedColumnName = "idmodulo")
    })
    @Comment("Codigo de recurso")
    @ToString.Exclude
    private Recurso recursos;

    @Comment("Codigo de opcion permiso Padre para manejar en el menu")
    @Column(name = "idopcionpadre", precision = 10)
    private Long idopcionpadre;

    @Comment("Nombre del item de menu")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("1 Opcion permiso activo, 0 inactivo")
    @Column(name = "activo")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean activo;

    @Comment("Muestra el menu")
    @Column(name = "mostar")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean mostar;

    @Comment("Permiso de crear")
    @Column(name = "crear")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean crear;

    @Comment("Permiso de editar")
    @Column(name = "editar")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean editar;

    @Comment("Permiso de eliminar")
    @Column(name = "eliminar")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean eliminar;

}
