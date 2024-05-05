package br.com.fiap.GerenciamentoPedido.dto.pedido;

import br.com.fiap.GerenciamentoPedido.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.GerenciamentoPedido.model.Pedido;

import java.time.LocalDate;

public record DetalhesPedidoDto(Long id, Double valorPedido, String nome, LocalDate dataPedido, String statusPedido, String descricao,
                                DetalhesUsuarioDto detalhesUsuario) {
    public DetalhesPedidoDto(Pedido pedido){
        this (pedido.getId(), pedido.getValorPedido(), pedido.getNome(), pedido.getDataPedido(),pedido.getStatusPedido(),
                pedido.getDescricao(), new DetalhesUsuarioDto(pedido.getUsuario()));
    }


}
