/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOControleDeProcessosEDiligência.DAOAdvogado;
import DAOControleDeProcessosEDiligência.DAOCliente;
import DAOControleDeProcessosEDiligência.DAOComarca;
import DAOControleDeProcessosEDiligência.DAOProcesso;
import DAOControleDeProcessosEDiligência.DAOSecrataria;
import Model.bean.Advogado;
import Model.bean.Cliente;
import Model.bean.Comarca;
import Model.bean.Processo;
import Model.bean.Secretaria;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adavilson
 */
public final class TelaCadastroProcesso extends javax.swing.JInternalFrame {

    ArrayList<Processo> ListaCadastroProcesso;
    DAOProcesso daoProcesso = new DAOProcesso();
    DAOSecrataria daoSecretaria = new DAOSecrataria();
    DAOCliente daoCliente = new DAOCliente();
    DAOAdvogado daoAdvogado = new DAOAdvogado();
    DAOComarca daoComarca = new DAOComarca();

    String Modo;
    int index;
    int numero;
    int aux;
    int auxPesquisar;
    int nomePesquisa;
    String nomePesquisas;
    String auxPesquisa;
    DAOProcesso daoProcessos = new DAOProcesso();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroProcesso() {
        this.setLocationRelativeTo(null);
        initComponents();

        carregarCliente();
        carregarAdvogado();
        carregarComarca();
        carregarSecretaria();
        ListaCadastroProcesso = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioCliente();

    }

    private void carregarSecretaria() {
        Object[] vetorCampusSecretaria = daoSecretaria.consultarEspecial().toArray();
        DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel(vetorCampusSecretaria);
        ComboBoxSecretaria.setModel(dcbm1);
    }

    private void carregarCliente() {
        Object[] vetorCampusCliente = daoCliente.consultarEspecial().toArray();
        DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel(vetorCampusCliente);
        ComboBoxCliente.setModel(dcbm2);

    }

    private void carregarAdvogado() {
        Object[] vetorCampusAdvogado = daoAdvogado.consultarEspecial().toArray();
        DefaultComboBoxModel dcbm3 = new DefaultComboBoxModel(vetorCampusAdvogado);
        ComboBoxAdvogado.setModel(dcbm3);
    }

    private void carregarComarca() {
        Object[] vetorCampusComarca = daoComarca.consultarEspecial().toArray();
        DefaultComboBoxModel dcbm4 = new DefaultComboBoxModel(vetorCampusComarca);
        ComboBoxComarca.setModel(dcbm4);
    }

    private void limparFormularioCliente() {

        txtNumeroProcesso.setText("");
        txtDescricao.setText("");
        txtDataInicio.setText("");
        txtDataFim.setText("");
        txtValorCausa.setText("");

    }

    public void ListaDeCadastroDaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroProcesso.getModel();
        modelo.setNumRows(0);

        for (Processo processo : daoProcesso.processoPesquisaGrid()) {

            modelo.addRow(new Object[]{
                processo.getId_processo(),
                processo.getNum_processo(),
                processo.getDescricao(),
                processo.getDt_inicio(),
                processo.getDt_fim(),
                processo.getVl_causa(),
                processo.getCliente().getNome_cliente(),
                processo.getAdvogado().getNome_Advogado(),
                processo.getSecretaria().getNome_secretaria(),
                processo.getComarca().getNome_Comarca()});

        }

    }

    public void ListaDeConsultaDaTabelaApartirDoIndex() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroProcesso.getModel();
        modelo.setNumRows(0);

        for (Processo processo : daoProcesso.processoConsultar()) {
            modelo.addRow(new Object[]{
                processo.getId_processo(),
                processo.getNum_processo(),
                processo.getDescricao(),
                processo.getDt_inicio(),
                processo.getDt_fim(),
                processo.getVl_causa(),
                processo.getCliente().getNome_cliente(),
                processo.getAdvogado().getNome_Advogado(),
                processo.getSecretaria().getNome_secretaria(),
                processo.getComarca().getNome_Comarca()});
        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String nomeProcesso) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroProcesso.getModel();
        modelo.setNumRows(0);

        for (Processo processo : daoProcesso.clientePesquisar(nomeProcesso)) {

            modelo.addRow(new Object[]{
                processo.getId_processo(),
                processo.getNum_processo(),
                processo.getDescricao(),
                processo.getDt_inicio(),
                processo.getDt_fim(),
                processo.getVl_causa(),
                processo.getCliente().getNome_cliente(),
                processo.getAdvogado().getNome_Advogado(),
                processo.getSecretaria().getNome_secretaria(),
                processo.getComarca().getNome_Comarca()});

            nomePesquisa = processo.getId_processo();
        }
        aux = nomePesquisa;
    }

    public void ManipulaInterface() {

        switch (Modo) {

            case "editarPesquisa":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNumeroProcesso.setEnabled(true);
                txtDescricao.setEnabled(true);
                txtDataInicio.setEnabled(true);
                txtDataFim.setEnabled(true);
                txtValorCausa.setEnabled(true);
                break;

            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNumeroProcesso.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtDataInicio.setEnabled(false);
                txtDataFim.setEnabled(false);
                txtValorCausa.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNumeroProcesso.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtDataInicio.setEnabled(false);
                txtDataFim.setEnabled(false);
                txtValorCausa.setEnabled(false);
                break;

            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNumeroProcesso.setEnabled(true);
                txtDescricao.setEnabled(true);
                txtDataInicio.setEnabled(true);
                txtDataFim.setEnabled(true);
                txtValorCausa.setEnabled(true);
                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);

                txtNumeroProcesso.setEnabled(true);
                txtDescricao.setEnabled(true);
                txtDataInicio.setEnabled(true);
                txtDataFim.setEnabled(true);
                txtValorCausa.setEnabled(true);
                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNumeroProcesso.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtDataInicio.setEnabled(false);
                txtDataFim.setEnabled(false);
                txtValorCausa.setEnabled(false);
                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNumeroProcesso.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtDataInicio.setEnabled(false);
                txtDataFim.setEnabled(false);
                txtValorCausa.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroProcesso = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNumeroProcesso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JTextField();
        txtDataFim = new javax.swing.JTextField();
        txtValorCausa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboBoxAdvogado = new javax.swing.JComboBox<>();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        ComboBoxComarca = new javax.swing.JComboBox<>();
        ComboBoxSecretaria = new javax.swing.JComboBox<>();
        BotaoPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        BotaoRelatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jTableCadastroProcesso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Numero Processo", "Descrição", "Data Inicio", "Data Fim", "Valor Causa", "Nome do Cliente", "Nome do Advogado", "Nome do Secretária", "Nome do Comarca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroProcesso.setToolTipText("");
        jTableCadastroProcesso.setDoubleBuffered(true);
        jTableCadastroProcesso.setDragEnabled(true);
        jTableCadastroProcesso.setEditingColumn(0);
        jTableCadastroProcesso.setEditingRow(0);
        jTableCadastroProcesso.setFillsViewportHeight(true);
        jTableCadastroProcesso.setFocusCycleRoot(true);
        jTableCadastroProcesso.setFocusTraversalPolicyProvider(true);
        jTableCadastroProcesso.setInheritsPopupMenu(true);
        jTableCadastroProcesso.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCadastroProcesso.getTableHeader().setResizingAllowed(false);
        jTableCadastroProcesso.getTableHeader().setReorderingAllowed(false);
        jTableCadastroProcesso.setUpdateSelectionOnSort(false);
        jTableCadastroProcesso.setVerifyInputWhenFocusTarget(false);
        jTableCadastroProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroProcessoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroProcesso);
        if (jTableCadastroProcesso.getColumnModel().getColumnCount() > 0) {
            jTableCadastroProcesso.getColumnModel().getColumn(0).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableCadastroProcesso.getColumnModel().getColumn(1).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableCadastroProcesso.getColumnModel().getColumn(2).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableCadastroProcesso.getColumnModel().getColumn(3).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableCadastroProcesso.getColumnModel().getColumn(4).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableCadastroProcesso.getColumnModel().getColumn(5).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTableCadastroProcesso.getColumnModel().getColumn(6).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTableCadastroProcesso.getColumnModel().getColumn(7).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(7).setPreferredWidth(200);
            jTableCadastroProcesso.getColumnModel().getColumn(8).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(8).setPreferredWidth(200);
            jTableCadastroProcesso.getColumnModel().getColumn(9).setResizable(false);
            jTableCadastroProcesso.getColumnModel().getColumn(9).setPreferredWidth(350);
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

        txtNumeroProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroProcessoActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Processo");

        jLabel3.setText("Descrição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Inicio");

        jLabel6.setText("Data Termino");

        jLabel7.setText("Cod Cliente");

        jLabel8.setText("Valor  da Causa");

        txtDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioActionPerformed(evt);
            }
        });

        jLabel9.setText("Cod Advogado");

        jLabel11.setText("Cod Secretaria");

        jLabel12.setText("Cod Comarca");

        ComboBoxAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAdvogadoActionPerformed(evt);
            }
        });

        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });

        ComboBoxComarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxComarcaActionPerformed(evt);
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
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxComarca, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtValorCausa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(132, 132, 132)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtValorCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ComboBoxComarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        BotaoPesquisar.setText("Pesquisa");
        BotaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisarActionPerformed(evt);
            }
        });

        BotaoRelatorio.setText("Relatorio");
        BotaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setText("Cadastro Processo");

        jLabel4.setText("Numero do Processo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BotaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(BotaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotaoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotaoPesquisar))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoRelatorio))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(BotaoPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListCliente() {
        java.util.List<Processo> listaProcesso = daoProcesso.processoConsultar();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome Processo");
        modelo.addColumn("Descrição");
        modelo.addColumn("Data Inicio");
        modelo.addColumn("Data Termino");
        modelo.addColumn("Valor Causa");
        modelo.addColumn("Cod Cliente");
        modelo.addColumn("Cod Advogado");
        modelo.addColumn("Cod Secretaria");
        modelo.addColumn("Cod Comarca");

        for (Processo ProcessoLista : listaProcesso) {

            Object Linha[] = new Object[]{ProcessoLista.getId_processo(), ProcessoLista.getNum_processo(), ProcessoLista.getDescricao(),
                ProcessoLista.getDt_inicio(), ProcessoLista.getDt_fim(), ProcessoLista.getVl_causa(), ProcessoLista.getCliente().getNome_cliente(), ProcessoLista.getAdvogado().getNome_Advogado(), ProcessoLista.getSecretaria().getNome_secretaria(), ProcessoLista.getComarca().getNome_Comarca()};
            modelo.addRow(Linha);

        }

        jTableCadastroProcesso.getTableHeader().setReorderingAllowed(false);
        jTableCadastroProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCadastroProcesso.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTableCadastroProcesso.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTableCadastroProcesso.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableCadastroProcesso.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableCadastroProcesso.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableCadastroProcesso.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTableCadastroProcesso.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTableCadastroProcesso.getColumnModel().getColumn(8).setPreferredWidth(100);
        jTableCadastroProcesso.getColumnModel().getColumn(9).setPreferredWidth(100);

        jTableCadastroProcesso.setModel(modelo);

    }

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Processo> ListaCadastroProcesso = daoProcesso.processoConsultar();
        Cliente cliente = (Cliente) ComboBoxCliente.getSelectedItem();
        Advogado advogado = (Advogado) ComboBoxAdvogado.getSelectedItem();
        Secretaria secretaria = (Secretaria) ComboBoxSecretaria.getSelectedItem();
        Comarca comarca = (Comarca) ComboBoxComarca.getSelectedItem();

        float valorCausa = Float.parseFloat(txtValorCausa.getText());

        index = jTableCadastroProcesso.getSelectedRow();

        if (Modo.equals("Novo")) {
            String dataAuxInicio = txtDataInicio.getText();
            LocalDate dataNascimentoInicio = LocalDate.parse(dataAuxInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataAuxFim = txtDataFim.getText();
            LocalDate dataNascimentoFim = LocalDate.parse(dataAuxFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Processo processo = new Processo(numero, txtNumeroProcesso.getText(), txtDescricao.getText(), dataNascimentoInicio, dataNascimentoFim, valorCausa, cliente, advogado, secretaria, comarca);

            if (ListaCadastroProcesso == ListaCadastroProcesso) {
                ListaCadastroProcesso.add(processo);
                DAOProcesso daoProcessoJTable = new DAOProcesso();
                daoProcessoJTable.inserir(processo);
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

                ListCliente();
                ListaDeCadastroDaTabela();

                limparFormularioCliente();
                Modo = "Navegar";
                ManipulaInterface();
            }
        } else if (Modo.equals("Editar")) {
            Cliente clientes = (Cliente) ComboBoxCliente.getSelectedItem();
            Advogado advogados = (Advogado) ComboBoxAdvogado.getSelectedItem();
            Secretaria secretarias = (Secretaria) ComboBoxSecretaria.getSelectedItem();
            Comarca comarcas = (Comarca) ComboBoxComarca.getSelectedItem();
            numero = (Integer) jTableCadastroProcesso.getValueAt(aux, 0);

            valorCausa = Float.parseFloat(txtValorCausa.getText());

            String dataAuxInicio = txtDataInicio.getText();
            LocalDate dataNascimentoInicio = LocalDate.parse(dataAuxInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataAuxFim = txtDataFim.getText();
            LocalDate dataNascimentoFim = LocalDate.parse(dataAuxFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            DAOProcesso daoProcessoJTable = new DAOProcesso();
            if (aux >= 0 && aux < ListaCadastroProcesso.size()) {
                Processo processo = new Processo(numero, txtNumeroProcesso.getText(), txtDescricao.getText(), dataNascimentoInicio, dataNascimentoFim, valorCausa, clientes, advogados, secretarias, comarcas);

                ListaCadastroProcesso.get(index).setNum_processo(txtNumeroProcesso.getText());
                ListaCadastroProcesso.get(index).setDescricao(txtDescricao.getText());
                ListaCadastroProcesso.get(index).setDt_inicio(dataNascimentoInicio);
                ListaCadastroProcesso.get(index).setDt_fim(dataNascimentoFim);
                ListaCadastroProcesso.get(index).setVl_causa(valorCausa);
                ListaCadastroProcesso.get(index).setCliente(clientes);
                ListaCadastroProcesso.get(index).setAdvogado(advogados);
                ListaCadastroProcesso.get(index).setSecretaria(secretarias);
                ListaCadastroProcesso.get(index).setComarca(comarcas);

                ListaCadastroProcesso.add(processo);

                daoProcessoJTable.alterar(processo);

                ListCliente();
                ListaDeCadastroDaTabela();
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

    private void jTableCadastroProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroProcessoMouseClicked

        index = jTableCadastroProcesso.getSelectedRow();

        Object obj = jTableCadastroProcesso.getValueAt(index, 1);
        String numeroProcesso = obj.toString();
        txtNumeroProcesso.setText(numeroProcesso);

        Object obj1 = jTableCadastroProcesso.getValueAt(index, 2);
        String descricao = obj1.toString();
        txtDescricao.setText(descricao);

        Object obj2 = jTableCadastroProcesso.getValueAt(index, 3);
        String dataInicio = obj2.toString();
        txtDataInicio.setText(dataInicio);

        Object obj3 = jTableCadastroProcesso.getValueAt(index, 4);
        String dataFim = obj3.toString();
        txtDataFim.setText(dataFim);

        Object obj4 = jTableCadastroProcesso.getValueAt(index, 5);
        String valorCausa = obj4.toString();
        txtValorCausa.setText(valorCausa);

        int id = (int) jTableCadastroProcesso.getValueAt(index, 0);
        Processo processoID = daoProcesso.GetBy(id);
        setComboBoxCampusSelectedValueCliente(processoID.getCliente().getId_cliente());

        setComboBoxCampusSelectedValueAdvogado(processoID.getAdvogado().getId_Advogado());

        setComboBoxCampusSelectedValueSecretaria(processoID.getSecretaria().getId_secretaria());

        setComboBoxCampusSelectedValueComarca(processoID.getComarca().getId_Comarca());

        aux = index;

        Modo = "editarPesquisa";
        ManipulaInterface();
    }//GEN-LAST:event_jTableCadastroProcessoMouseClicked

    public void setComboBoxCampusSelectedValueCliente(int value) {
        Cliente item;
        for (int i = 0; i < ComboBoxCliente.getItemCount(); i++) {
            item = (Cliente) ComboBoxCliente.getItemAt(i);
            if (item.getId_cliente() == value) {
                ComboBoxCliente.setSelectedIndex(i);
                break;
            }
        }
    }

    public void setComboBoxCampusSelectedValueAdvogado(int value) {
        Advogado item;
        for (int i = 0; i < ComboBoxAdvogado.getItemCount(); i++) {
            item = (Advogado) ComboBoxAdvogado.getItemAt(i);
            if (item.getId_Advogado() == value) {
                ComboBoxAdvogado.setSelectedIndex(i);
                break;
            }
        }
    }

    public void setComboBoxCampusSelectedValueSecretaria(int value) {
        Secretaria item;
        for (int i = 0; i < ComboBoxSecretaria.getItemCount(); i++) {
            item = (Secretaria) ComboBoxSecretaria.getItemAt(i);
            if (item.getId_secretaria() == value) {
                ComboBoxSecretaria.setSelectedIndex(i);
                break;
            }
        }
    }

    public void setComboBoxCampusSelectedValueComarca(int value) {
        Comarca item;
        for (int i = 0; i < ComboBoxComarca.getItemCount(); i++) {
            item = (Comarca) ComboBoxComarca.getItemAt(i);
            if (item.getId_Comarca() == value) {
                ComboBoxComarca.setSelectedIndex(i);
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
        numero = (Integer) jTableCadastroProcesso.getValueAt(index, 0);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Processo ", " Atenção",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOProcesso daoprocesso = new DAOProcesso();
            daoprocesso.Deletar(numero);

            limparFormularioCliente();

            ListaDeCadastroDaTabela();

            Modo = "Navegar";
            ManipulaInterface();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNumeroProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroProcessoActionPerformed

    }//GEN-LAST:event_txtNumeroProcessoActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
        ListaDeCadastroDaTabelaPesquisar(txtPesquisar.getText());
        index = aux;
        txtPesquisar.setText("");
        Modo = "Pesquisar";
        ManipulaInterface();

    }//GEN-LAST:event_BotaoPesquisarActionPerformed

    private void BotaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioActionPerformed
        MessageFormat titulo = new MessageFormat("Relatório de Clientes");
        MessageFormat t = new MessageFormat("t");
        try {
            jTableCadastroProcesso.print(JTable.PrintMode.FIT_WIDTH, titulo, t);
        } catch (PrinterException ex) {
            Logger.getLogger(TelaCadastroProcesso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoRelatorioActionPerformed

    private void ComboBoxAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAdvogadoActionPerformed

    }//GEN-LAST:event_ComboBoxAdvogadoActionPerformed

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

    private void ComboBoxComarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxComarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxComarcaActionPerformed

    private void ComboBoxSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSecretariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSecretariaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoRelatorio;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JComboBox< Model.bean.Advogado> ComboBoxAdvogado;
    private javax.swing.JComboBox< Model.bean.Cliente> ComboBoxCliente;
    private javax.swing.JComboBox<Model.bean.Comarca> ComboBoxComarca;
    private javax.swing.JComboBox<Model.bean.Secretaria> ComboBoxSecretaria;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroProcesso;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtDataFim;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNumeroProcesso;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtValorCausa;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
