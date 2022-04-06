package br.com.fiap.persistense.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.model.PedidosPK;
import br.com.fiap.persistense.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Cacheable(value= "allPedidoCache", unless= "#result.size() == 0")    
    public List<Pedido> listaPedidos() {
    		System.out.println("listaPedidos()");
    		List<Pedido> lista = new ArrayList<>();
    		pedidoRepository.findAll().forEach(e -> lista.add(e));
    		return lista;
//    	    return "Listando pedidos";
    }

	
	@Cacheable(value= "pedidoCache", key= "#id")	
    public Pedido consultaPedido(final Integer id) {
		PedidosPK pedidosPK = new PedidosPK();
		pedidosPK.setCodigo(id);
		pedidosPK.setProduto(3);
        // chamo aqui pedidoRepository
    	return pedidoRepository.findById(pedidosPK).get();
//        return "Consultando pedido de id: " + id;
    }

	
    public void deletaPedido(final Integer id) {
        // chamo aqui pedidoRepository
//        return "Deletando pedido de id: " + id;
    	System.out.println("deletaPedido()");		
		pedidoRepository.delete(pedidoRepository.findById(id).get());
		System.out.println("Deletou tudo!!!");
    }

    @Caching(
		put= { @CachePut(value= "pedidoCache", key= "#pedido.id") },
		evict= { @CacheEvict(value= "allPedidoCache", allEntries= true) }
	)
    public Pedido salvarPedido(Pedido pedido) {
    	return pedidoRepository.save(pedido);
        // chamo aqui pedidoRepository
//        return "Salvando pedido: " + pedido;
    }

    @Caching(
		put= { @CachePut(value= "pedidoCache", key= "#pedido.id") },
		evict= { @CacheEvict(value= "allPedidoCache", allEntries= true) }
	)
    public Pedido atualizaPedido(Pedido pedido) {
        // chamo aqui pedidoRepository
//        return "Atualizando pedido: " + pedido;
    	return pedidoRepository.save(pedido);
    }

}
