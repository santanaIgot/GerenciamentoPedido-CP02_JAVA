package br.com.fiap.GerenciamentoPedido.dto.usuario;

import br.com.fiap.GerenciamentoPedido.model.Usuario;

import java.time.LocalDate;
import java.util.Date;

public record DetalhesUsuarioDto(Long idUsuario,Long idDetalhesUsuario, String nome, String cpf,String email,
                                 String telefone, LocalDate dataNascimento ) {
    public DetalhesUsuarioDto(Usuario usuario){
        this(usuario.getIdUsuario(),
                usuario.getDetalhesUsuario().getIdDetalhesUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getDetalhesUsuario().getEmail(),
                usuario.getDetalhesUsuario().getTelefone(),
                usuario.getDetalhesUsuario().getDataNascimento());
    }
}
