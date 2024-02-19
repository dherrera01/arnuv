package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Data
public class TarifarioResponse extends RespuestaComun<TarifarioResponse.TarifarioDto> {
    @Data
    public static class TarifarioDto {
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
}
