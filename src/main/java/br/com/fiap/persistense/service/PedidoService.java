package br.com.fiap.persistense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.repository.PedidoRepository;

@Service
public class PedidoService {

    // @Autowired
    PedidoRepository pedidoRepository;

    public String listaPedidos() {
        // chamo aqui pedidoRepository
        return "Listando pedidos";
    }

    public String consultaPedido(final int id) {
        // chamo aqui pedidoRepository
        return "Consultando pedido de id: " + id;
    }

    public String deletaPedido(final int id) {
        // chamo aqui pedidoRepository
        return "Deletando pedido de id: " + id;
    }

    public String salvarPedido(Pedido pedido) {
        // chamo aqui pedidoRepository
        return "Salvando pedido: " + pedido;
    }

    public String atualizaPedido(Pedido pedido) {
        // chamo aqui pedidoRepository
        return "Atualizando pedido: " + pedido;
    }

}
