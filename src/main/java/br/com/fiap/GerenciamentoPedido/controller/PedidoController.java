package br.com.fiap.GerenciamentoPedido.controller;

import br.com.fiap.GerenciamentoPedido.dto.pedido.DetalhesPedidoDto;
import br.com.fiap.GerenciamentoPedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesPedidoDto>> listar(){
        var listaPedidos = pedidoRepository.findAll().stream().map(DetalhesPedidoDto::new).toList();
        return ResponseEntity.ok(listaPedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPedidoDto> pesquisarId(@PathVariable("id") Long id){
        var pedido = pedidoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPedidoDto(pedido));
    }

}
