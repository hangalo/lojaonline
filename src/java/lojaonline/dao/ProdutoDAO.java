/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lojaonline.bd.util.ConnectionFactory;
import lojaonline.modelo.Produto;

/**
 *
 * @author praveen
 */
public class ProdutoDAO {

    private static final String INSERIR = "INSERT INTO produto (codigo_produto, nome_produto, preco_produto) VALUES (?, ?, ?)";
    private static final String EDITAR = "UPDATE produto SET codigo_produto =?, nome_produto =?, preco_produto =? WHERE id_produto =?";
    private static final String ELIMINAR = "DELETE FROM produto WHERE id_produto =?";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM produto WHERE id_produto =?";
    private static final String LISTAR_TUDO = "SELECT * FROM produto";

    Connection con;

    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void guardar(Produto produto) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERIR);
            ps.setInt(1, produto.getCodigoProduto());
            ps.setString(2, produto.getNomeProduto());
            ps.setDouble(3, produto.getPrecoProduto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void alterar(Produto produto) {
        try {
            PreparedStatement ps = con.prepareStatement(EDITAR);
            ps.setInt(1, produto.getCodigoProduto());
            ps.setString(2, produto.getNomeProduto());
            ps.setDouble(3, produto.getPrecoProduto());
            ps.setInt(4, produto.getIdProduto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void eliminar(Produto produto) {
        try {
            PreparedStatement ps = con.prepareStatement(ELIMINAR);
            ps.setInt(1, produto.getIdProduto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Produto> listaTodos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(LISTAR_TUDO);
            while (rs.next()) {
                Produto produto = new Produto();
                popularProduto(produto, rs);
                produtos.add(produto);

            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return produtos;

    }

    public Produto buscarPorId(int idProduto) {
        Produto produto = new Produto();
        try {
            PreparedStatement ps = con.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                popularProduto(produto, rs);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produto;

    }

    private void popularProduto(Produto produto, ResultSet rs) {
        try {
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setCodigoProduto(rs.getInt("codigo_produto"));
            produto.setNomeProduto(rs.getString("nome_produto"));
            produto.setPrecoProduto(rs.getDouble("preco_produto"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
