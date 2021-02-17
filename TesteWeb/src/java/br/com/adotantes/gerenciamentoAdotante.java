
package br.com.adotantes;
import database.conexao;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.animais;


public class gerenciamentoAdotante {
    
    public void inserirAdotante(Adotante adotador) {
        Connection connect = conexao.connection();
        String sql = "insert into adotante(nome, idade, nascimento, endereco, endereco_numero, rg, cpf, telefone, celular, email, aptidao, documento, observacao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, adotador.getNome());
            preparador.setInt(2, adotador.getIdade());
            preparador.setString(3, adotador.getNascimento());
            preparador.setString(4, adotador.getEndereco());
            preparador.setInt(5, adotador.getEndereco_numero());
            preparador.setInt(6, adotador.getRg());
            preparador.setInt(7, adotador.getCpf());
            preparador.setString(8, adotador.getTelefone());
            preparador.setString(9, adotador.getCelular());
            preparador.setString(10, adotador.getEmail());
            preparador.setString(11, adotador.getAptidao());
            preparador.setString(12, adotador.getDocumento());
            preparador.setString(13, adotador.getObservacao());
            
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Adotante> mostrarAdotantes(){
        Connection connect = conexao.connection();
        String sql = "select * from adotante";
        ArrayList<Adotante> lista = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()){
                Adotante adotador = new Adotante();
                adotador.setCodigo(answer.getInt("codigo"));
                adotador.setNome(answer.getString("nome"));
                adotador.setIdade(answer.getInt("idade"));
                adotador.setNascimento(answer.getString("nascimento"));
                adotador.setEndereco(answer.getString("endereco"));
                adotador.setEndereco_numero(answer.getInt("endereco_numero"));
                adotador.setRg(answer.getInt("rg"));
                adotador.setCpf(answer.getInt("cpf"));
                adotador.setTelefone(answer.getString("telefone"))        ;
                adotador.setCelular(answer.getString("celular"));
                adotador.setEmail(answer.getString("email"));
                adotador.setAptidao(answer.getString("aptidao"));
                adotador.setDocumento(answer.getString("documento"));
                adotador.setObservacao(answer.getString("observacao"));
                
                lista.add(adotador);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Adotante> mostrarAdotanteExato(int id) {
        Connection connect = conexao.connection();
        String sql = "select * from adotante where codigo = ?";
        ArrayList<Adotante> lista = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Adotante adotador = new Adotante();
                adotador.setCodigo(answer.getInt("codigo"));
                adotador.setNome(answer.getString("nome"));
                adotador.setIdade(answer.getInt("idade"));
                adotador.setNascimento(answer.getString("nascimento"));
                adotador.setEndereco(answer.getString("endereco"));
                adotador.setEndereco_numero(answer.getInt("endereco_numero"));
                adotador.setRg(answer.getInt("rg"));
                adotador.setCpf(answer.getInt("cpf"));
                adotador.setTelefone(answer.getString("telefone"))        ;
                adotador.setCelular(answer.getString("celular"));
                adotador.setEmail(answer.getString("email"));
                adotador.setAptidao(answer.getString("aptidao"));
                adotador.setDocumento(answer.getString("documento"));
                adotador.setObservacao(answer.getString("observacao"));
                
                lista.add(adotador);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void deleteAdotante(int id) {
        Connection connect = conexao.connection();
        String sql = "delete from adotante where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editarAdotante(int id, Adotante adotador) {
        Connection connect = conexao.connection();
        String sql = "update adotante set nome = ?, idade = ?, nascimento = ?, endereco = ?, endereco_numero = ?, rg = ?, cpf = ?, telefone = ?, celular = ?, email = ?, aptidao = ?, documento = ?, observacao = ? where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, adotador.getNome());
            preparador.setInt(2, adotador.getIdade());
            preparador.setString(3, adotador.getNascimento());
            preparador.setString(4, adotador.getEndereco());
            preparador.setInt(5, adotador.getEndereco_numero());
            preparador.setInt(6, adotador.getRg());
            preparador.setInt(7, adotador.getCpf());
            preparador.setString(8, adotador.getTelefone());
            preparador.setString(9, adotador.getCelular());
            preparador.setString(10, adotador.getEmail());
            preparador.setString(11, adotador.getAptidao());
            preparador.setString(12, adotador.getDocumento());
            preparador.setString(13, adotador.getObservacao());
            preparador.setInt(14, id);
            
            preparador.execute();
                    

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Adotante> buscarAdotante(int id, String nome, int idade) {
        Connection connect = conexao.connection();
        ArrayList<Adotante> lista = new ArrayList<>();
        String sql = "select * from colaborador where codigo like '%?%' or nome like '%?%' or idade like '%?%' ";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.setString(2, nome);
            preparador.setInt(3, idade);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Adotante adotador = new Adotante();
                adotador.setCodigo(answer.getInt("codigo"));
                adotador.setNome(answer.getString("nome"));
                adotador.setIdade(answer.getInt("idade"));
                adotador.setNascimento(answer.getString("nascimento"));
                adotador.setEndereco(answer.getString("endereco"));
                adotador.setEndereco_numero(answer.getInt("endereco_numero"));
                adotador.setRg(answer.getInt("rg"));
                adotador.setCpf(answer.getInt("cpf"));
                adotador.setTelefone(answer.getString("telefone"))        ;
                adotador.setCelular(answer.getString("celular"));
                adotador.setEmail(answer.getString("email"));
                adotador.setAptidao(answer.getString("aptidao"));
                adotador.setDocumento(answer.getString("documento"));
                adotador.setObservacao(answer.getString("observacao"));
                
                lista.add(adotador);
                
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
}
