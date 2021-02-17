/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.colaborador;
import java.util.ArrayList;
import database.conexao;
import br.com.colaborador.Colaborador;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author gabri
 */
public class gerenciamentoColaborador {
    public void inserirColaborador(Colaborador colaborador) {
        Connection connect = conexao.connection();
        String sql = "insert into colaborador(nome, idade, nascimento, endereco, endereco_numero, cargo, rg, cpf, telefone, celular, email, data_inicio) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, colaborador.getNome());
            preparador.setInt(2, colaborador.getIdade());
            preparador.setString(3, colaborador.getNascimento());
            preparador.setString(4, colaborador.getEndereco());
            preparador.setInt(5, colaborador.getEndereco_numero());
            preparador.setString(6, colaborador.getCargo());
            preparador.setInt(7, colaborador.getRg());
            preparador.setInt(8, colaborador.getCpf());
            preparador.setString(9, colaborador.getTelefone());
            preparador.setString(10, colaborador.getCelular());
            preparador.setString(11, colaborador.getEmail());
            preparador.setString(12, colaborador.getData_inicio());
           
           preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Colaborador> mostrarColaboradores(){
        Connection connect = conexao.connection();
        String sql = "select * from colaborador";
        ArrayList<Colaborador> listaColab = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setCodigo(answer.getInt("codigo"));
                colaborador.setNome(answer.getString("nome"));
                colaborador.setIdade(answer.getInt("idade"));
                colaborador.setNascimento(answer.getString("nascimento"));
                colaborador.setEndereco(answer.getString("endereco"));
                colaborador.setEndereco_numero(answer.getInt("endereco_numero"));
                colaborador.setCargo(answer.getString("cargo"));
                colaborador.setRg(answer.getInt("rg"));
                colaborador.setCpf(answer.getInt("cpf"));
                colaborador.setTelefone(answer.getString("telefone"));
                colaborador.setCelular(answer.getString("celular"));
                colaborador.setEmail(answer.getString("email"));
                colaborador.setData_inicio("data_inicio");
                listaColab.add(colaborador);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return listaColab;
    }
    
    public ArrayList<Colaborador> mostrarColaborador(int id) {
        Connection connect = conexao.connection();
        String sql = "select * from colaborador where codigo = ?";
        ArrayList<Colaborador> listaColab = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setCodigo(answer.getInt("codigo"));
                colaborador.setNome(answer.getString("nome"));
                colaborador.setIdade(answer.getInt("idade"));
                colaborador.setNascimento(answer.getString("nascimento"));
                colaborador.setEndereco(answer.getString("endereco"));
                colaborador.setEndereco_numero(answer.getInt("endereco_numero"));
                colaborador.setCargo(answer.getString("cargo"));
                colaborador.setRg(answer.getInt("rg"));
                colaborador.setCpf(answer.getInt("cpf"));
                colaborador.setTelefone(answer.getString("telefone"));
                colaborador.setCelular(answer.getString("celular"));
                colaborador.setEmail(answer.getString("email"));
                colaborador.setData_inicio("data_inicio");
                listaColab.add(colaborador);   
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return listaColab;
    }
    
    public void deleteColaborador(int id) {
        Connection connect = conexao.connection();
        String sql = "delete from colaborador where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarColaborador(int id, Colaborador colaborador) {
        Connection connect = conexao.connection();
        String sql = "update colaborador set nome = ?, idade = ?, nascimento = ?, endereco = ?, endereco_numero = ?, cargo = ?, rg = ?, cpf = ?, telefone = ?, celular = ?, email = ?, data_inicio = ? where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, colaborador.getNome());
            preparador.setInt(2, colaborador.getIdade());
            preparador.setString(3, colaborador.getNascimento());
            preparador.setString(4, colaborador.getEndereco());
            preparador.setInt(5, colaborador.getEndereco_numero());
            preparador.setString(6, colaborador.getCargo());
            preparador.setInt(7, colaborador.getRg());
            preparador.setInt(8, colaborador.getCpf());
            preparador.setString(9, colaborador.getTelefone());
            preparador.setString(10, colaborador.getCelular());
            preparador.setString(11, colaborador.getEmail());
            preparador.setString(12, colaborador.getData_inicio());
            preparador.setInt(13, id);
           
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
            
        }
    }
    public ArrayList<Colaborador> buscarColaborador(int id, String nome, int idade) {
        Connection connect = conexao.connection();
        ArrayList<Colaborador> lista = new ArrayList<>();
        String sql = "select * from colaborador where codigo like '%?%' or nome like '%?%' or idade like '%?%' ";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.setString(2, nome);
            preparador.setInt(3, idade);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setCodigo(answer.getInt("codigo"));
                colaborador.setNome(answer.getString("nome"));
                colaborador.setIdade(answer.getInt("idade"));
                colaborador.setNascimento(answer.getString("nascimento"));
                colaborador.setEndereco(answer.getString("endereco"));
                colaborador.setEndereco_numero(answer.getInt("endereco_numero"));
                colaborador.setCargo(answer.getString("cargo"));
                colaborador.setRg(answer.getInt("rg"));
                colaborador.setCpf(answer.getInt("cpf"));
                colaborador.setTelefone(answer.getString("telefone"));
                colaborador.setCelular(answer.getString("celular"));
                colaborador.setEmail(answer.getString("email"));
                colaborador.setData_inicio("data_inicio");
                lista.add(colaborador);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
