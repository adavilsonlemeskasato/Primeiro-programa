package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Cliente;
import Model.bean.ClientePesquisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends DAOBase {

    public void inserir(Cliente cliente) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into cliente ( nome_cliente,cpf,email, telefone,  num_casa,endereco) values (?,?,?,?,?,?)";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cliente.getNome_cliente());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getNun_casa());
            ps.setString(6, cliente.getEndereco());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int Id_cliente = rs.getInt(1);
                cliente.setId_cliente(Id_cliente);
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

    public void Deletar(int clienteID) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "delete  from cliente where id_cliente=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, clienteID);
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

    public void alterar(Cliente cliente) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update cliente set  nome_cliente=?,cpf=?,email=?, telefone=?,  num_casa=?,endereco=? where id_cliente = ?";

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cliente.getNome_cliente());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getNun_casa());
            ps.setString(6, cliente.getEndereco());
            ps.setInt(7, cliente.getId_cliente());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final int Id_cliente = rs.getInt(1);
                cliente.setId_cliente(Id_cliente);
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
            String sqlSelect = "select * from cliente  order by id_cliente ";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {

                int id_Cliente = rs.getInt("id_cliente");
                String nome_CLiente = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String numeroCasa = rs.getString("num_casa");
                String endereco = rs.getString("endereco");

                System.out.println(id_Cliente + " - " + nome_CLiente + " - " + cpf + " - " + email + " - " + telefone + " - " + numeroCasa + " - " + endereco);

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

    public List<Cliente> clienteConsultar() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            String sqlSelect = "select * from cliente  order by id_cliente ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Cliente = rs.getInt("id_cliente");
                String nome_CLiente = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String numeroCasa = rs.getString("num_casa");
                String endereco = rs.getString("endereco");
                Cliente cliente = new Cliente(id_Cliente, nome_CLiente, cpf, email, telefone, numeroCasa, endereco);
                clientes.add(cliente);

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
        return clientes;

    }

    public List<Cliente> clientePesquisarLista() {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            String sqlSelect = "select * from cliente  order by id_cliente ";
            st = con.prepareStatement(sqlSelect);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Cliente = rs.getInt("id_cliente");
                String nome_CLiente = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String numeroCasa = rs.getString("num_casa");
                String endereco = rs.getString("endereco");
                Cliente cliente = new Cliente(id_Cliente, nome_CLiente, cpf, email, telefone, numeroCasa, endereco);
                clientes.add(cliente);

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
        return clientes;

    }

    public List<Cliente> clientePesquisar(String nomeCliente) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Cliente> clientePesquisa = new ArrayList<Cliente>();

        try {
            String sqlSelect = "select * from cliente where cpf like ? order by id_cliente ";
            st = con.prepareStatement(sqlSelect);
            st.setString(1, "%" + nomeCliente + "%");
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Cliente = rs.getInt("id_cliente");
                String nome_CLiente = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String numeroCasa = rs.getString("num_casa");
                String endereco = rs.getString("endereco");
                Cliente cliente = new Cliente(id_Cliente, nome_CLiente, cpf, email, telefone, numeroCasa, endereco);
                clientePesquisa.add(cliente);

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
        return clientePesquisa;

    }

    public List<Cliente> clientePesquisaClick(int nomeCliente) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            String sqlSelect = "select * from cliente where id_cliente = ? order by id_cliente ";
            st = con.prepareStatement(sqlSelect);
            st.setInt(1, nomeCliente);
            rs = st.executeQuery();

            while (rs.next()) {

                int id_Cliente = rs.getInt("id_cliente");
                String nome_CLiente = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String numeroCasa = rs.getString("num_casa");
                String endereco = rs.getString("endereco");
                Cliente cliente = new Cliente(id_Cliente, nome_CLiente, cpf, email, telefone, numeroCasa, endereco);
                clientes.add(cliente);

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
        return clientes;

    }
    
    
    public List<ClientePesquisa> consultarEspecial() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClientePesquisa> listaSecretariasEspeciais = new ArrayList<ClientePesquisa>();
        try {
            String sqlSelect = "select * from cliente";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nome_cliente = rs.getString("nome_cliente");

                ClientePesquisa clientePesquisa = new ClientePesquisa(id_cliente, nome_cliente);
                listaSecretariasEspeciais.add(clientePesquisa);
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
