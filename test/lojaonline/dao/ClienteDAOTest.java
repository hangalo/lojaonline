/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaonline.dao;

import java.util.List;
import lojaonline.modelo.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author praveen
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    

    /**
     * Test of guardar method, of class ClienteDAO.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        
        Cliente cliente = new Cliente();
        
        cliente.setNomeCliente("Jose");
        cliente.setSobrenomeCliente("Hangalo");
        ClienteDAO instance = new ClienteDAO();
        instance.guardar(cliente);
       
    }

    /**
     * Test of editar method, of class ClienteDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(5);
        cliente.setNomeCliente("Maria");
        cliente.setNomeCliente("Pungo");
              
        ClienteDAO instance = new ClienteDAO();
        instance.editar(cliente);
        
    }

    /**
     * Test of eliminar method, of class ClienteDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Cliente cliente = new Cliente();
        cliente.setIdCliente(3);
        ClienteDAO instance = new ClienteDAO();
        instance.eliminar(cliente);
       
    }

    /**
     * Test of listaTodos method, of class ClienteDAO.
     */
    @Test
    public void testListaTodos() {
        System.out.println("listaTodos");
        ClienteDAO instance = new ClienteDAO();
        
      
        List<Cliente> result = instance.listaTodos();
        assertTrue(result.size() >0 );
       
    }

    /**
     * Test of buscarPorId method, of class ClienteDAO.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(2);
        ClienteDAO instance = new ClienteDAO();
        
        Cliente result = instance.buscarPorId(cliente);
        assertNotNull(result);
        assertEquals(cliente.getIdCliente(), result.getIdCliente());
       
    }
    
}
