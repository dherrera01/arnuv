package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.type.NumericBooleanConverter;

import java.util.List;

@Data
@Comment("Tabla que almacena el detalle de cada catalogos que maneja el sistema")
@Entity
@Table(name = "catalogodetalle")
public class CatalogoDetalle {
    @EmbeddedId
    private CatalogoDetalleId id;

    @MapsId("idcatalogo")
    @ManyToOne()
    @Comment("Codigo de catalogo")
    @JoinColumn(name = "idcatalogo")
    @ToString.Exclude
    private Catalogo idcatalogo;

    @Comment("Nombre del catalogo")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("1 catalogo activo, 0 Inactivo")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean activo;

    @OneToMany(mappedBy = "catalogodetalle")
    private List<MascotaDetalle> mascotaDetalles;

    @OneToMany(mappedBy = "catalogodetalle")
    private List<Personadetalle> personadetalles;

}
