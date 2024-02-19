package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UsuarioSessionResponse extends RespuestaComun<UsuarioSessionResponse.UsuarioSesionDto> {

	@Data
	public static class UsuarioSesionDto {

		@Comment("Codigo de usuario.")
		private Integer idusuario;

		@Comment("Codigo de usuario.")
		private UsuarioDetalleResponse.UsuarioDetalleDto usuariodetalle;

		@Comment("Numero de intentos de login")
		private Integer numerointentos;

		@Comment("ID de la session del browser o movil")
		private String idsession;

		@Comment("Fecha de inicio de la session")
		private Date fechainicio;

		@Comment("Fecha de cierre de la session")
		private Date fechasalida;

		@Comment("1 Indica que el usuario realizo un login a la aplicacion y mantien la aplicacion activa, 0 el usuario esta fuera de la aplicacion.")
		private Boolean activo;

		@Comment("I(usuario realiza login con exito), F(Intento fallido de login), L(Usuario relizo logout), S(Sistema realizo logout por inactividad)")
		private String estado;

		@Comment("identificacion del dispositivo que ingresa el usuario")
		private String useragent;

		@Comment("Codigo de terminal publico o privado con la que sale la peticon del usuario, IPV4 y IPV6")
		private String iptermialremoto;
	}

}
