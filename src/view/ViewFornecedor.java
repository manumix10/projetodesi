/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerCidade;
import controller.ControllerEstado;
import controller.ControllerFornecedor;
import controller.ControllerFornecedorCidadeEstado;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCidade;
import model.ModelEstado;
import model.ModelFornecedor;
import model.ModelFornecedorCidadeEstado;
import util.TiraAcentos;
import view.ViewCidade;

public class ViewFornecedor
extends JFrame {
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ControllerFornecedorCidadeEstado controllerFornecedorCidadeEstado = new ControllerFornecedorCidadeEstado();
    ArrayList<ModelCidade> listaModelCidades = new ArrayList();
    ArrayList<ModelEstado> listaModelEstados = new ArrayList();
    ArrayList<ModelFornecedor> listModelFornecedors = new ArrayList();
    ArrayList<ModelFornecedorCidadeEstado> listaModelFornecedorCidadeEstados = new ArrayList();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    String tipoCadastro;
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btNovaCidade;
    private JButton btNovo;
    private JButton btPesquisarFornecedor;
    private JButton btSalvar;
    private JComboBox cbCidade;
    private JComboBox cbEstado;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane2;
    private JTable tbFornecedores;
    private JTextField tfBairro;
    private JTextField tfCep;
    private JTextField tfCodigo;
    private JTextField tfEndereco;
    private JTextField tfNome;
    private JTextField tfPesquisaFornecedor;
    private JTextField tfTelefone;

    public ViewFornecedor() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarFornecedores();
        this.listarEstados();
        this.listarCidades();
        this.desabilitarCampos();
    }

    private void initComponents() {
        this.tfPesquisaFornecedor = new JTextField();
        this.btPesquisarFornecedor = new JButton();
        this.jLabel1 = new JLabel();
        this.tfNome = new JTextField();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.tfEndereco = new JTextField();
        this.tfBairro = new JTextField();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.tfCep = new JTextField();
        this.tfTelefone = new JTextField();
        this.btNovo = new JButton();
        this.btAlterar = new JButton();
        this.btCancelar = new JButton();
        this.jButton1 = new JButton();
        this.btSalvar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.tbFornecedores = new JTable();
        this.tfCodigo = new JTextField();
        this.jLabel8 = new JLabel();
        this.btNovaCidade = new JButton();
        this.cbCidade = new JComboBox();
        this.cbEstado = new JComboBox();
        this.jLabel9 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Fornecedores");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.tfPesquisaFornecedor.setToolTipText("Digite o texto exatamente como deseja pesquisar, diferencia mai\u00fasculo de min\u00fasculo.");
        this.tfPesquisaFornecedor.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFornecedor.this.tfPesquisaFornecedorFocusLost(evt);
            }
        });
        this.btPesquisarFornecedor.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Search.png")));
        this.btPesquisarFornecedor.setText("Pesquisar");
        this.btPesquisarFornecedor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btPesquisarFornecedorActionPerformed(evt);
            }
        });
        this.jLabel1.setText("Nome:");
        this.tfNome.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFornecedor.this.tfNomeFocusLost(evt);
            }
        });
        this.jLabel2.setText("Endere\u00e7o:");
        this.jLabel3.setText("Bairro:");
        this.tfEndereco.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFornecedor.this.tfEnderecoFocusLost(evt);
            }
        });
        this.tfBairro.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFornecedor.this.tfBairroFocusLost(evt);
            }
        });
        this.jLabel4.setText("Cidade:");
        this.jLabel5.setText("UF:");
        this.jLabel6.setText("CEP:");
        this.jLabel7.setText("Telefone:");
        this.btNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovo.setText("Novo");
        this.btNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btNovoActionPerformed(evt);
            }
        });
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btAlterarActionPerformed(evt);
            }
        });
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btCancelarActionPerformed(evt);
            }
        });
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.jButton1.setText("Excluir");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.jButton1ActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar");
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btSalvarActionPerformed(evt);
            }
        });
        this.tbFornecedores.setAutoCreateRowSorter(true);
        this.tbFornecedores.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null}}, new String[]{"C\u00f3digo", "Nome", "Cidade", "Estado", "Telefone"}){
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
        this.tbFornecedores.setAutoResizeMode(0);
        this.tbFornecedores.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbFornecedores);
        if (this.tbFornecedores.getColumnModel().getColumnCount() > 0) {
            this.tbFornecedores.getColumnModel().getColumn(1).setMinWidth(200);
            this.tbFornecedores.getColumnModel().getColumn(1).setPreferredWidth(200);
            this.tbFornecedores.getColumnModel().getColumn(2).setMinWidth(200);
            this.tbFornecedores.getColumnModel().getColumn(2).setPreferredWidth(200);
        }
        this.tfCodigo.setEnabled(false);
        this.jLabel8.setText("Codigo:");
        this.btNovaCidade.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovaCidade.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewFornecedor.this.btNovaCidadeActionPerformed(evt);
            }
        });
        this.cbEstado.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewFornecedor.this.cbEstadoPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        this.cbEstado.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewFornecedor.this.cbEstadoFocusLost(evt);
            }
        });
        this.jLabel9.setText("Pesquisa?");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(layout.createSequentialGroup().addComponent(this.btCancelar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btAlterar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btNovo, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btSalvar)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfCodigo).addGroup(layout.createSequentialGroup().addComponent(this.jLabel8).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.tfNome, -2, 451, -2))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addGap(65, 65, 65).addComponent(this.jLabel4)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.cbEstado, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cbCidade, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btNovaCidade, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.tfCep, -2, 106, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tfPesquisaFornecedor))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.tfTelefone, -2, 113, -2).addComponent(this.btPesquisarFornecedor))))).addGroup(layout.createSequentialGroup().addComponent(this.tfBairro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.tfEndereco, -2, 272, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(295, 295, 295).addComponent(this.jLabel3).addGap(0, 0, 32767))).addContainerGap()));
        layout.linkSize(0, this.btCancelar, this.btPesquisarFornecedor);
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfNome, -2, -1, -2).addComponent(this.tfCodigo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfEndereco, -2, -1, -2).addComponent(this.tfBairro, -2, -1, -2)).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfCep, -2, -1, -2).addComponent(this.tfTelefone, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.cbEstado, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbCidade, -2, -1, -2).addComponent(this.btNovaCidade))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btPesquisarFornecedor).addComponent(this.tfPesquisaFornecedor, -2, -1, -2).addComponent(this.jLabel9)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 181, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btNovo).addComponent(this.btAlterar).addComponent(this.btCancelar).addComponent(this.jButton1).addComponent(this.btSalvar)).addContainerGap()));
        layout.linkSize(1, this.btAlterar, this.btCancelar, this.btNovo, this.btPesquisarFornecedor);
        this.pack();
    }

    private void btPesquisarFornecedorActionPerformed(ActionEvent evt) {
        DefaultTableModel tabela = (DefaultTableModel)this.tbFornecedores.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tabela);
        this.tbFornecedores.setRowSorter(sorter);
        String text = this.tfPesquisaFornecedor.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }

    private void btAlterarActionPerformed(ActionEvent evt) {
        int linha = this.tbFornecedores.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.novo();
            this.habilitarCampos();
            this.recuperarFornecedor();
            this.tipoCadastro = "alteracao";
        }
    }

    private void btNovoActionPerformed(ActionEvent evt) {
        this.novo();
        this.listarEstados();
        this.listarCidades();
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        if (this.tipoCadastro.equals("novo")) {
            this.salvarFornecedor();
        } else if (this.tipoCadastro.equals("alteracao")) {
            this.alteraFornecedor();
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        int linha = this.tbFornecedores.getSelectedRow();
        String nome = "";
        int codigo = 0;
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            nome = (String)this.tbFornecedores.getValueAt(linha, 1);
            codigo = (Integer)this.tbFornecedores.getValueAt(linha, 0);
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro:\n\n " + nome + "?", "Aten\u00e7\u00e3o", 0);
            if (opcao == 0) {
                if (this.controllerFornecedor.excluirFornecedorController(codigo)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                    this.carregarFornecedores();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao e os dados!", "ERRO", 0);
                }
            }
        }
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.desabilitarCampos();
    }

    private void tfNomeFocusLost(FocusEvent evt) {
        this.tfNome.setText(this.tfNome.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfNome.setText(blTiraAcentos.TiraAcentos(this.tfNome.getText()));
    }

    private void btNovaCidadeActionPerformed(ActionEvent evt) {
        new ViewCidade().setVisible(true);
    }

    private void cbEstadoPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.cbEstado.isPopupVisible()) {
            this.listarCidades();
        }
    }

    private void tfBairroFocusLost(FocusEvent evt) {
        this.tfBairro.setText(this.tfBairro.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfBairro.setText(blTiraAcentos.TiraAcentos(this.tfBairro.getText()));
    }

    private void tfEnderecoFocusLost(FocusEvent evt) {
        this.tfEndereco.setText(this.tfEndereco.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfEndereco.setText(blTiraAcentos.TiraAcentos(this.tfEndereco.getText()));
    }

    private void tfPesquisaFornecedorFocusLost(FocusEvent evt) {
        this.tfPesquisaFornecedor.setText(this.tfPesquisaFornecedor.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfPesquisaFornecedor.setText(blTiraAcentos.TiraAcentos(this.tfPesquisaFornecedor.getText()));
    }

    private void cbEstadoFocusLost(FocusEvent evt) {
        this.listarCidades();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewFornecedor().setVisible(true);
            }
        });
    }

    private void listarEstados() {
        this.listaModelEstados = this.controllerEstado.getListaEstadoController();
        this.cbEstado.removeAllItems();
        for (int i = 0; i < this.listaModelEstados.size(); ++i) {
            this.cbEstado.addItem(this.listaModelEstados.get(i).getUf());
        }
    }

    private void listarCidades() {
        this.listaModelCidades = this.controllerCidade.getListaCidadePorEstadoController(this.controllerEstado.getEstadoUFController(this.cbEstado.getSelectedItem().toString()).getCodigo());
        this.cbCidade.removeAllItems();
        for (int i = 0; i < this.listaModelCidades.size(); ++i) {
            this.cbCidade.addItem(this.listaModelCidades.get(i).getNome());
        }
    }

    private void alteraFornecedor() {
        try {
            this.modelFornecedor.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
            this.modelFornecedor.setNome(this.tfNome.getText());
            this.modelFornecedor.setEndereco(this.tfEndereco.getText());
            this.modelFornecedor.setBairro(this.tfBairro.getText());
            this.modelFornecedor.setCodCidade(this.controllerCidade.getCidadeController(this.cbCidade.getSelectedItem().toString()).getCodigo());
            this.modelFornecedor.setCodEstado(this.controllerEstado.getEstadoUFController(this.cbEstado.getSelectedItem().toString()).getCodigo());
            this.modelFornecedor.setCep(this.tfCep.getText());
            this.modelFornecedor.setTelefone(this.tfTelefone.getText());
            if (this.controllerFornecedor.atualizarFornecedorController(this.modelFornecedor)) {
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                this.desabilitarCampos();
                this.carregarFornecedores();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR.!", "ERRO", 0);
        }
    }

    private void salvarFornecedor() {
        try {
            this.modelFornecedor.setNome(this.tfNome.getText());
            this.modelFornecedor.setEndereco(this.tfEndereco.getText());
            this.modelFornecedor.setBairro(this.tfBairro.getText());
            this.modelFornecedor.setCodCidade(this.controllerCidade.getCidadeController(this.cbCidade.getSelectedItem().toString()).getCodigo());
            this.modelFornecedor.setCodEstado(this.controllerEstado.getEstadoUFController(this.cbEstado.getSelectedItem().toString()).getCodigo());
            this.modelFornecedor.setCep(this.tfCep.getText());
            this.modelFornecedor.setTelefone(this.tfTelefone.getText());
            if (this.controllerFornecedor.salvarFornecedorController(this.modelFornecedor) > 0) {
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                this.desabilitarCampos();
                this.carregarFornecedores();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente antes de clicar em SALVAR.!", "ERRO", 0);
        }
    }

    private boolean recuperarFornecedor() {
        int linha = this.tbFornecedores.getSelectedRow();
        int codigo = (Integer)this.tbFornecedores.getValueAt(linha, 0);
        try {
            this.modelFornecedor = this.controllerFornecedor.getFornecedorController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelFornecedor.getCodigo()));
            this.tfNome.setText(this.modelFornecedor.getNome());
            this.tfEndereco.setText(this.modelFornecedor.getEndereco());
            this.tfBairro.setText(this.modelFornecedor.getBairro());
            this.cbEstado.setSelectedItem(this.controllerEstado.getEstadoController(this.modelFornecedor.getCodEstado()).getUf());
            this.listarCidades();
            this.cbCidade.setSelectedItem(this.controllerCidade.getCidadeController(this.modelFornecedor.getCodCidade()).getNome());
            System.err.println(this.controllerCidade.getCidadeController(this.modelFornecedor.getCodCidade()).getNome());
            this.tfCep.setText(this.modelFornecedor.getCep());
            this.tfTelefone.setText(this.modelFornecedor.getTelefone());
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void carregarFornecedores() {
        this.listaModelFornecedorCidadeEstados = this.controllerFornecedorCidadeEstado.getlistaFornecedorCidadeEstados();
        DefaultTableModel modelo = (DefaultTableModel)this.tbFornecedores.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelFornecedorCidadeEstados.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelFornecedorCidadeEstados.get(i).getModelFornecedor().getCodigo(), this.listaModelFornecedorCidadeEstados.get(i).getModelFornecedor().getNome(), this.listaModelFornecedorCidadeEstados.get(i).getModelCidade().getNome(), this.listaModelFornecedorCidadeEstados.get(i).getModelEstado().getUf(), this.listaModelFornecedorCidadeEstados.get(i).getModelFornecedor().getTelefone()});
        }
    }

    private void novo() {
        this.habilitarCampos();
        this.tfCodigo.setText("Novo");
        this.tfNome.setText("");
        this.tfEndereco.setText("");
        this.tfBairro.setText("");
        this.cbEstado.setSelectedIndex(0);
        this.tfCep.setText("");
        this.tfTelefone.setText("");
        this.tipoCadastro = "novo";
        this.tfNome.grabFocus();
    }

    protected boolean verificarCampos() {
        if (!this.tfNome.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    private void habilitarCampos() {
        this.tfNome.setEditable(true);
        this.tfEndereco.setEditable(true);
        this.tfBairro.setEditable(true);
        this.cbCidade.setEnabled(true);
        this.tfCep.setEditable(true);
        this.cbEstado.setEnabled(true);
        this.tfTelefone.setEditable(true);
        this.btSalvar.setEnabled(true);
    }

    protected void desabilitarCampos() {
        this.tfNome.setEditable(false);
        this.tfEndereco.setEditable(false);
        this.tfBairro.setEditable(false);
        this.cbCidade.setEnabled(false);
        this.tfCep.setEditable(false);
        this.cbEstado.setEnabled(false);
        this.tfTelefone.setEditable(false);
        this.btSalvar.setEnabled(false);
        this.tfCodigo.setText("");
        this.tfNome.setText("");
        this.tfEndereco.setText("");
        this.tfBairro.setText("");
        this.cbEstado.setSelectedIndex(0);
        this.tfCep.setText("");
        this.tfTelefone.setText("");
    }

}

