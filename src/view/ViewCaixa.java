package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.ModelCaixa;
import model.ModelCliente;
import model.ModelClienteContaParcelaPag;
import model.ModelClienteContaParcelaRec;
import model.ModelContaPagar;
import model.ModelContaReceber;
import model.ModelFornecedor;
import model.ModelParcelaContaPag;
import model.ModelParcelaContaRec;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import util.AguardeImagensProjetos;
import util.BLCampoApagator;
import util.BLData;
import util.BLValida;

public class ViewCaixa
extends JFrame {
    String pNomeUsuario;
    private ModelCaixa caixa;
    public static ViewCaixa instance = null;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel6;
    private JPanel jPanelSaldoCaixa;
    private JScrollPane jScrollPane2;
    private JButton jbCancelarMovimentacao;
    private JDateChooser jdFinal;
    private JDateChooser jdInicial;
    private JLabel jlCredito;
    private JLabel jlDebito;
    private JLabel jlDiferenca;
    private JLabel jldebido;
    private JTable jtFluxoCaixa;
    private JLabel jtfCaixa;

    public ViewCaixa() {
        this.initComponents();
        BLValida.validarUsuarioSistema();
        this.setLocationRelativeTo(null);
        final AguardeImagensProjetos carregando = new AguardeImagensProjetos();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                ViewCaixa.this.setarDataHoje();
                ViewCaixa.this.carregarListaContas();
                carregando.dispose();
            }
        };
        t.start();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jbCancelarMovimentacao = new JButton();
        this.jPanel6 = new JPanel();
        this.jtfCaixa = new JLabel();
        this.jPanelSaldoCaixa = new JPanel();
        this.jLabel1 = new JLabel();
        this.jlCredito = new JLabel();
        this.jLabel2 = new JLabel();
        this.jlDiferenca = new JLabel();
        this.jlDebito = new JLabel();
        this.jldebido = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.jtFluxoCaixa = new JTable();
        this.jPanel2 = new JPanel();
        this.jdInicial = new JDateChooser();
        this.jLabel10 = new JLabel();
        this.jdFinal = new JDateChooser();
        this.jLabel9 = new JLabel();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Fluxo de Caixa");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jbCancelarMovimentacao.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.jbCancelarMovimentacao.setText("Cancelar");
        this.jbCancelarMovimentacao.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCaixa.this.jbCancelarMovimentacaoActionPerformed(evt);
            }
        });
        this.jPanel6.setBackground(new Color(204, 255, 204));
        this.jPanel6.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.jPanel6.setLayout((LayoutManager)new AbsoluteLayout());
        this.jtfCaixa.setFont(new Font("Dialog", 0, 24));
        this.jtfCaixa.setHorizontalAlignment(0);
        this.jtfCaixa.setText("Fluxo de Caixa");
        this.jtfCaixa.setHorizontalTextPosition(0);
        this.jPanel6.add((Component)this.jtfCaixa, (Object)new AbsoluteConstraints(0, 0, 720, -1));
        this.jPanelSaldoCaixa.setBorder(BorderFactory.createTitledBorder("Saldo do caixa"));
        this.jPanelSaldoCaixa.setLayout((LayoutManager)new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Tahoma", 1, 11));
        this.jLabel1.setText("Diferen\u00e7a:");
        this.jPanelSaldoCaixa.add((Component)this.jLabel1, (Object)new AbsoluteConstraints(490, 20, -1, -1));
        this.jlCredito.setForeground(new Color(0, 102, 51));
        this.jlCredito.setText("credito");
        this.jPanelSaldoCaixa.add((Component)this.jlCredito, (Object)new AbsoluteConstraints(120, 20, -1, -1));
        this.jLabel2.setFont(new Font("Tahoma", 1, 11));
        this.jLabel2.setText("Total em cr\u00e9dito:");
        this.jPanelSaldoCaixa.add((Component)this.jLabel2, (Object)new AbsoluteConstraints(10, 20, -1, -1));
        this.jlDiferenca.setForeground(new Color(0, 0, 153));
        this.jlDiferenca.setText("diferen\u00e7a");
        this.jPanelSaldoCaixa.add((Component)this.jlDiferenca, (Object)new AbsoluteConstraints(560, 20, -1, -1));
        this.jlDebito.setFont(new Font("Tahoma", 1, 11));
        this.jlDebito.setText("Total em d\u00e9bito:");
        this.jPanelSaldoCaixa.add((Component)this.jlDebito, (Object)new AbsoluteConstraints(240, 20, -1, -1));
        this.jldebido.setForeground(new Color(153, 0, 0));
        this.jldebido.setText("debito");
        this.jPanelSaldoCaixa.add((Component)this.jldebido, (Object)new AbsoluteConstraints(350, 20, -1, -1));
        this.jtFluxoCaixa.setAutoCreateRowSorter(true);
        jtFluxoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Cliente", "Data", "Vencimento", "Valor", "Tipo", "Forma de pagamento", "Tipo C/V"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jtFluxoCaixa.setAutoResizeMode(0);
        this.jtFluxoCaixa.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.jtFluxoCaixa);
        if (this.jtFluxoCaixa.getColumnModel().getColumnCount() > 0) {
            this.jtFluxoCaixa.getColumnModel().getColumn(0).setMinWidth(80);
            this.jtFluxoCaixa.getColumnModel().getColumn(0).setPreferredWidth(80);
            this.jtFluxoCaixa.getColumnModel().getColumn(1).setMinWidth(350);
            this.jtFluxoCaixa.getColumnModel().getColumn(1).setPreferredWidth(350);
            this.jtFluxoCaixa.getColumnModel().getColumn(2).setMinWidth(100);
            this.jtFluxoCaixa.getColumnModel().getColumn(2).setPreferredWidth(100);
            this.jtFluxoCaixa.getColumnModel().getColumn(3).setMinWidth(120);
            this.jtFluxoCaixa.getColumnModel().getColumn(3).setPreferredWidth(120);
            this.jtFluxoCaixa.getColumnModel().getColumn(4).setMinWidth(80);
            this.jtFluxoCaixa.getColumnModel().getColumn(4).setPreferredWidth(80);
            this.jtFluxoCaixa.getColumnModel().getColumn(5).setMinWidth(300);
            this.jtFluxoCaixa.getColumnModel().getColumn(5).setPreferredWidth(300);
        }
        this.jPanel2.setBackground(new Color(204, 204, 204));
        this.jPanel2.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.jLabel10.setText("Data final:");
        this.jLabel9.setText("Data inicial:");
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Search.png")));
        this.jButton1.setText("Filtrar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCaixa.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent((Component)this.jdInicial, -2, 154, -2).addGap(27, 27, 27).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent((Component)this.jdFinal, -2, 152, -2).addGap(18, 18, 18).addComponent(this.jButton1).addContainerGap(87, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1).addComponent(this.jLabel10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.jdFinal, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent((Component)this.jdInicial, -2, -1, -2).addComponent(this.jLabel9)))).addContainerGap(14, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanelSaldoCaixa, -2, 720, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jbCancelarMovimentacao)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 720, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane2, -2, 330, -2).addGap(9, 9, 9).addComponent(this.jPanelSaldoCaixa, -2, 50, -2).addGap(10, 10, 10).addComponent(this.jbCancelarMovimentacao).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }

    private void jbCancelarMovimentacaoActionPerformed(ActionEvent evt) {
        this.limparCampos(this.jPanelSaldoCaixa);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.carregarListaContas();
    }

    public void limparCampos(JPanel painel) {
        BLCampoApagator blCamposApagator = new BLCampoApagator();
        blCamposApagator.limparCampos(painel);
        DefaultTableModel modelo = (DefaultTableModel)this.jtFluxoCaixa.getModel();
        modelo.setNumRows(0);
    }

    private void setarDataHoje() {
        this.jdInicial.setDate(new java.util.Date());
        this.jdFinal.setDate(new java.util.Date());
    }

    private void carregarListaContas() {
    //    ControllerClienteContaParcelaRec controllerClienteContaParcelaRec = new ControllerClienteContaParcelaRec();
    //    ControllerClienteContaParcelaPag controllerClienteContaParcelaPag = new ControllerClienteContaParcelaPag();
        ArrayList listaModelClienteContaParcelaRecs = new ArrayList();
        ArrayList listaModelClienteContaParcelaPag = new ArrayList();
        ModelParcelaContaRec modelParcelaContaRec = new ModelParcelaContaRec();
        ModelParcelaContaPag modelParcelaContaPag = new ModelParcelaContaPag();
        BLData bldata = new BLData();
        float valorReceberFinal = 0.0f;
        float valorTotalReceberfinal = 0.0f;
        float valorTotalPagarfinal = 0.0f;
        float valorPagarFinal = 0.0f;
        modelParcelaContaRec.setStatus(1);
        modelParcelaContaPag.setStatus(1);
        try {
            modelParcelaContaRec.setDataRecebimento(bldata.converterDataParaDateBR(this.jdInicial.getDate()));
            modelParcelaContaRec.setDataVencimento(bldata.converterDataParaDateBR(this.jdFinal.getDate()));
            modelParcelaContaPag.setDataPagamento(bldata.converterDataParaDateBR(this.jdInicial.getDate()));
            modelParcelaContaPag.setDataVenciamento(bldata.converterDataParaDateBR(this.jdFinal.getDate()));
        }
        catch (Exception ex) {
            Logger.getLogger(ViewCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
//        listaModelClienteContaParcelaRecs = controllerClienteContaParcelaRec.getListaClienteContaParcelaController(modelParcelaContaRec);
//        listaModelClienteContaParcelaPag = controllerClienteContaParcelaPag.getListaClienteContaParcelaController(modelParcelaContaPag);
        DefaultTableModel modelo = (DefaultTableModel)this.jtFluxoCaixa.getModel();
        modelo.setNumRows(0);
        int cont = listaModelClienteContaParcelaRecs.size();
        for (int i = 0; i < cont; ++i) {
            valorReceberFinal = ((ModelClienteContaParcelaRec)listaModelClienteContaParcelaRecs.get(i)).getModelParcelaContaRec().getValorReceber();
            valorTotalReceberfinal += valorReceberFinal;
            modelo.addRow(new Object[]{((ModelClienteContaParcelaRec)listaModelClienteContaParcelaRecs.get(i)).getModelContaReceber().getCodigo(), ((ModelClienteContaParcelaRec)listaModelClienteContaParcelaRecs.get(i)).getModelCliente().getNome(), "Cr\u00e9dito", Float.valueOf(valorReceberFinal), bldata.addBarras(((ModelClienteContaParcelaRec)listaModelClienteContaParcelaRecs.get(i)).getModelParcelaContaRec().getDataRecebimento().toString()), ((ModelClienteContaParcelaRec)listaModelClienteContaParcelaRecs.get(i)).getModelContaReceber().getObservacao()});
        }
        this.jlCredito.setText("R$ " + valorTotalReceberfinal);
        int cont2 = listaModelClienteContaParcelaPag.size();
        for (int i = 0; i < cont2; ++i) {
            valorPagarFinal = ((ModelClienteContaParcelaPag)listaModelClienteContaParcelaPag.get(i)).getModelParcelaContaPag().getValorPagar();
            valorTotalPagarfinal += valorPagarFinal;
            modelo.addRow(new Object[]{((ModelClienteContaParcelaPag)listaModelClienteContaParcelaPag.get(i)).getModelContaPagar().getCodigo(), ((ModelClienteContaParcelaPag)listaModelClienteContaParcelaPag.get(i)).getModelFornecedor().getNome(), "D\u00e9bito", Float.valueOf(valorPagarFinal), bldata.addBarras(((ModelClienteContaParcelaPag)listaModelClienteContaParcelaPag.get(i)).getModelParcelaContaPag().getDataPagamento().toString()), ((ModelClienteContaParcelaPag)listaModelClienteContaParcelaPag.get(i)).getModelContaPagar().getObservacao()});
        }
        this.jldebido.setText("R$ " + valorTotalPagarfinal);
        this.jlDiferenca.setText("R$ " + (valorTotalReceberfinal - valorTotalPagarfinal));
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
            Logger.getLogger(ViewCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewCaixa().setVisible(true);
            }
        });
    }

}

