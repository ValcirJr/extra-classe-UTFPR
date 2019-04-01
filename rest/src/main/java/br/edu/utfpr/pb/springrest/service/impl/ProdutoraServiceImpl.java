package br.edu.utfpr.pb.springrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.pb.springrest.model.Produtora;
import br.edu.utfpr.pb.springrest.repository.ProdutoraRepository;
import br.edu.utfpr.pb.springrest.service.ProdutoraService;

@Service
public class ProdutoraServiceImpl 
			extends CrudServiceImpl<Produtora, Long>
			implements ProdutoraService{

	@Autowired
	private ProdutoraRepository produtoraRepository;
	
	@Override
	protected JpaRepository<Produtora, Long> getRepository() {
		return produtoraRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produtora> findByNomeLike(String nome) {
		
		return produtoraRepository
				.findByNomeLike(nome);
	}
	
	
}
