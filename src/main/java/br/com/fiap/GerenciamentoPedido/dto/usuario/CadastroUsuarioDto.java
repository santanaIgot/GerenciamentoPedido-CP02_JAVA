package br.com.fiap.GerenciamentoPedido.dto.usuario;

import java.time.LocalDate;
import java.util.Date;

public record CadastroUsuarioDto(String nome, String cpf, String email,
                                 String telefone,LocalDate dataNascimento) {

}
