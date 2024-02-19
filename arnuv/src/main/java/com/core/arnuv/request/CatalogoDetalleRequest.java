package com.core.arnuv.request;

import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.model.CatalogoDetalleId;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class CatalogoDetalleRequest extends RequestComun<CatalogoDetalle> {

    @Comment("Id compuesto de la entidad")
    private CatalogoDetalleId id;

    @Comment("Nombre del catalogo")
    private String nombre;

    @Comment("1 catalogo activo, 0 Inactivo")
    private Boolean activo;

}
