/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  componentes.UJComboBox
 *  org.netbeans.lib.awtextra.AbsoluteConstraints
 *  org.netbeans.lib.awtextra.AbsoluteLayout
 */
package view;

import componentes.UJComboBox;
import controller.ControllerFornecedor;
import controller.ControllerProdutoFornecedorUM;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ModelFornecedor;
import model.ModelProdutoFornecedorUM;
import model.ModelProdutos;
import model.ModelUnidadeMedia;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import util.Mascaras;
import util.TiraAcentos;

public class ViewProduto
extends JFrame {
    ModelProdutos modelProdutos = new ModelProdutos();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
    ArrayList<ModelUnidadeMedia> listaModelUnidadeMedias = new ArrayList();
    ArrayList<ModelProdutos> listamModelProdutos = new ArrayList();
    ArrayList<ModelFornecedor> listaFornecedor = new ArrayList();
    ArrayList<ModelProdutoFornecedorUM> listaModelProdutoFornecedorUMs = new ArrayList();
    ModelProdutoFornecedorUM modelProdutoFornecedorUM = new ModelProdutoFornecedorUM();
    ControllerProdutoFornecedorUM controllerProdutoFornecedorUM = new ControllerProdutoFornecedorUM();
    String tipoCadastro;
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btExcluir;
    private JButton btNovo;
    private JButton btPesquisaProduto;
    private ButtonGroup buttonGroup1;
    private UJComboBox cbFornecedores;
    private JComboBox cbUnidadeMedida;
    private JLabel jLabel1;
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
    private JButton jbSalvar;
    private JRadioButton jrbCodigoBarras;
    private JRadioButton jrbNomeProdutos;
    private JTextField jtfNome;
    private JTable tbProdutos;
    private JTextField tfCodigo;
    private JTextField tfCodigoBarras;
    private JTextField tfPesquisaProduto;
    private JTextField tfValorCusto;
    private JFormattedTextField tfValorVenda;

    public ViewProduto() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarProdutos();
        this.listarFornecedor();
        this.listarUnidadeMedidas();
        this.desabilitarCampos();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.btPesquisaProduto = new JButton();
        this.jLabel1 = new JLabel();
        this.btNovo = new JButton();
        this.btAlterar = new JButton();
        this.btExcluir = new JButton();
        this.btCancelar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.tbProdutos = new JTable();
        this.jbSalvar = new JButton();
        this.tfCodigo = new JTextField();
        this.jLabel5 = new JLabel();
        this.jtfNome = new JTextField();
        this.tfPesquisaProduto = new JTextField();
        this.jLabel8 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel2 = new JLabel();
        this.tfValorVenda = new JFormattedTextField();
        this.tfValorCusto = new JTextField();
        this.jLabel9 = new JLabel();
        this.jLabel6 = new JLabel();
        this.tfCodigoBarras = new JTextField();
        this.jLabel3 = new JLabel();
        this.cbFornecedores = new UJComboBox();
        this.cbUnidadeMedida = new JComboBox();
        this.jLabel7 = new JLabel();
        this.jrbNomeProdutos = new JRadioButton();
        this.jrbCodigoBarras = new JRadioButton();
        this.jLabel4 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Produtos");
        this.setAlwaysOnTop(true);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setMaximumSize(null);
        this.setResizable(false);
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
        this.btPesquisaProduto.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Search.png")));
        this.btPesquisaProduto.setText("Pesquisar");
        this.btPesquisaProduto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.btPesquisaProdutoActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.btPesquisaProduto, (Object)new AbsoluteConstraints(601, 170, 130, -1));
        this.jLabel1.setText("Nome:");
        this.jPanel1.add((Component)this.jLabel1, (Object)new AbsoluteConstraints(160, 10, -1, -1));
        this.btNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovo.setText("Novo");
        this.btNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.btNovoActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.btNovo, (Object)new AbsoluteConstraints(290, 510, -1, -1));
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.btAlterarActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.btAlterar, (Object)new AbsoluteConstraints(200, 510, -1, -1));
        this.btExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.btExcluir.setText("Excluir");
        this.btExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.btExcluirActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.btExcluir, (Object)new AbsoluteConstraints(110, 510, -1, -1));
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.btCancelarActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.btCancelar, (Object)new AbsoluteConstraints(10, 510, -1, -1));
        this.tbProdutos.setAutoCreateRowSorter(true);
        this.tbProdutos.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null}}, new String[]{"C\u00f3digo", "C\u00f3digo Loja", "Nome", "Valor Custo", "Valor Venda", "Fornecedor"}){
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
        this.tbProdutos.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbProdutos);
        if (this.tbProdutos.getColumnModel().getColumnCount() > 0) {
            this.tbProdutos.getColumnModel().getColumn(0).setMinWidth(60);
            this.tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
            this.tbProdutos.getColumnModel().getColumn(0).setMaxWidth(60);
            this.tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(120);
            this.tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(300);
            this.tbProdutos.getColumnModel().getColumn(5).setPreferredWidth(200);
        }
        this.jPanel1.add((Component)this.jScrollPane2, (Object)new AbsoluteConstraints(10, 220, 730, 270));
        this.jbSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.jbSalvar.setText("Salvar");
        this.jbSalvar.setEnabled(false);
        this.jbSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewProduto.this.jbSalvarActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jbSalvar, (Object)new AbsoluteConstraints(650, 510, -1, -1));
        this.tfCodigo.setEditable(false);
        this.tfCodigo.setEnabled(false);
        this.jPanel1.add((Component)this.tfCodigo, (Object)new AbsoluteConstraints(10, 30, 140, -1));
        this.jLabel5.setText("C\u00f3digo:");
        this.jPanel1.add((Component)this.jLabel5, (Object)new AbsoluteConstraints(10, 10, -1, -1));
        this.jtfNome.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewProduto.this.jtfNomeFocusLost(evt);
            }
        });
        this.jPanel1.add((Component)this.jtfNome, (Object)new AbsoluteConstraints(158, 31, 480, -1));
        this.tfPesquisaProduto.setToolTipText("Digite o texto exatamente como deseja pesquisar, diferencia mai\u00fasculo de min\u00fasculo.");
        this.tfPesquisaProduto.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewProduto.this.tfPesquisaProdutoFocusLost(evt);
            }
        });
        this.jPanel1.add((Component)this.tfPesquisaProduto, (Object)new AbsoluteConstraints(10, 180, 380, -1));
        this.jLabel8.setText("Pesquisar:");
        this.jPanel1.add((Component)this.jLabel8, (Object)new AbsoluteConstraints(10, 160, -1, -1));
        this.jPanel2.setBackground(new Color(255, 204, 204));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder("Pre\u00e7o"));
        this.jPanel2.setLayout((LayoutManager)new AbsoluteLayout());
        this.jLabel2.setText("Valor de venda:");
        this.jPanel2.add((Component)this.jLabel2, (Object)new AbsoluteConstraints(130, 30, -1, -1));
        this.tfValorVenda.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewProduto.this.tfValorVendaFocusLost(evt);
            }
        });
        this.jPanel2.add((Component)this.tfValorVenda, (Object)new AbsoluteConstraints(130, 50, 100, -1));
        this.tfValorCusto.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewProduto.this.tfValorCustoFocusLost(evt);
            }
        });
        this.jPanel2.add((Component)this.tfValorCusto, (Object)new AbsoluteConstraints(20, 50, 100, -1));
        this.jLabel9.setText("Valor de custo:");
        this.jPanel2.add((Component)this.jLabel9, (Object)new AbsoluteConstraints(20, 30, -1, -1));
        this.jLabel6.setFont(new Font("Tahoma", 1, 11));
        this.jLabel6.setText("C\u00f3digo da Loja:");
        this.jPanel2.add((Component)this.jLabel6, (Object)new AbsoluteConstraints(240, 30, -1, -1));
        this.tfCodigoBarras.setBackground(new Color(255, 255, 204));
        this.jPanel2.add((Component)this.tfCodigoBarras, (Object)new AbsoluteConstraints(240, 50, 170, -1));
        this.jLabel3.setText("Fornecedor:");
        this.jPanel2.add((Component)this.jLabel3, (Object)new AbsoluteConstraints(420, 30, -1, -1));
        this.jPanel2.add((Component)this.cbFornecedores, (Object)new AbsoluteConstraints(420, 50, 290, -1));
        this.jPanel1.add((Component)this.jPanel2, (Object)new AbsoluteConstraints(10, 60, 720, 90));
        this.jPanel1.add((Component)this.cbUnidadeMedida, (Object)new AbsoluteConstraints(650, 30, 80, -1));
        this.jLabel7.setText("Unid. Med.");
        this.jPanel1.add((Component)this.jLabel7, (Object)new AbsoluteConstraints(650, 10, -1, -1));
        this.buttonGroup1.add(this.jrbNomeProdutos);
        this.jrbNomeProdutos.setText("Nome Prod.");
        this.jPanel1.add((Component)this.jrbNomeProdutos, (Object)new AbsoluteConstraints(500, 180, -1, -1));
        this.buttonGroup1.add(this.jrbCodigoBarras);
        this.jrbCodigoBarras.setSelected(true);
        this.jrbCodigoBarras.setText("Cod. da Loja");
        this.jPanel1.add((Component)this.jrbCodigoBarras, (Object)new AbsoluteConstraints(400, 180, -1, -1));
        this.jLabel4.setText("Pesquisar por:");
        this.jPanel1.add((Component)this.jLabel4, (Object)new AbsoluteConstraints(400, 160, -1, -1));
        this.getContentPane().add((Component)this.jPanel1, (Object)new AbsoluteConstraints(0, 0, 750, 550));
        this.pack();
    }

    private void btPesquisaProdutoActionPerformed(ActionEvent evt) {
        DefaultTableModel tabela = (DefaultTableModel)this.tbProdutos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tabela);
        this.tbProdutos.setRowSorter(sorter);
        String text = this.tfPesquisaProduto.getText();
        if (this.jrbCodigoBarras.isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (this.jrbNomeProdutos.isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter(text, 2));
        } else {
            JOptionPane.showMessageDialog(null, "ATEN\u00c7\u00c2O: Voc\u00ea deve selecionar uma op\u00e7\u00e3o para pesquisar! Em 'Pesquisar por:'", "Menssagem de alerta", 2);
        }
    }

    private void btNovoActionPerformed(ActionEvent evt) {
        this.novoProduto();
        this.jbSalvar.setEnabled(true);
        this.habilitarCampos();
        this.tipoCadastro = "novo";
        this.jtfNome.grabFocus();
    }

    private void btAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbProdutos.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.novoProduto();
            this.jbSalvar.setEnabled(true);
            this.habilitarCampos();
            this.recuperarProduto();
            this.tipoCadastro = "alteracao";
        }
    }

    private void btExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbProdutos.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.excluirProduto();
        }
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.desabilitarCampos();
        this.jbSalvar.setEnabled(false);
    }

    private void jbSalvarActionPerformed(ActionEvent evt) {
        if (this.tipoCadastro.equals("novo")) {
            this.salvarProduto();
        } else if (this.tipoCadastro.equals("alteracao")) {
            this.alterarProduto();
            this.jbSalvar.setEnabled(false);
        }
    }

    private void tfValorVendaFocusLost(FocusEvent evt) {
        this.tfValorVenda.setText(new Mascaras().converterVirgulaParaPonto(this.tfValorVenda.getText()));
    }

    private void jtfNomeFocusLost(FocusEvent evt) {
        this.jtfNome.setText(this.jtfNome.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.jtfNome.setText(blTiraAcentos.TiraAcentos(this.jtfNome.getText()));
    }

    private void tfPesquisaProdutoFocusLost(FocusEvent evt) {
        this.tfPesquisaProduto.setText(this.tfPesquisaProduto.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfPesquisaProduto.setText(blTiraAcentos.TiraAcentos(this.tfPesquisaProduto.getText()));
    }

    private void tfValorCustoFocusLost(FocusEvent evt) {
        this.tfValorCusto.setText(new Mascaras().converterVirgulaParaPonto(this.tfValorCusto.getText()));
    }

    private void listarUnidadeMedidas() {
        this.listaModelUnidadeMedias = this.controllerUnidadeMedia.getListaUnidadeMediaController();
        this.cbUnidadeMedida.removeAllItems();
        for (int i = 0; i < this.listaModelUnidadeMedias.size(); ++i) {
            this.cbUnidadeMedida.addItem(this.listaModelUnidadeMedias.get(i).getAbreviacao());
        }
    }

    private void listarFornecedor() {
        this.listaFornecedor = this.controllerFornecedor.getListaFornecedorController();
        this.cbFornecedores.removeAllItems();
        for (int i = 0; i < this.listaFornecedor.size(); ++i) {
            this.cbFornecedores.addItem((Object)this.listaFornecedor.get(i).getNome());
        }
    }

    private void excluirProduto() {
        int linha = this.tbProdutos.getSelectedRow();
        String nome = (String)this.tbProdutos.getValueAt(linha, 1);
        int codigo = (Integer)this.tbProdutos.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro \nNome: " + nome + " ?", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            if (this.controllerProdutos.excluirProdutosController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarProdutos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao e os dados!", "ERRO", 0);
            }
        }
    }

    private boolean recuperarProduto() {
        int linha = this.tbProdutos.getSelectedRow();
        int codigo = (Integer)this.tbProdutos.getValueAt(linha, 0);
        try {
            this.modelProdutos = this.controllerProdutos.getProdutosController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelProdutos.getCodigo()));
            this.jtfNome.setText(this.modelProdutos.getNome());
            this.tfValorVenda.setText(this.modelProdutos.getValor().toString());
            this.tfValorCusto.setText(this.modelProdutos.getValorCusto().toString());
            this.cbFornecedores.setSelectedItem((Object)this.controllerFornecedor.getFornecedorController(this.modelProdutos.getFornecedoresCodigo()).getNome());
            this.tfCodigoBarras.setText(this.modelProdutos.getCodigoBarras());
            this.cbUnidadeMedida.setSelectedItem(this.controllerUnidadeMedia.getUnidadeMediaController(this.modelProdutos.getUnidadeMedida()).getAbreviacao());
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void alterarProduto() {
        try {
            this.modelProdutos.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
            this.modelProdutos.setNome(this.jtfNome.getText());
            this.modelProdutos.setValor(Double.parseDouble(this.tfValorVenda.getText()));
            this.modelProdutos.setValorCusto(Double.parseDouble(this.tfValorCusto.getText()));
            this.modelProdutos.setFornecedoresCodigo(this.controllerFornecedor.getFornecedorController(this.cbFornecedores.getSelectedItem().toString()).getCodigo());
            this.modelProdutos.setCodigoBarras(this.tfCodigoBarras.getText());
            this.modelProdutos.setUnidadeMedida(this.controllerUnidadeMedia.getUnidadeMediaController(this.cbUnidadeMedida.getSelectedItem().toString()).getCodigo());
            if (this.controllerProdutos.atualizarProdutosController(this.modelProdutos)) {
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                this.desabilitarCampos();
                this.carregarProdutos();
                this.limparDados();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR.!", "ERRO", 0);
        }
    }

    private void carregarProdutos() {
        this.listaModelProdutoFornecedorUMs = this.controllerProdutoFornecedorUM.getlistaProdutoFornecedorUM();
        DefaultTableModel modelo = (DefaultTableModel)this.tbProdutos.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelProdutoFornecedorUMs.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelProdutoFornecedorUMs.get(i).getModelProdutos().getCodigo(), this.listaModelProdutoFornecedorUMs.get(i).getModelProdutos().getCodigoBarras(), this.listaModelProdutoFornecedorUMs.get(i).getModelProdutos().getNome(), this.listaModelProdutoFornecedorUMs.get(i).getModelProdutos().getValorCusto(), this.listaModelProdutoFornecedorUMs.get(i).getModelProdutos().getValor(), this.listaModelProdutoFornecedorUMs.get(i).getModelFornecedor().getNome()});
        }
    }

    private void limparDados() {
        this.jtfNome.setText("");
        this.tfValorVenda.setText("");
        this.tfValorCusto.setText("");
        this.tfPesquisaProduto.setText("");
    }

    private void desabilitarCampos() {
        this.jtfNome.setEnabled(false);
        this.tfValorVenda.setEnabled(false);
        this.tfCodigoBarras.setEnabled(false);
        this.jbSalvar.setEnabled(false);
        this.tfValorCusto.setEnabled(false);
        this.carregarProdutos();
    }

    private void novoProduto() {
        this.habilitarCampos();
        this.tfCodigo.setText("Novo");
        this.jtfNome.setText("");
        this.tfValorVenda.setText("");
        this.tfValorCusto.setText("");
        this.tfCodigoBarras.setText("");
        this.jbSalvar.setEnabled(true);
        this.cbFornecedores.setSelectedItem((Object)"");
        this.tipoCadastro = "novo";
    }

    private void habilitarCampos() {
        this.jtfNome.setEnabled(true);
        this.tfValorVenda.setEnabled(true);
        this.tfValorCusto.setEnabled(true);
        this.tfCodigoBarras.setEnabled(true);
        this.cbFornecedores.setEnabled(true);
        this.tfValorCusto.setEnabled(true);
    }

    private void salvarProduto() {
        try {
            this.modelProdutos.setNome(this.jtfNome.getText());
            this.modelProdutos.setValor(Double.parseDouble(this.tfValorVenda.getText()));
            this.modelProdutos.setValorCusto(Double.parseDouble(this.tfValorCusto.getText()));
            this.modelProdutos.setFornecedoresCodigo(this.controllerFornecedor.getFornecedorController(this.cbFornecedores.getSelectedItem().toString()).getCodigo());
            this.modelProdutos.setCodigoBarras(this.tfCodigoBarras.getText());
            this.modelProdutos.setUnidadeMedida(this.controllerUnidadeMedia.getUnidadeMediaController(this.cbUnidadeMedida.getSelectedItem().toString()).getCodigo());
            if (this.controllerProdutos.salvarProdutosController(this.modelProdutos) > 0) {
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                this.carregarProdutos();
                this.limparDados();
                this.desabilitarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR!", "ERRO", 0);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewProduto().setVisible(true);
            }
        });
    }

}

