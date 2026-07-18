package com.biblioteca.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.biblioteca.model.entity.Livro;

public class LivroView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int exibirMenu() throws IOException {
        System.out.println("\n=== GESTAO DE BIBLIOTECA ===");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Buscar livro por ID");
        System.out.println("3. Listar todos os livros");
        System.out.println("4. Atualizar livro");
        System.out.println("5. Deletar livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
        return Integer.parseInt(br.readLine());
    }

    public Livro leLivroNovo() throws IOException {
        System.out.println("Titulo do Livro: ");
        String titulo = br.readLine();

        System.out.println("Nome do Autor: ");
        String autor = br.readLine();

        System.out.println("Isbn: ");
        String isbn = br.readLine();

        System.out.println("Quantidade Total: ");
        int quantidadeTotal = Integer.parseInt(br.readLine());

        System.out.println("Quantidade Disponivel: ");
        int quantidadeDisponivel = Integer.parseInt(br.readLine());

        return new Livro(titulo, autor, isbn, quantidadeTotal, quantidadeDisponivel);

    }

    public int lierID() throws IOException {
        System.out.println("ID do livro: ");
        int id = Integer.parseInt(br.readLine());

        return id;
    }

    public void mostrarLivro(Livro livro) {
        if (livro == null) {
            System.out.println("Livro não encontrado.");
        } else {
            System.out.println(livro);
        }
    }

    public void mostraLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro foi cadastrado.");
        } else {
            /*
             * for (Livro livro : livros) {
             * System.out.println(livro);
             * }
             */
            
            livros.forEach(System.out::println);
        }
    }

    public void mostrarMenssagem(String msg) {
        System.out.println(msg);
    }
}
