package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Escritorio;
import Model.bean.Secretaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEscritorio extends DAOBase {

    public void inserir(Escritorio escritorio) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into escritorio ( nome_advocacia, telefone,  endereco, id_secretaria) values (?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, escritorio.getNome_advocacia());
            ps.setString(2, escritorio.getTelefone());
            ps.setString(3, escritorio.getEndereco());
            ps.setInt(4, (int) escritorio.getSecretaria().getId_secretaria());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int Id_escritorio = rs.getInt(5);
                escritorio.setId_escritorio(Id_escritorio);
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

    public void Deletar(int id_escritorio) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete from escritorio where id_escritorio=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id_escritorio);
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

    public void alterar(Escritorio escritorio) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update escritorio set nome_advocacia = ?,telefone=?,endereco=?, id_secretaria=? where id_escritorio = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, escritorio.getNome_advocacia());
            ps.setString(2, escritorio.getTelefone());
            ps.setString(3, escritorio.getEndereco());

            //Lembrar de Pegar automatico o ID da Secretaria
            ps.setInt(4, (int) escritorio.getSecretaria().getId_secretaria());

            ps.setInt(5, escritorio.getId_escritorio());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int id_escritorio = rs.getInt(5);
                escritorio.setId_escritorio(id_escritorio);
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

    public List<Escritorio> escritorioConsultar() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Escritorio> escritorios = new ArrayList<Escritorio>();

        try {
            String sqlSelect = "SELECT p.id_escritorio, p.nome_advocacia,p.telefone,p.endereco,\n"
                    + "                    e.nome_secretaria,e.id_secretaria\n"
                    + "                    FROM escritorio p, secretaria e \n"
                    + "                    where p.id_secretaria = e.id_secretaria\n"
                    + "					order by p.nome_advocacia ; ";

            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_escritorio = rs.getInt("id_escritorio");
                String nome_advocacia = rs.getString("nome_advocacia");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");

                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");

                Secretaria secretaria = new Secretaria(id_secretaria, nome_secretaria);
                Escritorio escritorio = new Escritorio(id_escritorio, nome_advocacia, telefone, endereco, secretaria);
                escritorios.add(escritorio);

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
        return escritorios;

    }

    public List<Escritorio> escritorioPesquisa(String nomeEscritorio) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Escritorio> escritorios = new ArrayList<Escritorio>();

        try {
            String sqlSelect = "SELECT p.id_escritorio, p.nome_advocacia,p.telefone,p.endereco,\n"
                    + "                    e.nome_secretaria,e.id_secretaria\n"
                    + "                    FROM escritorio p, secretaria e \n"
                    + "                    where p.id_secretaria = e.id_secretaria\n"
                    + "			   and  p.nome_advocacia like ?\n order by p.nome_advocacia" //                    + "					order by p.nome_advocacia; "
                    ;
            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nomeEscritorio + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id_escritorio = rs.getInt("id_escritorio");
                String nome_advocacia = rs.getString("nome_advocacia");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");

                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");

                Secretaria secretaria = new Secretaria(id_secretaria, nome_secretaria);
                Escritorio escritorio = new Escritorio(id_escritorio, nome_advocacia, telefone, endereco, secretaria);
                escritorios.add(escritorio);

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
        return escritorios;

    }

    public List<Escritorio> Pesquisarconsultar() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Escritorio> listaServidor = new ArrayList<Escritorio>();
        try {
            String sqlSelect = "SELECT p.id_escritorio, p.nome_advocacia,p.telefone,p.endereco,\n"
                    + "                    e.nome_secretaria\n"
                    + "                    FROM escritorio p, secretaria e \n"
                    + "                    where p.id_secretaria = e.id_secretaria order by p.nome_advocacia;";

            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id_escritorio = rs.getInt("id_escritorio");
                String nome_advocacia = rs.getString("nome_advocacia");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");

                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");

                Secretaria secretaria = new Secretaria(id_secretaria, nome_secretaria);
                Escritorio escritorio = new Escritorio(id_escritorio, nome_advocacia, telefone, endereco, secretaria);
                listaServidor.add(escritorio);
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
        return listaServidor;
    }

    public Escritorio GetById(int id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Escritorio escritorio = new Escritorio();
        try {
            String sqlSelect = "SELECT p.id_escritorio, p.nome_advocacia,p.telefone,p.endereco,\n"
                    + "                    e.nome_secretaria,e.id_secretaria\n"
                    + "                    FROM escritorio p, secretaria e \n"
                    + "                    where p.id_secretaria = e.id_secretaria\n"
                    + "					and  p.id_escritorio = ?\n"
                    + "					order by p.nome_advocacia;";

            ps = con.prepareStatement(sqlSelect);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                escritorio.setId_escritorio(rs.getInt("id_escritorio"));
                escritorio.setNome_advocacia(rs.getString("nome_advocacia"));
                escritorio.setTelefone(rs.getString("telefone"));
                escritorio.setEndereco(rs.getString("endereco"));

                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");

                Secretaria secretaria = new Secretaria(id_secretaria, nome_secretaria);

                escritorio.setSecretaria(secretaria);
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
        return escritorio;
    }

}
