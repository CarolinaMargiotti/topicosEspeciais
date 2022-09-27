package com.carolinam.topicosespeciais.service;

import java.util.List;

import com.carolinam.topicosespeciais.entity.Glossario;

public interface IGlossarioService {
    public List<Glossario> buscarGlossarioPorTermoContem(String termo);

    public List<Glossario> buscarGlossarios();

    public Glossario buscarGlossarioPorTermo(String termo);
}
