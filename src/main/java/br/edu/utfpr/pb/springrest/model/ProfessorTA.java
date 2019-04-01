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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_professorTA")
@Data
@NoArgsConstructor	
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class ProfessorTA implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable=false)
	@NotNull(message="Ah pronto, o nome  é obrigatório")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id", referencedColumnName = "id")
	private Departamento departamento;
	
	@Column(name="email")
	@Email(message="Ah pronto, Deve ser um email")
	private String email;
	
	
	
}
