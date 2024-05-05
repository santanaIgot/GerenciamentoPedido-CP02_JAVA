package br.com.fiap.GerenciamentoPedido.repository;

import br.com.fiap.GerenciamentoPedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
