package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Comarca;
import Model.bean.ComarcaPesquisa;
import Model.bean.SecretariaPesquisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOComarca extends DAOBase {

    public void inserir(Comarca comarca) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into comarca ( uf,nome_comarca, telefone) values (?,?,?)";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, comarca.getUf());
            ps.setString(2, comarca.getNome_Comarca());
            ps.setString(3, comarca.getTeledone());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int id_comarca = rs.getInt(1);
                comarca.setId_Comarca(id_comarca);
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

    public void Deletar(int comarcaId) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete  from comarca where id_comarca=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, comarcaId);
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

    public void alterar(Comarca comarca) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

//            , , 
            String sql = "update comarca set  nome_comarca=?,uf=?,telefone=? where id_comarca = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, comarca.getNome_Comarca());
            ps.setString(2, comarca.getUf());
            ps.setString(3, comarca.getTeledone());
            ps.setInt(4, comarca.getId_Comarca());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int id_Comarca = rs.getInt(4);
                comarca.setId_Comarca(id_Comarca);
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
            String sqlSelect = "select * from comarca";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {

                int id_Comarca = rs.getInt("id_comarca");
                String uf = rs.getString("uf");
                String nome_Comarca = rs.getString("nome_comarca");
                String telefone = rs.getString("telefone");

                System.out.println(id_Comarca + " - " + uf + " - " + nome_Comarca + " - " + telefone);

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

    public List<Comarca> comarcaConsultar() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Comarca> comarcas = new ArrayList<Comarca>();

        try {

            String sqlSelect = "select * from comarca order by nome_comarca ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Comarca = rs.getInt("id_comarca");
                String uf = rs.getString("uf");
                String nome_Comarca = rs.getString("nome_comarca");
                String telefone = rs.getString("telefone");

                Comarca comarca = new Comarca(id_Comarca, uf, nome_Comarca, telefone);
                comarcas.add(comarca);

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
        return comarcas;

    }

    public List<Comarca> comarcaPesquisar(String nomeComarca) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Comarca> comarcas = new ArrayList<Comarca>();

        try {
            String sqlSelect = "select * from comarca where nome_comarca like ? order by nome_comarca ";
            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nomeComarca + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Comarca = rs.getInt("id_comarca");
                String uf = rs.getString("uf");
                String nome_Comarca = rs.getString("nome_comarca");
                String telefone = rs.getString("telefone");

                Comarca comarca = new Comarca(id_Comarca, uf, nome_Comarca, telefone);
                comarcas.add(comarca);

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
        return comarcas;

    }

    public List<ComarcaPesquisa> consultarEspecial() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ComarcaPesquisa> listaSecretariasEspeciais = new ArrayList<ComarcaPesquisa>();
        try {
            String sqlSelect = "select * from comarca";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_comarca = rs.getInt("id_comarca");
                String nome_comarca = rs.getString("nome_comarca");

                ComarcaPesquisa comarcapesquisa = new ComarcaPesquisa(id_comarca, nome_comarca);
                listaSecretariasEspeciais.add(comarcapesquisa);
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

}
