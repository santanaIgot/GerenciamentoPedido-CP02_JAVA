package br.com.fiap.GerenciamentoPedido.controller;

import br.com.fiap.GerenciamentoPedido.dto.pedido.CadastroPedidoDto;
import br.com.fiap.GerenciamentoPedido.dto.pedido.DetalhesPedidoDto;
import br.com.fiap.GerenciamentoPedido.dto.usuario.AtualizacaoUsuarioDto;
import br.com.fiap.GerenciamentoPedido.dto.usuario.CadastroUsuarioDto;
import br.com.fiap.GerenciamentoPedido.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.GerenciamentoPedido.model.Pedido;
import br.com.fiap.GerenciamentoPedido.model.Usuario;
import br.com.fiap.GerenciamentoPedido.repository.PedidoRepository;
import br.com.fiap.GerenciamentoPedido.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;
import java.util.List;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        var url = uriBuilder.path("/usuario").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuarioDto(usuario));
    }


    @GetMapping
    public ResponseEntity<List<DetalhesUsuarioDto>> get(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable).stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(lista);
    }


    //get listar
    public ResponseEntity<List<DetalhesUsuarioDto>> listar(){
        var listaUsuario = usuarioRepository.findAll().stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(listaUsuario);
    }

    //pesquisa por id
    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> pesquisar(@PathVariable("id") Long idUsuario){
        var usuario = usuarioRepository.getReferenceById(idUsuario);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> put (@PathVariable("id") Long idUsuario,
                                                   @RequestBody AtualizacaoUsuarioDto dto){
        var usuario = usuarioRepository.getReferenceById(idUsuario);
        usuario.atualizaDados(dto);

        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("id") Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
        return ResponseEntity.noContent().build();
    }

    //post do pedido
    @PostMapping("{id}/pedido")
    @Transactional
    public ResponseEntity<DetalhesPedidoDto> post(@PathVariable("id")Long idUsuario,
                                                  @RequestBody @Valid CadastroPedidoDto dto,
                                                  UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(idUsuario);
        var pedido = new Pedido(dto,usuario);
        usuario.adicionar(pedido);
        var uri = uriBuilder.path("pedido/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesPedidoDto(pedido));
    }




}
