package br.com.fiap.persistense.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/pedido")
    public String listaPedidos() {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/pedido/{id}")
    public String consultaPedido(@PathVariable("id") int id) {
        return pedidoService.consultaPedido(id);
    }

    @DeleteMapping("/pedido/{id}")
    private String deletaPedido(@PathVariable("id") int id) {
        return pedidoService.deletaPedido(id);
    }

    @PostMapping("/pedido")
    private String salvarPedido(@RequestBody Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    @PutMapping("/pedido")
    private String atualizaPedido(@RequestBody Pedido pedido) {
        return pedidoService.atualizaPedido(pedido);
    }
}
