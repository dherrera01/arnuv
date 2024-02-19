package com.core.arnuv.request;

import com.core.arnuv.model.Rol;
import com.core.arnuv.model.Seguridadpolitica;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class RolRequest extends RequestComun<Rol> {
    @Comment("Codigo de catalogo")
    private Integer id;

    @Comment("Codigo de politica")
    private Seguridadpolitica idpolitica;

    @Comment("Nombre del catalogo")
    private String nombre;

    @Comment("1 catalogo activo, 0 Inactivo")
    private Boolean activo;
}
