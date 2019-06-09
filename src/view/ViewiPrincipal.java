package view;


import componentes.UJPanelImagem;
import controller.ControllerAberturaCaixaPDV;
import controller.ControllerCliente;
import controller.ControllerFornecedor;
import controller.ControllerPermissaousuario;
import controller.ControllerProdutos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.ModelAberturaCaixaPDV;
import model.ModelPermissaousuario;
import model.ModelSessaoUsuario;
import util.Aguarde;
import util.AguardeGerandoRelatorio;
import util.Datas;

public class ViewiPrincipal
extends JFrame {
    String pNomeUsuario;
    ModelSessaoUsuario modelSessaoUsuario = new ModelSessaoUsuario();
    ControllerAberturaCaixaPDV controllerAberturaCaixaPDV = new ControllerAberturaCaixaPDV();
    ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
    private JButton btClientes;    
    private JButton btContasReceber;
    private JButton btContaspagar;
    private JButton btFluxoCaixa;
    private JButton btFornecedores;
    private JButton btOrcamento;
    private JButton btPDV;
    private JButton btProdutos;
    private JButton btRegistrarVenda;
    private JButton btVideoAula;
    private JCheckBoxMenuItem jCheckBoxMenuItem1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenuBar jMenuBar1;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JSeparator jSeparator1;
    private JToolBar jToolBar1;
    private JLabel jlData;
    private JLabel jlUsuario;
    private JMenu jmAjuda;
    private JMenu jmArquivo;
    private JMenu jmCadastrar;
    private JMenu jmFinanceiro;
    private JMenu jmVendas;
    private JMenuItem jmiAcessoRemoto;
    private JMenuItem jmiAtivacao;
    private JMenuItem jmiClientes;
    private JMenuItem jmiNotaFiscal;
    private JMenuItem jmiComprarImpressora;
    private JMenuItem jmiComprasEstoque;
    private JMenuItem jmiConsultarVenda;
    private JMenuItem jmiContasPagar;
    private JMenuItem jmiContasReceber;
    private JMenuItem jmiFornecedor;
    private JMenuItem jmiProdutos;
    private JMenuItem jmiRegistrarVenda;
    private JMenuItem jmiRelClientes;
    private JMenuItem jmiRelFornecedor;
    private JMenuItem jmiRelProdutos;
    private JMenuItem jmiRelatorioAberturaFechamentoCaixa;
    private JMenuItem jmiRelatorioContasPagar;
    private JMenuItem jmiRelatorioVenda;
    private JMenuItem jmiRelatorioVendasPeriodo;
    private JMenuItem jmiSobre;
    private JMenuItem jmiUsuario;
    private JMenuItem jmiVideoAula;
    private JMenuItem miCidades;
    private JMenuItem miEmpresa;
    private JMenuItem miFluxoCaixa;
    private JMenuItem miFormaPagamento;
    private JMenuItem miOrcamento;
    private JMenuItem miPDV;
    private JMenuItem miRelatorioContasReceber;
    private JMenuItem miUnidadeMedida;
    private JMenuItem mnuSair;
    private UJPanelImagem uJPanelImagem1;

    public ViewiPrincipal() {
        this.setExtendedState(6);
        this.initComponents();
        this.configurar();
        this.liberarModulos();
    }

    private void initComponents() {
        this.jMenuBar2 = new JMenuBar();
        this.jMenu2 = new JMenu();
        this.jMenu3 = new JMenu();
        this.jMenu4 = new JMenu();
        this.jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
        this.uJPanelImagem1 = new UJPanelImagem();
        this.jPanel1 = new JPanel();
        this.jToolBar1 = new JToolBar();
        this.jLabel1 = new JLabel();
        this.btClientes = new JButton();        
        this.btProdutos = new JButton();
        this.btFornecedores = new JButton();
        this.jLabel2 = new JLabel();
        this.btRegistrarVenda = new JButton();
        this.btOrcamento = new JButton();
        this.btPDV = new JButton();
        this.jLabel3 = new JLabel();
        this.btContaspagar = new JButton();
        this.btContasReceber = new JButton();
        this.btFluxoCaixa = new JButton();
        this.jLabel7 = new JLabel();
        this.btVideoAula = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jlUsuario = new JLabel();
        this.jlData = new JLabel();
        this.jLabel5 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jmArquivo = new JMenu();
        this.jmiSobre = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnuSair = new JMenuItem();
        this.jmCadastrar = new JMenu();
        this.jmiClientes = new JMenuItem();
        this.jmiNotaFiscal = new JMenuItem();
        this.jmiProdutos = new JMenuItem();
        this.jmiFornecedor = new JMenuItem();
        this.jmiUsuario = new JMenuItem();
        this.miCidades = new JMenuItem();
        this.miEmpresa = new JMenuItem();
        this.miUnidadeMedida = new JMenuItem();
        this.miFormaPagamento = new JMenuItem();
        this.jmiComprasEstoque = new JMenuItem();
        this.jmVendas = new JMenu();
        this.jmiRegistrarVenda = new JMenuItem();
        this.jmiConsultarVenda = new JMenuItem();
        this.miOrcamento = new JMenuItem();
        this.miPDV = new JMenuItem();
        this.jmFinanceiro = new JMenu();
        this.jmiContasPagar = new JMenuItem();
        this.jmiContasReceber = new JMenuItem();
        this.miFluxoCaixa = new JMenuItem();
        this.jMenu1 = new JMenu();
        this.jmiRelClientes = new JMenuItem();
        this.jmiRelFornecedor = new JMenuItem();
        this.jmiRelProdutos = new JMenuItem();
        this.jmiRelatorioVendasPeriodo = new JMenuItem();
        this.jmiRelatorioVenda = new JMenuItem();
        this.jmiRelatorioContasPagar = new JMenuItem();
        this.miRelatorioContasReceber = new JMenuItem();
        this.jMenuItem1 = new JMenuItem();
        this.jmiRelatorioAberturaFechamentoCaixa = new JMenuItem();
        this.jMenu5 = new JMenu();
        this.jmiVideoAula = new JMenuItem();
        this.jmAjuda = new JMenu();
        this.jMenuItem3 = new JMenuItem();
        this.jmiAcessoRemoto = new JMenuItem();
        this.jmiComprarImpressora = new JMenuItem();
        this.jmiAtivacao = new JMenuItem();
        this.jMenu2.setText("File");
        this.jMenuBar2.add(this.jMenu2);
        this.jMenu3.setText("Edit");
        this.jMenuBar2.add(this.jMenu3);
        this.jMenu4.setText("jMenu4");
        this.jCheckBoxMenuItem1.setSelected(true);
        this.jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
        this.setDefaultCloseOperation(3);
        this.setTitle("Sistema de Ordem de Serviços");
        this.setFocusTraversalPolicyProvider(true);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setLocationByPlatform(true);
        this.uJPanelImagem1.setImagem(new File("C:\\Sistema Assistencia OS\\SistemaAssistenciaOS\\src\\imagens\\png.png"));
        this.jToolBar1.setBackground(new Color(204, 204, 204));
        this.jToolBar1.setBorder(BorderFactory.createTitledBorder(null, "Menu r\u00e1pido", 2, 3, new Font("Tahoma", 0, 11), new Color(102, 102, 102)));
        this.jToolBar1.setForeground(new Color(102, 102, 102));
        this.jToolBar1.setOrientation(1);
        this.jToolBar1.setRollover(true);
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setForeground(new Color(0, 51, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Cadastro");
        this.jToolBar1.add(this.jLabel1);
        this.btClientes.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/User group.png")));
        this.btClientes.setText("Clientes");
        this.btClientes.setBorder(BorderFactory.createEtchedBorder());
        this.btClientes.setEnabled(false);
        this.btClientes.setHorizontalAlignment(2);
        this.btClientes.setMaximumSize(new Dimension(200, 40));
        this.btClientes.setMinimumSize(new Dimension(200, 40));
        this.btClientes.setPreferredSize(new Dimension(200, 40));
        this.btClientes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btClientesActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btClientes);
        this.btProdutos.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/produtos24x24.png")));
        this.btProdutos.setText("Produtos");
        this.btProdutos.setBorder(BorderFactory.createEtchedBorder());
        this.btProdutos.setEnabled(false);
        this.btProdutos.setHorizontalAlignment(2);
        this.btProdutos.setMaximumSize(new Dimension(200, 40));
        this.btProdutos.setMinimumSize(new Dimension(200, 40));
        this.btProdutos.setPreferredSize(new Dimension(200, 40));
        this.btProdutos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btProdutosActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btProdutos);
        this.btFornecedores.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Boss.png")));
        this.btFornecedores.setText("Fornecedor");
        this.btFornecedores.setBorder(BorderFactory.createEtchedBorder());
        this.btFornecedores.setEnabled(false);
        this.btFornecedores.setHorizontalAlignment(2);
        this.btFornecedores.setMaximumSize(new Dimension(200, 40));
        this.btFornecedores.setMinimumSize(new Dimension(200, 40));
        this.btFornecedores.setPreferredSize(new Dimension(200, 40));
        this.btFornecedores.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btFornecedoresActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btFornecedores);
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setForeground(new Color(0, 51, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Vendas");
        this.jToolBar1.add(this.jLabel2);
        this.btRegistrarVenda.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/ordem24x24.png")));
        this.btRegistrarVenda.setText("Registrar uma Ordem");
        this.btRegistrarVenda.setBorder(BorderFactory.createEtchedBorder());
        this.btRegistrarVenda.setEnabled(false);
        this.btRegistrarVenda.setHorizontalAlignment(2);
        this.btRegistrarVenda.setMaximumSize(new Dimension(200, 40));
        this.btRegistrarVenda.setMinimumSize(new Dimension(200, 40));
        this.btRegistrarVenda.setPreferredSize(new Dimension(200, 40));
        this.btRegistrarVenda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btRegistrarVendaActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btRegistrarVenda);
        this.btOrcamento.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/orcamento24x25.png")));
        this.btOrcamento.setText("Registrar Or\u00e7amento");
        this.btOrcamento.setBorder(BorderFactory.createEtchedBorder());
        this.btOrcamento.setEnabled(false);
        this.btOrcamento.setFocusable(false);
        this.btOrcamento.setHorizontalAlignment(2);
        this.btOrcamento.setMaximumSize(new Dimension(200, 40));
        this.btOrcamento.setMinimumSize(new Dimension(200, 40));
        this.btOrcamento.setPreferredSize(new Dimension(200, 40));
        this.btOrcamento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btOrcamentoActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btOrcamento);
        this.btPDV.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Shopping cart.png")));
        this.btPDV.setText("Vendas em PDV");
        this.btPDV.setBorder(BorderFactory.createEtchedBorder());
        this.btPDV.setEnabled(false);
        this.btPDV.setFocusable(false);
        this.btPDV.setHorizontalAlignment(2);
        this.btPDV.setHorizontalTextPosition(4);
        this.btPDV.setMaximumSize(new Dimension(200, 40));
        this.btPDV.setMinimumSize(new Dimension(200, 40));
        this.btPDV.setPreferredSize(new Dimension(200, 40));
        this.btPDV.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btPDVActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btPDV);
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setForeground(new Color(0, 51, 255));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Financeiro");
        this.jToolBar1.add(this.jLabel3);
        this.btContaspagar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Upload.png")));
        this.btContaspagar.setText("Contas a pagar");
        this.btContaspagar.setBorder(BorderFactory.createEtchedBorder());
        this.btContaspagar.setEnabled(false);
        this.btContaspagar.setFocusable(false);
        this.btContaspagar.setHorizontalAlignment(2);
        this.btContaspagar.setHorizontalTextPosition(4);
        this.btContaspagar.setMaximumSize(new Dimension(200, 40));
        this.btContaspagar.setMinimumSize(new Dimension(200, 40));
        this.btContaspagar.setPreferredSize(new Dimension(200, 40));
        this.btContaspagar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btContaspagarActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btContaspagar);
        this.btContasReceber.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Download.png")));
        this.btContasReceber.setText("Contas a receber");
        this.btContasReceber.setBorder(BorderFactory.createEtchedBorder());
        this.btContasReceber.setEnabled(false);
        this.btContasReceber.setFocusable(false);
        this.btContasReceber.setHorizontalAlignment(2);
        this.btContasReceber.setHorizontalTextPosition(4);
        this.btContasReceber.setMaximumSize(new Dimension(200, 40));
        this.btContasReceber.setMinimumSize(new Dimension(200, 40));
        this.btContasReceber.setPreferredSize(new Dimension(200, 40));
        this.btContasReceber.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btContasReceberActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btContasReceber);
        this.btFluxoCaixa.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Left-right.png")));
        this.btFluxoCaixa.setText("Fluxo de caixa");
        this.btFluxoCaixa.setBorder(BorderFactory.createEtchedBorder());
        this.btFluxoCaixa.setEnabled(false);
        this.btFluxoCaixa.setFocusable(false);
        this.btFluxoCaixa.setHideActionText(true);
        this.btFluxoCaixa.setHorizontalAlignment(2);
        this.btFluxoCaixa.setHorizontalTextPosition(4);
        this.btFluxoCaixa.setMaximumSize(new Dimension(200, 40));
        this.btFluxoCaixa.setMinimumSize(new Dimension(200, 40));
        this.btFluxoCaixa.setPreferredSize(new Dimension(200, 40));
        this.btFluxoCaixa.setVerticalTextPosition(3);
        this.btFluxoCaixa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btFluxoCaixaActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btFluxoCaixa);
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setForeground(new Color(0, 51, 255));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("Outros");
        this.jToolBar1.add(this.jLabel7);
        this.btVideoAula.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/devolucao24x24.png")));
        this.btVideoAula.setText("Devolução de Mercadoria");
        this.btVideoAula.setBorder(BorderFactory.createEtchedBorder());
        this.btVideoAula.setFocusable(false);
        this.btVideoAula.setHideActionText(true);
        this.btVideoAula.setHorizontalAlignment(2);
        this.btVideoAula.setMaximumSize(new Dimension(200, 40));
        this.btVideoAula.setMinimumSize(new Dimension(200, 40));
        this.btVideoAula.setPreferredSize(new Dimension(200, 40));
        this.btVideoAula.setVerticalTextPosition(3);
        this.btVideoAula.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.btVideoAulaActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btVideoAula);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jToolBar1, -2, 203, -2).addGap(0, 1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jToolBar1, -1, 563, 32767).addGap(0, 0, 0)));
        this.jPanel2.setBackground(new Color(102, 102, 102));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel6.setForeground(new Color(255, 255, 255));
        this.jLabel6.setText("Alt+C = Clientes   - Alt+N = Clientes   -   Alt+P = Produtos   -   Alt+F = Fornecedor   -   Alt+V = Vendas  -   Alt+G = Contas Pagar   -    Alt+R = Contas a Receber   -  Or\u00e7amento =  ALt+O   -   Alt+D = PDV");
        this.jPanel2.add(this.jLabel6);
        GroupLayout uJPanelImagem1Layout = new GroupLayout((Container)this.uJPanelImagem1);
        this.uJPanelImagem1.setLayout((LayoutManager)uJPanelImagem1Layout);
        uJPanelImagem1Layout.setHorizontalGroup(uJPanelImagem1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(uJPanelImagem1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)).addComponent(this.jPanel2, -1, 1029, 32767));
        uJPanelImagem1Layout.setVerticalGroup(uJPanelImagem1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(uJPanelImagem1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(2, 2, 2).addComponent(this.jPanel1, -1, -1, 32767)));
        this.jPanel3.setBackground(new Color(102, 102, 102));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setForeground(new Color(255, 255, 255));
        this.jLabel4.setText("Logado como:");
        this.jlUsuario.setForeground(new Color(255, 255, 255));
        this.jlUsuario.setText("usuario");
        this.jlData.setForeground(new Color(255, 255, 255));
        this.jlData.setText("data");
        this.jLabel5.setForeground(new Color(255, 255, 255));
        this.jLabel5.setText("Data/Hora de login:");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jlUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 787, 32767).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jlData)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jlUsuario, -1, -1, 32767).addComponent(this.jlData, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel4, -2, 22, -2)).addComponent(this.jLabel5, -1, -1, 32767));
        this.jmArquivo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Folder.png")));
        this.jmArquivo.setText("Arquivo");
        this.jmiSobre.setText("Sobre o Sistema...");
        this.jmiSobre.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiSobreActionPerformed(evt);
            }
        });
        this.jmArquivo.add(this.jmiSobre);
        this.jmArquivo.add(this.jSeparator1);
        this.mnuSair.setAccelerator(KeyStroke.getKeyStroke(115, 8));
        this.mnuSair.setText("Sair");
        this.mnuSair.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.mnuSairActionPerformed(evt);
            }
        });
        this.jmArquivo.add(this.mnuSair);
        this.jMenuBar1.add(this.jmArquivo);
        this.jmCadastrar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Create.png")));
        this.jmCadastrar.setText("Cadastros");
        this.jmiClientes.setAccelerator(KeyStroke.getKeyStroke(67, 8));
        this.jmiClientes.setText("Clientes");
        this.jmiClientes.setEnabled(false);
        this.jmiClientes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiClientesActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.jmiNotaFiscal);
        this.jmiNotaFiscal.setAccelerator(KeyStroke.getKeyStroke(67, 8));
        this.jmiNotaFiscal.setText("Nota Fiscal");
        this.jmiNotaFiscal.setEnabled(false);
        this.jmiNotaFiscal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiNotaFiscalActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.jmiClientes);
        this.jmiProdutos.setAccelerator(KeyStroke.getKeyStroke(80, 8));
        this.jmiProdutos.setText("Produtos");
        this.jmiProdutos.setEnabled(false);
        this.jmiProdutos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiProdutosActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.jmiProdutos);
        this.jmiFornecedor.setAccelerator(KeyStroke.getKeyStroke(70, 8));
        this.jmiFornecedor.setText("Fornecedores");
        this.jmiFornecedor.setEnabled(false);
        this.jmiFornecedor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiFornecedorActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.jmiFornecedor);
        this.jmiUsuario.setAccelerator(KeyStroke.getKeyStroke(85, 8));
        this.jmiUsuario.setText("Usu\u00e1rios");
        this.jmiUsuario.setEnabled(false);
        this.jmiUsuario.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiUsuarioActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.jmiUsuario);
        this.miCidades.setText("Cidades");
        this.miCidades.setEnabled(false);
        this.miCidades.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miCidadesActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.miCidades);
        this.miEmpresa.setText("Empresa");
        this.miEmpresa.setEnabled(false);
        this.miEmpresa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miEmpresaActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.miEmpresa);
        this.miUnidadeMedida.setText("Unidade de Medida");
        this.miUnidadeMedida.setEnabled(false);
        this.miUnidadeMedida.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miUnidadeMedidaActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.miUnidadeMedida);
        this.miFormaPagamento.setText("Formas de Pagamentos");
        this.miFormaPagamento.setEnabled(false);
        this.miFormaPagamento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miFormaPagamentoActionPerformed(evt);
            }
        });
        this.jmCadastrar.add(this.miFormaPagamento);
         this.jmiComprasEstoque.setText("Compras e Estoque de Produtos");
        this.jmiComprasEstoque.setEnabled(false);
        this.jmiComprasEstoque.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiComprasEstoqueActionPerformed(evt);
            }
        });
 
        this.jmCadastrar.add(this.jmiComprasEstoque);
        this.jMenuBar1.add(this.jmCadastrar);
        this.jmVendas.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Shopping cart.png")));
        this.jmVendas.setText("Ordem de Serviços");
        this.jmiRegistrarVenda.setAccelerator(KeyStroke.getKeyStroke(86, 8));
        this.jmiRegistrarVenda.setText("Ordem de Serviços");
        this.jmiRegistrarVenda.setEnabled(false);
        this.jmiRegistrarVenda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRegistrarVendaActionPerformed(evt);
            }
        });
        this.jmVendas.add(this.jmiRegistrarVenda);
        this.jmiConsultarVenda.setText("Consultar uma Ordem");
        this.jmiConsultarVenda.setEnabled(false);
        this.jmiConsultarVenda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiConsultarVendaActionPerformed(evt);
            }
        });
        this.jmVendas.add(this.jmiConsultarVenda);
        this.miOrcamento.setText("Or\u00e7amento");
        this.miOrcamento.setEnabled(false);
        this.miOrcamento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miOrcamentoActionPerformed(evt);
            }
        });
        this.jmVendas.add(this.miOrcamento);
        this.miPDV.setAccelerator(KeyStroke.getKeyStroke(68, 8));
        this.miPDV.setText("Vendas em PDV");
        this.miPDV.setEnabled(false);
        this.miPDV.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miPDVActionPerformed(evt);
            }
        });
        this.jmVendas.add(this.miPDV);
        this.jMenuBar1.add(this.jmVendas);
        this.jmFinanceiro.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Dollar.png")));
        this.jmFinanceiro.setText("Financeiro");
        this.jmiContasPagar.setAccelerator(KeyStroke.getKeyStroke(71, 8));
        this.jmiContasPagar.setText("Conta a pagar");
        this.jmiContasPagar.setEnabled(false);
        this.jmiContasPagar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiContasPagarActionPerformed(evt);
            }
        });
        this.jmFinanceiro.add(this.jmiContasPagar);
        this.jmiContasReceber.setAccelerator(KeyStroke.getKeyStroke(82, 8));
        this.jmiContasReceber.setText("Contas a receber");
        this.jmiContasReceber.setEnabled(false);
        this.jmiContasReceber.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiContasReceberActionPerformed(evt);
            }
        });
        this.jmFinanceiro.add(this.jmiContasReceber);
        this.miFluxoCaixa.setText("Fluxo de caixa");
        this.miFluxoCaixa.setEnabled(false);
        this.miFluxoCaixa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miFluxoCaixaActionPerformed(evt);
            }
        });
        this.jmFinanceiro.add(this.miFluxoCaixa);
        this.jMenuBar1.add(this.jmFinanceiro);
        this.jMenu1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Report.png")));
        this.jMenu1.setText("Relat\u00f3rios");
        this.jmiRelClientes.setText("Clientes");
        this.jmiRelClientes.setEnabled(false);
        this.jmiRelClientes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelClientesActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelClientes);
        this.jmiRelFornecedor.setText("Fornecedores");
        this.jmiRelFornecedor.setEnabled(false);
        this.jmiRelFornecedor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelFornecedorActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelFornecedor);
        this.jmiRelProdutos.setText("Produtos");
        this.jmiRelProdutos.setEnabled(false);
        this.jmiRelProdutos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelProdutosActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelProdutos);
        this.jmiRelatorioVendasPeriodo.setText("Vendas por pe\u00edodo");
        this.jmiRelatorioVendasPeriodo.setEnabled(false);
        this.jmiRelatorioVendasPeriodo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelatorioVendasPeriodoActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelatorioVendasPeriodo);
        this.jmiRelatorioVenda.setText("Venda unit\u00e1ria");
        this.jmiRelatorioVenda.setEnabled(false);
        this.jmiRelatorioVenda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelatorioVendaActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelatorioVenda);
        this.jmiRelatorioContasPagar.setText("Relat\u00f3rio de contas a pagar");
        this.jmiRelatorioContasPagar.setEnabled(false);
        this.jmiRelatorioContasPagar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelatorioContasPagarActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelatorioContasPagar);
        this.miRelatorioContasReceber.setText("Relat\u00f3rio de contas a receber");
        this.miRelatorioContasReceber.setEnabled(false);
        this.miRelatorioContasReceber.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.miRelatorioContasReceberActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.miRelatorioContasReceber);
        this.jMenuItem1.setText("C\u00f3digo de barras");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jMenuItem1ActionPerformed(evt);
            }
        });
       
        this.jMenu1.add(this.jMenuItem1);
        this.jmiRelatorioAberturaFechamentoCaixa.setText("Abertura/Fechamento Caixa");
        this.jmiRelatorioAberturaFechamentoCaixa.setEnabled(false);
        this.jmiRelatorioAberturaFechamentoCaixa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jmiRelatorioAberturaFechamentoCaixaActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jmiRelatorioAberturaFechamentoCaixa);
        this.jMenu1.add(this.jmiRelatorioAberturaFechamentoCaixa);
        this.jMenuBar1.add(this.jMenu1);
        
  //      this.jMenu5.add(this.jmiVideoAula);
        this.jMenuBar1.add(this.jMenu5);
        this.jmAjuda.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Help.png")));
        this.jmAjuda.setText("Ajuda");
        this.jMenuItem3.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Help book 3d.png")));
        this.jMenuItem3.setText("Suporte");
        this.jMenuItem3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewiPrincipal.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.jmAjuda.add(this.jMenuItem3);        
        
        this.jMenuBar1.add(this.jmAjuda);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.uJPanelImagem1, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent((Component)this.uJPanelImagem1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2)));
        this.pack();
    }

    private void jmiSobreActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Desenvolvimento de Sistemas");
    }

    private void mnuSairActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jmiClientesActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewClientes().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }
    
    private void jmiNotaFiscalActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewNotaFiscal().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiProdutosActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewProduto().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiFornecedorActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewFornecedor().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiRegistrarVendaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewVenda().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiConsultarVendaActionPerformed(ActionEvent evt) {
        ViewVenda venda = new ViewVenda();
        venda.setViewConsultarVendas();
        venda.setVisible(true);
    }

    private void jmiRelClientesActionPerformed(ActionEvent evt) {
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerCliente controllerCliente = new ControllerCliente();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                controllerCliente.gerarRelatorioCliente();
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiRelFornecedorActionPerformed(ActionEvent evt) {
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                controllerFornecedor.gerarRelatorioFornecedor();
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiRelProdutosActionPerformed(ActionEvent evt) {
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerProdutos controllerProdutos = new ControllerProdutos();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                controllerProdutos.gerarRelatorioProdutos();
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiUsuarioActionPerformed(ActionEvent evt) {
        new ViewUsuario().setVisible(true);
    }

    private void btContasReceberActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewContasReceber().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btContaspagarActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewContasPagar().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btRegistrarVendaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewVenda().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btFornecedoresActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewFornecedor().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btProdutosActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewProduto().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btClientesActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewClientes().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        new ViewSuporte(this, this.rootPaneCheckingEnabled).setVisible(true);
    }

    private void jmiRelatorioVendasPeriodoActionPerformed(ActionEvent evt) {
        new ViewRelatorioVendas().setVisible(true);
    }

    private void jmiRelatorioVendaActionPerformed(ActionEvent evt) {
        new ViewImprimirPDV(this, this.rootPaneCheckingEnabled).setVisible(true);
    }

    private void jmiContasPagarActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewContasPagar().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiContasReceberActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewContasReceber().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiRelatorioContasPagarActionPerformed(ActionEvent evt) {
        new ViewRelatoriosContasPagar().setVisible(true);
    }

    private void miCidadesActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewCidade().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void miEmpresaActionPerformed(ActionEvent evt) {
        new ViewEmpresa().setVisible(true);
    }

    private void miUnidadeMedidaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewUnidadeMedia().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void miFormaPagamentoActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewFormaPagamento().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void btOrcamentoActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewOrcamento().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void miRelatorioContasReceberActionPerformed(ActionEvent evt) {
        new ViewRelatoriosContasReceber().setVisible(true);
    }

    private void btPDVActionPerformed(ActionEvent evt) {
        int statusCaixa = this.controllerAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioController(ModelSessaoUsuario.codigo).getStatus();
        if (statusCaixa == 1) {
            new ViewPdv().setVisible(true);
        } else {
            new ViewValidarAberturaCaixa(this, this.rootPaneCheckingEnabled).setVisible(true);
        }
    }

    private void miOrcamentoActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewOrcamento().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void miPDVActionPerformed(ActionEvent evt) {
        int statusCaixa = this.controllerAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioController(ModelSessaoUsuario.codigo).getStatus();
        if (statusCaixa == 1) {
            new ViewPdv().setVisible(true);
        } else {
            new ViewValidarAberturaCaixa(this, this.rootPaneCheckingEnabled).setVisible(true);
        }
    }

    private void btFluxoCaixaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewFluxoCaixa().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void miFluxoCaixaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewFluxoCaixa().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        new ViewCodigobarras().setVisible(true);
    }


    private void jmiComprasEstoqueActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewComprarEstoque().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }

    private void jmiRelatorioAberturaFechamentoCaixaActionPerformed(ActionEvent evt) {
        final Aguarde carregando = new Aguarde();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                new ViewRelatorioAberturaFechamentoCaixa().setVisible(true);
                carregando.dispose();
            }
        };
        t.start();
    }


    private void btVideoAulaActionPerformed(ActionEvent evt) {
        new ViewDevolucao().setVisible(true);
    }

    public void irURL(String URL2) {
        try {
            Runtime.getRuntime().exec("explorer.exe " + URL2);
        }
        catch (IOException ex) {
            System.out.println("Desculpe, falha na execu\u00e7\u00e3o do acesso remoto!");
        }
    }

    public String retornarUsuarioLogado() {
        new ModelSessaoUsuario();
        return ModelSessaoUsuario.nome;
    }

    private void configurar() {
        this.pNomeUsuario = this.retornarUsuarioLogado();
        this.jlUsuario.setText(this.pNomeUsuario);
        Datas bLDatas = new Datas();
        this.jlData.setText(bLDatas.retornarDataHora());
    }

    private void liberarModulos() {
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ArrayList listaModelPermissaousuarios = new ArrayList();
        new ModelSessaoUsuario();
        listaModelPermissaousuarios = controllerPermissaousuario.getListaPermissaousuarioController(ModelSessaoUsuario.codigo);
        for (int i = 0; i < listaModelPermissaousuarios.size(); ++i) {
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("cliente")) {
                this.btClientes.setEnabled(true);
                this.jmiRelClientes.setEnabled(true);
                this.jmiClientes.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("nota")) {                
                this.jmiNotaFiscal.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("produto")) {
                this.btProdutos.setEnabled(true);
                this.jmiRelProdutos.setEnabled(true);
                this.jmiProdutos.setEnabled(true);
                this.jmiComprasEstoque.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("fornecedor")) {
                this.btFornecedores.setEnabled(true);
                this.jmiFornecedor.setEnabled(true);
                this.jmiRelFornecedor.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("usuario")) {
                this.jmiUsuario.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("venda")) {
                this.btRegistrarVenda.setEnabled(true);
                this.jmiRegistrarVenda.setEnabled(true);
                this.jmiConsultarVenda.setEnabled(true);
                this.jmiRelatorioVenda.setEnabled(true);
                this.jmiRelatorioVendasPeriodo.setEnabled(true);
                this.btPDV.setEnabled(true);
                this.miPDV.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("pagar")) {
                this.btContaspagar.setEnabled(true);
                this.jmiContasPagar.setEnabled(true);
                this.jmiRelatorioContasPagar.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("receber")) {
                this.btContasReceber.setEnabled(true);
                this.jmiContasReceber.setEnabled(true);
                this.miRelatorioContasReceber.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("caixa")) {
                this.jmiRelatorioContasPagar.setEnabled(true);
                this.miFluxoCaixa.setEnabled(true);
                this.btFluxoCaixa.setEnabled(true);
                this.jmiRelatorioAberturaFechamentoCaixa.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("empresa")) {
                this.miEmpresa.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("fornecedor")) {
                this.jmiFornecedor.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("cidade")) {
                this.miCidades.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("unidade")) {
                this.miUnidadeMedida.setEnabled(true);
            }
            if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("pagamento")) {
                this.miFormaPagamento.setEnabled(true);
            }
            if (!((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("orcamento")) continue;
            this.miOrcamento.setEnabled(true);
            this.btOrcamento.setEnabled(true);
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
            Logger.getLogger(ViewiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewiPrincipal().setVisible(true);
            }
        });
    }

    private void JButton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

