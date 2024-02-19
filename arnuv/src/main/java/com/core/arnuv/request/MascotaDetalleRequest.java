package com.core.arnuv.request;

import lombok.Data;
import org.hibernate.annotations.Comment;

import com.core.arnuv.model.MascotaDetalle;
import com.core.arnuv.utils.RequestComun;

@Data
public class MascotaDetalleRequest extends RequestComun<MascotaDetalle> {
	@Comment("Codigo de la mascota")
    private Long id;
	
	@Comment("Nombre de la mascota")
    private String nombre;

    @Comment("Edad de la mascota")
    private Integer edad;
}
