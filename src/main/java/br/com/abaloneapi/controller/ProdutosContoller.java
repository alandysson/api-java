package br.com.abaloneapi.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
    	System.out.print("a");
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
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
	
//	@GetMapping("/produtos")
//	  public @ResponseBody Iterable<Produto> getAllUsers() {
//	    return produtoRepository.findAll();
//	}
//	
//	@PostMapping("/novo-produto")
//	public void salvarProduto(@RequestBody Produto produto, RedirectAttributes attr) {
//		try {
//			produtoRepository.save(produto);
//			attr.addFlashAttribute("message", "Sucesso ao salvar");
//		} catch(Exception e) {
//			attr.addFlashAttribute("message", "Erro ao salvar");			
//		}
//	}
}
