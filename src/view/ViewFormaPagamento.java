/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerFormaPagamento;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import model.ModelFormaPagamento;
import util.BLTiraAcentos;

public class ViewFormaPagamento
extends JFrame {
    ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
    ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
    ArrayList<ModelFormaPagamento> listaFormaPagamentos = new ArrayList();
    String tipoCadastro;
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btExcluir;
    private JButton btNovo;
    private JButton btSalvar;
    private ButtonGroup buttonGroup1;
    private JComboBox jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JRadioButton rbAtivo;
    private JRadioButton rbInativo;
    private JTable tbFormaPagamento;
    private JTextField tfCodigo;
    private JFormattedTextField tfDesconto;
    private JTextField tfDescricao;
    private JTextArea tfObservacao;
    private JFormattedTextField tfQuantidadeParcelas;

    public ViewFormaPagamento() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarFormaPagamento();
        this.habilitarCampos(false);
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jComboBox1 = new JComboBox();
        this.jLabel1 = new JLabel();
        this.tfCodigo = new JTextField();
        this.tfDescricao = new JTextField();
        this.jLabel2 = new JLabel();
        this.btCancelar = new JButton();
        this.btSalvar = new JButton();
        this.jLabel3 = new JLabel();
        this.tfDesconto = new JFormattedTextField();
        this.tfQuantidadeParcelas = new JFormattedTextField();
        this.jLabel4 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jScrollPane2 = new JScrollPane();
        this.tbFormaPagamento = new JTable();
        this.btNovo = new JButton();
        this.btAlterar = new JButton();
        this.btExcluir = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.tfObservacao = new JTextArea();
        this.jLabel6 = new JLabel();
        this.jPanel1 = new JPanel();
        this.rbAtivo = new JRadioButton();
        this.rbInativo = new JRadioButton();
        this.jComboBox1.setModel(new DefaultComboBoxModel<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.setDefaultCloseOperation(2);
        this.setTitle("Forma de pagamento");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jLabel1.setText("C\u00f3digo:");
        this.tfCodigo.setEditable(false);
        this.tfCodigo.setEnabled(false);
        this.tfDescricao.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFormaPagamento.this.tfDescricaoFocusLost(evt);
            }
        });
        this.jLabel2.setText("Descri\u00e7\u00e3o:");
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFormaPagamento.this.btCancelarActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar");
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFormaPagamento.this.btSalvarActionPerformed(evt);
            }
        });
        this.jLabel3.setText("% Desconto:");
        this.tfDesconto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.tfQuantidadeParcelas.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.jLabel4.setText("Quant. Parcelas:");
        this.tbFormaPagamento.setAutoCreateRowSorter(true);
        this.tbFormaPagamento.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null}}, new String[]{"C\u00f3digo", "Descri\u00e7\u00e3o", "Desconto", "Parcela", "Situa\u00e7\u00e3o"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this.tbFormaPagamento.setAutoResizeMode(0);
        this.tbFormaPagamento.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbFormaPagamento);
        if (this.tbFormaPagamento.getColumnModel().getColumnCount() > 0) {
            this.tbFormaPagamento.getColumnModel().getColumn(1).setMinWidth(300);
            this.tbFormaPagamento.getColumnModel().getColumn(1).setPreferredWidth(300);
            this.tbFormaPagamento.getColumnModel().getColumn(4).setMinWidth(110);
            this.tbFormaPagamento.getColumnModel().getColumn(4).setPreferredWidth(110);
            this.tbFormaPagamento.getColumnModel().getColumn(4).setMaxWidth(110);
        }
        this.btNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovo.setText("Novo");
        this.btNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFormaPagamento.this.btNovoActionPerformed(evt);
            }
        });
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFormaPagamento.this.btAlterarActionPerformed(evt);
            }
        });
        this.btExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.btExcluir.setText("Excluir");
        this.btExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFormaPagamento.this.btExcluirActionPerformed(evt);
            }
        });
        this.tfObservacao.setColumns(20);
        this.tfObservacao.setRows(5);
        this.jScrollPane1.setViewportView(this.tfObservacao);
        this.jLabel6.setText("Observa\u00e7\u00e3o:");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("Situa\u00e7\u00e3o:"));
        this.buttonGroup1.add(this.rbAtivo);
        this.rbAtivo.setSelected(true);
        this.rbAtivo.setText("Ativo");
        this.buttonGroup1.add(this.rbInativo);
        this.rbInativo.setText("Inativo");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.rbAtivo).addGap(32, 32, 32).addComponent(this.rbInativo).addContainerGap(45, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.rbAtivo).addComponent(this.rbInativo)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator1).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.btCancelar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btExcluir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btAlterar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btNovo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 219, 32767).addComponent(this.btSalvar)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.tfCodigo, -2, 97, -2).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(0, 0, 32767)).addComponent(this.tfDescricao))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfDesconto, -2, 97, -2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfQuantidadeParcelas, -2, 93, -2).addComponent(this.jLabel4))).addComponent(this.jPanel1, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.jLabel6).addGap(0, 0, 32767)))).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfCodigo, -2, -1, -2).addComponent(this.tfDescricao, -2, -1, -2)).addGap(11, 11, 11).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel6)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 103, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfDesconto, -2, -1, -2).addComponent(this.tfQuantidadeParcelas, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 258, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btCancelar).addComponent(this.btSalvar).addComponent(this.btNovo).addComponent(this.btAlterar).addComponent(this.btExcluir)).addContainerGap()));
        this.pack();
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        if (this.tipoCadastro.equals("novo")) {
            this.salvarFormaPagamento();
            this.novaFormaPagamento();
            this.tfCodigo.setText("");
        } else if (this.tipoCadastro.equals("alteracao")) {
            this.alterarFormaPagamento();
            this.novaFormaPagamento();
            this.tfCodigo.setText("");
        }
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.novaFormaPagamento();
        this.tfCodigo.setText("");
        this.habilitarCampos(false);
    }

    private void btAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbFormaPagamento.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.novaFormaPagamento();
            this.habilitarCampos(true);
            this.tipoCadastro = "alteracao";
            this.retornarFormaPagamento();
        }
    }

    private void btNovoActionPerformed(ActionEvent evt) {
        this.novaFormaPagamento();
        this.habilitarCampos(true);
    }

    private void btExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbFormaPagamento.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.excluirFormapagamento();
        }
    }

    private void tfDescricaoFocusLost(FocusEvent evt) {
        this.tfDescricao.setText(this.tfDescricao.getText().toUpperCase());
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.tfDescricao.setText(blTiraAcentos.TiraAcentos(this.tfDescricao.getText()));
    }

    private void alterarFormaPagamento() {
        try {
            this.modelFormaPagamento.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
            this.modelFormaPagamento.setDescricao(this.tfDescricao.getText());
            this.modelFormaPagamento.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
            this.modelFormaPagamento.setQuantidadeParcelas(Integer.parseInt(this.tfQuantidadeParcelas.getText()));
            this.modelFormaPagamento.setObservacao(this.tfObservacao.getText());
            if (this.rbAtivo.isSelected()) {
                this.modelFormaPagamento.setSituacao(true);
            } else {
                this.modelFormaPagamento.setSituacao(false);
            }
            if (this.controllerFormaPagamento.atualizarFormaPagamentoController(this.modelFormaPagamento)) {
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                this.habilitarCampos(false);
                this.carregarFormaPagamento();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR.!", "ERRO", 0);
        }
    }

    private void salvarFormaPagamento() {
        try {
            this.modelFormaPagamento.setDescricao(this.tfDescricao.getText());
            this.modelFormaPagamento.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
            this.modelFormaPagamento.setQuantidadeParcelas(Integer.parseInt(this.tfQuantidadeParcelas.getText()));
            this.modelFormaPagamento.setObservacao(this.tfObservacao.getText());
            if (this.rbAtivo.isSelected()) {
                this.modelFormaPagamento.setSituacao(true);
            } else {
                this.modelFormaPagamento.setSituacao(false);
            }
            if (this.controllerFormaPagamento.salvarFormaPagamentoController(this.modelFormaPagamento) > 0) {
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                this.habilitarCampos(false);
                this.carregarFormaPagamento();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR.!", "ERRO", 0);
        }
    }

    private void excluirFormapagamento() {
        int linha = this.tbFormaPagamento.getSelectedRow();
        String nome = (String)this.tbFormaPagamento.getValueAt(linha, 1);
        int codigo = (Integer)this.tbFormaPagamento.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro \nNome: " + nome + " ?", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            if (this.controllerFormaPagamento.excluirFormaPagamentoController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarFormaPagamento();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao e os dados!", "ERRO", 0);
            }
        }
    }

    private boolean retornarFormaPagamento() {
        int linha = this.tbFormaPagamento.getSelectedRow();
        int codigo = (Integer)this.tbFormaPagamento.getValueAt(linha, 0);
        try {
            this.modelFormaPagamento = this.controllerFormaPagamento.getFormaPagamentoController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelFormaPagamento.getCodigo()));
            this.tfDescricao.setText(this.modelFormaPagamento.getDescricao());
            this.tfDesconto.setText(String.valueOf(this.modelFormaPagamento.getDesconto()));
            this.tfQuantidadeParcelas.setText(String.valueOf(this.modelFormaPagamento.getQuantidadeParcelas()));
            this.tfObservacao.setText(this.modelFormaPagamento.getObservacao());
            if (this.modelFormaPagamento.isSituacao()) {
                this.rbAtivo.setSelected(true);
            } else {
                this.rbInativo.setSelected(true);
            }
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void novaFormaPagamento() {
        this.habilitarCampos(true);
        this.tfCodigo.setText("Novo");
        this.tfDescricao.setText("");
        this.tfDesconto.setText("");
        this.tfQuantidadeParcelas.setText("");
        this.tfObservacao.setText("");
        this.tipoCadastro = "novo";
    }

    private void habilitarCampos(boolean pStatus) {
        this.tfDescricao.setEditable(pStatus);
        this.tfDesconto.setEditable(pStatus);
        this.tfQuantidadeParcelas.setEditable(pStatus);
        this.tfObservacao.setEditable(pStatus);
        this.btSalvar.setEnabled(pStatus);
    }

    private void carregarFormaPagamento() {
        this.listaFormaPagamentos = this.controllerFormaPagamento.getListaFormaPagamentoController();
        DefaultTableModel modelo = (DefaultTableModel)this.tbFormaPagamento.getModel();
        modelo.setNumRows(0);
        String situacao = "";
        int cont = this.listaFormaPagamentos.size();
        for (int i = 0; i < cont; ++i) {
            situacao = !this.listaFormaPagamentos.get(i).isSituacao() ? "Inativo" : "Ativo";
            modelo.addRow(new Object[]{this.listaFormaPagamentos.get(i).getCodigo(), this.listaFormaPagamentos.get(i).getDescricao(), Float.valueOf(this.listaFormaPagamentos.get(i).getDesconto()), this.listaFormaPagamentos.get(i).getQuantidadeParcelas(), situacao});
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
            Logger.getLogger(ViewFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewFormaPagamento().setVisible(true);
            }
        });
    }

}

