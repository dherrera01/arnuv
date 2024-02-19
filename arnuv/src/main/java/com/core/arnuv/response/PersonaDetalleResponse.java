package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Data
public class PersonaDetalleResponse extends RespuestaComun<PersonaDetalleResponse.PersonaDetalleDto> {

	@Data
	public static class PersonaDetalleDto {
		@Comment("Codigo de personas")
		private Integer id;

		@Comment("Codigo de usuario de ingreso.")
		private String idusuarioing;

		@Comment("Codigo de usuario de modificacion")
		private String idusuariomod;

		@Comment("Fecha de ingreso del registro")
		@Temporal(TemporalType.DATE)
		private Date fechaingreso;

		@Comment("Fecha de modificacion del registro")
		@Temporal(TemporalType.DATE)
		private Date fechamodificacion;

		@Comment("Nombre de la persona")
		private String nombres;

		@Comment("Apellido de la persona")
		private String apellidos;

		@Comment("Codigo de catalogo")
    	private CatalogoDetalleResponse.CatalogoDetalleDto catalogodetalle;

		@Comment("Identificacion, cedula, ruc, pasaporte")
		private String identificacion;

		@Comment("Numero de celular")
		private String celular;

		@Comment("Correo electronico")
		private String email;

	}

}
