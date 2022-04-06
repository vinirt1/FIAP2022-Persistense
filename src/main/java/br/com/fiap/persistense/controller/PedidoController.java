package br.com.fiap.persistense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.persistense.model.Pedido;
import br.com.fiap.persistense.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listaPedidos() {
        return (ResponseEntity<List<Pedido>>) pedidoService.listaPedidos();
    }

    @GetMapping("/pedidos/{id}")
    public Pedido consultaPedido(@PathVariable("id") int id) {
        return pedidoService.consultaPedido(id);
    }

    @DeleteMapping("/pedidos/{id}")
    private String deletaPedido(@PathVariable("id") int id) {
    	pedidoService.deletaPedido(id);
        return "Dados apagados";
    }

    @PostMapping("/pedidos")
    private Pedido salvarPedido(@RequestBody Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    @PutMapping("/pedidos")
    private Pedido atualizaPedido(@RequestBody Pedido pedido) {
        return pedidoService.atualizaPedido(pedido);
    }
}
