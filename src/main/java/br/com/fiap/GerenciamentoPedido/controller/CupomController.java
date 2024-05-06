package br.com.fiap.GerenciamentoPedido.controller;

import br.com.fiap.GerenciamentoPedido.dto.cupom.CadastroCupomDto;
import br.com.fiap.GerenciamentoPedido.dto.cupom.DetalhesCupomDto;
import br.com.fiap.GerenciamentoPedido.model.Cupom;
import br.com.fiap.GerenciamentoPedido.model.Usuario;
import br.com.fiap.GerenciamentoPedido.repository.CupomRepository;
import br.com.fiap.GerenciamentoPedido.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cupom")
public class CupomController {
    @Autowired
    private CupomRepository cupomRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCupomDto> post(@RequestBody @Valid CadastroCupomDto dto,

                                                 UriComponentsBuilder uriBuilder){

        var cupom = new Cupom(dto);
        cupomRepository.save(cupom);
        var uri = uriBuilder.path("cupom/{id}").buildAndExpand(cupom.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesCupomDto(cupom));
    }

}
