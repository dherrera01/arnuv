package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.type.NumericBooleanConverter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Comment("Tabla que almacena las tarifas basicas del paseo")
@Entity
@Table(name = "tarifario")
public class Tarifario {
	@Id
    @Comment("Codigo de tarifas")
    @Column(name = "idtarifario")
    private Long id;

    @Comment("Nombre del tarifario")
    @Column(name = "nombre", length = 120)
    private String nombre;

    @Comment("tiempo del paseo maximo en minutos")
    @Column(name = "tiempo", precision = 10)
    private BigDecimal tiempo;

    @Comment("precio de la tarifa")
    @Column(name = "precio", precision = 10, scale = 7)
    private BigDecimal precio;

    @Comment("1 tarifa activa, 0 inactiva")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean activo;

    @OneToMany(mappedBy = "idtarifario")
    private List<Paseo> paseos;

}
