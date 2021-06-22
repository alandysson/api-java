package br.com.abaloneapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.abaloneapi.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Optional<Produto> findByNome(String nome);
}
