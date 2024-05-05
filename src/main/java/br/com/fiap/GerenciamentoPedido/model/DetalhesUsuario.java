package br.com.fiap.GerenciamentoPedido.model;

import br.com.fiap.GerenciamentoPedido.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_DETALHES_USUARIO")
@EntityListeners(AuditingEntityListener.class)
public class DetalhesUsuario {
    @GeneratedValue
    @Id
    @Column(name = "cd_detalhes_usuario", nullable = false)
    private Long idDetalhesUsuario;

    @Column(name = "nm_telefone", nullable = false, length = 9)
    private String telefone;

    @Column(name = "email", nullable = false, length = 32)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "cd_usuario", nullable = false, unique = true)
    private Usuario usuario;

    public DetalhesUsuario(CadastroUsuarioDto dto) {

        telefone = dto.telefone();
        email = dto.email();
        dataNascimento = dto.dataNascimento();
    }
}
