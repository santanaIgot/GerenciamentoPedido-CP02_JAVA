package br.com.fiap.GerenciamentoPedido.dto.usuario;

import br.com.fiap.GerenciamentoPedido.dto.cupom.DetalhesCupomDto;
import br.com.fiap.GerenciamentoPedido.model.Cupom;
import br.com.fiap.GerenciamentoPedido.model.Usuario;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record DetalhesUsuarioDto(Long idUsuario, Long idDetalhesUsuario, String nome, String cpf, String email,
                                 String telefone, LocalDate dataNascimento, List<DetalhesCupomDto> cupoms) {
    public DetalhesUsuarioDto(Usuario usuario){
        this(usuario.getIdUsuario(),
                usuario.getDetalhesUsuario().getIdDetalhesUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getDetalhesUsuario().getEmail(),
                usuario.getDetalhesUsuario().getTelefone(),
                usuario.getDetalhesUsuario().getDataNascimento(),
                usuario.getCupoms().stream().map(DetalhesCupomDto::new).toList());
    }
}
