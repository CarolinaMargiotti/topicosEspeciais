package com.carolinam.topicosespeciais.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.carolinam.topicosespeciais.entity.Autorizacao;
import com.carolinam.topicosespeciais.entity.Usuario;

public interface ISegurancaService extends UserDetailsService {
    public Usuario NovoUsuario(Usuario usuario);

    public Usuario NovoUsuario(String nome, String senha);

    public Usuario NovoUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> ListaUsuarios();

    public Usuario BuscarPorId(long id);

    public Autorizacao buscarAutorizacaoPorNome(String nome);
}
