package com.carolinam.topicosespeciais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolinam.topicosespeciais.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);

}