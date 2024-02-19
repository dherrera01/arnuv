package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class CatalogoResponse extends RespuestaComun<CatalogoResponse.CatalogoDto> {

	@Data
	public static class CatalogoDto {
        @Comment("Codigo de catalogo")
		private Integer id;

		@Comment("Nombre del catalogo")
		private String nombre;

		@Comment("1 catalogo activo, 0 Inactivo")
		private Boolean activo;
	}

}
