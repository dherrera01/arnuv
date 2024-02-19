package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Comment("Tabla que almacena los roles asociados a un usuario")
@Entity
@Table(name = "usuariorol")
public class Usuariorol {
    @EmbeddedId
    private UsuariorolId id;

    @MapsId("idrol")
    @ManyToOne()
    @Comment("Codigo de rol")
    @JoinColumn(name = "idrol")
    @ToString.Exclude
    private Rol idrol;

    @MapsId("idusuario")
    @ManyToOne()
    @Comment("Codigo de usuario.")
    @JoinColumn(name = "idusuario")
    @ToString.Exclude
    private Usuariodetalle idusuario;

    @Comment("Codigo de usuario de ingreso.")
    @Column(name = "idususarioing", length = 20)
    private String idususarioing;

    @Comment("Codigo de usuario de modificacion")
    @Column(name = "idususariomod", length = 20)
    private String idususariomod;

    @Comment("Fecha de ingreso del registro")
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;

    @Comment("Fecha de modificacion del registro")
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;

}
