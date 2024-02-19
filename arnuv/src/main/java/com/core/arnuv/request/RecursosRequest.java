package com.core.arnuv.request;

import com.core.arnuv.model.Recurso;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class RecursosRequest extends RequestComun<Recurso> {
    @Comment("Codigo de recurso")
    private Integer idrecurso;

    @Comment("Codigo del modulo")
    private Integer idmodulo;

    @Comment("Nombre del recurso")
    private String nombre;

    @Comment("ruta de acceso de la aplicacion en flutter")
    private String ruta;
}
