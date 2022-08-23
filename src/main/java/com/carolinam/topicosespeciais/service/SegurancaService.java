package com.carolinam.topicosespeciais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinam.topicosespeciais.entity.Usuario;
import com.carolinam.topicosespeciais.repository.UsuarioRepository;

@Service
public class SegurancaService implements ISegurancaService {

    @Autowired // spring instancia a variavel, eu mesma n posso, só em constructor
    private UsuarioRepository usuarioRepo;

    @Override
    public Usuario NovoUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario NovoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario(nome, senha);
        return NovoUsuario(usuario);
    }

    @Override
    public List<Usuario> ListaUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario BuscarPorId(long id) {
        Optional<Usuario> usuario = usuarioRepo.findById(id);
        if(usuario.isPresent()){
            return usuario.get();
        } else {
            throw new RuntimeException( "Usuario não encontrado");
        }
    }

}
