package com.carolinam.topicosespeciais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolinam.topicosespeciais.entity.Glossario;
import com.carolinam.topicosespeciais.service.IGlossarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/glossario")
public class glossarioController {

    @Autowired
    private IGlossarioService glossarioService;

    @GetMapping
    public List<Glossario> buscarPorTermoContem(@RequestBody Glossario glossario) {
        List<Glossario> aaaa = glossarioService.buscarGlossarioPorTermoContem(glossario.getTermo());
        return aaaa;
    }

    @GetMapping("/achar")
    public Glossario buscarPorTermo(@RequestBody Glossario glossario) {
        return glossarioService.buscarGlossarioPorTermo(glossario.getTermo());
    }

    @PostMapping("/list")
    public List<Glossario> buscarTodos() {
        return glossarioService.buscarGlossarios();
    }

}
