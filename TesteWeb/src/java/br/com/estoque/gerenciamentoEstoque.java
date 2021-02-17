
package br.com.estoque;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.estoque.Estoque;
import database.conexao;

/**
 *
 * @author gabri
 */
public class gerenciamentoEstoque {
    public void inserirEstoque(Estoque produto) {
        Connection connect = conexao.connection();
        String sql = "insert into estoque(item, categoria, quantidade) values (?, ?, ?)";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, produto.getItem());
            preparador.setString(2, produto.getCategoria());
            preparador.setString(3, produto.getQuantidade());
            
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Estoque> mostrarEstoque() {
        Connection connect = conexao.connection();
        String sql = "select * from estoque";
        ArrayList<Estoque> lista = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()) {
                Estoque produto = new Estoque();
                produto.setCodigo(answer.getInt("codigo"));
                produto.setItem(answer.getString("item"));
                produto.setCategoria(answer.getString("categoria"));
                produto.setQuantidade(answer.getString("quantidade"));
                lista.add(produto);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Estoque> mostrarItemExato(int id) {
        Connection connect = conexao.connection();
        String sql = "select * from estoque where codigo = ?";
        ArrayList<Estoque> lista = new ArrayList<>();
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            ResultSet answer = preparador.executeQuery();
            while(answer.next()) {
                Estoque produto = new Estoque();
                produto.setCodigo(answer.getInt("codigo"));
                produto.setItem(answer.getString("item"));
                produto.setCategoria(answer.getString("categoria"));
                produto.setQuantidade(answer.getString("quantidade"));
                lista.add(produto);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void deleteItem(int id) {
        Connection connect = conexao.connection();
        String sql = "delete from estoque where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarItem(int id, Estoque produto) {
        Connection connect = conexao.connection();
        String sql = "update estoque set item = ?, categoria = ?, quantidade = ? where codigo = ?";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, produto.getItem());
            preparador.setString(2, produto.getCategoria());
            preparador.setString(3, produto.getQuantidade());
            preparador.setInt(4, id);
            
            preparador.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Estoque> buscarItem(String item) {
        Connection connect = conexao.connection();
        ArrayList<Estoque> lista = new ArrayList<>();
        String sql = "select * from estoque where item = item";
        try {
            PreparedStatement preparador = connect.prepareStatement(sql);
            preparador.setString(1, item);
            //preparador.setString(2, item);
            //preparador.setString(3, categoria);
            ResultSet answer = preparador.executeQuery();
            while (answer.next()) {
                Estoque produto = new Estoque();
                produto.setCodigo(answer.getInt("codigo"));
                produto.setItem(answer.getString("item"));
                produto.setCategoria(answer.getString("categoria"));
                produto.setQuantidade(answer.getString("quantidade"));
                lista.add(produto);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
