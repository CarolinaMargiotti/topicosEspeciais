package com.carolinam.topicosespeciais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.carolinam.topicosespeciais.entity.Usuario;
import com.carolinam.topicosespeciais.service.ISegurancaService;

@RestController
@CrossOrigin // para poder acessar de fora
@RequestMapping(value = "/usuario") // mudar a url do request
public class usuarioController {

    @Autowired
    private ISegurancaService segurancaService; // declara sempre a interface

    // GET 8080-carolinamar-topicosespe-vvyd2gjo61c.ws-us63.gitpod.io/usuario
    @GetMapping
    public List<Usuario> buscarTodos() {
        return segurancaService.ListaUsuarios(); // spring sempre retorna json por padrão
    }

    //GET
    // 8080-carolinamar-topicosespe-vvyd2gjo61c.ws-us63.gitpod.io/usuario/buscarPorId/3
    @GetMapping(value = "/buscarPorId/{id}")
    public Usuario buscarPorID(@PathVariable long id) {
        return segurancaService.BuscarPorId(id);
    }

    // POST
    // 8080-carolinamar-topicosespe-vvyd2gjo61c.ws-us63.gitpod.io/usuario/cadastrar
    @PostMapping(value = "/cadastrar") // url especifica da função
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) { // vai vir do body as infos do post
        return segurancaService.NovoUsuario(usuario);
    }
}
