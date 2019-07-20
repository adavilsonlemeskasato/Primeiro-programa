/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOCliente;
import Model.bean.Cliente;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adavilson
 */
public final class TelaCadastroCliente extends javax.swing.JInternalFrame {

    ArrayList<Cliente> ListaCadastroCliente;
    DAOCliente daoCliente = new DAOCliente();

    String Modo;
    int index;
    int numero;
    int aux;
    String nomePesquisa;
    int listaCadastroClickAnntiga;
    int listaCadastroClickNova;
    DAOCliente daoClientes = new DAOCliente();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroCliente() {
        this.setLocationRelativeTo(null);
        initComponents();
        ListaCadastroCliente = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioCliente();

    }

    private void limparFormularioCliente() {

        txtNomedeCliente.setText("");
        txtCPF.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtNumerocasa.setText("");
        txtEndereco.setText("");

    }

    public void ListaDeCadastroDaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroCliente.getModel();
        modelo.setNumRows(0);

        for (Cliente clientes : daoCliente.clienteConsultar()) {

            modelo.addRow(new Object[]{
                clientes.getId_cliente(),
                clientes.getNome_cliente(),
                clientes.getCpf(),
                clientes.getEmail(),
                clientes.getTelefone(),
                clientes.getNun_casa(),
                clientes.getEndereco(),});

        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String cpfCliente) {
        DefaultTableModel modelo2 = (DefaultTableModel) jTableCadastroCliente.getModel();
        modelo2.setNumRows(0);

        for (Cliente clientes : daoCliente.clientePesquisar(cpfCliente)) {

            modelo2.addRow(new Object[]{
                clientes.getId_cliente(),
                clientes.getNome_cliente(),
                clientes.getCpf(),
                clientes.getEmail(),
                clientes.getTelefone(),
                clientes.getNun_casa(),
                clientes.getEndereco()
            });

            listaCadastroClickAnntiga = clientes.getId_cliente();
            nomePesquisa = clientes.getCpf();
            listaCadastroClickNova = listaCadastroClickAnntiga;
        }
        jTableCadastroCliente.setModel(modelo2);
    }

    public void ManipulaInterface() {

        switch (Modo) {
            case "PesquisaClick":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedeCliente.setEnabled(true);
                txtCPF.setEnabled(true);
                txtEmail.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtNumerocasa.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;
            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedeCliente.setEnabled(false);
                txtCPF.setEnabled(false);
                txtEmail.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtNumerocasa.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedeCliente.setEnabled(false);
                txtCPF.setEnabled(false);
                txtEmail.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtNumerocasa.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;

            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedeCliente.setEnabled(true);
                txtCPF.setEnabled(true);
                txtEmail.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtNumerocasa.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);

                txtNomedeCliente.setEnabled(true);
                txtCPF.setEnabled(true);
                txtEmail.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtNumerocasa.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedeCliente.setEnabled(false);
                txtCPF.setEnabled(false);
                txtEmail.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtNumerocasa.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedeCliente.setEnabled(false);
                txtCPF.setEnabled(false);
                txtEmail.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtNumerocasa.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;

            default:
                System.out.println("Modo Invalido!!!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        BotaoSalvar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JToggleButton();
        BotaoNovo = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNomedeCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtNumerocasa = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        BotaoPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        BotaoRelatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroCliente = new javax.swing.JTable();

        jButton5.setText("jButton5");

        jLabel10.setText("jLabel10");

        jTextField5.setText("jTextField5");

        setClosable(true);
        setMaximizable(true);
        setVisible(false);

        BotaoSalvar.setText("Salvar");
        BotaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvarActionPerformed(evt);
            }
        });

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        BotaoNovo.setText("Novo");
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoEditar.setText("Editar");
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Dados"));
        jPanel2.setToolTipText("");

        txtNomedeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomedeClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Secretaria:");

        jLabel3.setText("CPF:");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel5.setText("E-mail");

        jLabel6.setText("Telefone");

        jLabel7.setText("Numero casa");

        jLabel8.setText("Endereço");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomedeCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumerocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomedeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumerocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        BotaoPesquisar.setText("Pesquisa");
        BotaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoPesquisarMouseClicked(evt);
            }
        });
        BotaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisarActionPerformed(evt);
            }
        });

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });

        BotaoRelatorio.setText("Relatorio");
        BotaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setText("Cadastro Cliente");

        jLabel4.setText("CPF Cliente");

        jTableCadastroCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome cliente", "CPF", "Email", "Telefone", "Numero Casa", "Endereco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroCliente.setToolTipText("");
        jTableCadastroCliente.setCellSelectionEnabled(true);
        jTableCadastroCliente.setDoubleBuffered(true);
        jTableCadastroCliente.setDragEnabled(true);
        jTableCadastroCliente.setEditingColumn(0);
        jTableCadastroCliente.setEditingRow(0);
        jTableCadastroCliente.setFillsViewportHeight(true);
        jTableCadastroCliente.setFocusCycleRoot(true);
        jTableCadastroCliente.setFocusTraversalPolicyProvider(true);
        jTableCadastroCliente.setInheritsPopupMenu(true);
        jTableCadastroCliente.getTableHeader().setResizingAllowed(false);
        jTableCadastroCliente.getTableHeader().setReorderingAllowed(false);
        jTableCadastroCliente.setUpdateSelectionOnSort(false);
        jTableCadastroCliente.setVerifyInputWhenFocusTarget(false);
        jTableCadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoPesquisar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jLabel2)))
                .addGap(0, 491, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(BotaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoCancelar)
                        .addGap(13, 13, 13)
                        .addComponent(BotaoRelatorio)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListCliente() {
        java.util.List<Cliente> listaCliente = daoCliente.clienteConsultar();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome Cliente");
        modelo.addColumn("CPF");
        modelo.addColumn("EMAIL");
        modelo.addColumn("TELEFONE");
        modelo.addColumn("NUMERO CASA");
        modelo.addColumn("ENDERECO");

        for (Cliente ClienteLista : listaCliente) {

            Object Linha[] = new Object[]{ClienteLista.getId_cliente(), ClienteLista.getNome_cliente(), ClienteLista.getCpf(),
                ClienteLista.getEmail(), ClienteLista.getTelefone(), ClienteLista.getNun_casa(), ClienteLista.getEndereco()};
            modelo.addRow(Linha);

        }

        jTableCadastroCliente.getTableHeader().setReorderingAllowed(false);
        jTableCadastroCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(600);
        jTableCadastroCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableCadastroCliente.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableCadastroCliente.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableCadastroCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableCadastroCliente.getColumnModel().getColumn(6).setPreferredWidth(150);

        jTableCadastroCliente.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Cliente> ListaCadastroCliente = daoCliente.clienteConsultar();

        index = jTableCadastroCliente.getSelectedRow();

        if (Modo.equals("Novo")) {

            Cliente cliente = new Cliente(numero, txtNomedeCliente.getText(), txtCPF.getText(), txtEmail.getText(), txtTelefone.getText(), txtNumerocasa.getText(), txtEndereco.getText());

            if (ListaCadastroCliente == ListaCadastroCliente) {
                ListaCadastroCliente.add(cliente);
                DAOCliente daoClientesJTable = new DAOCliente();
                daoClientesJTable.inserir(cliente);
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

                ListCliente();

                limparFormularioCliente();
                Modo = "Navegar";
                ManipulaInterface();

            }
        } else if (Modo.equals("Editar")) {

            index = aux;
            numero = (Integer) jTableCadastroCliente.getValueAt(index, 0);
            DAOCliente daoClienteJTable = new DAOCliente();
            if (index >= 0 && index < ListaCadastroCliente.size()) {
                Cliente cliente = new Cliente(numero, txtNomedeCliente.getText(), txtCPF.getText(), txtEmail.getText(), txtTelefone.getText(), txtNumerocasa.getText(), txtEndereco.getText());

                ListaCadastroCliente.get(index).setNome_cliente(txtNomedeCliente.getText());
                ListaCadastroCliente.get(index).setCpf(txtCPF.getText());
                ListaCadastroCliente.get(index).setEmail(txtEmail.getText());
                ListaCadastroCliente.get(index).setTelefone(txtTelefone.getText());
                ListaCadastroCliente.get(index).setNun_casa(txtNumerocasa.getText());
                ListaCadastroCliente.get(index).setEndereco(txtEndereco.getText());

                ListaCadastroCliente.add(cliente);

                daoClienteJTable.alterar(cliente);
                ListCliente();
            }

            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");

            limparFormularioCliente();
            Modo = "Navegar";
            ManipulaInterface();

        }


    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        limparFormularioCliente();
        Modo = "Navegar";
        ManipulaInterface();

        if (JOptionPane.showConfirmDialog(null, "Quer realmente sair ?", " ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.dispose();
        } else {

        }

    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        ListCliente();
        limparFormularioCliente();
        Modo = "Novo";
        ManipulaInterface();

    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        Modo = "Editar";
        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        index = aux;
        numero = (Integer) jTableCadastroCliente.getValueAt(index, 0);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Cliente ", " Atenção",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOCliente daoCLiente = new DAOCliente();
            daoCLiente.Deletar(numero);

            limparFormularioCliente();

            ListaDeCadastroDaTabela();

            Modo = "Navegar";
            ManipulaInterface();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNomedeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedeClienteActionPerformed

    }//GEN-LAST:event_txtNomedeClienteActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
        ListaDeCadastroDaTabelaPesquisar(txtPesquisar.getText());

        txtPesquisar.setText("");
        Modo = "Pesquisar";
        ManipulaInterface();
    }//GEN-LAST:event_BotaoPesquisarActionPerformed

    private void BotaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioActionPerformed
        MessageFormat titulo = new MessageFormat("Relatório de Clientes");
        MessageFormat t = new MessageFormat("t");
        try {
            jTableCadastroCliente.print(JTable.PrintMode.FIT_WIDTH, titulo, t);
        } catch (PrinterException ex) {
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BotaoRelatorioActionPerformed

    private void BotaoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseClicked

    }//GEN-LAST:event_BotaoPesquisarMouseClicked

    private void jTableCadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroClienteMouseClicked

        Object obj = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 1);
        String nomeCliente = obj.toString();

        txtNomedeCliente.setText(nomeCliente);

        Object obj1 = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 2);
        String cpf = obj1.toString();

        txtCPF.setText(cpf);

        Object obj2 = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 3);
        String email = obj2.toString();
        txtEmail.setText(email);

        Object obj3 = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 4);
        String telefone = obj3.toString();
        txtTelefone.setText(telefone);

        Object obj4 = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 5);
        String numcasa = obj4.toString();
        txtNumerocasa.setText(numcasa);

        Object obj5 = jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 6);
        String endereco = obj5.toString();
        txtEndereco.setText(endereco);

        Modo = "Selecao";
        ManipulaInterface();
    }//GEN-LAST:event_jTableCadastroClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoRelatorio;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroCliente;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomedeCliente;
    private javax.swing.JTextField txtNumerocasa;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
