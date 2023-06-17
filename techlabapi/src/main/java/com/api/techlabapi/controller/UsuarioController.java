package com.api.techlabapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.api.techlabapi.dto.UsuarioDTO;
import com.api.techlabapi.model.Agenda;
import com.api.techlabapi.model.Usuario;
import com.api.techlabapi.repository.AgendaRepository;
import com.api.techlabapi.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final AgendaRepository agendaRepository;

        
    @Autowired
    public UsuarioController(UsuarioService usuarioService, AgendaRepository agendaRepository) {
        this.usuarioService = usuarioService;
        this.agendaRepository = agendaRepository;
    }

    @PostMapping("/agendamentos")
    public ResponseEntity<Agenda> criarAgendamento(@RequestBody Agenda agenda) {
        Agenda novoAgendamento = agendaRepository.save(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }
    
    
        
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setSenha(usuarioDTO.getSenha());

        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> fazerLogin(@RequestBody UsuarioDTO loginDTO) {
        String matricula = loginDTO.getMatricula();
        String senha = loginDTO.getSenha();

        try {
            // Chama o serviço para autenticar o usuário
            Usuario usuarioAutenticado = usuarioService.buscarUsuarioPorMatriculaESenha(matricula, senha);

            if (usuarioAutenticado != null) {
                // Retorna uma mensagem de sucesso
                return ResponseEntity.ok("Login realizado com sucesso");
            } else {
                // Retorna uma mensagem de erro caso as credenciais sejam inválidas
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
            }
        } catch (RuntimeException e) {
            // Retorna uma mensagem de erro caso ocorra uma exceção
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no servidor");
        }
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody @Validated UsuarioDTO usuarioDTO
    ) {
        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setNome(usuarioDTO.getNome());
        usuarioAtualizado.setEmail(usuarioDTO.getEmail());
        usuarioAtualizado.setMatricula(usuarioDTO.getMatricula());
        usuarioAtualizado.setSenha(usuarioDTO.getSenha());

        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}