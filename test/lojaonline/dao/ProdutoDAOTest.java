/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaonline.dao;

import java.util.List;
import lojaonline.modelo.Produto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author praveen
 */
public class ProdutoDAOTest {
    
   

    /**
     * Test of guardar method, of class ProdutoDAO.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Produto produto = new Produto();
        produto.setCodigoProduto(98712);
        produto.setNomeProduto("Carne");
        produto.setPrecoProduto(5000);
        ProdutoDAO instance = new ProdutoDAO();
        instance.guardar(produto);
        
    }

    /**
     * Test of alterar method, of class ProdutoDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Produto produto = new Produto();
        produto.setIdProduto(1);
        produto.setCodigoProduto(101010);
        produto.setNomeProduto("Massa Velha");
        produto.setPrecoProduto(6000);
        ProdutoDAO instance = new ProdutoDAO();
        instance.alterar(produto);
        
    }

    /**
     * Test of eliminar method, of class ProdutoDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        
        Produto produto = new Produto();
        produto.setIdProduto(1);
        ProdutoDAO instance = new ProdutoDAO();
        instance.eliminar(produto);
       
    }

    /**
     * Test of listaTodos method, of class ProdutoDAO.
     */
    @Test
    public void testListaTodos() {
        System.out.println("listaTodos");
        ProdutoDAO instance = new ProdutoDAO();
        List<Produto> expResult = null;
        List<Produto> result = instance.listaTodos();
        
        assertTrue(result.size() > 0);
       
    }

    /**
     * Test of buscarPorId method, of class ProdutoDAO.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        
        int idProduto = 2;
        ProdutoDAO instance = new ProdutoDAO();
       
        Produto result = instance.buscarPorId(idProduto);
        
        assertNotNull(result);
        assertEquals(idProduto, result.getIdProduto());
      
    }
    
}
