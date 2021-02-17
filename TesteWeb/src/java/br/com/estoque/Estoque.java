/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque;

/**
 *
 * @author gabri
 */
public class Estoque {
    public Estoque (String item, String categoria, String quantidade) {
        this.item = item;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public Estoque () {
        
    }
    
    private int codigo;
    private String item;
    private String categoria;
    private String quantidade;
    
    public int getCodigo(){
        return this.codigo;
    }
    public String getItem(){
        return this.item;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public String getQuantidade() {
        return this.quantidade;
    }
    
    //================================
    
    public int setCodigo(int codigo){
        this.codigo = codigo;
        return this.codigo;
    }
    public String setItem(String item){
        this.item = item;
        return this.item;
    }
    public String setCategoria(String categoria) {
        this.categoria = categoria;
        return this.categoria;
    }
    public String setQuantidade(String quantidade) {
        this.quantidade = quantidade;
        return this.quantidade;
    }
            
            
            
            
            
            
            
            
            
}
