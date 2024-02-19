package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import org.hibernate.annotations.Comment;
import lombok.Data;

@Data
public class ModuloResponse extends RespuestaComun<ModuloResponse.ModuloDto> {
    @Data
    public static class ModuloDto {
        @Comment("Codigo del modulo")
        private Integer id;

        @Comment("Nombre del modulo")
        private String nombre;

        @Comment("1 modulo activo, 0 Inactivo")
        private Boolean activo;
    }
}
