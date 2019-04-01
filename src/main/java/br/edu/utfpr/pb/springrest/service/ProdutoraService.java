package br.edu.utfpr.pb.springrest.service;

import java.util.List;

import br.edu.utfpr.pb.springrest.model.Produtora;

public interface ProdutoraService 
		extends CrudService<Produtora, Long>{

	
	List<Produtora> findByNomeLike(String nome);
}



