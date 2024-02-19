package com.core.arnuv.response;

import com.core.arnuv.model.UsuariorolId;
import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.Date;

public class UsuarioRolResponse extends RespuestaComun<UsuarioRolResponse.UsuarioRolDto> {

    @Data
    public static class UsuarioRolDto {

        private UsuariorolId id;

        @Comment("Codigo de rol")
        private RolResponse.RolDto idrol;

        @Comment("Codigo de usuario.")
        private UsuarioDetalleResponse.UsuarioDetalleDto idusuario;

        @Comment("Codigo de usuario de ingreso.")
        private String idususarioing;

        @Comment("Codigo de usuario de modificacion")
        private String idususariomod;

        @Comment("Fecha de ingreso del registro")
        private Date fechaingreso;

        @Comment("Fecha de modificacion del registro")
        private Date fechamodificacion;
    }

}
