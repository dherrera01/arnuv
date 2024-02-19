package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.List;

@Data
public class LoginResponse extends RespuestaComun<LoginResponse.DataUserDto> {

	@Data
	public static class DataUserDto {
        @Comment("Codigo de usuario")
		private Integer idusuario;

		@Comment("Codigo de la persona")
		private Integer idpersona;

		@Comment("Nombre de usuarios")
		private String username;

		@Comment("Email")
		private String email;

		@Comment("Codigo de rol")
		private Integer idrol;

		@Comment("Nombre del rol")
		private String nrol;

	}

}
