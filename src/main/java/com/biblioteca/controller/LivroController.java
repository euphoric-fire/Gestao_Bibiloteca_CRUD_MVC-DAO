package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.Service.LivroService;
import com.biblioteca.model.entity.Livro;

public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    public void cadastrar(Livro livro) {
        livroService.cadastrar(livro);
    }

    public Livro buscarPorId(int id) {
        return livroService.buscarPorId(id);
    }

    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    public void atualizarLivro(Livro livro) {
        livroService.atualizar(livro);
    }

    public void deletar(int id) {
        livroService.deletar(id);
    }

}
