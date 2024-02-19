package com.core.arnuv.request;

import com.core.arnuv.model.Modulo;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class ModuloRequest extends RequestComun<Modulo> {
    @Comment("Codigo del modulo")
    private Integer id;

    @Comment("Nombre del modulo")
    private String nombre;

    @Comment("1 modulo activo, 0 Inactivo")
    private Boolean activo;
}
