package br.com.fiap.GerenciamentoPedido.model;


import br.com.fiap.GerenciamentoPedido.dto.usuario.AtualizacaoUsuarioDto;
import br.com.fiap.GerenciamentoPedido.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    @GeneratedValue
    @Id
    @Column(name = "cd_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "cpf_usuario", nullable = false, length = 11)
    private String cpf;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private DetalhesUsuario detalhesUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<Pedido> pedidos = new ArrayList<>() ;

    @ManyToMany
    @JoinTable(name = "TB_CUPOM", joinColumns = @JoinColumn(name = "cd_usuario"))
    private Set<Cupom> cupom = new HashSet<>();

    public Usuario (CadastroUsuarioDto dto){
        nome = dto.nome();
        cpf = dto.cpf();
        detalhesUsuario = new DetalhesUsuario(dto);
        detalhesUsuario.setUsuario(this);
        pedidos = new ArrayList<>();
    }

    public void atualizaDados(AtualizacaoUsuarioDto dto){
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.cpf() != null)
            cpf = dto.cpf();
        if(dto.email() != null)
            this.detalhesUsuario.setEmail(dto.email());
        if(dto.dataNascimento() != null)
            this.detalhesUsuario.setDataNascimento(dto.dataNascimento());
        if(dto.telefone() != null)
            this.detalhesUsuario.setTelefone(dto.telefone());

    }


    public void adicionar(Pedido pedido){
        pedidos.add(pedido);
        pedido.setUsuario(this);
    }

}
