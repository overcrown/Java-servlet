/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author gabri
 */
public class Teste {
    public Teste(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }
    
    public Teste() {
       
    }
    
    private int id;
    private String nome;
    private String ra;
    
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getRa() {
        return this.ra;
    }
    
    public int setId(int id) {
        this.id = id;
        return this.id;
    }
    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }
    public String setRa(String ra) {
        this.ra = ra;
        return this.ra;
    }
    
}
