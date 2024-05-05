package br.com.fiap.GerenciamentoPedido.dto.cupom;

import br.com.fiap.GerenciamentoPedido.model.Cupom;

public record DetalhesCupomDto(Long id, String nomeCupom, Double desconto) {
    public DetalhesCupomDto(Cupom cupom){
        this(cupom.getId(), cupom.getNomeCupom(), cupom.getDesconto());
    }
}
