package com.livro.Livros.controllers;

import com.livro.Livros.models.Livro;
import com.livro.Livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro){
        return livroService.criarLivro(livro);
    }

    @GetMapping
    public List<Livro> listar(){
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Livro> buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        livroService.deletarLivro(id);
    }
}
