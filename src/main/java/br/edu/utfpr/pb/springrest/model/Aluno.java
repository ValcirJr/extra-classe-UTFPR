package br.edu.utfpr.pb.springrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Aluno implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="nome", nullable=false)
	@NotNull(message="Ah pronto, o nome  é obrigatório")
	private String nome;
	
	@Column(name="ra", nullable=false, unique=true)
	@NotNull(message="Ah pronto, informe o RA")
	private String ra;
	
	@Column(name="email", nullable=false, unique=true)
	@Email(message="Ah pronto, Deve ser um email")
	private String email;
	
	@Column(name="telefone")
	@Pattern(regexp="^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", 
				message="Ah pronto, Telefone inválido")
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="curso_id", referencedColumnName="id")
	private Curso curso;
	
}
