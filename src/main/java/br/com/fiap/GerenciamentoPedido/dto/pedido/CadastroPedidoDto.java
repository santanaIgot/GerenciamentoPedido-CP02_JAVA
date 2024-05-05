package br.com.fiap.GerenciamentoPedido.dto.pedido;

import java.time.LocalDate;

public record CadastroPedidoDto(Double valorPedido, String nome,LocalDate dataPedido, String statusPedido, String descricao) {
}
