
package view;

import controller.ControllerAberturaCaixaPDV;
import controller.ControllerCaixa;
import controller.ControllerCliente;
import controller.ControllerFormaPagamento;
import controller.ControllerPermissaousuario;
import controller.ControllerProdutos;
import controller.ControllerUsuario;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import model.ModelAberturaCaixaPDV;
import model.ModelCaixa;
import model.ModelCliente;
import model.ModelFormaPagamento;
import model.ModelPermissaousuario;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelUsuario;
import model.ModelVendas;
import model.ModelVendasProdutos;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import util.AtualizadorHorario;
import util.BLDatas;
import util.BLMascaras;
import util.ImprimePDV;

public class ViewPdv
extends JFrame {
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList();
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList();
    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
    ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
    ModelUsuario modelUsuario = new ModelUsuario();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList();
    ControllerAberturaCaixaPDV controllerAberturaCaixaPDV = new ControllerAberturaCaixaPDV();
    ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
    ArrayList<ModelAberturaCaixaPDV> listaAberturaCaixaPDVs = new ArrayList();
    ModelSessaoUsuario modelSessaoUsuario = new ModelSessaoUsuario();
    float valorCartao;
    float valorCheque;
    float valorDinheiro;
    float valorVale;
    public float quantidadeProduto;
    public int codigoProduto;
    private int returnStatus;
    public float valorTotal;
    private ViewPagamentoPDV viewPagamentoPDV;
    public float desconto;
    public int codigoVenda;
    String pNomeUsuario;
    private ButtonGroup buttonGroup1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane2;
    private JCheckBox jcbImprimirPDF;
    private JLabel jlDataHora;
    private JLabel jlOperador;
    private JMenu jmArquivo;
    private JMenu jmComandos;
    private JMenuItem jmiAlterarQuantidade;
    private JMenuItem jmiCancelarProduto;
    private JMenuItem jmiEstoque;
    private JMenuItem jmiFinalizarVenda;
    private JMenuItem jmiImprimirCupom;
    private JMenuItem jmiPesquisarProduto;
    private JMenuItem jmiSair;
    private JRadioButton jrbCodigoBarras;
    private JRadioButton jrbCodigoProduto;
    private JFormattedTextField jtfCodigoProduto;
    private JTextField jtfStatusCaixa;
    private JLabel jtfStatusDoCaixa;
    private JTextField jtfValorPagar;
    private JTable tbProdutos;

    public ViewPdv() {
        this.initComponents();
        this.quantidadeProduto = 1.0f;
        this.setExtendedState(6);
        this.configurar();
        this.viewPagamentoPDV = new ViewPagamentoPDV(this, true);
        this.jtfCodigoProduto.grabFocus();
        this.mostrarHora();
    }

    private void initComponents() {
        this.jLabel13 = new JLabel();
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jLabel11 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.tbProdutos = new JTable();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jtfValorPagar = new JTextField();
        this.jPanel4 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jtfStatusCaixa = new JTextField();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jcbImprimirPDF = new JCheckBox();
        this.jLabel15 = new JLabel();
        this.jrbCodigoBarras = new JRadioButton();
        this.jrbCodigoProduto = new JRadioButton();
        this.jLabel9 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jtfCodigoProduto = new JFormattedTextField();
        this.jLabel12 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jlOperador = new JLabel();
        this.jlDataHora = new JLabel();
        this.jLabel16 = new JLabel();
        this.jtfStatusDoCaixa = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jmArquivo = new JMenu();
        this.jmiSair = new JMenuItem();
        this.jmComandos = new JMenu();
        this.jmiAlterarQuantidade = new JMenuItem();
        this.jmiFinalizarVenda = new JMenuItem();
        this.jmiPesquisarProduto = new JMenuItem();
        this.jmiEstoque = new JMenuItem();
        this.jmiCancelarProduto = new JMenuItem();
        this.jmiImprimirCupom = new JMenuItem();
        this.jMenuItem1 = new JMenuItem();
        this.jLabel13.setText("jLabel13");
        this.setDefaultCloseOperation(2);
        this.setTitle("Vendas PDV");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jPanel1.setBackground(new Color(0,0,255));
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
 //       this.jLabel11.setIcon(new ImageIcon(this.getClass().getResource("/imagens/bl trasparente1.png")));
        this.jPanel1.add((Component)this.jLabel11, (Object)new AbsoluteConstraints(0, 0, -1, -1));
        this.tbProdutos.setAutoCreateRowSorter(true);
        this.tbProdutos.setBackground(new Color(255, 255, 204));
        this.tbProdutos.setFont(new Font("Lucida Sans Unicode", 0, 16));
        this.tbProdutos.setModel(new DefaultTableModel(new Object[0][], new String[]{"Item", "C\u00f3digo", "Nome", "Quant.", "Valor Unit.", "Valor Tot."}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbProdutos.setAutoResizeMode(0);
        this.tbProdutos.setRowSelectionAllowed(false);
        this.tbProdutos.setSelectionBackground(new Color(0, 0, 0));
        this.tbProdutos.setSelectionForeground(new Color(0, 0, 0));
        this.tbProdutos.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbProdutos);
        if (this.tbProdutos.getColumnModel().getColumnCount() > 0) {
            this.tbProdutos.getColumnModel().getColumn(0).setMaxWidth(40);
            this.tbProdutos.getColumnModel().getColumn(1).setMaxWidth(60);
            this.tbProdutos.getColumnModel().getColumn(2).setMinWidth(250);
            this.tbProdutos.getColumnModel().getColumn(2).setMaxWidth(250);
            this.tbProdutos.getColumnModel().getColumn(3).setMinWidth(50);
            this.tbProdutos.getColumnModel().getColumn(3).setMaxWidth(50);
        }
        this.jPanel2.setBackground(new Color(255, 255, 255));
        this.jPanel2.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel2.setFont(new Font("Tahoma", 1, 18));
        this.jLabel2.setText("Valor Total");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.jLabel2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING));
        this.jtfValorPagar.setFont(new Font("Tahoma", 0, 30));
        this.jtfValorPagar.setHorizontalAlignment(0);
        this.jLabel3.setFont(new Font("Tahoma", 1, 18));
        this.jLabel3.setText("Status do caixa");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(67, 67, 67).addComponent(this.jLabel3).addContainerGap(76, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING));
        this.jtfStatusCaixa.setFont(new Font("Tahoma", 0, 24));
        this.jtfStatusCaixa.setHorizontalAlignment(0);
        this.jtfStatusCaixa.setText("Caixa Livre");
        this.jLabel4.setFont(new Font("Tahoma", 1, 18));
        this.jLabel4.setText("Comandos");
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.jLabel4).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING));
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("F7 - Cancelar produto");
        this.jLabel5.setFont(new Font("Tahoma", 0, 18));
        this.jLabel5.setText("F3 - Quantidade");
        this.jLabel6.setFont(new Font("Tahoma", 0, 18));
        this.jLabel6.setText("F4 - Finalizar venda");
        this.jLabel7.setFont(new Font("Tahoma", 0, 18));
        this.jLabel7.setText("F5 - Pesquisar produto");
        this.jLabel8.setFont(new Font("Tahoma", 0, 18));
        this.jLabel8.setText("F6 - Verificar estoque");
        this.jLabel10.setFont(new Font("Tahoma", 0, 18));
        this.jLabel10.setText("F8 - Imprimir cupom manual");
        this.jcbImprimirPDF.setSelected(true);
        this.jcbImprimirPDF.setText("Imprimir cupom ao finalizar a venda");
        this.jLabel15.setFont(new Font("Tahoma", 0, 18));
        this.jLabel15.setText("F9 - Sair");
        this.buttonGroup1.add(this.jrbCodigoBarras);
        this.jrbCodigoBarras.setSelected(true);
        this.jrbCodigoBarras.setText("C\u00f3digo da Loja");
        this.buttonGroup1.add(this.jrbCodigoProduto);
        this.jrbCodigoProduto.setText("C\u00f3digo do prduto");
        this.jLabel9.setText("Buscar produtos por?");
        this.jLabel17.setFont(new Font("Tahoma", 0, 18));
        this.jLabel17.setText("Alt + F10 - Abrir/Fechar Caixa");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jtfValorPagar).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jtfStatusCaixa).addComponent(this.jPanel5, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jrbCodigoBarras).addGap(18, 18, 18).addComponent(this.jrbCodigoProduto)).addComponent(this.jLabel9)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jcbImprimirPDF).addGap(34, 34, 34)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel10).addComponent(this.jLabel15).addComponent(this.jLabel17)).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfValorPagar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfStatusCaixa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jcbImprimirPDF).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbCodigoBarras).addComponent(this.jrbCodigoProduto)).addGap(18, 18, 18).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel17).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel15).addContainerGap(-1, 32767)));
        this.jtfCodigoProduto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.jtfCodigoProduto.setFont(new Font("Tahoma", 0, 36));
        this.jtfCodigoProduto.setMaximumSize(new Dimension(6, 50));
        this.jtfCodigoProduto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jtfCodigoProdutoActionPerformed(evt);
            }
        });
        this.jtfCodigoProduto.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                ViewPdv.this.jtfCodigoProdutoKeyPressed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Tahoma", 0, 24));
        this.jLabel12.setText("Caixa: 1");
        this.jLabel14.setFont(new Font("Tahoma", 0, 24));
        this.jLabel14.setText("Operador:");
        this.jlOperador.setText("nome do operador");
        this.jlDataHora.setHorizontalAlignment(4);
        this.jlDataHora.setText("hora");
        this.jLabel16.setFont(new Font("Tahoma", 0, 14));
        this.jLabel16.setText("Caixa:");
        this.jtfStatusDoCaixa.setFont(new Font("Tahoma", 1, 14));
        this.jtfStatusDoCaixa.setForeground(new Color(255, 0, 0));
        this.jtfStatusDoCaixa.setText("Aberto"); 
      //  this.jtfStatusDoCaixa.setText("Fechado");
     
        this.jmArquivo.setText("Arquivo");
        this.jmArquivo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmArquivoActionPerformed(evt);
            }
        });
        this.jmiSair.setAccelerator(KeyStroke.getKeyStroke(120, 0));
        this.jmiSair.setText("Sair");
        this.jmiSair.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiSairActionPerformed(evt);
            }
        });
        this.jmArquivo.add(this.jmiSair);
        this.jMenuBar1.add(this.jmArquivo);
        this.jmComandos.setText("Comandos");
        this.jmiAlterarQuantidade.setAccelerator(KeyStroke.getKeyStroke(114, 0));
        this.jmiAlterarQuantidade.setText("Alterar quantidade");
        this.jmiAlterarQuantidade.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiAlterarQuantidadeActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiAlterarQuantidade);
        this.jmiFinalizarVenda.setAccelerator(KeyStroke.getKeyStroke(115, 0));
        this.jmiFinalizarVenda.setText("Finalizar venda");
        this.jmiFinalizarVenda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiFinalizarVendaActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiFinalizarVenda);
        this.jmiPesquisarProduto.setAccelerator(KeyStroke.getKeyStroke(116, 0));
        this.jmiPesquisarProduto.setText("Pesquisar produto");
        this.jmiPesquisarProduto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiPesquisarProdutoActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiPesquisarProduto);
        this.jmiEstoque.setAccelerator(KeyStroke.getKeyStroke(117, 0));
        this.jmiEstoque.setText("Verificar estoque");
        this.jmiEstoque.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiEstoqueActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiEstoque);
        this.jmiCancelarProduto.setAccelerator(KeyStroke.getKeyStroke(118, 0));
        this.jmiCancelarProduto.setText("Cancelar produto");
        this.jmiCancelarProduto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiCancelarProdutoActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiCancelarProduto);
        this.jmiImprimirCupom.setAccelerator(KeyStroke.getKeyStroke(119, 0));
        this.jmiImprimirCupom.setText("Imprimir Cupom");
        this.jmiImprimirCupom.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jmiImprimirCupomActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jmiImprimirCupom);
        this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(121, 8));
        this.jMenuItem1.setText("Abrir caixa");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPdv.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jmComandos.add(this.jMenuItem1);
        this.jMenuBar1.add(this.jmComandos);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jtfCodigoProduto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 685, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jlDataHora, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfStatusDoCaixa)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jlOperador))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 106, -2).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jlDataHora, -2, 23, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.jlOperador)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jtfStatusDoCaixa)))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 477, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfCodigoProduto, -2, -1, -2)).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        this.pack();
    }

    private void jmArquivoActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void jmiEstoqueActionPerformed(ActionEvent evt) {
        new ViewEstoquePDV().setVisible(true);
    }

    private void jtfCodigoProdutoKeyPressed(KeyEvent evt) {
        this.keyPressed(evt);
        this.statusCaixa();        
        this.jtfValorPagar.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.somaEAtualizaValorTotal()));
    }

    private void jtfCodigoProdutoActionPerformed(ActionEvent evt) {
        this.statusCaixa();
    }
   
    private void jmiAlterarQuantidadeActionPerformed(ActionEvent evt) {
        ViewQuantidadePDV viewQuantidadePDV = new ViewQuantidadePDV(this, this.rootPaneCheckingEnabled);
        viewQuantidadePDV.setVisible(true);
        this.quantidadeProduto = viewQuantidadePDV.getReturnStatus();
    }

    private void jmiCancelarProdutoActionPerformed(ActionEvent evt) {
    
      int linha = this.tbProdutos.getSelectedRow();
        String nome = (String)this.tbProdutos.getValueAt(linha, 2);
        int item = (Integer)this.tbProdutos.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o item: " + item + " \n" + "\n " + nome + "?", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
            int linhaSelecionada = this.tbProdutos.getSelectedRow();
            System.out.print("Voc\u00ea selecionou a linha" + linhaSelecionada);
            if (linhaSelecionada < 0) {
                return;
            }
            modelo.removeRow(linhaSelecionada);
        }
        
    }

    private void jmiFinalizarVendaActionPerformed(ActionEvent evt) {
        this.viewPagamentoPDV.setValorTotal(Float.parseFloat(this.jtfValorPagar.getText()));
        this.viewPagamentoPDV.setTextFildValorTotal();
        this.viewPagamentoPDV.setVisible(true);        
        this.zerarValoresCaixa();
        if (this.viewPagamentoPDV.getReturnStatus() == 1) {
            this.salvarVenda();
        }
    }

    private void jmiPesquisarProdutoActionPerformed(ActionEvent evt) {
        ViewPesquisarProdutoPDV viewPesquisarProduto = new ViewPesquisarProdutoPDV(this, this.rootPaneCheckingEnabled);
        viewPesquisarProduto.setVisible(true);
        this.codigoProduto = viewPesquisarProduto.getReturnStatus();
        this.adicionarProdutoPesquisa(this.codigoProduto);
        this.somaEAtualizaValorTotal();
    }

    private void jmiSairActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void jmiImprimirCupomActionPerformed(ActionEvent evt) {
        new ViewImprimirPDV(this, this.rootPaneCheckingEnabled).setVisible(true);
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        ControllerAberturaCaixaPDV controllerAberturaCaixaPDV = new ControllerAberturaCaixaPDV();
        ModelAberturaCaixaPDV modelAberturaCaixaPDV = controllerAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioController(ModelSessaoUsuario.codigo);
        if (modelAberturaCaixaPDV.getStatus() == 1) {
            int resposta = JOptionPane.showConfirmDialog(null, "Ao fechar o caixa o sistema ser\u00e1 fechado, deseja continuar?", "Fechar?", 0);
            if (resposta == 0) {
                this.abrirFecharCaixa();
            } else if (resposta == 1) {
                // empty if block
            }
        }
    }

    private void abrirFecharCaixa() {
        new ViewValidarAberturaCaixa(this, this.rootPaneCheckingEnabled).setVisible(true);
    }

    public void statusCaixa() {
        DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
        if (modelo.getRowCount() < 1) {
            this.jtfStatusCaixa.setText("Caixa Livre");
        } else {
            this.jtfStatusCaixa.setText("Venda em Aberta");
        }
        
    }

    public void mostrarHora() {
        AtualizadorHorario ah = new AtualizadorHorario(this.jlDataHora);
        ah.mostrarData(true);
        AtualizadorHorario thHora = ah;
        thHora.start();
    }

    private void adicionarValorCaixa() {
        this.modelCaixa = new ModelCaixa();
        this.modelCaixa = this.controllerCaixa.getCaixaController(1);
        if (this.modelVendas.getTipoPagamento() == 1) {
            this.valorDinheiro = this.modelVendas.getValorTotal();
            this.modelCaixa.setDinheiro(this.modelCaixa.getDinheiro() + this.valorDinheiro);
        } else if (this.modelVendas.getTipoPagamento() == 2) {
            this.valorCartao = this.modelVendas.getValorTotal();
            this.modelCaixa.setCartao(this.modelCaixa.getCartao() + this.valorCartao);
        } else if (this.modelVendas.getTipoPagamento() == 3) {
            this.valorCheque = this.modelVendas.getValorTotal();
            this.modelCaixa.setCheque(this.modelCaixa.getCheque() + this.valorCheque);
        } else if (this.modelVendas.getTipoPagamento() == 4) {
            this.valorVale = this.modelVendas.getValorTotal();
            this.modelCaixa.setVale(this.modelCaixa.getVale() + this.valorVale);
        }
        this.controllerCaixa.atualizarCaixaController(this.modelCaixa);
    }

    private void zerarValoresCaixa() {
        this.valorCartao = 0;
        this.valorCheque = 0.0f;
        this.valorDinheiro = 0;
        this.valorVale = 0.0f;
        
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            ControllerProdutos controllerProdutos = new ControllerProdutos();
            ModelProdutos modelProdutos = new ModelProdutos();
            DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
            BLMascaras bLMascaras = new BLMascaras();
            try {
                modelProdutos = this.jrbCodigoBarras.isSelected() ? controllerProdutos.getProdutosCodigoBarrasController(this.jtfCodigoProduto.getText()) : controllerProdutos.getProdutosController(Integer.parseInt(this.jtfCodigoProduto.getText()));
                float valorArredondado = (float)(this.quantidadeProduto * (double)modelProdutos.getValor());
                String valorArredondadoFinal = bLMascaras.arredondamentoComPontoDuasCasasString(valorArredondado);
                modelo.addRow(new Object[]{
                    this.tbProdutos.getRowCount() + 1, 
                    modelProdutos.getCodigo(), 
                    modelProdutos.getNome(), 
                    Float.valueOf(this.quantidadeProduto), 
                    modelProdutos.getValor(), 
                    valorArredondadoFinal});
                this.quantidadeProduto = 1.0f;
                this.jtfCodigoProduto.setText(null);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "C\u00f3digo inexistente!", "Aviso", 1);
            }
        }
    }

    private void adicionarProdutoPesquisa(int pCodigoProduto) {
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ModelProdutos modelProdutos = new ModelProdutos();
        DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
        modelProdutos = controllerProdutos.getProdutosController(pCodigoProduto);
        BLMascaras bLMascaras = new BLMascaras();
        float valorArredondado = (float)(modelProdutos.getValor() * (float)this.quantidadeProduto);
        float valorArredondadoFinal = bLMascaras.arredondamentoComPontoDuasCasas(valorArredondado);
        modelo.addRow(new Object[]{
        this.tbProdutos.getRowCount() + 1, 
        modelProdutos.getCodigo(), 
        modelProdutos.getNome(), 
        Float.valueOf(this.quantidadeProduto), 
        modelProdutos.getValor(), 
        Float.valueOf(valorArredondadoFinal)});
        this.quantidadeProduto = 1.0f;
        this.jtfCodigoProduto.setText(null);
    }

    private void limparTabela() {
        DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
        modelo.setNumRows(0);
        this.statusCaixa();
        this.jtfValorPagar.setText("0.00");
        
    }

    private float somaEAtualizaValorTotal() {
        float soma = 0.0f;
        float valor = 0.0f;
        int cont = this.tbProdutos.getRowCount();
        for (int i = 0; i < cont; ++i) {
            valor = Float.parseFloat(String.valueOf(this.tbProdutos.getValueAt(i, 5)));
            soma = valor + soma;
        }
        return soma;
    }

    public int getReturnStatus() {
        return this.returnStatus;
    }

    public float getValorTotal() {
        return this.valorTotal;
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
            Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewPdv().setVisible(true);
            }
        });
    }
 /*   private void imprimirCupom(){
        ControllerVendas controllerVendas = new ControllerVendas();
        controllerVendas.gerarRelatorioPDV(codigoVenda);
        statusCaixa();
    }
*/
    private void imprimirCupom() {
        ImprimePDV imprimePDV = new ImprimePDV();
        try {
            imprimePDV.geraCupomTXT(codigoVenda);
        }
        catch (IOException ex) {
            Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        statusCaixa();
    }
  
    public String retornarUsuarioLogado() {
        new ModelSessaoUsuario();
        return ModelSessaoUsuario.nome;
    }

    private void configurar() {
        this.pNomeUsuario = this.retornarUsuarioLogado();
        this.jlOperador.setText(this.pNomeUsuario);
    }

    private boolean salvarVenda() {
        int codigoProduto;
        int i;
        this.listaModelVendas = new ArrayList();
        this.listaProdutoses = new ArrayList();
        this.modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        float quantidade = 0.0f;
        BLDatas bl = new BLDatas();
        for (i = 0; i < this.tbProdutos.getRowCount(); ++i) {
            this.modelVendas = new ModelVendas();
            this.modelProdutos = new ModelProdutos();
            this.modelVendas.setClientesCodigo(1);
            this.modelVendas.setDesconto(Float.valueOf(""+ this.viewPagamentoPDV.getDesconto()));
            this.modelVendas.setValorTotal(Float.valueOf(""+ this.viewPagamentoPDV.getValorTotal()));
            
            try {
                this.modelVendas.setDataVenda(bl.converterDataParaDateUS(new Date(System.currentTimeMillis())));
                this.modelVendas.setDataSaida(bl.converterDataParaDateUS(new Date(System.currentTimeMillis())));
                this.modelVendas.setDataGarantia(bl.converterDataParaDateUS(new Date(System.currentTimeMillis())));
            }
            catch (Exception ex) {
                Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            codigoProduto = Integer.parseInt(this.tbProdutos.getValueAt(i, 1).toString());
            this.modelVendas.setProdutosCodigo(codigoProduto);
            this.modelVendas.setTipo(1);
            this.modelVendas.setQuantidade(Float.parseFloat(this.tbProdutos.getValueAt(i, 3).toString()));
            this.modelVendas.setValor(Double.parseDouble(this.tbProdutos.getValueAt(i, 4).toString()));
            this.modelVendas.setTipoPagamento(this.controllerTipoPagamento.getFormaPagamentoController(this.viewPagamentoPDV.getTipoPagamento()).getCodigo());
            this.modelProdutos.setCodigo(codigoProduto);
            quantidade = this.controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(this.tbProdutos.getValueAt(i, 3).toString());
            this.modelProdutos.setEstoque(quantidade);
            this.listaModelVendas.add(this.modelVendas);
            this.listaProdutoses.add(this.modelProdutos);
        }
        this.modelVendas.setListamModelVendases(this.listaModelVendas);
        this.modelProdutos.setListaModelProdutoses(this.listaProdutoses);
        this.codigoVenda = this.controllerVendas.salvarVendasController(this.modelVendas);
        if (this.codigoVenda > 0) {
            this.modelVendas.setCodigo(this.codigoVenda);
            for (i = 0; i < this.modelProdutos.getListaModelProdutoses().size(); ++i) {
                codigoProduto = this.modelProdutos.getListaModelProdutoses().get(i).getCodigo();
                quantidade = this.modelProdutos.getListaModelProdutoses().get(i).getEstoque();
                this.controllerProdutos.atualizarProdutosQuantidadeUmController(codigoProduto, quantidade);
            }
            this.controllerVendas.salvarVendasProdutosController(this.modelVendas);
            Double valorAtual = this.controllerAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioController(ModelSessaoUsuario.codigo).getValorFechamento();
            Double valorRecebido = Double.parseDouble("" + this.viewPagamentoPDV.getValorTotal());
            this.modelAberturaCaixaPDV.setValorFechamento(new BLMascaras().arredondamentoComPontoDuasCasasDouble(valorAtual + valorRecebido));
            this.modelAberturaCaixaPDV.setCodigoUsuario(ModelSessaoUsuario.codigo);
            this.controllerAberturaCaixaPDV.atualizarValorFechamentoCaixaController(this.modelAberturaCaixaPDV);
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.adicionarValorCaixa();
            if (this.jcbImprimirPDF.isSelected()) {
                this.imprimirCupom();
                try {
                    this.imprimirCupomTXT();
                } catch (IOException ex) {
                    Logger.getLogger(ViewPdv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.limparTabela();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
        return false;
    }

    public void imprimirCupomTXT() throws IOException {
        ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ControllerVendas controllerVendas = new ControllerVendas();
        ArrayList listaModelVendasProdutoses = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras bLMascaras = new BLMascaras();
        modelVendas = controllerVendas.getVendasController(79);
        listaModelVendasProdutoses = controllerVendasProdutos.getListaVendasProdutosController(79);
        System.out.println("Entrei aqui 2");
        FileWriter arq = new FileWriter("C:/BLVendasPdvMySQL/relImprimir.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.println(" AREFRIGERAÇÃO TECNICA LTDA");
        gravarArq.println(" RUA: SANTA RITA, 1000");
        gravarArq.println(" CEP: 79100-000 - UB\u00c1 - MS");
        gravarArq.println(" CNPJ: 12.345.678/0001-10");
        gravarArq.println("--------------------------------");
        gravarArq.println("        CUPOM N\u00c3O FISCAL        ");
        gravarArq.println("--------------------------------");
        gravarArq.println("QT   PRE\u00c7O   DESCRI\u00c7\u00c3O");
        gravarArq.println("");
        System.out.println("Entrei aqui 3");
        for (int i = 0; i < listaModelVendasProdutoses.size(); ++i) {
            gravarArq.println("" + ((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getQuantidade() + " x " + bLMascaras.arredondamentoDoubleComPontoDuasCasasString(controllerProdutos.getProdutosController(((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getCodigo_produto()).getValor()) + " - " + controllerProdutos.getProdutosController(((ModelVendasProdutos)listaModelVendasProdutoses.get(i)).getCodigo_produto()).getNome());
        }
        gravarArq.println("--------------------------------");
        gravarArq.println("                 Valor bruto: " + modelVendas.getValorTotal());
        gravarArq.println("                 Desconto: " + modelVendas.getDesconto());
        gravarArq.println("                 Valor total: " + (modelVendas.getValorTotal() - modelVendas.getDesconto()));
        arq.close();
    }
    

}

