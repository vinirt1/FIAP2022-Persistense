package br.com.fiap.persistense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.model.PedidosPK;

public interface PedidoRepository extends JpaRepository<Pedido, PedidosPK> {

} 

//public interface PedidoRepository extends CrudRepositor<Pedido, Long> {
//
//}