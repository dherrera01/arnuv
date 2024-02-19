package com.core.arnuv.request;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class OpcionesPermisoRequest extends RequestComun<Opcionespermiso> {

    @Comment("Codigo de rol")
    private Integer idrol;

    @Comment("Codigo de opcion permiso")
    private Long idopcion;

    @Comment("Codigo de recurso")
    private Integer idrecurso;

    @Comment("Codigo del modulo")
    private Integer idmodulo;

    @Comment("Codigo de opcion permiso Padre para manejar en el menu")
    private Long idopcionpadre;

    @Comment("Nombre del item de menu")
    private String nombre;

    @Comment("1 Opcion permiso activo, 0 inactivo")
    private Boolean activo;

    @Comment("Muestra el menu")
    private Boolean mostar;

    @Comment("Permiso de crear")
    private Boolean crear;

    @Comment("Permiso de editar")
    private Boolean editar;

    @Comment("Permiso de eliminar")
    private Boolean eliminar;
}
