/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaonline.modelo;

import java.io.Serializable;

/**
 *
 * @author praveen
 */
public class VendaProduto implements Serializable{
    private Venda venda;
    private Produto produto;
    private int quantidade;
    private int precoVenda;

    public VendaProduto() {
    }

    public VendaProduto(Venda venda, Produto produto, int quantidade, int precoVenda) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(int precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    
}
