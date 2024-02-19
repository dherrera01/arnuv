package com.core.arnuv.request;

import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Data
public class UsuarioDetalleRequest extends RequestComun<Usuariodetalle> {

    @Comment("Codigo de usuario.")
    private Integer idusuario;

    @Comment("Codigo de personas")
    private Integer idpersona;

    @Comment("Codigo de usuario de ingreso.")
    private String idusuarioing;

    @Comment("Codigo de usuario de modificacion")
    private String idusuariomod;

    @Comment("Codigo de usuario de aprobacion.")
    private String idusuarioaprobacion;

    @Comment("Fecha de ingreso del registro")
    private Date fechaingreso;

    @Comment("Fecha de modificacion del registro")
    private Date fechamodificacion;

    @Comment("Fecha de Aprobacion del registro")
    private Date fechaaprobacion;

    @Comment("1 catalogo activo, 0 Inactivo")
    private Boolean estado;

    @Comment("Nombre de usuario ")
    private String username;

    @Comment("Password encriptado del usuario.")
    private String password;

    @Comment("1, Indica que el usuario tiene que cambiar de password")
    private Boolean cambiopassword;

    @Comment("Observacion del usuario, ejemplo cuando hay cambio de estado")
    private String observacion;

}
