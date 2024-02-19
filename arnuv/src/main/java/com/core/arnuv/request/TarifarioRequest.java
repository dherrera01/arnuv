package com.core.arnuv.request;

import com.core.arnuv.model.Tarifario;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Data
public class TarifarioRequest extends RequestComun<Tarifario> {
    @Comment("Codigo de tarifas")
    private Long id;
    @Comment("Nombre del tarifario")
    private String nombre;
    @Comment("tiempo del paseo maximo en minutos")
    private BigDecimal tiempo;
    @Comment("precio de la tarifa")
    private BigDecimal precio;
    @Comment("1 tarifa activa, 0 inactiva")
    private Boolean activo;
}
