/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOCliente;
import Model.bean.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adavilson
 */
public final class TelaHonorario extends javax.swing.JInternalFrame {

//    ArrayList<Cliente> ListaCadastroCliente;
//    DAOCliente daoCliente = new DAOCliente();
//
//    String Modo;
//    int index;
//    int numero;
//    int aux;
//    DAOCliente daoClientes = new DAOCliente();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaHonorario() {
//        java.util.List<Secretaria> ListaCadastroSecretaria = daoSecretaria.secretariaConsultar();
//        this.setLocationRelativeTo(null);
//        initComponents();
//        ListaCadastroCliente = new ArrayList();
//        ListaDeCadastroDaTabela();
//        Modo = "Navegar";
//        ManipulaInterface();
//        limparFormularioCliente();

    }

    private void limparFormularioCliente() {

//        txtNomedeComarca.setText(" ");
//        txtCPF.setText(" ");
//        txtEmail.setText(" ");
//        txtTelefone.setText(" ");
//        txtNumerocasa.setText(" ");
//        txtEndereco.setText(" ");

    }

    public void ListaDeCadastroDaTabela() {
//        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroCliente.getModel();
//        modelo.setNumRows(0);
//
//        for (Cliente clientes : daoCliente.clienteConsultar()) {
//
//            modelo.addRow(new Object[]{
//                clientes.getId_cliente(),
//                clientes.getNome_cliente(),
//                clientes.getCpf(),
//                clientes.getEmail(),
//                clientes.getTelefone(),
//                clientes.getNun_casa(),
//                clientes.getEndereco(),});
//
//        }

    }

    public void ManipulaInterface() {

//        switch (Modo) {
//            case "Navegar":
//                BotaoCancelar.setEnabled(false);
//                BotaoSalvar.setEnabled(false);
//                BotaoNovo.setEnabled(true);
//                BotaoEditar.setEnabled(false);
//                BotaoExcluir.setEnabled(false);
//
//                txtNomedeCliente.setEnabled(false);
//                txtCPF.setEnabled(false);
//                txtEmail.setEnabled(false);
//                txtTelefone.setEnabled(false);
//                txtNumerocasa.setEnabled(false);
//                txtEndereco.setEnabled(false);
//                break;
//
//            case "Novo":
//                BotaoCancelar.setEnabled(true);
//                BotaoSalvar.setEnabled(true);
//                BotaoNovo.setEnabled(true);
//                BotaoEditar.setEnabled(false);
//                BotaoExcluir.setEnabled(false);
//
//                txtNomedeCliente.setEnabled(true);
//                txtCPF.setEnabled(true);
//                txtEmail.setEnabled(true);
//                txtTelefone.setEnabled(true);
//                txtNumerocasa.setEnabled(true);
//                txtEndereco.setEnabled(true);
//                break;
//
//            case "Editar":
//                BotaoCancelar.setEnabled(true);
//                BotaoSalvar.setEnabled(true);
//                BotaoNovo.setEnabled(false);
//                BotaoEditar.setEnabled(true);
//                BotaoExcluir.setEnabled(false);
//
//                txtNomedeCliente.setEnabled(true);
//                txtCPF.setEnabled(true);
//                txtEmail.setEnabled(true);
//                txtTelefone.setEnabled(true);
//                txtNumerocasa.setEnabled(true);
//                txtEndereco.setEnabled(true);
//                break;
//
//            case "Excluir":
//                BotaoCancelar.setEnabled(false);
//                BotaoSalvar.setEnabled(false);
//                BotaoNovo.setEnabled(true);
//                BotaoEditar.setEnabled(false);
//                BotaoExcluir.setEnabled(false);
//
//                txtNomedeCliente.setEnabled(false);
//                txtCPF.setEnabled(false);
//                txtEmail.setEnabled(false);
//                txtTelefone.setEnabled(false);
//                txtNumerocasa.setEnabled(false);
//                txtEndereco.setEnabled(false);
//                break;
//
//            case "Selecao":
//                BotaoCancelar.setEnabled(false);
//                BotaoSalvar.setEnabled(false);
//                BotaoNovo.setEnabled(true);
//                BotaoEditar.setEnabled(true);
//                BotaoExcluir.setEnabled(true);
//
//                txtNomedeCliente.setEnabled(false);
//                txtCPF.setEnabled(false);
//                txtEmail.setEnabled(false);
//                txtTelefone.setEnabled(false);
//                txtNumerocasa.setEnabled(false);
//                txtEndereco.setEnabled(false);
//                break;
//
//            default:
//                System.out.println("Modo Invalido!!!");
//        }
    }

//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BotaoSalvar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroCliente = new javax.swing.JTable();
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
        txtTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JTextField();
        txtTelefone2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jButton5.setText("jButton5");

        jLabel10.setText("jLabel10");

        jTextField5.setText("jTextField5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jTableCadastroCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data de Pagamento", "Valor", "Observação", "Advogado", "Processo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroCliente.setToolTipText("");
        jTableCadastroCliente.setDoubleBuffered(true);
        jTableCadastroCliente.setDragEnabled(true);
        jTableCadastroCliente.setEditingColumn(0);
        jTableCadastroCliente.setEditingRow(0);
        jTableCadastroCliente.setFillsViewportHeight(true);
        jTableCadastroCliente.setFocusCycleRoot(true);
        jTableCadastroCliente.setFocusTraversalPolicyProvider(true);
        jTableCadastroCliente.setInheritsPopupMenu(true);
        jTableCadastroCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
        if (jTableCadastroCliente.getColumnModel().getColumnCount() > 0) {
            jTableCadastroCliente.getColumnModel().getColumn(0).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableCadastroCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableCadastroCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

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

        jLabel1.setText("Data de Pagamento:");

        jLabel3.setText("Valor R$:");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel6.setText("Observação:");

        jLabel2.setText("Advogado:");

        jLabel4.setText("Processo:");

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
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(txtTelefone2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomedeCliente))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomedeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Cadastro Honorários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(517, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(23, 23, 23))))
            .addGroup(layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListCliente() {
//        java.util.List<Cliente> listaCliente = daoCliente.clienteConsultar();
//
//        DefaultTableModel modelo = new DefaultTableModel();
//
//        modelo.addColumn("ID");
//        modelo.addColumn("Nome Cliente");
//        modelo.addColumn("CPF");
//        modelo.addColumn("EMAIL");
//        modelo.addColumn("TELEFONE");
//        modelo.addColumn("NUMERO CASA");
//        modelo.addColumn("ENDERECO");
//
//        for (Cliente ClienteLista : listaCliente) {
//
//            Object Linha[] = new Object[]{ClienteLista.getId_cliente(), ClienteLista.getNome_cliente(), ClienteLista.getCpf(),
//                ClienteLista.getEmail(), ClienteLista.getTelefone(), ClienteLista.getNun_casa(), ClienteLista.getEndereco()};
//            modelo.addRow(Linha);
//
//        }
//        jTableCadastroCliente.getTableHeader().setReorderingAllowed(false);
//        jTableCadastroCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
//        jTableCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(600);
//        jTableCadastroCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
//        jTableCadastroCliente.getColumnModel().getColumn(3).setPreferredWidth(150);
//        jTableCadastroCliente.getColumnModel().getColumn(4).setPreferredWidth(100);
//        jTableCadastroCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
//        jTableCadastroCliente.getColumnModel().getColumn(6).setPreferredWidth(150);
//
//        jTableCadastroCliente.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
//        java.util.List<Cliente> ListaCadastroCliente = daoCliente.clienteConsultar();
//
//        index = jTableCadastroCliente.getSelectedRow();
//
//        if (Modo.equals("Novo")) {
//
//            Cliente cliente = new Cliente(numero, txtNomedeCliente.getText(), txtCPF.getText(), txtEmail.getText(), txtTelefone.getText(), txtNumerocasa.getText(), txtEndereco.getText());
//            ListaCadastroCliente.add(cliente);
//
//            DAOCliente daoClientesJTable = new DAOCliente();
//            daoClientesJTable.inserir(cliente);
//            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");
//
//            ListCliente();
//
//            limparFormularioCliente();
//            Modo = "Navegar";
//            ManipulaInterface();
//
//        } else if (Modo.equals("Editar")) {
//
//            index = aux;
//            numero = (Integer) jTableCadastroCliente.getValueAt(index, 0);
//            DAOCliente daoClienteJTable = new DAOCliente();
//            if (index >= 0 && index < ListaCadastroCliente.size()) {
//                Cliente cliente = new Cliente(numero, txtNomedeCliente.getText(), txtCPF.getText(), txtEmail.getText(), txtTelefone.getText(), txtNumerocasa.getText(), txtEndereco.getText());
//
//                ListaCadastroCliente.get(index).setNome_cliente(txtNomedeCliente.getText());
//                ListaCadastroCliente.get(index).setCpf(txtCPF.getText());
//                ListaCadastroCliente.get(index).setEmail(txtEmail.getText());
//                ListaCadastroCliente.get(index).setTelefone(txtTelefone.getText());
//                ListaCadastroCliente.get(index).setNun_casa(txtNumerocasa.getText());
//                ListaCadastroCliente.get(index).setEndereco(txtEndereco.getText());
//
//                ListaCadastroCliente.add(cliente);
//
//                daoClienteJTable.alterar(cliente);
//
//            }
//
//            ListCliente();
//            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");
//
//            limparFormularioCliente();
//            Modo = "Navegar";
//            ManipulaInterface();
//
//        }
//
//
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
//        limparFormularioCliente();
//        Modo = "Navegar";
//        ManipulaInterface();
//
//        if (JOptionPane.showConfirmDialog(null, "Quer realmente sair ?", " ",
//                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//
//            this.dispose();
//        } else {
//
//        }

    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
//        ListCliente();
//        limparFormularioCliente();
//        Modo = "Novo";
//        ManipulaInterface();

    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void jTableCadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroClienteMouseClicked
//        java.util.List<Cliente> ListaCadastroCliente = daoClientes.clienteConsultar();
//
//        index = jTableCadastroCliente.getSelectedRow();
//        aux = index;
//
//        if (index >= 0 && index < ListaCadastroCliente.size()) {
//
//            Cliente cliente = ListaCadastroCliente.get(index);
//
//            txtNomedeCliente.setText((cliente.getNome_cliente()));
//            txtCPF.setText((cliente.getCpf()));
//            txtEmail.setText((cliente.getEmail()));
//            txtTelefone.setText(cliente.getTelefone());
//            txtNumerocasa.setText(cliente.getNun_casa());
//            txtEndereco.setText((cliente.getEndereco()));
//
//            Modo = "Selecao";
//            ManipulaInterface();
//        }


    }//GEN-LAST:event_jTableCadastroClienteMouseClicked

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
//        Modo = "Editar";
//        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
//        index = aux;
//        numero = (Integer) jTableCadastroCliente.getValueAt(index, 0);
//
//        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Secretaria ", " ",
//                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//
//            DAOCliente daoCLiente = new DAOCliente();
//            daoCLiente.Deletar(numero);
//
//            limparFormularioCliente();
//
//            ListaDeCadastroDaTabela();
//
//            Modo = "Navegar";
//            ManipulaInterface();
//        } else {
//           JOptionPane.showMessageDialog(null, "erro");
//        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNomedeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedeClienteActionPerformed

    }//GEN-LAST:event_txtNomedeClienteActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroCliente;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtNomedeCliente;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefone1;
    private javax.swing.JTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
