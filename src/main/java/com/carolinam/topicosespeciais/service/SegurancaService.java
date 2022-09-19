package com.carolinam.topicosespeciais.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;

import com.carolinam.topicosespeciais.entity.Autorizacao;
import com.carolinam.topicosespeciais.entity.Usuario;
import com.carolinam.topicosespeciais.exception.RegistroNaoEncontradoException;
import com.carolinam.topicosespeciais.repository.UsuarioRepository;
import com.carolinam.topicosespeciais.repository.AutorizacaoRepository;

@Service
public class SegurancaService implements ISegurancaService {

    @Autowired // spring instancia a variavel, eu mesma n posso, só em constructor
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')") //no banco é ROLE_ADMIN
    public Usuario NovoUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario NovoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario(nome, senha);
        return NovoUsuario(usuario);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Usuario> ListaUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario BuscarPorId(long id) {
        Optional<Usuario> usuario = usuarioRepo.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
                .authorities(usuario.getAutorizacoes().stream()
                        .map(Autorizacao::getNome).collect(Collectors.toList())
                        .toArray(new String[usuario.getAutorizacoes().size()])) // transforma em vetor
                .build();
    }

    @Override
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
        Autorizacao autorizacao = autRepo.findByNome(nome);
        if (autorizacao != null) {
            return autorizacao;
        }
        throw new RegistroNaoEncontradoException("Autorização não encontrada!");
    }

}
