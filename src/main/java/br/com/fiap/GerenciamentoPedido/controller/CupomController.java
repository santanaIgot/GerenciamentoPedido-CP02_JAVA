package br.com.fiap.GerenciamentoPedido.controller;

import br.com.fiap.GerenciamentoPedido.dto.cupom.CadastrarCupomDto;
import br.com.fiap.GerenciamentoPedido.dto.cupom.DetalhesCupomDto;
import br.com.fiap.GerenciamentoPedido.model.Cupom;
import br.com.fiap.GerenciamentoPedido.repository.CupomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cupom")
public class CupomController {
    @Autowired
    CupomRepository cupomRepository;

    public ResponseEntity<DetalhesCupomDto> post(@RequestBody @Valid CadastrarCupomDto dto, UriComponentsBuilder
                                                 uriBuilder){
        var cupom = new Cupom(dto);
        cupomRepository.save(cupom);
        var uri = uriBuilder.path("cupom/{id}").buildAndExpand(cupom.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesCupomDto(cupom));
    }
}
