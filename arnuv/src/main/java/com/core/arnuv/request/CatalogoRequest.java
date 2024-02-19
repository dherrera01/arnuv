package com.core.arnuv.request;

import com.core.arnuv.model.Catalogo;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class CatalogoRequest extends RequestComun<Catalogo> {
    @Comment("Codigo de catalogo")
    private Integer id;

    @Comment("Nombre del catalogo")
    private String nombre;

    @Comment("1 catalogo activo, 0 Inactivo")
    private Boolean activo;
}
