package com.carolinam.topicosespeciais.service;

import java.util.List;

import com.carolinam.topicosespeciais.entity.Usuario;

public interface ISegurancaService {
    public Usuario NovoUsuario(Usuario usuario);

    public Usuario NovoUsuario(String nome, String senha);

    public List<Usuario> ListaUsuarios();

    public Usuario BuscarPorId(long id);
}
