package com.core.arnuv.response;

import com.core.arnuv.utils.RespuestaComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class SeguridadPoliticaResponse extends RespuestaComun<SeguridadPoliticaResponse.SeguridadPoliticaDto> {

	@Data
	public static class SeguridadPoliticaDto {
		@Comment("Codigo de politica")
		private Integer id;

		@Comment("Longitud minima del password")
		private Integer longitud;

		@Comment("Numero de ingresos de password erroneo para bloquear al usuario")
		private Integer intentos;

		@Comment("Canridad minima de numeros que requiere el password")
		private Integer numeros;

		@Comment("Numero de caracteres minimos que requeiere el password")
		private Integer especiales;

		@Comment("Cantidad de letras en minusculas que requeire el password")
		private Integer minusculas;

		@Comment("Cantidad de letras en mayusculas que requiere el password")
		private Integer mayusculas;

		@Comment("Tiempo de Regeracion delToken en minutos")
		private Integer tiemporegeraciontoken;
	}

}
