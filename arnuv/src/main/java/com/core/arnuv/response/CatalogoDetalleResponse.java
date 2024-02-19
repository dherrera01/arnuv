package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class CatalogoDetalleResponse extends RespuestaComun<CatalogoDetalleResponse.CatalogoDetalleDto> {

	@Data
	public static class CatalogoDetalleDto {
		@Comment("Codigo de catalogo")
		private CatalogoDetalleId id;

		@Comment("Nombre del catalogo")
		private String nombre;

		@Comment("1 catalogo activo, 0 Inactivo")
		private Boolean activo;
	}

	@Data
	private static class CatalogoDetalleId {
        @Comment("Codigo de catalogo")
        private Integer idcatalogo;

        @Comment("Codigo de catalogo detalle")
        private String iddetalle;

    }

}
