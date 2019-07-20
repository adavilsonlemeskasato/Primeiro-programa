/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOEscritorio;
import DAOControleDeProcessosEDiligência.DAOSecrataria;
import Model.bean.Escritorio;
import Model.bean.Secretaria;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adavilson
 */
public final class TelaCadastroEscritorio extends javax.swing.JInternalFrame {

    ArrayList<Escritorio> ListaCadastroEscritorio;

    DAOEscritorio daoEscritorio = new DAOEscritorio();
    DAOSecrataria daoSecretaria = new DAOSecrataria();
    String Modo;
    int index;
    int numero;
    int aux;
    int nomePesquisaID;
    String nomePesquisa;
    String auxPesquisa;

    DAOEscritorio daoEscritorios = new DAOEscritorio();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroEscritorio() {

        this.setLocationRelativeTo(null);
        initComponents();
        carregarSecretaria();
        ListaCadastroEscritorio = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioEscritorio();

    }

    private void carregarSecretaria() {
        Object[] vetorCampus = daoSecretaria.consultarEspecial().toArray();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(vetorCampus);
        ComboBoxSecretaria.setModel(dcbm);
    }

    private void limparFormularioEscritorio() {

        txtNomedoEscritorio.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");

    }

    public void ListaDeCadastroDaTabela() {
        //Conseguir obter a lista do Banco de Dados.
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroEscritorio.getModel();
        modelo.setNumRows(0);

        for (Escritorio escritorios : daoEscritorio.escritorioConsultar()) {

            modelo.addRow(new Object[]{
                escritorios.getId_escritorio(),
                escritorios.getNome_advocacia(),
                escritorios.getTelefone(),
                escritorios.getEndereco(),
                escritorios.getSecretaria().getNome_secretaria()});
        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String nomeCliente) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroEscritorio.getModel();
        modelo.setNumRows(0);

        for (Escritorio ClienteEscritorio : daoEscritorio.escritorioPesquisa(nomeCliente)) {

            modelo.addRow(new Object[]{
                ClienteEscritorio.getId_escritorio(),
                ClienteEscritorio.getNome_advocacia(),
                ClienteEscritorio.getTelefone(),
                ClienteEscritorio.getEndereco(),
                ClienteEscritorio.getSecretaria().getNome_secretaria()});
            nomePesquisaID = ClienteEscritorio.getId_escritorio();
        }
        aux = nomePesquisaID;
    }

    public void ManipulaInterface() {

        switch (Modo) {
            case "editarPesquisa":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedoEscritorio.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;
            case "PesquisaClick":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedoEscritorio.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtTelefone.setEnabled(true);
                break;

            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoEscritorio.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtTelefone.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoEscritorio.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;

            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoEscritorio.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);

                txtNomedoEscritorio.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEndereco.setEnabled(true);
                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoEscritorio.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEndereco.setEnabled(false);
                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedoEscritorio.setEnabled(false);
                txtTelefone.setEnabled(false);
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
        txtNomedoEscritorio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        ComboBoxSecretaria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BotaoPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroEscritorio = new javax.swing.JTable();

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

        txtNomedoEscritorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomedoEscritorioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Escritorio:");

        jLabel3.setText("Telefone:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel5.setText("Endereco:");

        jLabel6.setText("ID Secretaria");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        ComboBoxSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSecretariaActionPerformed(evt);
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
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNomedoEscritorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(ComboBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomedoEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel2.setText("Cadastro Escritorio");

        BotaoPesquisar.setText("Pesquisa");
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

        jLabel4.setText("Nome Escritorio");

        jTableCadastroEscritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroEscritorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome Escritório ", "Telefone", "Endereco", "Nome Secretaria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroEscritorio.setToolTipText("");
        jTableCadastroEscritorio.setDoubleBuffered(true);
        jTableCadastroEscritorio.setDragEnabled(true);
        jTableCadastroEscritorio.setEditingColumn(0);
        jTableCadastroEscritorio.setEditingRow(0);
        jTableCadastroEscritorio.setFillsViewportHeight(true);
        jTableCadastroEscritorio.setFocusCycleRoot(true);
        jTableCadastroEscritorio.setFocusTraversalPolicyProvider(true);
        jTableCadastroEscritorio.setInheritsPopupMenu(true);
        jTableCadastroEscritorio.getTableHeader().setResizingAllowed(false);
        jTableCadastroEscritorio.getTableHeader().setReorderingAllowed(false);
        jTableCadastroEscritorio.setUpdateSelectionOnSort(false);
        jTableCadastroEscritorio.setVerifyInputWhenFocusTarget(false);
        jTableCadastroEscritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroEscritorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroEscritorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(BotaoNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(BotaoPesquisar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1093, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoCancelar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoPesquisar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListCliente() {
        // Como fazer a copia da gride de  lista das Tabelas .
        java.util.List<Escritorio> listaEscritorio = daoEscritorio.escritorioConsultar();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("NOME ESCRITORIO");
        modelo.addColumn("TELEFONE");
        modelo.addColumn("ENDERECO");
        modelo.addColumn("ID SECRETARIA");

        for (Escritorio ClienteEscritorio : listaEscritorio) {

            Object Linha[] = new Object[]{ClienteEscritorio.getId_escritorio(), ClienteEscritorio.getNome_advocacia(), ClienteEscritorio.getTelefone(),
                ClienteEscritorio.getEndereco(), ClienteEscritorio.getSecretaria().getNome_secretaria()};
            modelo.addRow(Linha);

        }
        jTableCadastroEscritorio.getTableHeader().setReorderingAllowed(false);
        jTableCadastroEscritorio.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCadastroEscritorio.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTableCadastroEscritorio.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableCadastroEscritorio.getColumnModel().getColumn(3).setPreferredWidth(600);
        jTableCadastroEscritorio.getColumnModel().getColumn(4).setPreferredWidth(100);

        jTableCadastroEscritorio.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Escritorio> ListaCadastroSecretario = daoEscritorio.escritorioConsultar();

        // Metodo de transformar im texto em  em inteiro !!!
        Secretaria secretaria = (Secretaria) ComboBoxSecretaria.getSelectedItem();

        index = jTableCadastroEscritorio.getSelectedRow();

        if (Modo.equals("Novo")) {

            Escritorio escritorio = new Escritorio(numero, txtNomedoEscritorio.getText(), txtTelefone.getText(), txtEndereco.getText(), secretaria);
            ListaCadastroSecretario.add(escritorio);

            DAOEscritorio daoClientesJTable = new DAOEscritorio();
            daoClientesJTable.inserir(escritorio);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

            ListCliente();

            limparFormularioEscritorio();
            Modo = "Navegar";
            ManipulaInterface();

        } else if (Modo.equals("Editar")) {
            Secretaria secretarias = (Secretaria) ComboBoxSecretaria.getSelectedItem();
            numero = (Integer) jTableCadastroEscritorio.getValueAt(aux, 0);

            DAOEscritorio daoClienteJTable = new DAOEscritorio();
            if (aux >= 0 && aux < ListaCadastroSecretario.size()) {
                Escritorio escritorio = new Escritorio(numero, txtNomedoEscritorio.getText(), txtTelefone.getText(), txtEndereco.getText(), secretarias);

                ListaCadastroSecretario.get(index).setNome_advocacia(txtNomedoEscritorio.getText());
                ListaCadastroSecretario.get(index).setTelefone(txtTelefone.getText());
                ListaCadastroSecretario.get(index).setEndereco(txtEndereco.getText());
                ListaCadastroSecretario.get(index).setSecretaria(secretarias);

                ListaCadastroSecretario.add(escritorio);

                daoClienteJTable.alterar(escritorio);
                ListCliente();
            }

            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");

            limparFormularioEscritorio();
            Modo = "Navegar";
            ManipulaInterface();

        }


    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        limparFormularioEscritorio();
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
        limparFormularioEscritorio();
        Modo = "Novo";
        ManipulaInterface();

    }//GEN-LAST:event_BotaoNovoActionPerformed
    public void setComboBoxCampusSelectedValue(int value) {
        Secretaria item;
        for (int i = 0; i < ComboBoxSecretaria.getItemCount(); i++) {
            item = (Secretaria) ComboBoxSecretaria.getItemAt(i);
            if (item.getId_secretaria() == value) {
                ComboBoxSecretaria.setSelectedIndex(i);
                break;
            }
        }
    }
    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        Modo = "Editar";
        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        index = aux;
        numero = (Integer) jTableCadastroEscritorio.getValueAt(index, 0);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Secretaria ", " ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOEscritorio daoEscritorioNovo = new DAOEscritorio();
            daoEscritorioNovo.Deletar(numero);

            limparFormularioEscritorio();

            ListaDeCadastroDaTabela();

            Modo = "Navegar";
            ManipulaInterface();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNomedoEscritorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedoEscritorioActionPerformed

    }//GEN-LAST:event_txtNomedoEscritorioActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
        ListaDeCadastroDaTabelaPesquisar(txtPesquisar.getText());
        index = aux;
        txtPesquisar.setText("");
//        ListCliente();
        Modo = "Pesquisar";
        ManipulaInterface();
    }//GEN-LAST:event_BotaoPesquisarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void ComboBoxSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSecretariaActionPerformed

    }//GEN-LAST:event_ComboBoxSecretariaActionPerformed

    private void jTableCadastroEscritorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroEscritorioMouseClicked

        index = jTableCadastroEscritorio.getSelectedRow();

        Object obj = jTableCadastroEscritorio.getValueAt(index, 1);
        String numeroProcesso = obj.toString();
        txtNomedoEscritorio.setText(numeroProcesso);

        Object obj1 = jTableCadastroEscritorio.getValueAt(index, 2);
        String descricao = obj1.toString();
        txtTelefone.setText(descricao);

        Object obj2 = jTableCadastroEscritorio.getValueAt(index, 3);
        String dataInicio = obj2.toString();
        txtEndereco.setText(dataInicio);

        int idDetran = (int) jTableCadastroEscritorio.getValueAt(index, 0);
        Escritorio escritorio = daoEscritorio.GetById(idDetran);
        setComboBoxCampusSelectedValue(escritorio.getSecretaria().getId_secretaria());

        aux = index;
        Modo = "editarPesquisa";
        ManipulaInterface();

    }//GEN-LAST:event_jTableCadastroEscritorioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JComboBox<Model.bean.Secretaria> ComboBoxSecretaria;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroEscritorio;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomedoEscritorio;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
