package com.carolinam.topicosespeciais.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.Column;

@Entity // mapeia uma tabela
@Table(name = "usr_usuario") // nome da tabela diferente, então precisa uma forma de especificar
public class Usuario {
    @Column(name = "usr_id") // nome de coluna diferente, então precisa uma forma de especificar
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pega valor automatico
    private long id;

    @Column(name = "usr_nome")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY) // relacionamento
    @JoinTable(name = "uau_usuario_autorizacao", joinColumns = { @JoinColumn(name = "usr_id") }, inverseJoinColumns = {
            @JoinColumn(name = "aut_id") }) // não pode ter do outro lado
    private Set<Autorizacao> autorizacoes;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

}
