//package br.com.abaloneapi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.abaloneapi.model.Pedido;
//import br.com.abaloneapi.repository.PedidoRepository;
//
//@RestController
//@RequestMapping(path="/api")
//public class PedidoController {
//
//	@Autowired
//	private PedidoRepository pedidoRepository;
//	
//    @PostMapping("/cadastrarPedido")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody(required=true) Pedido pedido) {
//    	System.out.print(pedido);
//    	try { 		
//    		return new ResponseEntity<>(pedidoRepository.save(pedido), HttpStatus.CREATED);
//    	} catch (Exception e) {
//    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    	}
//    }
//}
