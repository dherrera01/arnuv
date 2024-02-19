package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Comment("Tabla que almacena detalle de informacion de un usuario")
@Entity
@Table(name = "usuariodetallehistorial")
public class Usuariodetallehistorial {
    @EmbeddedId
    private UsuariodetallehistorialId id;

    @Comment("Codigo de personas")
    @Column(name = "idpersona")
    private Long idpersona;

    @Comment("Codigo de usuario de ingreso.")
    @Column(name = "idusuarioing", length = 20)
    private String idusuarioing;

    @Comment("Codigo de usuario de modificacion")
    @Column(name = "idusuariomod", length = 20)
    private String idusuariomod;

    @Comment("Codigo de usuario de aprobacion.")
    @Column(name = "idusuarioaprobacion", length = 20)
    private String idusuarioaprobacion;

    @Comment("Fecha de ingreso del registro")
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;

    @Comment("Fecha de modificacion del registro")
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;

    @Comment("Fecha de Aprobacion del registro")
    @Column(name = "fechaaprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaaprobacion;

    @Comment("1 Activo, 0 Inactivo")
    @Column(name = "estado", precision = 1)
    private BigDecimal estado;

    @Comment("Nombre de usuario ")
    @Column(name = "username", length = 20)
    private String username;

    @Comment("Password encriptado del usuario.")
    @Column(name = "password", length = 70)
    private String password;

    @Comment("1, Indica que el usuario tiene que cambiar de password")
    @Column(name = "cambiopassword", precision = 1)
    private BigDecimal cambiopassword;

    @Comment("Observacion del usuario, ejemplo cuando hay cambio de estado")
    @Column(name = "observacion", length = 100)
    private String observacion;

}
