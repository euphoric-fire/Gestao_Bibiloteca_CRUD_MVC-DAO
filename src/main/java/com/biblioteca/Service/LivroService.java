package com.biblioteca.Service;

import java.util.List;

import com.biblioteca.model.dao.LivroDAO;
import com.biblioteca.model.entity.Livro;

public class LivroService {
    private final LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    private void validar(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new ValidacaoExecption("O compo titulo não pode estar vazio.");
        }

        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            throw new ValidacaoExecption("O campo autor não pode estar vazio.");
        }

        if (livro.getIsbn() == null || livro.getIsbn().trim().isEmpty()) {
            throw new ValidacaoExecption("O campo isbn não pode estar vazio.");
        }

        if (livro.getQuantidadeDisponivel() < 0) {
            throw new ValidacaoExecption("Quantidade desponivel não pode ser inferior a 0.");
        }

        if (livro.getQuantidadeTotal() < 0) {
            throw new ValidacaoExecption("Quantidade total não pode ser inferior a 0.");
        }

        if (livro.getQuantidadeDisponivel() > livro.getQuantidadeTotal()) {
            throw new ValidacaoExecption("Quantidade disponivel não pode ser mair que a quantidadte total");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new ValidacaoExecption("Id invalido.");
        }
    }

    public void cadastrar(Livro livro) {
        validar(livro);
        livroDAO.inserir(livro);

    }

    public Livro buscarPorId(int id) {
        validarId(id);
        return livroDAO.buscarPorId(id);
    }

    public List<Livro> listarTodos() {
        return livroDAO.listarTodos();
    }

    public void atualizar(Livro livro) {
        validar(livro);
        validarId(livro.getId());
        livroDAO.atualizarLivro(livro);
    }

    public void deletar(int id) {
        validarId(id);
        livroDAO.deletar(id);
    }

}
