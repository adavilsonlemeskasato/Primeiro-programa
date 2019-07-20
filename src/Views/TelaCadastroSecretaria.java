/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOSecrataria;
import Model.bean.Secretaria;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adavilson
 */
public final class TelaCadastroSecretaria extends javax.swing.JInternalFrame {

    ArrayList<Secretaria> ListaCadastroSecretaria;
    DAOSecrataria daoSecretaria = new DAOSecrataria();
    String Modo;
    int index;
    int numero;
    int aux;
    String nomePesquisa;
    DAOSecrataria daosecretaria = new DAOSecrataria();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroSecretaria() {

        this.setLocationRelativeTo(null);
        initComponents();
        ListaCadastroSecretaria = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioSecretaria();

    }

    private void limparFormularioSecretaria() {
        txtNomedeSecretaria.setText("");
        txtCPF.setText("");
        txtLoginSecretaria.setText("");
        txtSenha.setText("");

    }

    public void ListaDeCadastroDaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroSecretaria.getModel();
        modelo.setNumRows(0);

        for (Secretaria secretarias : daosecretaria.secretariaConsultar()) {

            modelo.addRow(new Object[]{
                secretarias.getId_secretaria(),
                secretarias.getNome_secretaria(),
                secretarias.getCpf(),});

        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String nomeCliente) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroSecretaria.getModel();
        modelo.setNumRows(0);

        for (Secretaria secretarias : daoSecretaria.secretariasPesquisar(nomeCliente)) {

            modelo.addRow(new Object[]{
                secretarias.getId_secretaria(),
                secretarias.getNome_secretaria(),
                secretarias.getCpf(),});
            nomePesquisa = secretarias.getNome_secretaria();
        }

    }

    public void ManipulaInterface() {

        switch (Modo) {
            case "PesquisaClick":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedeSecretaria.setEnabled(true);
                txtCPF.setEnabled(true);
                txtLoginSecretaria.setEnabled(true);
                txtSenha.setEnabled(true);
                break;
            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedeSecretaria.setEnabled(false);
                txtCPF.setEnabled(false);
                txtLoginSecretaria.setEnabled(false);
                txtSenha.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);
                txtNomedeSecretaria.setEnabled(false);
                txtCPF.setEnabled(false);
                txtLoginSecretaria.setEnabled(false);
                txtSenha.setEnabled(false);

                break;

            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);
                txtNomedeSecretaria.setEnabled(true);
                txtCPF.setEnabled(true);
                txtLoginSecretaria.setEnabled(true);
                txtSenha.setEnabled(true);
                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);
                txtNomedeSecretaria.setEnabled(true);
                txtCPF.setEnabled(true);
                txtLoginSecretaria.setEnabled(true);
                txtSenha.setEnabled(true);
                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);
                txtNomedeSecretaria.setEnabled(false);
                txtCPF.setEnabled(false);
                txtLoginSecretaria.setEnabled(false);
                txtSenha.setEnabled(false);
                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);
                txtNomedeSecretaria.setEnabled(false);
                txtCPF.setEnabled(false);
                txtLoginSecretaria.setEnabled(false);
                txtSenha.setEnabled(false);
                break;

            default:
                System.out.println("Modo Invalido!!!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        BotaoSalvar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroSecretaria = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNomedeSecretaria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLoginSecretaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        BotaoPesquisar = new javax.swing.JButton();

        jButton5.setText("jButton5");

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

        jTableCadastroSecretaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroSecretaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome Secretaria", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroSecretaria.setToolTipText("");
        jTableCadastroSecretaria.setDoubleBuffered(true);
        jTableCadastroSecretaria.setDragEnabled(true);
        jTableCadastroSecretaria.setEditingColumn(0);
        jTableCadastroSecretaria.setEditingRow(0);
        jTableCadastroSecretaria.setFillsViewportHeight(true);
        jTableCadastroSecretaria.setFocusCycleRoot(true);
        jTableCadastroSecretaria.setFocusTraversalPolicyProvider(true);
        jTableCadastroSecretaria.setInheritsPopupMenu(true);
        jTableCadastroSecretaria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCadastroSecretaria.getTableHeader().setResizingAllowed(false);
        jTableCadastroSecretaria.getTableHeader().setReorderingAllowed(false);
        jTableCadastroSecretaria.setUpdateSelectionOnSort(false);
        jTableCadastroSecretaria.setVerifyInputWhenFocusTarget(false);
        jTableCadastroSecretaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroSecretariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroSecretaria);
        if (jTableCadastroSecretaria.getColumnModel().getColumnCount() > 0) {
            jTableCadastroSecretaria.getColumnModel().getColumn(0).setResizable(false);
            jTableCadastroSecretaria.getColumnModel().getColumn(1).setResizable(false);
            jTableCadastroSecretaria.getColumnModel().getColumn(1).setPreferredWidth(600);
            jTableCadastroSecretaria.getColumnModel().getColumn(2).setResizable(false);
            jTableCadastroSecretaria.getColumnModel().getColumn(2).setPreferredWidth(150);
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

        txtNomedeSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomedeSecretariaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Secretaria:");

        jLabel3.setText("CPF:");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel2.setText("Login Secretaria:");

        txtLoginSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginSecretariaActionPerformed(evt);
            }
        });

        jLabel4.setText("Senha:");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(txtNomedeSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLoginSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomedeSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLoginSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel5.setText("Cadastro Secretaria");

        jLabel6.setText("Nome Secretaria");

        BotaoPesquisar.setText("Pesquisa");
        BotaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(BotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotaoPesquisar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(jLabel5)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addGap(10, 10, 10)
                        .addComponent(BotaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoPesquisar))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomedeSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedeSecretariaActionPerformed


    }//GEN-LAST:event_txtNomedeSecretariaActionPerformed

    public void ListSecretaria() {
        java.util.List<Secretaria> lista = daoSecretaria.secretariaConsultar();
//        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Nome Secretaria", "CPF", "Login Secretaria", "Senha"}, 0);

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome Secretaria");
        modelo.addColumn("CPF");

        for (Secretaria secretariaLista : lista) {

            Object Linha[] = new Object[]{secretariaLista.getId_secretaria(), secretariaLista.getNome_secretaria(), secretariaLista.getCpf(),};
            modelo.addRow(Linha);

        }

        jTableCadastroSecretaria.getTableHeader().setReorderingAllowed(false);
        jTableCadastroSecretaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCadastroSecretaria.getColumnModel().getColumn(1).setPreferredWidth(600);
        jTableCadastroSecretaria.getColumnModel().getColumn(2).setPreferredWidth(150);

        jTableCadastroSecretaria.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Secretaria> ListaCadastroSecretaria = daoSecretaria.secretariaConsultar();
        String senha = new String(txtSenha.getPassword());
        index = jTableCadastroSecretaria.getSelectedRow();

        if (Modo.equals("Novo")) {

            Secretaria secretaria = new Secretaria(numero, txtNomedeSecretaria.getText(), txtCPF.getText(), txtLoginSecretaria.getText(), Integer.parseInt(senha));
            ListaCadastroSecretaria.add(secretaria);

            DAOSecrataria daoSecretria = new DAOSecrataria();
            daoSecretria.inserir(secretaria);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

            ListSecretaria();

            limparFormularioSecretaria();
            Modo = "Navegar";
            ManipulaInterface();

        } else if (Modo.equals("Editar")) {

            index = aux;
            numero = (Integer) jTableCadastroSecretaria.getValueAt(index, 0);
            DAOSecrataria daoSecretria = new DAOSecrataria();
            if (index >= 0 && index < ListaCadastroSecretaria.size()) {
                Secretaria secretaria = new Secretaria(numero, txtNomedeSecretaria.getText(), txtCPF.getText(), txtLoginSecretaria.getText(), Integer.parseInt(senha));

                ListaCadastroSecretaria.get(index).setNome_secretaria(txtNomedeSecretaria.getText());
                ListaCadastroSecretaria.get(index).setCpf(txtCPF.getText());
                ListaCadastroSecretaria.get(index).setLogin_secretaria(txtLoginSecretaria.getText());
                ListaCadastroSecretaria.get(index).setSenha(Integer.parseInt(senha));

                ListaCadastroSecretaria.add(secretaria);

                daoSecretria.alterar(secretaria);
                ListSecretaria();
            }

            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");

            limparFormularioSecretaria();
            Modo = "Navegar";
            ManipulaInterface();

        }

//        

    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void txtLoginSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginSecretariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginSecretariaActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        limparFormularioSecretaria();
        Modo = "Navegar";
        ManipulaInterface();

        if (JOptionPane.showConfirmDialog(null, "Quer realmente sair Sim?", " Não",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.dispose();
        } else {

        }

    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        ListSecretaria();
        limparFormularioSecretaria();
        Modo = "Novo";
        ManipulaInterface();

    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        txtSenha.setText("");
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void jTableCadastroSecretariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroSecretariaMouseClicked
        java.util.List<Secretaria> ListaCadastroSecretaria = daoSecretaria.secretariaConsultar();

        index = jTableCadastroSecretaria.getSelectedRow();
        aux = index;

        if (index >= 0 && index < ListaCadastroSecretaria.size()) {

            Secretaria Secretaria = ListaCadastroSecretaria.get(index);

            txtNomedeSecretaria.setText((Secretaria.getNome_secretaria()));
            txtCPF.setText((Secretaria.getCpf()));
            txtLoginSecretaria.setText((Secretaria.getLogin_secretaria()));
            txtSenha.setText(String.valueOf(Secretaria.getSenha()));
            Modo = "Selecao";
            ManipulaInterface();
        }


    }//GEN-LAST:event_jTableCadastroSecretariaMouseClicked

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        Modo = "Editar";
        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        index = aux;
        numero = (Integer) jTableCadastroSecretaria.getValueAt(index, 0);
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Secretaria ", " ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOSecrataria dAOSecrataria = new DAOSecrataria();
            dAOSecrataria.Deletar(numero);

            limparFormularioSecretaria();

            ListaDeCadastroDaTabela();

            Modo = "Navegar";
            ManipulaInterface();
        } else {

        }


    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
        ListaDeCadastroDaTabelaPesquisar(txtPesquisar.getText());
        index = aux;
        txtPesquisar.setText("");
        Modo = "Pesquisar";
        ManipulaInterface();
    }//GEN-LAST:event_BotaoPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroSecretaria;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtLoginSecretaria;
    private javax.swing.JTextField txtNomedeSecretaria;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
