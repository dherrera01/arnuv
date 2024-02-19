package com.core.arnuv.response;

import com.core.arnuv.model.OpcionespermisoId;
import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class OpcionesPermisoResponse extends RespuestaComun<OpcionesPermisoResponse.OpcionesPermisoDto> {
    @Data
    public static class OpcionesPermisoDto {

        private OpcionespermisoId id;

        @Comment("Codigo de rol")
        private RolResponse.RolDto idrol;

        @Comment("Codigo de recurso")
        private RecursosResponse.RecursosDto recursos;

        @Comment("Codigo de opcion permiso Padre para manejar en el menu")
        private Long idopcionpadre;

        @Comment("Nombre del item de menu")
        private String nombre;

        @Comment("1 Opcion permiso activo, 0 inactivo")
        private Boolean activo;

        @Comment("Muestra el menu")
        private Boolean mostar;

        @Comment("Permiso de crear")
        private Boolean crear;

        @Comment("Permiso de editar")
        private Boolean editar;

        @Comment("Permiso de eliminar")
        private Boolean eliminar;
    }

}
