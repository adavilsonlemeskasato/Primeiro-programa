package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Advogado;
import Model.bean.AdvogadoPesquisa;
import Model.bean.ComarcaPesquisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOAdvogado extends DAOBase {

    public void inserir(Advogado advogado) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into advogado (nome ,registro_oab , telefone,email,  endereco,login_Advogado , senha, id_escritorio) values (?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, advogado.getNome_Advogado());
            ps.setString(2, advogado.getRegistro_Oab());
            ps.setString(3, advogado.getTelefone());
            ps.setString(4, advogado.getEmail());
            ps.setString(5, advogado.getEndereco());
            ps.setString(6, advogado.getLogin_Advogado());
            ps.setInt(7, (int) advogado.getSenha());
            ps.setInt(8, (int) advogado.getId_escritorio());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int Id_Advogado = rs.getInt(1);
                advogado.setId_escritorio(Id_Advogado);
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

    public void Deletar(int id_advogado) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete from advogado where id_advogado=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id_advogado);
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
//

    public void alterar(Advogado advogado) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "update advogado set nome = ?,registro_oab=?,telefone=?,email=?,endereco=?,login_Advogado=?,senha=?, id_escritorio=? where id_advogado = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, advogado.getNome_Advogado());
            ps.setString(2, advogado.getRegistro_Oab());
            ps.setString(3, advogado.getTelefone());
            ps.setString(4, advogado.getEmail());
            ps.setString(5, advogado.getEndereco());
            ps.setString(6, advogado.getLogin_Advogado());

            //Lembrar de como Pega automatico o ID da senha e escritorio
            ps.setInt(7, (int) advogado.getSenha());
            ps.setInt(8, (int) advogado.getId_escritorio());
            ps.setInt(9, (int) advogado.getId_Advogado());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int id_advogado = rs.getInt(9);
                advogado.setId_escritorio(id_advogado);
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
//

    public void consultar() {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            String sqlSelect = "select * from advogado order by nome ";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {
                int id_advogado = rs.getInt("id_advogado");
                String nome_advogado = rs.getString("nome");
                String registro_oab = rs.getString("registro_oab");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String login_Advogado = rs.getString("login_Advogado");
                long senha = rs.getInt("senha");
                long id_escritorio = rs.getInt("id_escritorio");

                System.out.println(id_advogado + " - " + nome_advogado + " - " + registro_oab + " - " + telefone + " - " + email
                        + " - " + endereco + " - " + login_Advogado + " - " + senha + " - " + id_escritorio);

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

    public List<Advogado> advogadoConsulta() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Advogado> advogados = new ArrayList<Advogado>();

        try {
            String sqlSelect = "select * from advogado order by nome ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_advogado = rs.getInt("id_advogado");
                String nome_advogado = rs.getString("nome");
                String registro_oab = rs.getString("registro_oab");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String login_Advogado = rs.getString("login_Advogado");
                int senha = rs.getInt("senha");
                int id_escritorio = rs.getInt("id_escritorio");

                Advogado advogado = new Advogado(id_advogado,nome_advogado, registro_oab, telefone, email, endereco, login_Advogado, senha, id_escritorio);
                advogados.add(advogado);

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
        return advogados;

    }
    
     public List<Advogado> advogadoPesquisar(String nome_Advogado) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Advogado> advogados = new ArrayList<Advogado>();

        try {
            String sqlSelect = "select * from advogado where nome like ? order by  nome ";
            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nome_Advogado + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id_advogado = rs.getInt("id_advogado");
                String nome_advogado = rs.getString("nome");
                String registro_oab = rs.getString("registro_oab");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String login_Advogado = rs.getString("login_Advogado");
                int senha = rs.getInt("senha");
                int id_escritorio = rs.getInt("id_escritorio");

                Advogado advogado = new Advogado(id_advogado,nome_advogado, registro_oab, telefone, email, endereco, login_Advogado, senha, id_escritorio);
                advogados.add(advogado);

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
        return advogados;

    }
     
      public List<AdvogadoPesquisa> consultarEspecial() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AdvogadoPesquisa> listaSecretariasEspeciais = new ArrayList<AdvogadoPesquisa>();
        try {
            String sqlSelect = "select * from advogado";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_Advogado = rs.getInt("id_advogado");
                String nome_advogado = rs.getString("nome");

                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_Advogado, nome_advogado);
                listaSecretariasEspeciais.add(advogadoPesquisa);
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
