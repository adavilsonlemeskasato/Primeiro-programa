package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Advogado;
import Model.bean.Secretaria;
import Model.bean.SecretariaPesquisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adavilson
 */
public class DAOSecrataria extends DAOBase {

    public boolean checkLogin(String text, String senha) {
        Statement st = null;
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        System.out.println(text);
        System.out.println(senha);

        try {
            String sql = " Select secretaria.login_secretaria,secretaria.senha From secretaria where login_secretaria= ? and senha= ? ";

            ps = con.prepareStatement(sql);
            ps.setString(1, text);
            ps.setInt(2, Integer.parseInt(senha));

            rs = ps.executeQuery();
//            System.out.println(sql);

            if (rs.next()) {
                check = true;
            } else {
                System.out.println("Usuario e senha invalido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return check;
    }

    public void inserir(Secretaria secretaria) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into secretaria (nome_secretaria, cpf,  login_secretaria, senha) values (?,?,?,?)";
            //sintaxe para conecção com id
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, secretaria.getNome_secretaria());
            ps.setString(2, secretaria.getCpf());
            ps.setString(3, secretaria.getLogin_secretaria());
            ps.setInt(4, secretaria.getSenha());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
                secretaria.setId_secretaria(lastId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void Deletar(int secretariaID) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete  from secretaria where id_secretaria=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, secretariaID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void alterar(Secretaria secretaria) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "update secretaria set nome_secretaria = ?, cpf= ?, login_secretaria=?, senha=? where id_secretaria = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, secretaria.getNome_secretaria());
            ps.setString(2, secretaria.getCpf());
            ps.setString(3, secretaria.getLogin_secretaria());
            ps.setInt(4, secretaria.getSenha());
            ps.setInt(5, secretaria.getId_secretaria());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int id_secretaria = rs.getInt(5);
                secretaria.setId_secretaria(id_secretaria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void consultar() {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            String sqlSelect = "select * from secretaria order by nome_secretaria   ";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {
                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");
                String cpf = rs.getString("cpf");
                String login_secretaria = rs.getString("login_secretaria");
                int senha = rs.getInt("senha");
                System.out.println(id_secretaria + " - " + nome_secretaria + " - " + cpf + " - " + login_secretaria + " - " + senha);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public List<Secretaria> secretariaConsultar() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Secretaria> secretarias = new ArrayList<Secretaria>();

        try {
            String sqlSelect = "select * from secretaria order by nome_secretaria ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_secretaria");
                String nome = rs.getString("nome_secretaria");
                String cpf = rs.getString("cpf");
                String loginSecretaria = rs.getString("login_secretaria");
                int senhaSecretaria = rs.getInt("senha");
                Secretaria secretaria = new Secretaria(id, nome, cpf, loginSecretaria, senhaSecretaria);
                secretarias.add(secretaria);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return secretarias;

    }

    public List<SecretariaPesquisa> consultarEspecial() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SecretariaPesquisa> listaSecretariasEspeciais = new ArrayList<SecretariaPesquisa>();
        try {
            String sqlSelect = "select * from secretaria";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");

                SecretariaPesquisa secretaria = new SecretariaPesquisa(id_secretaria, nome_secretaria);
                listaSecretariasEspeciais.add(secretaria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return listaSecretariasEspeciais;
    }

    public List<Secretaria> secretariasPesquisar(String nome_Secretaria) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Secretaria> Secretarias = new ArrayList<Secretaria>();

        try {
            String sqlSelect = "select * from secretaria where nome_secretaria like ? order by  nome_secretaria ";
            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nome_Secretaria + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_secretaria");
                String nome = rs.getString("nome_secretaria");
                String cpf = rs.getString("cpf");
                String loginSecretaria = rs.getString("login_secretaria");
                int senhaSecretaria = rs.getInt("senha");
                Secretaria secretaria = new Secretaria(id, nome, cpf, loginSecretaria, senhaSecretaria);
                Secretarias.add(secretaria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return Secretarias;

    }

}
