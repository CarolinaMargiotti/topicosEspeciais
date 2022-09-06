package com.carolinam.topicosespeciais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolinam.topicosespeciais.entity.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // jparepository gera implementação, tem q
                                                                          // passar a classe q vai usar e o tipo da
                                                                          // variavel primaria
    public Usuario findByNome(String nome);

    public List<Usuario> findByNomeContains(String nome);

    public Usuario findByAutorizacoesNome(String autorizacao); // join
}
