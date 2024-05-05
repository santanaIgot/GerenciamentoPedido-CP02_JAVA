package br.com.fiap.GerenciamentoPedido.dto.usuario;

import java.time.LocalDate;

public record AtualizacaoUsuarioDto(String nome, String cpf, String email,
                                    String telefone, LocalDate dataNascimento) {
}
