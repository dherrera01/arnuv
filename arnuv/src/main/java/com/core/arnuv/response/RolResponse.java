package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class RolResponse extends RespuestaComun<RolResponse.RolDto> {

	@Data
	public static class RolDto {
		@Comment("Codigo de rol")
		private Integer id;

		@Comment("Codigo de politica")
		private SeguridadPoliticaResponse.SeguridadPoliticaDto idpolitica;

		@Comment("Nombre del rol")
		private String nombre;

		@Comment("Campo para el menu y transaccion activos")
		private Boolean activo;
	}

}
