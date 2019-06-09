/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerAberturaCaixaPDV;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelAberturaCaixaPDV;
import model.ModelSessaoUsuario;
import util.AguardeGerandoRelatorio;
import util.BLDatas;

public class ViewRelatorioAberturaFechamentoCaixa
extends JFrame {
    ControllerAberturaCaixaPDV controllerAberturaCaixaPDV = new ControllerAberturaCaixaPDV();
    ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
    ArrayList<ModelAberturaCaixaPDV> listaAberturaCaixaPDVs = new ArrayList();
    private ModelSessaoUsuario sessaoUsuario = new ModelSessaoUsuario();
    BLDatas bLDatas = new BLDatas();
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTableCaixas;
    private JButton jbImprimir;
    private JButton jbPesquisar;
    private JTextField jtfPesquisaUsuario;

    public ViewRelatorioAberturaFechamentoCaixa() {
        this.initComponents();
        this.carregarCaixas();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTableCaixas = new JTable();
        this.jLabel1 = new JLabel();
        this.jtfPesquisaUsuario = new JTextField();
        this.jbPesquisar = new JButton();
        this.jbImprimir = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Relat\u00f3rio de abertura e fechamento de caixa");
        this.setResizable(false);
        this.jTableCaixas.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo", "Nome usu\u00e1rio", "Data", "Valor abert.", "Valor fech.", "Status"}){
            boolean[] canEdit;

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
           
               return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane1.setViewportView(this.jTableCaixas);
        if (this.jTableCaixas.getColumnModel().getColumnCount() > 0) {
            this.jTableCaixas.getColumnModel().getColumn(0).setMinWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(0).setPreferredWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(0).setMaxWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(2).setMinWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(2).setPreferredWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(2).setMaxWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(3).setMinWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(3).setPreferredWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(3).setMaxWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(4).setMinWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(4).setPreferredWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(4).setMaxWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(5).setMinWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(5).setPreferredWidth(100);
            this.jTableCaixas.getColumnModel().getColumn(5).setMaxWidth(100);
        }
        this.jLabel1.setText("Pesquisar por usu\u00e1rio:");
        this.jbPesquisar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Search.png")));
        this.jbPesquisar.setText("Pesquisar");
        this.jbPesquisar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewRelatorioAberturaFechamentoCaixa.this.jbPesquisarActionPerformed(evt);
            }
        });
        this.jbImprimir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/print.png")));
        this.jbImprimir.setText("Vizualizar/Imprimir selecionado");
        this.jbImprimir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewRelatorioAberturaFechamentoCaixa.this.jbImprimirActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jbImprimir).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jtfPesquisaUsuario, -2, 488, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbPesquisar, -1, -1, 32767)).addComponent(this.jLabel1).addComponent(this.jScrollPane1, -2, 757, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jtfPesquisaUsuario, -2, -1, -2).addComponent(this.jbPesquisar)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 404, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbImprimir).addContainerGap()));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }

    private void jbImprimirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.jTableCaixas.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o imprimir!", "ATEN\u00c7\u00c3O", 2);
        } else {
            final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
            carregando.setVisible(true);
            Thread t = new Thread(){

                @Override
                public void run() {
                    ViewRelatorioAberturaFechamentoCaixa.this.controllerAberturaCaixaPDV.gerarRelatorioAberturaFechamentoCaixaPDVController((Integer)ViewRelatorioAberturaFechamentoCaixa.this.jTableCaixas.getValueAt(ViewRelatorioAberturaFechamentoCaixa.this.jTableCaixas.getSelectedRow(), 0));
                    carregando.dispose();
                }
            };
            t.start();
        }
    }

    private void jbPesquisarActionPerformed(ActionEvent evt) {
        DefaultTableModel tabela = (DefaultTableModel)this.jTableCaixas.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tabela);
        this.jTableCaixas.setRowSorter(sorter);
        String text = this.jtfPesquisaUsuario.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
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
            Logger.getLogger(ViewRelatorioAberturaFechamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewRelatorioAberturaFechamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewRelatorioAberturaFechamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewRelatorioAberturaFechamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewRelatorioAberturaFechamentoCaixa().setVisible(true);
            }
        });
    }

    private void carregarCaixas() {
        this.listaAberturaCaixaPDVs = this.controllerAberturaCaixaPDV.getListaAberturaCaixaNomeUsuPDVController();
        DefaultTableModel modelo = (DefaultTableModel)this.jTableCaixas.getModel();
        modelo.setNumRows(0);
        String status = "aberto";
        int cont = this.listaAberturaCaixaPDVs.size();
        for (int i = 0; i < cont; ++i) {
            status = this.listaAberturaCaixaPDVs.get(i).getStatus() == 0 ? "fechado" : "aberto";
            modelo.addRow(new Object[]{this.listaAberturaCaixaPDVs.get(i).getCodigo(), this.listaAberturaCaixaPDVs.get(i).getNomeUsuario(), this.listaAberturaCaixaPDVs.get(i).getData(), this.listaAberturaCaixaPDVs.get(i).getValorAbertura(), this.listaAberturaCaixaPDVs.get(i).getValorFechamento(), status});
        }
    }

}

