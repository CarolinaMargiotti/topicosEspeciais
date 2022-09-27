package com.carolinam.topicosespeciais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinam.topicosespeciais.entity.Glossario;
import com.carolinam.topicosespeciais.repository.GlossarioRepository;

@Service
public class GlossarioService implements IGlossarioService {
    @Autowired
    private GlossarioRepository glossarioRepo;

    @Override
    public List<Glossario> buscarGlossarioPorTermoContem(String termo) {
        return glossarioRepo.findByTermoContains(termo);
    }

    @Override
    public List<Glossario> buscarGlossarios() {
        return glossarioRepo.findAll();
    }

    @Override
    public Glossario buscarGlossarioPorTermo(String termo) {
        return glossarioRepo.findByTermo(termo);
    }
}
