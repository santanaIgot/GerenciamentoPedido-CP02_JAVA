package br.com.fiap.GerenciamentoPedido.repository;

import br.com.fiap.GerenciamentoPedido.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
