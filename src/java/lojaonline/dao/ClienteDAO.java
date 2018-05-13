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
import lojaonline.modelo.Cliente;

/**
 *
 * @author praveen
 */
public class ClienteDAO {

    private static final String INSERIR = "INSERT INTO cliente (nome_cliente, sobrenome_cliente) VALUES (?, ?)";
    private static final String EDITAR = "UPDATE cliente SET nome_cliente =?, sobrenome_cliente =? WHERE id_cliente =?";
    private static final String ELIMINAR = "DELETE FROM cliente WHERE id_cliente =?";
    private static final String LISTAR_POR_CODIGO = "SELECT * FROM cliente WHERE id_cliente =?";
    private static final String LISTAR_TUDO = "SELECT * FROM cliente";

    Connection con;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void guardar(Cliente cliente) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERIR);
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getSobrenomeCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void editar(Cliente cliente) {
        try {
            PreparedStatement ps = con.prepareStatement(EDITAR);
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getSobrenomeCliente());
            ps.setInt(3, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void eliminar(Cliente cliente) {
        try {
            PreparedStatement ps = con.prepareStatement(ELIMINAR);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Cliente> listaTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(LISTAR_TUDO);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                popularCliente(cliente, rs);
                clientes.add(cliente);

            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return clientes;

    }

    public Cliente buscarPorId(Cliente cliente) {
       
        try {
            PreparedStatement ps = con.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                popularCliente(cliente, rs);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;

    }

    private void popularCliente(Cliente cliente, ResultSet rs) {
        try {
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNomeCliente(rs.getString("nome_cliente"));
            cliente.setSobrenomeCliente(rs.getString("sobrenome_cliente"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
