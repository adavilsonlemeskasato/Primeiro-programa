/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOComarca;
import Model.bean.Comarca;
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
public final class TelaCadastroComarca extends javax.swing.JInternalFrame {

    ArrayList<Comarca> ListaCadastroComarca;
    DAOComarca daoComarca = new DAOComarca();

    String Modo;
    int index;
    int numero;
    int aux;
    String combobox;
    String comboboxReceberUF;
    String nomePesquisa;

    DAOComarca daoComarcas = new DAOComarca();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroComarca() {
        java.util.List<Comarca> ListaCadastroComarca = daoComarca.comarcaConsultar();
        this.setLocationRelativeTo(null);
        initComponents();
        ListaCadastroComarca = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioComarca();

    }

    private void limparFormularioComarca() {

        txtNomedaComarca.setText(" ");
        txtTelefone.setText(" ");

    }

    public void ListaDeCadastroDaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroDaComarca.getModel();
        modelo.setNumRows(0);

        for (Comarca comarca : daoComarca.comarcaConsultar()) {

            modelo.addRow(new Object[]{
                comarca.getId_Comarca(),
                comarca.getUf(),
                comarca.getNome_Comarca(),
                comarca.getTeledone(),});
        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String nomeCliente) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroDaComarca.getModel();
        modelo.setNumRows(0);

        for (Comarca comarca : daoComarca.comarcaPesquisar(nomeCliente)) {

            modelo.addRow(new Object[]{
                comarca.getId_Comarca(),
                comarca.getUf(),
                comarca.getNome_Comarca(),
                comarca.getTeledone(),});
            nomePesquisa = comarca.getNome_Comarca();
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

                txtNomedaComarca.setEnabled(false);
                txtTelefone.setEnabled(false);
                break;
            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedaComarca.setEnabled(false);
                txtTelefone.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedaComarca.setEnabled(false);
                txtTelefone.setEnabled(false);

                break;
            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedaComarca.setEnabled(true);
                txtTelefone.setEnabled(true);

                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);

                txtNomedaComarca.setEnabled(true);
                txtTelefone.setEnabled(true);

                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedaComarca.setEnabled(false);
                txtTelefone.setEnabled(false);

                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedaComarca.setEnabled(false);
                txtTelefone.setEnabled(false);

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
        jPanel1 = new javax.swing.JPanel();
        BotaoSalvar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JToggleButton();
        BotaoNovo = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNomedaComarca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        ComboBoxEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BotaoRelatorio = new javax.swing.JButton();
        BotaoPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroDaComarca = new javax.swing.JTable();

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

        txtNomedaComarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomedaComarcaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Comarca:");

        jLabel3.setText("UF:");

        jLabel6.setText("Telefone:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        ComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        ComboBoxEstado.setToolTipText("AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO");
        ComboBoxEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxEstadoMouseClicked(evt);
            }
        });
        ComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone)
                            .addComponent(txtNomedaComarca))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(269, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNomedaComarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel2.setText("Cadastro Comarca");

        BotaoRelatorio.setText("Relatorio");
        BotaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatorioActionPerformed(evt);
            }
        });

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

        jLabel4.setText("Nome Comarca");

        jTableCadastroDaComarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroDaComarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "UF", "Nome Comarca", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroDaComarca.setToolTipText("");
        jTableCadastroDaComarca.setDoubleBuffered(true);
        jTableCadastroDaComarca.setDragEnabled(true);
        jTableCadastroDaComarca.setEditingColumn(0);
        jTableCadastroDaComarca.setEditingRow(0);
        jTableCadastroDaComarca.setFillsViewportHeight(true);
        jTableCadastroDaComarca.setFocusCycleRoot(true);
        jTableCadastroDaComarca.setFocusTraversalPolicyProvider(true);
        jTableCadastroDaComarca.setInheritsPopupMenu(true);
        jTableCadastroDaComarca.getTableHeader().setResizingAllowed(false);
        jTableCadastroDaComarca.getTableHeader().setReorderingAllowed(false);
        jTableCadastroDaComarca.setUpdateSelectionOnSort(false);
        jTableCadastroDaComarca.setVerifyInputWhenFocusTarget(false);
        jTableCadastroDaComarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroDaComarcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroDaComarca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoPesquisar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoRelatorio))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoPesquisar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListComarca() {
        java.util.List<Comarca> listaComarca = daoComarca.comarcaConsultar();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Uf");
        modelo.addColumn("Nome Comarca");
        modelo.addColumn("Telefone");

        for (Comarca comarca : listaComarca) {

            Object Linha[] = new Object[]{comarca.getId_Comarca(), comarca.getUf(), comarca.getNome_Comarca(), comarca.getTeledone()};
            modelo.addRow(Linha);
        }
        jTableCadastroDaComarca.getTableHeader().setReorderingAllowed(false);
        jTableCadastroDaComarca.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTableCadastroDaComarca.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableCadastroDaComarca.getColumnModel().getColumn(2).setPreferredWidth(1000);
        jTableCadastroDaComarca.getColumnModel().getColumn(3).setPreferredWidth(400);

        jTableCadastroDaComarca.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Comarca> ListaCadastroComarca = daoComarca.comarcaConsultar();

        index = jTableCadastroDaComarca.getSelectedRow();

        if (Modo.equals("Novo")) {

            Comarca comarca = new Comarca(numero, comboboxReceberUF, txtNomedaComarca.getText(), txtTelefone.getText());
            ListaCadastroComarca.add(comarca);

            DAOComarca daoComarcaJTable = new DAOComarca();
            daoComarcaJTable.inserir(comarca);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

            ListaDeCadastroDaTabela();

            limparFormularioComarca();
            Modo = "Navegar";
            ManipulaInterface();

        } else if (Modo.equals("Editar")) {

            index = aux;
            numero = (Integer) jTableCadastroDaComarca.getValueAt(index, 0);
            DAOComarca daoComarcaJTable = new DAOComarca();
            if (index >= 0 && index < ListaCadastroComarca.size()) {
                Comarca comarca = new Comarca(numero, comboboxReceberUF, txtNomedaComarca.getText(), txtTelefone.getText());

                ListaCadastroComarca.get(index).setUf(ComboBoxEstado.getToolTipText());
                ListaCadastroComarca.get(index).setNome_Comarca(txtNomedaComarca.getText());
                ListaCadastroComarca.get(index).setTeledone(txtTelefone.getText());

                ListaCadastroComarca.add(comarca);

                daoComarcaJTable.alterar(comarca);
                ListaDeCadastroDaTabela();
            }

            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");

            limparFormularioComarca();
            Modo = "Navegar";
            ManipulaInterface();

        }


    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        limparFormularioComarca();
        Modo = "Navegar";
        ManipulaInterface();

        if (JOptionPane.showConfirmDialog(null, "Quer realmente sair ?", " ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.dispose();
        } else {

        }

    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        ListaDeCadastroDaTabela();
        limparFormularioComarca();
        Modo = "Novo";
        ManipulaInterface();

    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        Modo = "Editar";
        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        index = aux;
        numero = (Integer) jTableCadastroDaComarca.getValueAt(index, 0);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Secretaria ", " ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOComarca daoCcomarca = new DAOComarca();
            daoCcomarca.Deletar(numero);
            ListaDeCadastroDaTabela();

            limparFormularioComarca();

            Modo = "Navegar";
            ManipulaInterface();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNomedaComarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedaComarcaActionPerformed

    }//GEN-LAST:event_txtNomedaComarcaActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void ComboBoxEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxEstadoMouseClicked

        if (ComboBoxEstado.getSelectedIndex() == 0) {
            combobox = "AC";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 1) {
            combobox = "AL";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex() == 2) {
            combobox = "AP";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex() == 3) {
            combobox = "AM";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex() == 4) {
            combobox = "BA";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 5) {
            combobox = "CE";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 6) {
            combobox = "DF";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 7) {
            combobox = "ES";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 8) {
            combobox = "AM";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 9) {
            combobox = "GO";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 10) {
            combobox = "MA";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 11) {
            combobox = "MT";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 12) {
            combobox = "MS";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex() == 13) {
            combobox = "MG";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "PA";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "PB";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "PR";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "PE ";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "PI";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "RJ";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "RN";
            comboboxReceberUF = combobox;
        }

        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "RS";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "RO";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "RR";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "SC";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "SP";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "SE";
            comboboxReceberUF = combobox;
        }
        if (ComboBoxEstado.getSelectedIndex()
                == 3) {
            combobox = "TO";
            comboboxReceberUF = combobox;
        }


    }//GEN-LAST:event_ComboBoxEstadoMouseClicked

    private void ComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxEstadoActionPerformed

    private void BotaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioActionPerformed
        MessageFormat titulo = new MessageFormat("Relatório de Comarca");
        MessageFormat t = new MessageFormat("t");
        try {
            jTableCadastroDaComarca.print(JTable.PrintMode.FIT_WIDTH, titulo, t);

        } catch (PrinterException ex) {
            Logger.getLogger(TelaCadastroCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoRelatorioActionPerformed

    private void BotaoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseClicked
        java.util.List<Comarca> ListaPesquisaCadastroComarca = daoComarca.comarcaPesquisar(nomePesquisa);

        index = jTableCadastroDaComarca.getSelectedRow();

        if (Modo.equals("PesquisaClick")) {
            index = aux;
            numero = (Integer) jTableCadastroDaComarca.getValueAt(index, 0);

            if (index >= 0 && index < ListaPesquisaCadastroComarca.size()) {

                Comarca comarca = new Comarca(numero, comboboxReceberUF, txtNomedaComarca.getText(), txtTelefone.getText());
                if (ListaCadastroComarca == ListaCadastroComarca) {
                    ListaPesquisaCadastroComarca.add(comarca);
                    DAOComarca daoComarcaJTable = new DAOComarca();
                    daoComarcaJTable.inserir(comarca);
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

                    ListaDeCadastroDaTabela();

                }
                limparFormularioComarca();
                Modo = "Navegar";
                ManipulaInterface();
            }
        }
    }//GEN-LAST:event_BotaoPesquisarMouseClicked

    private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
        ListaDeCadastroDaTabelaPesquisar(txtPesquisar.getText());
        txtPesquisar.setText("");
        Modo = "Pesquisar";
        ManipulaInterface();
    }//GEN-LAST:event_BotaoPesquisarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void jTableCadastroDaComarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroDaComarcaMouseClicked
        java.util.List<Comarca> ListaCadastroComarca = daoComarca.comarcaConsultar();

        index = jTableCadastroDaComarca.getSelectedRow();
        aux = index;

        if (index >= 0 && index < ListaCadastroComarca.size()) {

            Comarca comarca = ListaCadastroComarca.get(index);
            ComboBoxEstado.setToolTipText((comarca.getUf()));
            txtNomedaComarca.setText((comarca.getNome_Comarca()));
            txtTelefone.setText(comarca.getTeledone());

            Modo = "Selecao";
            ManipulaInterface();
        }
    }//GEN-LAST:event_jTableCadastroDaComarcaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoRelatorio;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JComboBox<Object> ComboBoxEstado;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroDaComarca;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtNomedaComarca;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }

}
