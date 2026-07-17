package com.biblioteca.model.dao;

import java.util.List;

import com.biblioteca.model.entity.Livro;

public interface LivroDAO {
    void inserir(Livro livro);

    Livro buscarPorId(int id);

    List<Livro> listarTodos();

    void atualizarLivro(Livro livro);

    void deletar(int id);
}
