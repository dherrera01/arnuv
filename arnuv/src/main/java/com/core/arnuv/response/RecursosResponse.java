package com.core.arnuv.response;

import com.core.arnuv.model.RecursoId;
import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class RecursosResponse extends RespuestaComun<RecursosResponse.RecursosDto> {
    @Data
    public static class RecursosDto {

        private RecursoId id;

        @Comment("Codigo del modulo")
        private ModuloResponse.ModuloDto idmodulo;

        @Comment("Nombre del recurso")
        private String nombre;

        @Comment("ruta de acceso de la aplicacion en flutter")
        private String ruta;
    }

}
