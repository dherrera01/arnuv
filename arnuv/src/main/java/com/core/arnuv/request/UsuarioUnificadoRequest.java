package com.core.arnuv.request;

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.utils.RequestComun;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Data
public class UsuarioUnificadoRequest {

    @Comment("Nombre de la persona")
    private String nombres;

    @Comment("Apellido de la persona")
    private String apellidos;

    @Comment("Codigo de catalogo")
    private Integer idcatalogoidentificacion;

    @Comment("Codigo de catalogo detalle")
    private String iddetalleidentificacion;

    @Comment("Identificacion, cedula, ruc, pasaporte")
    private String identificacion;

    @Comment("Numero de celular")
    private String celular;

    @Comment("Correo electronico")
    private String email;

    @Comment("Nombre de usuario ")
    private String username;

    @Comment("Password encriptado del usuario.")
    private String password;

    @Comment("Codigo de rol")
    private Integer idrol;


}
