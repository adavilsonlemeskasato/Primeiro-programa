/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAOConexao.DAOBase;
import DAOControleDeProcessosEDiligência.DAOAdvogado;
import DAOControleDeProcessosEDiligência.DAOEscritorio;
import Model.bean.Advogado;
import Model.bean.Escritorio;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author adavilson
 */
public final class TelaCadastroAdvogado extends javax.swing.JInternalFrame {

    ArrayList<Escritorio> ListaCadastroEscritorio;
    ArrayList<Advogado> ListaCadastroAdvogado;

    DAOEscritorio daoEscritorio = new DAOEscritorio();
    DAOAdvogado daoAdvogado = new DAOAdvogado();

    String Modo;
    int index;
    int numero;
    int aux;
    String nomePesquisa;

    DAOEscritorio daoEscritorios = new DAOEscritorio();
    DAOAdvogado daoAdvogados = new DAOAdvogado();

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroAdvogado() throws JRException {

        this.setLocationRelativeTo(null);
        initComponents();
        ListaCadastroAdvogado = new ArrayList();
        ListaDeCadastroDaTabela();
        Modo = "Navegar";
        ManipulaInterface();
        limparFormularioAdvogado();

    }

    public JasperPrint gerar() throws JRException, SQLException, ClassNotFoundException {
        JasperPrint rel = null;
        try {
            Connection con = DAOBase.getConRel();
            HashMap map = new HashMap();
            String arquivoJasper = "C:\\Users\\Adavilson\\Documents\\NetBeansProjects\\ControleDeProcessosEDiligência\\report2.jasper";
            rel = JasperFillManager.fillReport(arquivoJasper, map, con);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rel;
    }

    private void limparFormularioAdvogado() {

        txtNomedoAdvogado.setText("");
        txtRegistroOab.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtLoginEscritorio.setText("");
        txtSenha.setText("");
        txt_ID_Escritorio.setText("");

    }

//
     public void ListaDeCadastroDaTabela() {
        //Conseguir obter a lista do Banco de Dados.
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroAdvogado.getModel();
        modelo.setNumRows(0);

        for (Advogado advogado : daoAdvogado.advogadoConsulta()) {

            modelo.addRow(new Object[]{
                advogado.getId_Advogado(),
                advogado.getNome_Advogado(),
                advogado.getRegistro_Oab(),
                advogado.getTelefone(),
                advogado.getEmail(),
                advogado.getEndereco()});
        }

    }

    public void ListaDeCadastroDaTabelaPesquisar(String nomeCliente) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCadastroAdvogado.getModel();
        modelo.setNumRows(0);

        for (Advogado advogado : daoAdvogado.advogadoPesquisar(nomeCliente)) {

            modelo.addRow(new Object[]{
                advogado.getId_Advogado(),
                advogado.getNome_Advogado(),
                advogado.getRegistro_Oab(),
                advogado.getTelefone(),
                advogado.getEmail(),
                advogado.getEndereco()});
            nomePesquisa = advogado.getNome_Advogado();
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

                txtNomedoAdvogado.setEnabled(true);
                txtRegistroOab.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEmail.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtLoginEscritorio.setEnabled(true);
                txtSenha.setEnabled(true);
                txt_ID_Escritorio.setEnabled(true);
                break;
            case "Pesquisar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoAdvogado.setEnabled(false);
                txtRegistroOab.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEmail.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtLoginEscritorio.setEnabled(false);
                txtSenha.setEnabled(false);
                txt_ID_Escritorio.setEnabled(false);
                break;
            case "Navegar":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoAdvogado.setEnabled(false);
                txtRegistroOab.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEmail.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtLoginEscritorio.setEnabled(false);
                txtSenha.setEnabled(false);
                txt_ID_Escritorio.setEnabled(false);
                break;

            case "Novo":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoAdvogado.setEnabled(true);
                txtRegistroOab.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEmail.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtLoginEscritorio.setEnabled(true);
                txtSenha.setEnabled(true);
                txt_ID_Escritorio.setEnabled(true);
                break;

            case "Editar":
                BotaoCancelar.setEnabled(true);
                BotaoSalvar.setEnabled(true);
                BotaoNovo.setEnabled(false);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(false);

                txtNomedoAdvogado.setEnabled(true);
                txtRegistroOab.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtEmail.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtLoginEscritorio.setEnabled(true);
                txtSenha.setEnabled(true);
                txt_ID_Escritorio.setEnabled(true);
                break;

            case "Excluir":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(false);
                BotaoExcluir.setEnabled(false);

                txtNomedoAdvogado.setEnabled(false);
                txtRegistroOab.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEmail.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtLoginEscritorio.setEnabled(false);
                txtSenha.setEnabled(false);
                txt_ID_Escritorio.setEnabled(false);
                break;

            case "Selecao":
                BotaoCancelar.setEnabled(false);
                BotaoSalvar.setEnabled(false);
                BotaoNovo.setEnabled(true);
                BotaoEditar.setEnabled(true);
                BotaoExcluir.setEnabled(true);

                txtNomedoAdvogado.setEnabled(false);
                txtRegistroOab.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtEmail.setEnabled(false);
                txtLoginEscritorio.setEnabled(false);
                txtSenha.setEnabled(false);
                txtEndereco.setEnabled(false);
                txt_ID_Escritorio.setEnabled(false);
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
        txtNomedoAdvogado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRegistroOab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txt_ID_Escritorio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLoginEscritorio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BotaoPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        BotaoRelatorio = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroAdvogado = new javax.swing.JTable();

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

        txtNomedoAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomedoAdvogadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Advogado:");

        jLabel3.setText("Registro OAB");

        txtRegistroOab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistroOabActionPerformed(evt);
            }
        });

        jLabel5.setText("Endereco:");

        jLabel6.setText("ID Escritorio");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txt_ID_Escritorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ID_EscritorioActionPerformed(evt);
            }
        });

        jLabel2.setText("Login Secretaria:");

        txtLoginEscritorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginEscritorioActionPerformed(evt);
            }
        });

        jLabel4.setText("Senha:");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegistroOab, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(txtLoginEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomedoAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(txt_ID_Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomedoAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRegistroOab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID_Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel9.setText("Cadastro Advogado");

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

        jLabel11.setText("Nomde Advogado");

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableCadastroAdvogado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCadastroAdvogado.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "NomeAdvogado", "Registro da OAB", "Telefono", "Email", "Endereco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroAdvogado.setToolTipText("");
        jTableCadastroAdvogado.setDoubleBuffered(true);
        jTableCadastroAdvogado.setDragEnabled(true);
        jTableCadastroAdvogado.setEditingColumn(0);
        jTableCadastroAdvogado.setEditingRow(0);
        jTableCadastroAdvogado.setFillsViewportHeight(true);
        jTableCadastroAdvogado.setFocusCycleRoot(true);
        jTableCadastroAdvogado.setFocusTraversalPolicyProvider(true);
        jTableCadastroAdvogado.setInheritsPopupMenu(true);
        jTableCadastroAdvogado.getTableHeader().setResizingAllowed(false);
        jTableCadastroAdvogado.getTableHeader().setReorderingAllowed(false);
        jTableCadastroAdvogado.setUpdateSelectionOnSort(false);
        jTableCadastroAdvogado.setVerifyInputWhenFocusTarget(false);
        jTableCadastroAdvogado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroAdvogadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroAdvogado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(BotaoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoPesquisar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1291, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BotaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoRelatorio)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoPesquisar)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ListCliente() {
        // Como fazer a copia da gride de  lista das Tabelas .
        java.util.List<Advogado> listaAdvogado = daoAdvogado.advogadoConsulta();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("NOME Do Advogado");
        modelo.addColumn("Nº REGISTRO DA OAB");
        modelo.addColumn("TELEFONE");
        modelo.addColumn("EMAIL");
        modelo.addColumn("ENDERECO");

        for (Advogado advogado : listaAdvogado) {

            Object Linha[] = new Object[]{advogado.getId_Advogado(), advogado.getNome_Advogado(), advogado.getRegistro_Oab(), advogado.getTelefone(),
                advogado.getEmail(), advogado.getEndereco()};
            modelo.addRow(Linha);

        }
        jTableCadastroAdvogado.getTableHeader().setReorderingAllowed(false);
        jTableCadastroAdvogado.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCadastroAdvogado.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTableCadastroAdvogado.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTableCadastroAdvogado.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableCadastroAdvogado.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTableCadastroAdvogado.getColumnModel().getColumn(5).setPreferredWidth(200);

        jTableCadastroAdvogado.setModel(modelo);

    }


    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        java.util.List<Advogado> ListaCadastroAdvogado = daoAdvogado.advogadoConsulta();

//        // Metodo de transformar im texto em  em inteiro !!!
        int senha = Integer.parseInt(txt_ID_Escritorio.getText());
        String senhas = new String(txtSenha.getPassword());

        index = jTableCadastroAdvogado.getSelectedRow();

        if (Modo.equals("Novo")) {

            Advogado advogado = new Advogado(numero, txtNomedoAdvogado.getText(), txtRegistroOab.getText(), txtTelefone.getText(), txtEmail.getText(), txtEndereco.getText(), txtLoginEscritorio.getText(), Integer.parseInt(senhas), senha);
            ListaCadastroAdvogado.add(advogado);

            DAOAdvogado daoAdvogadoJTable = new DAOAdvogado();
            daoAdvogadoJTable.inserir(advogado);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

            ListCliente();

            limparFormularioAdvogado();
            Modo = "Navegar";
            ManipulaInterface();

        } else if (Modo.equals("Editar")) {

            index = aux;
            numero = (Integer) jTableCadastroAdvogado.getValueAt(index, 0);

            senha = Integer.parseInt(txt_ID_Escritorio.getText());
            senhas = new String(txtSenha.getPassword());

            DAOAdvogado daoAdvogadoJTable = new DAOAdvogado();
            if (index >= 0 && index < ListaCadastroAdvogado.size()) {
                Advogado advogado = new Advogado(numero, txtNomedoAdvogado.getText(), txtRegistroOab.getText(), txtTelefone.getText(), txtEmail.getText(), txtEndereco.getText(), txtLoginEscritorio.getText(), Integer.parseInt(senhas), senha);

                ListaCadastroAdvogado.get(index).setNome_Advogado(txtNomedoAdvogado.getText());
                ListaCadastroAdvogado.get(index).setRegistro_Oab(txtRegistroOab.getText());
                ListaCadastroAdvogado.get(index).setTelefone(txtTelefone.getText());
                ListaCadastroAdvogado.get(index).setEmail(txtEmail.getText());
                ListaCadastroAdvogado.get(index).setEndereco(txtEndereco.getText());
                ListaCadastroAdvogado.get(index).setLogin_Advogado(txtLoginEscritorio.getText());
                ListaCadastroAdvogado.get(index).setSenha(Integer.parseInt(senhas));
                ListaCadastroAdvogado.get(index).setId_escritorio(senha);

                ListaCadastroAdvogado.add(advogado);

                daoAdvogadoJTable.alterar(advogado);
            }

            ListCliente();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!!!");

            limparFormularioAdvogado();
            Modo = "Navegar";
            ManipulaInterface();
        }

    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        limparFormularioAdvogado();
        Modo = "Navegar";
        ManipulaInterface();

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair ?", " Atenção ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.dispose();
        } else {

        }

    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        ListCliente();
        limparFormularioAdvogado();
        Modo = "Novo";
        ManipulaInterface();
//
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        Modo = "Editar";
        ManipulaInterface();


    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        index = aux;
        numero = (Integer) jTableCadastroAdvogado.getValueAt(index, 0);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Advogado ", " Atenção ",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            DAOAdvogado daoAdvogadoNovo = new DAOAdvogado();
            daoAdvogadoNovo.Deletar(numero);

            limparFormularioAdvogado();

            ListaDeCadastroDaTabela();

            Modo = "Navegar";
            ManipulaInterface();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void txtNomedoAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomedoAdvogadoActionPerformed

    }//GEN-LAST:event_txtNomedoAdvogadoActionPerformed

    private void txtRegistroOabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistroOabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistroOabActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txt_ID_EscritorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ID_EscritorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ID_EscritorioActionPerformed

    private void txtLoginEscritorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginEscritorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginEscritorioActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        txtSenha.setText("");
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void BotaoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseClicked
        java.util.List<Advogado> ListaPesquisaCadastroAdvogado = daoAdvogado.advogadoPesquisar(nomePesquisa);

        index = jTableCadastroAdvogado.getSelectedRow();

        if (Modo.equals("PesquisaClick")) {
            index = aux;
            numero = (Integer) jTableCadastroAdvogado.getValueAt(index, 0);
            int senha = Integer.parseInt(txt_ID_Escritorio.getText());
            String senhas = new String(txtSenha.getPassword());

            if (index >= 0 && index < ListaCadastroAdvogado.size()) {
                Advogado advogado = new Advogado(numero, txtNomedoAdvogado.getText(), txtRegistroOab.getText(), txtTelefone.getText(), txtEmail.getText(), txtEndereco.getText(), txtLoginEscritorio.getText(), Integer.parseInt(senhas), senha);
                if (ListaCadastroEscritorio == ListaCadastroEscritorio) {
                    ListaPesquisaCadastroAdvogado.add(advogado);
                    DAOAdvogado daoClientesJTable = new DAOAdvogado();
                    daoClientesJTable.inserir(advogado);
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!!");

                    ListCliente();

                }
                limparFormularioAdvogado();
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

    private void BotaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioActionPerformed
        MessageFormat titulo = new MessageFormat("Relatório de Advogados");
        MessageFormat t = new MessageFormat("t");
        try {
            jTableCadastroAdvogado.print(JTable.PrintMode.FIT_WIDTH, titulo, t);
        } catch (PrinterException ex) {
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoRelatorioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JasperViewer.viewReport(gerar());
        } catch (JRException ex) {
            Logger.getLogger(TelaCadastroAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableCadastroAdvogadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroAdvogadoMouseClicked
        java.util.List<Advogado> ListaCadastroAdvogado = daoAdvogado.advogadoConsulta();

        index = jTableCadastroAdvogado.getSelectedRow();
        aux = index;

        if (index >= 0 && index < ListaCadastroAdvogado.size()) {

            Advogado advogado = ListaCadastroAdvogado.get(index);

            txtNomedoAdvogado.setText((advogado.getNome_Advogado()));
            txtRegistroOab.setText((advogado.getRegistro_Oab()));
            txtTelefone.setText((advogado.getTelefone()));
            txtEmail.setText((advogado.getEmail()));
            txtEndereco.setText((advogado.getEndereco()));
            txtLoginEscritorio.setText((advogado.getLogin_Advogado()));
            txtSenha.setText(String.valueOf((advogado.getSenha())));
            txt_ID_Escritorio.setText(String.valueOf(advogado.getId_escritorio()));

            Modo = "Selecao";
            ManipulaInterface();
        }

    }//GEN-LAST:event_jTableCadastroAdvogadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JButton BotaoRelatorio;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable jTableCadastroAdvogado;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLoginEscritorio;
    private javax.swing.JTextField txtNomedoAdvogado;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtRegistroOab;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txt_ID_Escritorio;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {

    }
}
