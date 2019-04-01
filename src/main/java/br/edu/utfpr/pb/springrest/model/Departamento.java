package br.edu.utfpr.pb.springrest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Departamento implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descricao", nullable = false, length=254 )
	@NotNull(message="Ah pronto, A descrição é obrigatória meu querido.")
	private String descricao;
	
	@Column(name="silga", nullable=false, length=254, unique=true)
	@NotNull(message="Ah pronto, a sigla deve ser informada!")
	private String sigla;
	
	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL,
			orphanRemoval=true)
	private List<ProfessorTA> professores;
	
	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL,
			orphanRemoval=true)
	private List<Curso> cursos;

}
