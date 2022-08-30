package com.carolinam.topicosespeciais.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToMany;

@Entity // mapeia uma tabela
@Table(name = "aut_autorizacao") // nome da tabela diferente, então precisa uma forma de especificar
public class Autorizacao {

    @Column(name = "aut_id") // nome de coluna diferente, então precisa uma forma de especificar
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pega valor automatico
    private long id;

    @Column(name = "aut_nome")
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes",fetch = FetchType.LAZY) // foi mapeado ja na outra classe, nesse atributo
    @JsonIgnore //vai ignorar o atributo, impede o loop infinito das relações se chamando
    private Set<Usuario> usuarios;

    public Autorizacao(String nome) {
        this.nome = nome;
    }

    public Autorizacao() {
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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}