package br.edu.utfpr.pb.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.springrest.model.Produtora;

public interface ProdutoraRepository 
				extends JpaRepository<Produtora, Long>{

	List<Produtora> findByNomeLike(String nome);
}
