package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;

import java.io.Serializable;
import java.util.List;

@Data
@Comment("Tabla que almacena roles de usuario")
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Comment("Codigo de rol")
	@Column(name = "idrol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne()
	@Comment("Codigo de politica")
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "idpolitica")
	@ToString.Exclude
	private Seguridadpolitica idpolitica;

	@Comment("Nombre del rol")
	@Column(name = "nombre", length = 100)
	private String nombre;

	@Comment("Campo para el menu y transaccion activos")
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean activo;

	@OneToMany(mappedBy = "idrol")
	private List<Opcionespermiso> opcionespermisos;

	@OneToMany(mappedBy = "idrol")
	private List<Usuariorol> usuariorols;
}
