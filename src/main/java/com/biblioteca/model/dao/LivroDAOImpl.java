package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.infra.ConexaoFatory;
import com.biblioteca.model.entity.Livro;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void inserir(Livro livro) {
        String sql = "INSERT INTO Livro(titulo, autor, isbn, quantidade_total, quantidade_disponivel) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoFatory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getIsbn());
            ps.setInt(4, livro.getQuantidadeTotal());
            ps.setInt(5, livro.getQuantidadeDisponivel());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o livro", e);
        }
    }

    @Override
    public Livro buscarPorId(int id) {

        String sql = "SELECT * FROM Livro WHERE id = ?";
        try (Connection conn = ConexaoFatory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
                            rs.getString("isbn"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));

                }

            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Livro por ID. Id Invalido", e);
        }

        return null;
    }

    @Override
    public List<Livro> listarTodos() {
        String sql = "SELECT * FROM Livro";
        List<Livro> livros = new ArrayList<>();

        try (Connection conn = ConexaoFatory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
                        rs.getString("isbn"), rs.getInt("quantidade_total"), rs.getInt("qunatidade_disponivel"));

                livros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros", e);
        }

        return livros;
    }

    @Override
    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE Livros SET titulo = ?, autor = ?, isbn = ?,quantidade_total = ?, quantidade_disponivel = ? WHERE id = ?";

        try (Connection conn = ConexaoFatory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getIsbn());
            ps.setInt(4, livro.getQuantidadeTotal());
            ps.setInt(5, livro.getQuantidadeDisponivel());
            ps.setInt(6, livro.getId());

            int linhasModificadas = ps.executeUpdate();
            if (linhasModificadas == 0) {
                throw new RuntimeException("Nenhum livro foi encontrado com o id " + livro.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar");
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Livro WHERE id = ?";

        try (Connection conn = ConexaoFatory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int linhasModificadas = ps.executeUpdate();
            if (linhasModificadas == 0) {
                throw new RuntimeException("Nenhum livro foi encontrado com o id " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o livro", e);
        }
    }

}
