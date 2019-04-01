package br.edu.utfpr.pb.springrest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descricao", nullable = false, length=254 )
	@NotNull(message="Ah pronto, A descrição é obrigatória meu querido.")
	private String descricao;
	
	@Column(name="silga", nullable=false, length=254, unique=true)
	@NotNull(message="Ah pronto, a sigla deve ser informada!")
	private String sigla;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id", referencedColumnName = "id")
	private Departamento departamento;
	
	@OneToMany(mappedBy="curso", cascade=CascadeType.ALL,
			orphanRemoval=true)
	private List<Aluno> alunos;

}
