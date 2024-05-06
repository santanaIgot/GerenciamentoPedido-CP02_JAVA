package br.com.fiap.GerenciamentoPedido.model;

import br.com.fiap.GerenciamentoPedido.dto.cupom.CadastroCupomDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter@Setter
@NoArgsConstructor


@Entity
@Table(name = "TB_CUPOM")
public class Cupom {

    @Id
    @GeneratedValue
    @Column(name = "cd_cupom")
    private Long id;

    @Column(name = "nm_cupom", nullable = false)
    private String nomeCupom;

    @Column(name = "dc_cupom", nullable = false)
    private Double desconto;


    @ManyToMany(mappedBy = "cupoms" )
    private List<Usuario> usuarios;


    public Cupom(CadastroCupomDto dto){
        nomeCupom = dto.nomeCupom();
        desconto = dto.desconto();


    }



}
