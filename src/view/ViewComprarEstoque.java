/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  componentes.UJComboBox
 */
package view;

import componentes.UJComboBox;
import controller.ControllerComprasProdutos;
import controller.ControllerContaPagar;
import controller.ControllerFornecedor;
import controller.ControllerProdutos;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import model.ModelComprasProdutos;
import model.ModelContaPagar;
import model.ModelFornecedor;
import model.ModelProdutos;
import util.AguardeGerandoRelatorio;
import util.Datas;
import util.Mascaras;
import view.ViewVenda;

public class ViewComprarEstoque
extends JFrame {
    ModelProdutos modelProdutos = new ModelProdutos();
    ArrayList<ModelProdutos> listaModelProdutoses = new ArrayList();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ArrayList<ModelComprasProdutos> listaModelComprasProdutoses = new ArrayList();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ArrayList<ModelFornecedor> listaModelFornecedors = new ArrayList();
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    ModelContaPagar modelContaPagar = new ModelContaPagar();
    Mascaras blmascaras = new Mascaras();
    Datas bLDatas = new Datas();
    private JButton btExcluir;
    private JButton btSalvar;
    private UJComboBox cbCodBarrasProdutos;
    private UJComboBox cbCodProdutos;
    private JComboBox cbFornecedores;
    private UJComboBox cbNomeProduto;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JButton jbAdicionarProduto;
    private JButton jbCancelar;
    private JButton jbNovo;
    private JCheckBox jcbGerarContaPagar;
    private JFormattedTextField jtfAdicionarEstoque;
    private JTextField jtfQuantidadeEstoqueAtual;
    private JTextField jtfValorCusto;
    private JTextField jtfValorTotal;
    private JTextField jtfValorUltimaCompra;
    private JTable tbCompras;
    private JTable tbProdutos;

    public ViewComprarEstoque() {
        this.initComponents();
        this.listarProdutos();
        this.listaFornecedores();
        this.setLocationRelativeTo(null);
        this.habilitarCampos(false);
        this.inicializar();
        this.carregarCompras();
    }

    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.cbCodProdutos = new UJComboBox();
        this.jLabel7 = new JLabel();
        this.jtfValorUltimaCompra = new JTextField();
        this.jLabel2 = new JLabel();
        this.cbCodBarrasProdutos = new UJComboBox();
        this.jtfQuantidadeEstoqueAtual = new JTextField();
        this.jLabel4 = new JLabel();
        this.cbNomeProduto = new UJComboBox();
        this.jLabel3 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jtfValorCusto = new JTextField();
        this.jtfAdicionarEstoque = new JFormattedTextField();
        this.jLabel5 = new JLabel();
        this.jbAdicionarProduto = new JButton();
        this.jLabel6 = new JLabel();
        this.cbFornecedores = new JComboBox();
        this.jcbGerarContaPagar = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.tbProdutos = new JTable();
        this.jbNovo = new JButton();
        this.jtfValorTotal = new JTextField();
        this.jLabel9 = new JLabel();
        this.btExcluir = new JButton();
        this.jbCancelar = new JButton();
        this.btSalvar = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.tbCompras = new JTable();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Compras Produtos / atualiza Estoque ");
        this.setResizable(false);
        this.jLabel1.setText("C\u00f3digo produto:");
        this.cbCodProdutos.setAutocompletar(true);
        this.cbCodProdutos.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewComprarEstoque.this.cbCodProdutosPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        this.jLabel7.setText("Val. Ult. Compra:");
        this.jtfValorUltimaCompra.setEditable(false);
        this.jtfValorUltimaCompra.setBackground(new Color(204, 255, 204));
        this.jtfValorUltimaCompra.setToolTipText("Valor de custo do produto referente a ultima compra!");
        this.jLabel2.setText("C\u00f3digo da Loja:");
        this.cbCodBarrasProdutos.setAutocompletar(true);
        this.cbCodBarrasProdutos.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewComprarEstoque.this.cbCodBarrasProdutosPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        this.jtfQuantidadeEstoqueAtual.setEditable(false);
        this.jtfQuantidadeEstoqueAtual.setBackground(new Color(204, 255, 204));
        this.jtfQuantidadeEstoqueAtual.setToolTipText("Quantidade atual em estoque!");
        this.jLabel4.setText("Quantidade atual:");
        this.cbNomeProduto.setAutocompletar(true);
        this.cbNomeProduto.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewComprarEstoque.this.cbNomeProdutoPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        this.jLabel3.setText("Nome do produto:");
        this.jLabel8.setText("Valor de custo:");
        this.jtfValorCusto.setToolTipText("Valor de custo para compra deste produto!");
        this.jtfValorCusto.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewComprarEstoque.this.jtfValorCustoFocusLost(evt);
            }
        });
        this.jtfValorCusto.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent evt) {
                ViewComprarEstoque.this.jtfValorCustoKeyReleased(evt);
            }
        });
        this.jtfAdicionarEstoque.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewComprarEstoque.this.jtfAdicionarEstoqueFocusLost(evt);
            }
        });
        this.jtfAdicionarEstoque.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent evt) {
                ViewComprarEstoque.this.jtfAdicionarEstoqueKeyReleased(evt);
            }
        });
        this.jLabel5.setText("Adicionar ao estoque:");
        this.jbAdicionarProduto.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Down.png")));
        this.jbAdicionarProduto.setText("Adicionar a Lista");
        this.jbAdicionarProduto.setToolTipText("Clique aqui para adicionar o produto na tabela");
        this.jbAdicionarProduto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.jbAdicionarProdutoActionPerformed(evt);
            }
        });
        this.jLabel6.setText("Fornecedor:");
        this.jcbGerarContaPagar.setSelected(true);
        this.jcbGerarContaPagar.setText("Gerar faturamento - Conta a pagar");
        this.jcbGerarContaPagar.setToolTipText("Deixe marcado para gerar uma conta a pagar");
        this.tbProdutos.setAutoCreateRowSorter(true);
        this.tbProdutos.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo", "C\u00f3digo Loja", "Nome", "Valor Custo", "Qt. Anterior", "Add. Qt.", "Fornecedor", "Cod. Fornecedor", "Valor total"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbProdutos.setAutoResizeMode(0);
        this.tbProdutos.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbProdutos);
        if (this.tbProdutos.getColumnModel().getColumnCount() > 0) {
            this.tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
            this.tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(150);
            this.tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(200);
            this.tbProdutos.getColumnModel().getColumn(6).setPreferredWidth(200);
        }
        this.jbNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/New document.png")));
        this.jbNovo.setText("Novo");
        this.jbNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.jbNovoActionPerformed(evt);
            }
        });
        this.jtfValorTotal.setEditable(false);
        this.jtfValorTotal.setBackground(new Color(255, 255, 204));
        this.jLabel9.setText("V. Total:");
        this.btExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.btExcluir.setText("Excluir da tabela");
        this.btExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.btExcluirActionPerformed(evt);
            }
        });
        this.jbCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.jbCancelar.setText("Cancelar");
        this.jbCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.jbCancelarActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar");
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.btSalvarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.cbCodProdutos, -2, 100, -2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.cbCodBarrasProdutos, -2, 160, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent((Component)this.cbNomeProduto, -2, 420, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtfValorUltimaCompra, -2, 115, -2).addComponent(this.jLabel7)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtfQuantidadeEstoqueAtual, -2, 115, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtfValorCusto, -2, 115, -2).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jtfAdicionarEstoque, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbAdicionarProduto, -2, 200, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbFornecedores, -2, 440, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jcbGerarContaPagar)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jbCancelar).addGap(3, 3, 3).addComponent(this.btExcluir).addGap(7, 7, 7).addComponent(this.jbNovo).addGap(71, 71, 71).addComponent(this.btSalvar).addGap(30, 30, 30).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfValorTotal, -2, 170, -2))).addGap(0, 34, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent((Component)this.cbCodProdutos, -2, -1, -2).addComponent((Component)this.cbCodBarrasProdutos, -2, -1, -2).addComponent((Component)this.cbNomeProduto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jLabel4).addComponent(this.jLabel8).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jtfValorUltimaCompra, -2, -1, -2).addComponent(this.jtfQuantidadeEstoqueAtual, -2, -1, -2).addComponent(this.jtfValorCusto, -2, -1, -2).addComponent(this.jtfAdicionarEstoque, -2, -1, -2).addComponent(this.jbAdicionarProduto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.cbFornecedores, -2, -1, -2).addComponent(this.jcbGerarContaPagar)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 366, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jbCancelar).addComponent(this.btExcluir).addComponent(this.jbNovo).addComponent(this.btSalvar).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jtfValorTotal, -2, -1, -2).addComponent(this.jLabel9))).addContainerGap()));
        this.jTabbedPane1.addTab("Principal", this.jPanel1);
        this.jLabel10.setText("Pesquisa:");
        this.tbCompras.setAutoCreateRowSorter(true);
        this.tbCompras.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo da Compra", "Data"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbCompras.setAutoResizeMode(0);
        this.tbCompras.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane3.setViewportView(this.tbCompras);
        if (this.tbCompras.getColumnModel().getColumnCount() > 0) {
            this.tbCompras.getColumnModel().getColumn(0).setPreferredWidth(200);
            this.tbCompras.getColumnModel().getColumn(1).setPreferredWidth(200);
        }
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.jButton2.setText("Excluir");
        this.jButton2.setEnabled(false);
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/print.png")));
        this.jButton3.setText("Imprimir");
        this.jButton3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewComprarEstoque.this.jButton3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jScrollPane3, -2, 730, -2)).addGap(0, 24, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton3))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 461, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton3)).addContainerGap()));
        this.jTabbedPane1.addTab("Pesquisa/Impress\u00e3o", this.jPanel2);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
        this.pack();
    }

    private void cbNomeProdutoPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.cbNomeProduto.isPopupVisible()) {
            this.modelProdutos = this.controllerProdutos.getProdutosController(this.cbNomeProduto.getSelectedItem().toString());
            this.cbCodProdutos.setSelectedItem((Object)this.modelProdutos.getCodigo());
            this.cbCodBarrasProdutos.setSelectedItem((Object)this.modelProdutos.getCodigoBarras());
            this.jtfValorUltimaCompra.setText(this.blmascaras.arredondamentoDoubleComPontoDuasCasasString(this.modelProdutos.getValorCusto()));
            this.jtfQuantidadeEstoqueAtual.setText(this.blmascaras.arredondamentoComPontoDuasCasasString(this.modelProdutos.getEstoque()));
        }
    }

    private void cbCodProdutosPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.cbCodProdutos.isPopupVisible()) {
            this.modelProdutos = this.controllerProdutos.getProdutosController(Integer.parseInt(this.cbCodProdutos.getSelectedItem().toString()));
            this.cbNomeProduto.setSelectedItem((Object)String.valueOf(this.modelProdutos.getNome()));
            this.cbCodBarrasProdutos.setSelectedItem((Object)this.modelProdutos.getCodigoBarras());
            this.jtfValorUltimaCompra.setText(this.blmascaras.arredondamentoDoubleComPontoDuasCasasString(this.modelProdutos.getValorCusto()));
            this.jtfQuantidadeEstoqueAtual.setText(this.blmascaras.arredondamentoComPontoDuasCasasString(this.modelProdutos.getEstoque()));
        }
    }

    private void cbCodBarrasProdutosPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.cbCodBarrasProdutos.isPopupVisible()) {
            this.modelProdutos = this.controllerProdutos.getProdutosCodigoBarrasController(this.cbCodBarrasProdutos.getSelectedItem().toString());
            this.cbNomeProduto.setSelectedItem((Object)String.valueOf(this.modelProdutos.getNome()));
            this.cbCodProdutos.setSelectedItem((Object)this.modelProdutos.getCodigo());
            this.jtfValorUltimaCompra.setText(this.blmascaras.arredondamentoDoubleComPontoDuasCasasString(this.modelProdutos.getValorCusto()));
            this.jtfQuantidadeEstoqueAtual.setText(this.blmascaras.arredondamentoComPontoDuasCasasString(this.modelProdutos.getEstoque()));
        }
    }

    private void jtfValorCustoKeyReleased(KeyEvent evt) {
        this.jtfValorCusto.setText(this.blmascaras.converterVirgulaParaPonto(this.jtfValorCusto.getText()));
    }

    private void jtfValorCustoFocusLost(FocusEvent evt) {
        this.jtfValorCusto.setText(this.blmascaras.converterVirgulaParaPonto(this.jtfValorCusto.getText()));
    }

    private void jbNovoActionPerformed(ActionEvent evt) {
        this.limpaTela(true);
        this.inicializar();
    }

    private void jbAdicionarProdutoActionPerformed(ActionEvent evt) {
        if (this.jtfAdicionarEstoque.getText().equals("") || this.jtfValorCusto.getText().equals("")) {
            JOptionPane.showMessageDialog(this.rootPane, "Voc\u00ea deve preencher os campos valor de custo e quantidade comprada!");
        } else {
            DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
            int cont = 0;
            for (int i = 0; i < cont; ++i) {
                modelo.setNumRows(0);
            }
            int codigoFornecedor = this.controllerFornecedor.getFornecedorController(this.cbFornecedores.getSelectedItem().toString()).getCodigo();
            float valorUnitario = 0.0f;
            float quantidade = 0.0f;
            float valorTotal = 0.0f;
            valorUnitario = Float.parseFloat(this.jtfValorCusto.getText());
            quantidade = Float.parseFloat(this.jtfAdicionarEstoque.getText());
            valorTotal = this.blmascaras.arredondamentoComPontoDuasCasas(valorUnitario * quantidade);
            modelo.addRow(new Object[]{this.cbCodProdutos.getSelectedItem().toString(), this.cbCodBarrasProdutos.getSelectedItem().toString(), this.cbNomeProduto.getSelectedItem().toString(), this.jtfValorCusto.getText(), this.jtfQuantidadeEstoqueAtual.getText(), this.jtfAdicionarEstoque.getText(), this.cbFornecedores.getSelectedItem().toString(), codigoFornecedor, Float.valueOf(valorTotal)});
            this.jtfValorTotal.setText("" + this.somaEAtualizaValorTotal() + "");
        }
    }

    private void btExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbProdutos.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
            modelo.removeRow(linhaSelecionada);
        }
    }

    private void jbCancelarActionPerformed(ActionEvent evt) {
        this.habilitarCampos(false);
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        this.listaModelProdutoses = new ArrayList();
        this.listaModelComprasProdutoses = new ArrayList();
        for (int i = 0; i < this.tbProdutos.getRowCount(); ++i) {
            this.modelProdutos = new ModelProdutos();
            this.modelComprasProdutos = new ModelComprasProdutos();
            this.modelProdutos.setCodigo(Integer.parseInt(this.tbProdutos.getValueAt(i, 0).toString()));
            this.modelProdutos.setValorCusto(Double.parseDouble(this.tbProdutos.getValueAt(i, 3).toString()));
            this.modelProdutos.setEstoque(Float.parseFloat(this.tbProdutos.getValueAt(i, 4).toString()) + (float)Integer.parseInt(this.tbProdutos.getValueAt(i, 5).toString()));
            this.modelProdutos.setFornecedoresCodigo(Integer.parseInt(this.tbProdutos.getValueAt(i, 7).toString()));
            int pcodigoCompras = this.controllerComprasProdutos.getNovoCodigoComprasController();
            this.modelComprasProdutos.setCodigo(pcodigoCompras);
            this.modelComprasProdutos.setCodigoProduto(Integer.parseInt(this.tbProdutos.getValueAt(i, 0).toString()));
            this.modelComprasProdutos.setValorCusto(Double.parseDouble(this.tbProdutos.getValueAt(i, 3).toString()));
            this.modelComprasProdutos.setQuantidade(Float.parseFloat(this.tbProdutos.getValueAt(i, 4).toString()) + (float)Integer.parseInt(this.tbProdutos.getValueAt(i, 5).toString()));
            this.modelComprasProdutos.setCodigoFornecedor(Integer.parseInt(this.tbProdutos.getValueAt(i, 7).toString()));
            try {
                this.modelComprasProdutos.setData(this.bLDatas.converterDataParaDateUS(new Date(System.currentTimeMillis())));
            }
            catch (Exception ex) {
                Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.listaModelProdutoses.add(this.modelProdutos);
            this.listaModelComprasProdutoses.add(this.modelComprasProdutos);
        }
        this.modelProdutos.setListaModelProdutoses(this.listaModelProdutoses);
        this.modelComprasProdutos.setListaModelComprasProdutoses(this.listaModelComprasProdutoses);
        if (!this.controllerProdutos.atualizarEstoqueProdutosController(this.modelProdutos)) {
            JOptionPane.showMessageDialog(this, "Compra salva com sucesso!");
            if (!this.controllerComprasProdutos.salvarComprasProdutosController(this.modelComprasProdutos)) {
                if (this.jcbGerarContaPagar.isSelected()) {
                    this.modelContaPagar.setTipoConta("PAGAR");
                    this.modelContaPagar.setCodigoPessoa(this.modelProdutos.getFornecedoresCodigo());
                    try {
                        this.modelContaPagar.setDescricao("Compra de produtos realizada no dia " + this.bLDatas.converterDataParaDateUS(new Date(System.currentTimeMillis())) + "n\u00ba do pedido de compra " + this.controllerComprasProdutos.getUltimoCodigoCompraController());
                        this.modelContaPagar.setData(this.bLDatas.converterDataParaDateUS(new Date(System.currentTimeMillis())));
                        this.modelContaPagar.setVencimento(this.bLDatas.converterDataParaDateUS(new Date(System.currentTimeMillis())));
                        this.modelContaPagar.setPagamento(this.bLDatas.converterDataParaDateUS(new Date(System.currentTimeMillis())));
                    }
                    catch (Exception ex) {
                        Logger.getLogger(ViewComprarEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.modelContaPagar.setSituacao(0);
                    this.modelContaPagar.setValor(Float.parseFloat(this.jtfValorTotal.getText()));
                    this.modelContaPagar.setTipoPagamento(1);
                    this.modelContaPagar.setObservacao("Para verificar os itens dessa conta consulte o pedido de compra na interface de compra de produtos");
                    this.controllerContaPagar.salvarContaPagarController(this.modelContaPagar);
                    JOptionPane.showMessageDialog(this, "Foi gerada um fatura sobre essa compra e criada uma conta a pagar.\nVoc\u00ea pode consultar esse conta em Contas a Pagar!");
                }
                this.habilitarCampos(false);
                this.limpaTela(false);
                this.carregarCompras();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
        }
    }

    private void jtfAdicionarEstoqueKeyReleased(KeyEvent evt) {
        this.jtfAdicionarEstoque.setText(this.blmascaras.converterVirgulaParaPonto(this.jtfAdicionarEstoque.getText()));
    }

    private void jtfAdicionarEstoqueFocusLost(FocusEvent evt) {
        this.jtfAdicionarEstoque.setText(this.blmascaras.converterVirgulaParaPonto(this.jtfAdicionarEstoque.getText()));
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        int linha = this.tbCompras.getSelectedRow();
        String nome = (String)this.tbCompras.getValueAt(linha, 1);
        int codigo = (Integer)this.tbCompras.getValueAt(linha, 0);
        this.listaModelComprasProdutoses = new ArrayList();
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro:\n\n " + nome + "? \n Os produtos adicionados no estoque para essa compra ser\u00e3o removidos autom\u00e1ticamente!", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            this.listaModelComprasProdutoses = this.controllerComprasProdutos.getListaComprasProdutosController();
            if (this.controllerComprasProdutos.excluirComprasProdutosController(codigo)) {
                if (this.controllerComprasProdutos.removerProdutoEstoqueController(this.listaModelComprasProdutoses)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", 0);
                }
                this.carregarCompras();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Voc\u00ea cancelou a exclus\u00e3o, o registro n\u00e3o foi alterado!");
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbCompras.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o imprimir!", "ATEN\u00c7\u00c3O", 2);
        } else {
            final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
            carregando.setVisible(true);
            Thread t = new Thread(){

                @Override
                public void run() {
                    ViewComprarEstoque.this.controllerComprasProdutos.gerarRelatorioCompraEstoque((Integer)ViewComprarEstoque.this.tbCompras.getValueAt(ViewComprarEstoque.this.tbCompras.getSelectedRow(), 0));
                    carregando.dispose();
                }
            };
            t.start();
        }
    }

    private void listarProdutos() {
        this.listaModelProdutoses = this.controllerProdutos.getListaProdutosController();
        this.cbCodProdutos.removeAllItems();
        this.cbCodBarrasProdutos.removeAllItems();
        this.cbNomeProduto.removeAllItems();
        for (int i = 0; i < this.listaModelProdutoses.size(); ++i) {
            this.cbCodProdutos.addItem((Object)this.listaModelProdutoses.get(i).getCodigo());
            this.cbCodBarrasProdutos.addItem((Object)this.listaModelProdutoses.get(i).getCodigoBarras());
            this.cbNomeProduto.addItem((Object)this.listaModelProdutoses.get(i).getNome());
        }
    }

    private void inicializar() {
        this.modelProdutos = this.controllerProdutos.getProdutosController(this.cbNomeProduto.getSelectedItem().toString());
        this.cbCodProdutos.setSelectedItem((Object)this.modelProdutos.getCodigo());
        this.cbCodBarrasProdutos.setSelectedItem((Object)this.modelProdutos.getCodigoBarras());
        this.jtfValorUltimaCompra.setText(this.blmascaras.arredondamentoDoubleComPontoDuasCasasString(this.modelProdutos.getValorCusto()));
        this.jtfQuantidadeEstoqueAtual.setText(this.blmascaras.arredondamentoComPontoDuasCasasString(this.modelProdutos.getEstoque()));
    }

    private void listaFornecedores() {
        this.listaModelFornecedors = this.controllerFornecedor.getListaFornecedorController();
        this.cbFornecedores.removeAllItems();
        for (int i = 0; i < this.listaModelFornecedors.size(); ++i) {
            this.cbFornecedores.addItem(this.listaModelFornecedors.get(i).getNome());
        }
    }

    private float somaEAtualizaValorTotal() {
        float soma = 0.0f;
        float valor = 0.0f;
        int cont = this.tbProdutos.getRowCount();
        for (int i = 0; i < cont; ++i) {
            valor = Float.parseFloat(String.valueOf(this.tbProdutos.getValueAt(i, 8)));
            soma = valor + soma;
        }
        return this.blmascaras.arredondamentoComPontoDuasCasas(soma);
    }

    private void limpaTela(boolean status) {
        DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
        modelo.setNumRows(0);
        this.jtfAdicionarEstoque.setText("");
        this.jtfValorCusto.setText("");
        this.habilitarCampos(status);
    }

    private void habilitarCampos(boolean status) {
        this.cbCodProdutos.setEnabled(status);
        this.cbCodBarrasProdutos.setEnabled(status);
        this.cbNomeProduto.setEnabled(status);
        this.jtfValorCusto.setEnabled(status);
        this.jtfAdicionarEstoque.setEnabled(status);
        this.btSalvar.setEnabled(status);
    }

    private void carregarCompras() {
        this.listaModelComprasProdutoses = this.controllerComprasProdutos.getListaComprasProdutosController();
        DefaultTableModel modelo = (DefaultTableModel)this.tbCompras.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelComprasProdutoses.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelComprasProdutoses.get(i).getCodigo(), this.listaModelComprasProdutoses.get(i).getData()});
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) continue;
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewComprarEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewComprarEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewComprarEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewComprarEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewComprarEstoque().setVisible(true);
            }
        });
    }

}

