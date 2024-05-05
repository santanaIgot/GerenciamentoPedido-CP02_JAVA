package br.com.fiap.GerenciamentoPedido.model;

import br.com.fiap.GerenciamentoPedido.dto.cupom.CadastrarCupomDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_CUPOM")
public class Cupom {
    @GeneratedValue
    @Id
    @Column(name = "cd_cupom", nullable = false)
    private Long id;

    @Column(name = "nm_cupom", nullable = false, length = 32)
    private String nomeCupom;

    @Column(name = "dc_cupom", nullable = false)
    private Double desconto;



    @ManyToMany(mappedBy = "cupom")
    private List <Usuario> usuario;

    public Cupom(CadastrarCupomDto dto){
        nomeCupom = dto.nomeCupom();
        desconto = dto.desconto();

    }


}
