package br.com.abaloneapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.abaloneapi.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
