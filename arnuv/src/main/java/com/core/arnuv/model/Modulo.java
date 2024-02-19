package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.type.NumericBooleanConverter;

import java.util.List;

@Data
@Comment("Tabla que almacena los recursos del sistema.")
@Entity
@Table(name = "modulos")
public class Modulo {
	@Id
    @Comment("Codigo del modulo")
    @Column(name = "idmodulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Comment("Nombre del modulo")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("1 modulo activo, 0 Inactivo")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean activo;

    @OneToMany(mappedBy = "idmodulo")
    private List<Recurso> recursos;

}
