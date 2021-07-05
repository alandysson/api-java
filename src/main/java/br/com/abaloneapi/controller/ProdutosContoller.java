package br.com.abaloneapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.abaloneapi.model.Produto;
import br.com.abaloneapi.repository.ProdutoRepository;

@RestController
@RequestMapping(path="/api")
public class ProdutosContoller {

	@Autowired
	private ProdutoRepository produtoRepository;
	
    @PostMapping("/cadastrar")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Produto> cadastrar(@RequestBody(required=true) Produto produto) {
    	try { 		
    		return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
    	} catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscar(@RequestParam(required=false) String nome) {
    		try {
    			List<Produto> produto = new ArrayList<Produto>();
    			if(nome == null) {
    				produtoRepository.findAll().forEach(produto::add);
    			} else {
    				produtoRepository.findByNome(nome);
    			}
    			
    			if(produto.isEmpty()) {
    				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    			}
    			
    			return new ResponseEntity<>(produto, (HttpStatus.OK));
    		} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id){
		Optional<Produto> produtoDados = produtoRepository.findById(id);
		
		if(produtoDados.isPresent()) {
			return new ResponseEntity<>(produtoDados.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
	@PutMapping("/alterar/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Produto> updateLivros(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
		Optional<Produto> produtoDados = produtoRepository.findById(id);
		
		if(produtoDados.isPresent()) {
			Produto pr = produtoDados.get();
			pr.setNome(produtoAtualizado.getNome());
			pr.setCategoria(produtoAtualizado.getCategoria());
			pr.setValor(produtoAtualizado.getValor());
			pr.setQtd(produtoAtualizado.getQtd());
			
			produtoRepository.save(pr);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("excluir/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<HttpStatus> deletarLivro(@PathVariable("id") Long id){
		try {
			produtoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
