package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class conexao {
    public static Connection connection() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/ongpets", "root", "");
        }catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conexao;
    }
}