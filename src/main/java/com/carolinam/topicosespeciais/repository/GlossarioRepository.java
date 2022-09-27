package com.carolinam.topicosespeciais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolinam.topicosespeciais.entity.Glossario;

public interface GlossarioRepository extends JpaRepository<Glossario, Long> {

    public List<Glossario> findByTermoContains(String termo);

    public Glossario findByTermo(String termo);
}
