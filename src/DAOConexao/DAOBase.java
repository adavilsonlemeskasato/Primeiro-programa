package DAOConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOBase {

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/Controle de Processo e Diligencia";
        String user = "postgres", pass = "3636";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro de concecção atualize após 5 minutos");
        }
        return con;
    }

    public static Connection getConRel() {
        String url = "jdbc:postgresql://localhost:5432/Controle de Processo e Diligencia";
        String user = "postgres", pass = "3636";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro de concecção atualize após 5 minutos");
        }
        return con;
    }

   
}
