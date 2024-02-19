package com.core.arnuv.request;

import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.model.UsuariorolId;
import com.core.arnuv.response.RolResponse;
import com.core.arnuv.response.UsuarioDetalleResponse;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Data
public class UsuarioRolRequest extends RequestComun<Usuariorol> {

    @Comment("Codigo de rol")
    private Integer idrol;

    @Comment("Codigo de usuario.")
    private Integer idusuario;

    @Comment("Codigo de usuario de ingreso.")
    private String idususarioing;

    @Comment("Codigo de usuario de modificacion")
    private String idususariomod;

    @Comment("Fecha de ingreso del registro")
    private Date fechaingreso;

    @Comment("Fecha de modificacion del registro")
    private Date fechamodificacion;

}
