package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Advogado;
import Model.bean.AdvogadoPesquisa;
import Model.bean.Cliente;
import Model.bean.ClientePesquisa;
import Model.bean.Comarca;
import Model.bean.ComarcaPesquisa;
import Model.bean.Escritorio;
import Model.bean.Processo;
import Model.bean.Secretaria;
import Model.bean.SecretariaPesquisa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOProcesso extends DAOBase {

    public void inserir(Processo processo) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into processo ( num_processo,Descriçao,dt_inicio, dt_fim,vl_causa,id_cliente,id_advogado,id_secretaria,id_comarca ) values (?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, processo.getNum_processo());
            ps.setString(2, processo.getDescricao());
            ps.setDate(3, (Date) processo.getDataNascimentoBDInicio());
            ps.setDate(4, (Date) processo.getDataNascimentoBDFim());
            ps.setFloat(5, processo.getVl_causa());
            ps.setInt(6, processo.getCliente().getId_cliente());
            ps.setInt(7, processo.getAdvogado().getId_Advogado());
            ps.setInt(8, processo.getSecretaria().getId_secretaria());
            ps.setInt(9, processo.getComarca().getId_Comarca());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int id_Processo = rs.getInt(1);
                processo.setId_processo(id_Processo);
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

    public void Deletar(int processoID) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete  from processo where id_processo=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, processoID);
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

    public void alterar(Processo processo) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "update processo set  num_processo=?,Descriçao=?,"
                    + "dt_inicio=?, dt_fim=?, vl_causa=?,id_cliente=?,"
                    + " id_advogado=?,id_secretaria=?,id_comarca=?"
                    + " where id_processo = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, processo.getNum_processo());
            ps.setString(2, processo.getDescricao());
            ps.setDate(3, (Date) processo.getDataNascimentoBDInicio());
            ps.setDate(4, (Date) processo.getDataNascimentoBDFim());
            ps.setFloat(5, processo.getVl_causa());
            ps.setInt(6, processo.getCliente().getId_cliente());
            ps.setInt(7, processo.getAdvogado().getId_Advogado());
            ps.setInt(8, processo.getSecretaria().getId_secretaria());
            ps.setInt(9, processo.getComarca().getId_Comarca());
            ps.setInt(10, processo.getId_processo());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int id_Processo = rs.getInt(10);
                processo.setId_processo(id_Processo);
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

    public List<Processo> processoConsultar() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<Processo>();

        try {
            String sqlSelect = "select p.id_processo , p.num_processo ,p.descriçao,p.dt_inicio,p.dt_fim, p.vl_causa,\n"
                    + "         Cl.nome_cliente,a.nome, s.nome_secretaria,Co.Nome_comarca ,\n"
                    + "		Cl.id_cliente,a.id_advogado,s.id_secretaria,Co.id_comarca	   \n"
                    + "         from processo P , comarca Co ,cliente Cl ,advogado a,secretaria s\n"
                    + "         where  Cl.id_cliente = p.id_cliente \n"
                    + "         and Co.id_comarca=p.id_comarca\n"
                    + "         and a.id_advogado=p.id_advogado\n"
                    + "         and S.id_secretaria = p.id_secretaria\n"
                    + "         and p.num_processo = num_processo order by p.id_processo ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Processo = rs.getInt("id_processo");
                String num_processo = rs.getString("num_processo");
                String Descricao = rs.getString("Descriçao");
                LocalDate dt_Inicio = rs.getDate("dt_inicio").toLocalDate();
                LocalDate dt_Fim = rs.getDate("dt_fim").toLocalDate();
                Float vl_Causa = rs.getFloat("vl_causa");
                int id_Clientes = rs.getInt("id_Cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                Processo processo = new Processo(id_Processo, num_processo, Descricao, dt_Inicio, dt_Fim, vl_Causa, clientePesquisapesquisa, advogadoPesquisa, secretariaPesquisa, comarcaPesquisa);
                processos.add(processo);

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
        return processos;

    }

    public List<Processo> processoPesquisaCadastroAux(int id_processo) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<Processo>();

        try {
            String sqlSelect = "select p.id_processo , p.num_processo ,p.descriçao,p.dt_inicio,p.dt_fim, p.vl_causa,\n"
                    + "              Cl.nome_cliente,a.nome, s.nome_secretaria,Co.Nome_comarca ,\n"
                    + "              Cl.id_cliente,a.id_advogado,s.id_secretaria,Co.id_comarca	   \n"
                    + "              from processo P , comarca Co ,cliente Cl ,advogado a,secretaria s\n"
                    + "              where  Cl.id_cliente = p.id_cliente \n"
                    + "              and Co.id_comarca=p.id_comarca\n"
                    + "              and a.id_advogado=p.id_advogado\n"
                    + "              and S.id_secretaria = p.id_secretaria\n"
                    + "              and p.id_processo = ? order by p.id_processo";
            st = con.prepareStatement(sqlSelect);
            st.setInt(1, id_processo);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Processo = rs.getInt("id_processo");
                String num_processo = rs.getString("num_processo");
                String Descricao = rs.getString("Descriçao");
                LocalDate dt_Inicio = rs.getDate("dt_inicio").toLocalDate();
                LocalDate dt_Fim = rs.getDate("dt_fim").toLocalDate();
                Float vl_Causa = rs.getFloat("vl_causa");
                int id_Clientes = rs.getInt("id_Cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                Processo processo = new Processo(id_Processo, num_processo, Descricao, dt_Inicio, dt_Fim, vl_Causa, clientePesquisapesquisa, advogadoPesquisa, secretariaPesquisa, comarcaPesquisa);
                processos.add(processo);

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
        return processos;

    }

    public List<Processo> processoPesquisaGrid() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<Processo>();

        try {
            String sqlSelect = "select p.id_processo , p.num_processo ,p.descriçao,p.dt_inicio,p.dt_fim, p.vl_causa,\n"
                    + "         Cl.nome_cliente,a.nome, s.nome_secretaria,Co.Nome_comarca ,\n"
                    + "		Cl.id_cliente,a.id_advogado,s.id_secretaria,Co.id_comarca	   \n"
                    + "         from processo P , comarca Co ,cliente Cl ,advogado a,secretaria s\n"
                    + "         where  Cl.id_cliente = p.id_cliente \n"
                    + "         and Co.id_comarca=p.id_comarca\n"
                    + "         and a.id_advogado=p.id_advogado\n"
                    + "         and S.id_secretaria = p.id_secretaria\n"
                    + "         and p.num_processo = num_processo order by p.id_processo";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Processo = rs.getInt("id_processo");
                String num_processo = rs.getString("num_processo");
                String Descricao = rs.getString("Descriçao");
                LocalDate dt_Inicio = rs.getDate("dt_inicio").toLocalDate();
                LocalDate dt_Fim = rs.getDate("dt_fim").toLocalDate();
                Float vl_Causa = rs.getFloat("vl_causa");

                int id_Clientes = rs.getInt("id_Cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                Processo processo = new Processo(id_Processo, num_processo, Descricao, dt_Inicio, dt_Fim, vl_Causa, clientePesquisapesquisa, advogadoPesquisa, secretariaPesquisa, comarcaPesquisa);
                processos.add(processo);

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
        return processos;

    }

    public List<Processo> clientePesquisar(String nomeProcesso) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Processo> processoPesquisa = new ArrayList<Processo>();

        try {
            String sqlSelect = "select p.id_processo , p.num_processo ,p.descriçao,p.dt_inicio,p.dt_fim, p.vl_causa,\n"
                    + "              Cl.nome_cliente,a.nome, s.nome_secretaria,Co.Nome_comarca ,\n"
                    + "              Cl.id_cliente,a.id_advogado,s.id_secretaria,Co.id_comarca	   \n"
                    + "              from processo P , comarca Co ,cliente Cl ,advogado a,secretaria s\n"
                    + "              where  Cl.id_cliente = p.id_cliente \n"
                    + "              and Co.id_comarca=p.id_comarca\n"
                    + "              and a.id_advogado=p.id_advogado\n"
                    + "              and s.id_secretaria = p.id_secretaria\n"
                    + "              and num_processo like ? order by p.id_processo; ";

            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nomeProcesso + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Processo = rs.getInt("id_processo");
                String num_processo = rs.getString("num_processo");
                String Descricao = rs.getString("Descriçao");
                LocalDate dt_Inicio = rs.getDate("dt_inicio").toLocalDate();
                LocalDate dt_Fim = rs.getDate("dt_fim").toLocalDate();
                Float vl_Causa = rs.getFloat("vl_causa");
                int id_Clientes = rs.getInt("id_Cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                Processo processo = new Processo(id_Processo, num_processo, Descricao, dt_Inicio, dt_Fim, vl_Causa, clientePesquisapesquisa, advogadoPesquisa, secretariaPesquisa, comarcaPesquisa);
                processoPesquisa.add(processo);

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
        return processoPesquisa;

    }

    public List<Processo> Pesquisarconsultar() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Processo> listaProcessos = new ArrayList<Processo>();
        try {
            String sqlSelect = "select id_processo , num_processo ,descriçao,dt_inicio,dt_fim, vl_causa \n"
                    + "	,nome_cliente  ,nome , nome_secretaria ,Nome_comarca\n"
                    + "	from processo , comarca,cliente,advogado, escritorio,secretaria\n"
                    + "	where cliente.id_cliente = processo.id_cliente \n"
                    + "	and comarca.id_comarca=processo.id_comarca\n"
                    + "	and advogado.id_advogado=processo.id_advogado\n"
                    + "	and escritorio.id_escritorio=advogado.id_escritorio \n"
                    + "	and secretaria.id_secretaria = processo.id_secretaria\n"
                    + "	and processo.num_processo like ? order by id_processo";

            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id_Processo = rs.getInt("id_processo");
                String num_processo = rs.getString("num_processo");
                String Descricao = rs.getString("Descriçao");
                LocalDate dt_Inicio = rs.getDate("dt_inicio").toLocalDate();
                LocalDate dt_Fim = rs.getDate("dt_fim").toLocalDate();
                Float vl_Causa = rs.getFloat("vl_causa");

                int id_Clientes = rs.getInt("id_Cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                Processo processo = new Processo(id_Processo, num_processo, Descricao, dt_Inicio, dt_Fim, vl_Causa, clientePesquisapesquisa, advogadoPesquisa, secretariaPesquisa, comarcaPesquisa);
                listaProcessos.add(processo);
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
        return listaProcessos;
    }

    public Processo GetBy(int id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Processo processos = new Processo();
        try {
            String sqlSelect = "select p.id_processo , p.num_processo ,p.descriçao,p.dt_inicio,p.dt_fim, p.vl_causa,\n"
                    + "              Cl.nome_cliente,a.nome, s.nome_secretaria,Co.Nome_comarca ,\n"
                    + "              Cl.id_cliente,a.id_advogado,s.id_secretaria,Co.id_comarca	   \n"
                    + "              from processo P , comarca Co ,cliente Cl ,advogado a,secretaria s\n"
                    + "              where  Cl.id_cliente = p.id_cliente \n"
                    + "              and Co.id_comarca=p.id_comarca\n"
                    + "              and a.id_advogado=p.id_advogado\n"
                    + "              and S.id_secretaria = p.id_secretaria\n"
                    + "              and p.id_processo = ? order by p.id_processo";

            ps = con.prepareStatement(sqlSelect);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                processos.setId_processo(rs.getInt("id_processo"));
                processos.setNum_processo(rs.getString("num_processo"));
                processos.setDescricao(rs.getString("Descriçao"));
                processos.setDt_inicio(rs.getDate("dt_inicio").toLocalDate());
                processos.setDt_fim(rs.getDate("dt_fim").toLocalDate());
                processos.setVl_causa(rs.getFloat("vl_causa"));

                int id_Clientes = rs.getInt("id_cliente");
                String nome_clientes = rs.getString("nome_cliente");
                ClientePesquisa clientePesquisapesquisa = new ClientePesquisa(id_Clientes, nome_clientes);

                processos.setCliente(clientePesquisapesquisa);

                int id_advogados = rs.getInt("id_advogado");
                String nome_advogados = rs.getString("nome");
                AdvogadoPesquisa advogadoPesquisa = new AdvogadoPesquisa(id_advogados, nome_advogados);

                processos.setAdvogado(advogadoPesquisa);

                int id_secretarias = rs.getInt("id_secretaria");
                String nome_secretarias = rs.getString("nome_secretaria");
                SecretariaPesquisa secretariaPesquisa = new SecretariaPesquisa(id_secretarias, nome_secretarias);

                processos.setSecretaria(secretariaPesquisa);

                int id_comarcas = rs.getInt("id_comarca");
                String nome_comarcas = rs.getString("nome_comarca");
                ComarcaPesquisa comarcaPesquisa = new ComarcaPesquisa(id_comarcas, nome_comarcas);

                processos.setComarca(comarcaPesquisa);

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
        return processos;
    }

//   
}
