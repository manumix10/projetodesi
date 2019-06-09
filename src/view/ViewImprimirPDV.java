/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerCliente;
import controller.ControllerVendas;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ModelVendas;
import util.ImprimePDV;

public class ViewImprimirPDV
extends JDialog {
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList();
    ControllerCliente controllerCliente = new ControllerCliente();
    private JButton btPesquisar;
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JLabel jLabel8;
    private JScrollPane jScrollPane4;
    private JButton jbImprimir;
    private JTextField jtfPesquisa;
    private JRadioButton rbCompleto;
    private JRadioButton rbPDV;
    private JTable tbConsultasVendas;

    public ViewImprimirPDV(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarVendas();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jScrollPane4 = new JScrollPane();
        this.tbConsultasVendas = new JTable();
        this.jtfPesquisa = new JTextField();
        this.jLabel8 = new JLabel();
        this.btPesquisar = new JButton();
        this.jbImprimir = new JButton();
        this.jButton1 = new JButton();
        this.rbCompleto = new JRadioButton();
        this.rbPDV = new JRadioButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Imprimir Relat\u00f3rio");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.tbConsultasVendas.setAutoCreateRowSorter(true);
        this.tbConsultasVendas.setModel(new DefaultTableModel(new Object[][]{{null, null}}, new String[]{"Venda", "Cliente"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbConsultasVendas.setAutoResizeMode(0);
        this.tbConsultasVendas.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane4.setViewportView(this.tbConsultasVendas);
        if (this.tbConsultasVendas.getColumnModel().getColumnCount() > 0) {
            this.tbConsultasVendas.getColumnModel().getColumn(1).setMinWidth(450);
            this.tbConsultasVendas.getColumnModel().getColumn(1).setMaxWidth(450);
        }
        this.jtfPesquisa.setToolTipText("Digite o texto exatamente como deseja pesquisar, diferencia mai\u00fasculo de min\u00fasculo.");
        this.jLabel8.setText("Pesquisa:");
        this.btPesquisar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Search.png")));
        this.btPesquisar.setText("Pesquisar");
        this.btPesquisar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewImprimirPDV.this.btPesquisarActionPerformed(evt);
            }
        });
        this.jbImprimir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/print.png")));
        this.jbImprimir.setText("Imprimir");
        this.jbImprimir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewImprimirPDV.this.jbImprimirActionPerformed(evt);
            }
        });
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Close.png")));
        this.jButton1.setText("Fechar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewImprimirPDV.this.jButton1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.rbCompleto);
        this.rbCompleto.setText("Formato completo PDF");
        this.buttonGroup1.add(this.rbPDV);
        this.rbPDV.setSelected(true);
        this.rbPDV.setText("Formato PDV");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -2, 539, -2).addGroup(layout.createSequentialGroup().addComponent(this.jtfPesquisa, -2, 333, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btPesquisar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbImprimir))))).addGroup(layout.createSequentialGroup().addGap(108, 108, 108).addComponent(this.rbPDV).addGap(83, 83, 83).addComponent(this.rbCompleto)).addGroup(layout.createSequentialGroup().addGap(223, 223, 223).addComponent(this.jButton1))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btPesquisar).addComponent(this.jbImprimir).addComponent(this.jtfPesquisa, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.rbCompleto).addComponent(this.rbPDV)).addGap(18, 18, 18).addComponent(this.jScrollPane4, -1, 298, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap()));
        this.pack();
    }

    private void btPesquisarActionPerformed(ActionEvent evt) {
        DefaultTableModel tabela = (DefaultTableModel)this.tbConsultasVendas.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tabela);
        this.tbConsultasVendas.setRowSorter(sorter);
        String text = this.jtfPesquisa.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }

    private void jbImprimirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbConsultasVendas.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            ControllerVendas controllerVendas = new ControllerVendas();
            int linha = this.tbConsultasVendas.getSelectedRow();
            int codigo = (Integer)this.tbConsultasVendas.getValueAt(linha, 0);
            if (this.rbCompleto.isSelected()) {
                controllerVendas.gerarRelatorioVenda(codigo);
            } else {
                ImprimePDV imprimePDV = new ImprimePDV();
                try {
                    imprimePDV.geraCupomTXT(codigo);
                }
                catch (IOException ex) {
                    Logger.getLogger(ViewImprimirPDV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void carregarVendas() {
        this.listaModelVendas = this.controllerVendas.getListaPedidosController();
        DefaultTableModel modelo = (DefaultTableModel)this.tbConsultasVendas.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelVendas.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelVendas.get(i).getCodigo(), this.controllerCliente.getClienteController(this.listaModelVendas.get(i).getClientesCodigo()).getNome()});
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
            Logger.getLogger(ViewImprimirPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewImprimirPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewImprimirPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewImprimirPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewImprimirPDV dialog = new ViewImprimirPDV(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter(){

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }

        });
    }

}

