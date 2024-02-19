package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.type.NumericBooleanConverter;

import java.io.Serializable;
import java.util.List;

@Data
@Comment("Tabla que almacena los catalogos que maneja el sistema")
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Comment("Codigo de catalogo")
	@Column(name = "idcatalogo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Comment("Nombre del catalogo")
	@Column(name = "nombre", length = 100)
	private String nombre;

	@Comment("1 catalogo activo, 0 Inactivo")
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean activo;

	@OneToMany(mappedBy = "idcatalogo")
	private List<CatalogoDetalle> catalogodetalles;

}
