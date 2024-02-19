package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Comment("Tabla que almacena detalle de informacion de una persona")
@Entity
@Table(name = "personadetalle")
public class Personadetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Comment("Codigo de personas")
	@Column(name = "idpersona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Comment("Codigo de usuario de ingreso.")
	@Column(name = "idusuarioing", length = 20)
	private String idusuarioing;

	@Comment("Codigo de usuario de modificacion")
	@Column(name = "idusuariomod", length = 20)
	private String idusuariomod;

	@Comment("Fecha de ingreso del registro")
	@Column(name = "fechaingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	@Comment("Fecha de modificacion del registro")
	@Column(name = "fechamodificacion")
	@Temporal(TemporalType.DATE)
	private Date fechamodificacion;

	@Comment("Nombre de la persona")
	@Column(name = "nombres", length = 120)
	private String nombres;

	@Comment("Apellido de la persona")
	@Column(name = "apellidos", length = 120)
	private String apellidos;

	@ManyToOne()
	@JoinColumns({ @JoinColumn(name = "idcatalogoidentificacion", referencedColumnName = "iddetalle"),
			@JoinColumn(name = "iddetalleidentificacion", referencedColumnName = "idcatalogo") })
	@Comment("Codigo de catalogo")
	@ToString.Exclude
	private CatalogoDetalle catalogodetalle;

	@Comment("Identificacion, cedula, ruc, pasaporte")
	@Column(name = "identificacion", length = 15, unique=true)
	private String identificacion;

	@Comment("Numero de celular")
	@Column(name = "celular", length = 20, unique=true)
	private String celular;

	@Comment("Correo electronico")
	@Column(name = "email", length = 150, unique=true)
	private String email;

	@OneToMany(mappedBy = "idpersona")
	private List<MascotaDetalle> mascotaDetalles;

	@OneToMany(mappedBy = "idpersonapasedor")
	private List<Paseo> paseospaseador;

	@OneToMany(mappedBy = "idpersonacliente")
	private List<Paseo> paseoscliente;

	@OneToMany(mappedBy = "idpersona")
	private List<Personadireccion> personadireccions;

	@OneToMany(mappedBy = "idpersona")
	private List<Usuariodetalle> usuariodetalles;

}
