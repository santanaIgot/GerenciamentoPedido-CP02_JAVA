package br.com.fiap.GerenciamentoPedido.repository;

import br.com.fiap.GerenciamentoPedido.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
