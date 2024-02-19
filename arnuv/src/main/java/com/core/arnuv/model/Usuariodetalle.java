package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Comment("Tabla que almacena detalle de informacion de un usuario")
@Entity
@Table(name = "usuariodetalle")
public class Usuariodetalle implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Comment("Codigo de usuario.")
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;

	@ManyToOne()
	@Comment("Codigo de personas")
	@JoinColumn(name = "idpersona")
	@ToString.Exclude
	private Personadetalle idpersona;

	@Comment("Codigo de usuario de ingreso.")
	@Column(name = "idusuarioing", length = 20)
	private String idusuarioing;

	@Comment("Codigo de usuario de modificacion")
	@Column(name = "idusuariomod", length = 20)
	private String idusuariomod;

	@Comment("Codigo de usuario de aprobacion.")
	@Column(name = "idusuarioaprobacion", length = 20)
	private String idusuarioaprobacion;

	@Comment("Fecha de ingreso del registro")
	@Column(name = "fechaingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	@Comment("Fecha de modificacion del registro")
	@Column(name = "fechamodificacion")
	@Temporal(TemporalType.DATE)
	private Date fechamodificacion;

	@Comment("Fecha de Aprobacion del registro")
	@Column(name = "fechaaprobacion")
	@Temporal(TemporalType.DATE)
	private Date fechaaprobacion;

	@Comment("1 catalogo activo, 0 Inactivo")
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean estado;

	@Comment("Nombre de usuario ")
	@Column(name = "username", length = 20, unique=true)
	private String username;

	@Comment("Password encriptado del usuario.")
	@Column(name = "password", length = 70)
	private String password;

	@Comment("1, Indica que el usuario tiene que cambiar de password")
	@Column(name = "cambiopassword", precision = 1)
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean cambiopassword;

	@Comment("Observacion del usuario, ejemplo cuando hay cambio de estado")
	@Column(name = "observacion", length = 100)
	private String observacion;

	@OneToMany(mappedBy = "idusuario", fetch = FetchType.EAGER)
	@ToString.Exclude
	private List<Usuariorol> usuariorols;

	@OneToOne(mappedBy = "usuariodetalle")
	@ToString.Exclude
	private Usuariosession usuariosession;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(usuariorols.get(0).getIdrol().getNombre()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
