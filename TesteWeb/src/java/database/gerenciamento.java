/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import database.conexao;
import database.animais;
import java.sql.Connection;
import database.Teste;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class gerenciamento {
    public void inserir(animais animal) {
        Connection con = conexao.connection();
        String sql = "insert into pets(nome, especie, cor, raca, idade, castrado, vacinacao, dataChegada, adotado, nascimento, porte, observacao, adotante,cadastrador) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, animal.getNome());
            preparador.setString(2, animal.getEspecie());
            preparador.setString(3, animal.getCor());
            preparador.setString(4, animal.getRaca());
            preparador.setInt(5, animal.getIdade());
            preparador.setString(6, animal.getCastrado());
            preparador.setString(7, animal.getVacinacao());
            preparador.setString(8, animal.getDataChegada());
            preparador.setString(9, animal.getAdotado());
            preparador.setString(10, animal.getNascimento());
            preparador.setString(11, animal.getPorte());
            preparador.setString(12, animal.getObservacao());
            preparador.setInt(13, animal.getAdotante());
            preparador.setInt(14, animal.getCadastrador());
            
            preparador.execute();
            System.out.println("Dados inseridos com sucesso");
            
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<animais> mostrarPets() {
        Connection connect = conexao.connection();
        String sql = "select * from pets";
        ArrayList<animais> pets = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()) {
                animais pet = new animais();
                pet.setCodigo(answer.getInt("codigo"));
                pet.setNome(answer.getString("nome"));
                pet.setEspecie(answer.getString("especie"));
                pet.setCor(answer.getString("cor"));
                pet.setRaca(answer.getString("raca"));
                pet.setIdade(answer.getInt("idade"));
                pet.setCastrado(answer.getString("castrado"));
                pet.setVacinacao(answer.getString("vacinacao"));
                pet.setDataChegada(answer.getString("dataChegada"));
                pet.setAdotado(answer.getString("adotado"));
                pet.setNascimento(answer.getString("nascimento"));
                pet.setPorte(answer.getString("porte"));
                pet.setObservacao(answer.getString("observacao"));
                pet.setAdotante(answer.getInt("adotante"));
                pet.setCadastrador(answer.getInt("cadastrador"));
                pets.add(pet);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    public ArrayList<animais> mostrarGato() {
        Connection connect = conexao.connection();
        String sql = "select * from pets where especie = 'gato'";
        ArrayList<animais> pets = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()) {
                animais pet = new animais();
                pet.setCodigo(answer.getInt("codigo"));
                pet.setNome(answer.getString("nome"));
                pet.setEspecie(answer.getString("especie"));
                pet.setCor(answer.getString("cor"));
                pet.setRaca(answer.getString("raca"));
                pet.setIdade(answer.getInt("idade"));
                pet.setCastrado(answer.getString("castrado"));
                pet.setVacinacao(answer.getString("vacinacao"));
                pet.setDataChegada(answer.getString("dataChegada"));
                pet.setAdotado(answer.getString("adotado"));
                pet.setNascimento(answer.getString("nascimento"));
                pet.setPorte(answer.getString("porte"));
                pet.setObservacao(answer.getString("observacao"));
                pet.setAdotante(answer.getInt("adotante"));
                pet.setCadastrador(answer.getInt("cadastrador"));
                pets.add(pet);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    
    public ArrayList<animais> mostrarCachorro() {
        Connection connect = conexao.connection();
        String sql = "select * from pets where especie = 'Cachorro'";
        ArrayList<animais> pets = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()) {
                animais pet = new animais();
                pet.setCodigo(answer.getInt("codigo"));
                pet.setNome(answer.getString("nome"));
                pet.setEspecie(answer.getString("especie"));
                pet.setCor(answer.getString("cor"));
                pet.setRaca(answer.getString("raca"));
                pet.setIdade(answer.getInt("idade"));
                pet.setCastrado(answer.getString("castrado"));
                pet.setVacinacao(answer.getString("vacinacao"));
                pet.setDataChegada(answer.getString("dataChegada"));
                pet.setAdotado(answer.getString("adotado"));
                pet.setNascimento(answer.getString("nascimento"));
                pet.setPorte(answer.getString("porte"));
                pet.setObservacao(answer.getString("observacao"));
                pet.setAdotante(answer.getInt("adotante"));
                pet.setCadastrador(answer.getInt("cadastrador"));
                pets.add(pet);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    //deletar
    
    public void deletePet(int id) {
        Connection connect = conexao.connection();
        String sql = "delete from pets where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    //editar
    public void editarPet(int id, animais animal) {
        Connection connect = conexao.connection();
        String sql = "update pets set (nome = ?, especie = ?, cor = ?, raca = ?, idade = ?, castrado = ?, vacinacao = ?, dataChegada = ?, adotado = ?, adotante = ?, nascimento = ?, porte = ?, observacao = ?, cadastrador = ?) where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, animal.getNome());
            preparador.setString(2, animal.getEspecie());
            preparador.setString(3, animal.getCor());
            preparador.setString(4, animal.getRaca());
            preparador.setInt(5, animal.getIdade());
            preparador.setString(6, animal.getCastrado());
            preparador.setString(7, animal.getVacinacao());
            preparador.setString(8, animal.getDataChegada());
            preparador.setString(9, animal.getAdotado());
            preparador.setInt(10, animal.getAdotante());
            preparador.setString(11, animal.getNascimento());
            preparador.setString(12, animal.getPorte());
            preparador.setString(13, animal.getObservacao());
            preparador.setInt(14, animal.getCadastrador());
            preparador.setInt(15, id);
            
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<animais> buscarAnimal(int id, String nome, String especie) {
        Connection connect = conexao.connection();
        ArrayList<animais> lista = new ArrayList<>();
        String sql = "select * from pets where codigo like '%?%' or nome like '%?%' or especie like '%?%' ";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.setString(2, nome);
            preparador.setString(3, especie);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                animais pet = new animais();
                pet.setCodigo(answer.getInt("codigo"));
                pet.setNome(answer.getString("nome"));
                pet.setEspecie(answer.getString("especie"));
                pet.setCor(answer.getString("cor"));
                pet.setRaca(answer.getString("raca"));
                pet.setIdade(answer.getInt("idade"));
                pet.setCastrado(answer.getString("castrado"));
                pet.setVacinacao(answer.getString("vacinacao"));
                pet.setDataChegada(answer.getString("dataChegada"));
                pet.setAdotado(answer.getString("adotado"));
                pet.setNascimento(answer.getString("nascimento"));
                pet.setPorte(answer.getString("porte"));
                pet.setObservacao(answer.getString("observacao"));
                pet.setAdotante(answer.getInt("adotante"));
                pet.setCadastrador(answer.getInt("cadastrador"));
                lista.add(pet);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    
    //=================================================
    public void testeInserir(Teste a) {
        Connection con = conexao.connection();
        String sql = "insert into teste(nome, ra) values (?, ?)";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, a.getNome());
            preparador.setString(2, a.getRa());
            
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList mostrarTeste() {
        ArrayList<Teste> lista = new ArrayList<>();
        String sql = "select * from teste";
        Connection connection = conexao.connection();
        
        try {
            PreparedStatement preparador = connection.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Teste c = new Teste();
                c.setId(answer.getInt("id"));
                c.setNome(answer.getString("nome"));
                c.setRa(answer.getString("ra"));
                lista.add(c);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList mostrarExato(int id) {
        Connection connection = conexao.connection();
        ArrayList<Teste> lista = new ArrayList<>();
        String sql = "select * from teste where id = ?";
        try {
            PreparedStatement preparador = connection.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Teste teste = new Teste();
                teste.setId(answer.getInt("id"));
                teste.setNome(answer.getString("nome"));
                teste.setRa(answer.getString("ra"));
                lista.add(teste);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void delete(int id) {
        Connection connection = conexao.connection();
        String sql = "delete from teste where id = ?";
        try {
            PreparedStatement preparador = connection.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void alterar(Teste a) {
        Connection connection = conexao.connection();
        String sql = "update teste set nome = ?, ra = ? where id = ?";
        try {
           PreparedStatement preparador = connection.prepareStatement(sql);
           preparador.setString(1, a.getNome());
           preparador.setString(2, a.getRa());
           preparador.setInt(3, a.getId());
           preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
}
