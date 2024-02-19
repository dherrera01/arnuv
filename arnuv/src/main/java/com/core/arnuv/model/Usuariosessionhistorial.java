package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Comment("Tabla que almacena sessiones de usuario, cuando este esta conectado a  la aplicacion")
@Entity
@Table(name = "usuariosessionhistorial")
public class Usuariosessionhistorial {
    @EmbeddedId
    private UsuariosessionhistorialId id;

    @Comment("Numero de intentos de login")
    @Column(name = "numerointentos")
    private Integer numerointentos;

    @Comment("ID de la session del browser o movil")
    @Column(name = "idsession", length = 70)
    private String idsession;

    @Comment("Fecha de inicio de la session")
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;

    @Comment("Fecha de cierre de la session")
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;

    @Comment("1 Indica que el usuario realizo un login a la aplicacion y mantien la aplicacion activa, 0 el usuario esta fuera de la aplicacion.")
    @Column(name = "activo", precision = 1)
    private BigDecimal activo;

    @Comment("I(usuario realiza login con exito), F(Intento fallido de login), L(Usuario relizo logout), S(Sistema realizo logout por inactividad)")
    @Column(name = "estado", length = 1)
    private String estado;

    @Comment("identificacion del dispositivo que ingresa el usuario")
    @Column(name = "useragent", length = 200)
    private String useragent;

    @Comment("Codigo de terminal publico o privado con la que sale la peticon del usuario, IPV4 y IPV6")
    @Column(name = "iptermialremoto", length = 130)
    private String iptermialremoto;

}
