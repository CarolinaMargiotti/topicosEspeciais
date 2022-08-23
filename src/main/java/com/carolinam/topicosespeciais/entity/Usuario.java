package com.carolinam.topicosespeciais.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity // mapeia uma tabela
@Table(name = "usr_usuario") // nome da tabela diferente, então precisa uma forma de especificar
public class Usuario {

    @Column(name = "usr_id") // nome de usuario diferente, então precisa uma forma de especificar
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pega valor automatico
    private long id;

    @Column(name = "usr_nome")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    public Usuario( String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
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

}
