package com.core.arnuv.response;

import org.hibernate.annotations.Comment;

import com.core.arnuv.utils.RespuestaComun;

import lombok.Data;

@Data
public class MascotaDetalleReponse extends RespuestaComun<MascotaDetalleReponse.MascotaDetalleDto> {

	@Data
	public static class MascotaDetalleDto {
		@Comment("Codigo de la mascota")
	    private Long id;
		
		@Comment("Nombre de la mascota")
	    private String nombre;

	    @Comment("Edad de la mascota")
	    private Integer edad;
	}
}