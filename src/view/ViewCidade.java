package view;

import controller.ControllerCidade;
import controller.ControllerCidadeEstado;
import controller.ControllerEstado;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.ModelCidade;
import model.ModelCidadeEstado;
import model.ModelEstado;
import util.BLTiraAcentos;

public class ViewCidade
extends JFrame {
    ControllerEstado controllerEstados = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerCidadeEstado controllerCidadeEstado = new ControllerCidadeEstado();
    ModelEstado modelEstado = new ModelEstado();
    ModelCidade modelCidade = new ModelCidade();
    ArrayList<ModelCidadeEstado> listaModelCidadeEstados = new ArrayList();
    ArrayList<ModelEstado> listaModelEstados = new ArrayList();
    ArrayList<ModelCidade> listaModelCidades = new ArrayList();
    String tipoCadastro;
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btExcluir;
    private JButton btNovo;
    private JButton btSalvar;
    private JComboBox cbEstado;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane2;
    private JTable tbCidades;
    private JTextField tfCidade;
    private JTextField tfCodigo;

    public ViewCidade() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.habilitarCampos(false);
        this.carregarCidade();
        this.listarEstados();
    }

    private void initComponents() {
        this.tfCodigo = new JTextField();
        this.jLabel1 = new JLabel();
        this.cbEstado = new JComboBox();
        this.tfCidade = new JTextField();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.btCancelar = new JButton();
        this.btSalvar = new JButton();
        this.btNovo = new JButton();
        this.btAlterar = new JButton();
        this.btExcluir = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.tbCidades = new JTable();
        this.setDefaultCloseOperation(2);
        this.setTitle("Cadastro de cidades");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.tfCodigo.setEditable(false);
        this.jLabel1.setText("C\u00f3digo:");
        this.tfCidade.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewCidade.this.tfCidadeFocusLost(evt);
            }
        });
        this.jLabel2.setText("Estado");
        this.jLabel3.setText("Cidade:");
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCidade.this.btCancelarActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar");
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCidade.this.btSalvarActionPerformed(evt);
            }
        });
        this.btNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovo.setText("Novo");
        this.btNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCidade.this.btNovoActionPerformed(evt);
            }
        });
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCidade.this.btAlterarActionPerformed(evt);
            }
        });
        this.btExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.btExcluir.setText("Excluir");
        this.btExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCidade.this.btExcluirActionPerformed(evt);
            }
        });
        this.tbCidades.setAutoCreateRowSorter(true);
        this.tbCidades.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}}, new String[]{"C\u00f3digo", "UF", "Estado", "Cidade"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this.tbCidades.setAutoResizeMode(0);
        this.tbCidades.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tbCidades);
        if (this.tbCidades.getColumnModel().getColumnCount() > 0) {
            this.tbCidades.getColumnModel().getColumn(1).setMinWidth(50);
            this.tbCidades.getColumnModel().getColumn(1).setPreferredWidth(50);
            this.tbCidades.getColumnModel().getColumn(2).setMinWidth(200);
            this.tbCidades.getColumnModel().getColumn(2).setPreferredWidth(200);
            this.tbCidades.getColumnModel().getColumn(3).setMinWidth(200);
            this.tbCidades.getColumnModel().getColumn(3).setPreferredWidth(200);
        }
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.tfCodigo, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addGroup(layout.createSequentialGroup().addComponent(this.cbEstado, 0, -1, 32767).addContainerGap()))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addGap(0, 0, 32767)).addComponent(this.tfCidade).addGroup(layout.createSequentialGroup().addComponent(this.btCancelar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btExcluir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btAlterar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btNovo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btSalvar)).addComponent(this.jScrollPane2, -1, 550, 32767)).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfCodigo, -2, -1, -2).addComponent(this.cbEstado, -2, -1, -2)).addGap(7, 7, 7).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tfCidade, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btCancelar).addComponent(this.btSalvar).addComponent(this.btNovo).addComponent(this.btAlterar).addComponent(this.btExcluir)).addContainerGap()));
        this.pack();
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        if (this.tipoCadastro.equals("novo")) {
            this.salvarCidade();
        } else if (this.tipoCadastro.equals("alteracao")) {
            this.alterarCidade();
        }
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.habilitarCampos(false);
    }

    private void btNovoActionPerformed(ActionEvent evt) {
        this.novaCidade();
        this.habilitarCampos(true);
    }

    private void btAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbCidades.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.novaCidade();
            this.habilitarCampos(true);
            this.tipoCadastro = "alteracao";
            this.retornarCidade();
        }
    }

    private void btExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbCidades.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.excluirCidade();
        }
    }

    private void tfCidadeFocusLost(FocusEvent evt) {
        this.tfCidade.setText(this.tfCidade.getText().toUpperCase());
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.tfCidade.setText(blTiraAcentos.TiraAcentos(this.tfCidade.getText()));
    }

    private void excluirCidade() {
        int linha = this.tbCidades.getSelectedRow();
        String nome = (String)this.tbCidades.getValueAt(linha, 3);
        int codigo = (Integer)this.tbCidades.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro \nNome: " + nome + " ?", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            if (this.controllerCidade.excluirCidadeController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarCidade();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao e os dados!", "ERRO", 0);
            }
        }
    }

    private boolean salvarCidade() {
        this.modelCidade.setFk_cod_estado(this.controllerEstados.getEstadoController(this.cbEstado.getSelectedItem().toString()).getCodigo());
        this.modelCidade.setNome(this.tfCidade.getText());
        if (this.controllerCidade.salvarCidadeController(this.modelCidade) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.habilitarCampos(false);
            this.carregarCidade();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
        return false;
    }

    private boolean alterarCidade() {
        this.modelCidade.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
        this.modelCidade.setFk_cod_estado(this.controllerEstados.getEstadoController(this.cbEstado.getSelectedItem().toString()).getCodigo());
        this.modelCidade.setNome(this.tfCidade.getText());
        if (this.controllerCidade.atualizarCidadeController(this.modelCidade)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.habilitarCampos(false);
            this.carregarCidade();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", 0);
        return false;
    }

    private void carregarCidade() {
        this.listaModelCidadeEstados = this.controllerCidadeEstado.getListaCidadeEstadoController();
        DefaultTableModel modelo = (DefaultTableModel)this.tbCidades.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelCidadeEstados.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelCidadeEstados.get(i).getModelCidade().getCodigo(), this.listaModelCidadeEstados.get(i).getModelEstado().getUf(), this.listaModelCidadeEstados.get(i).getModelEstado().getNome(), this.listaModelCidadeEstados.get(i).getModelCidade().getNome()});
        }
    }

    private boolean retornarCidade() {
        int linha = this.tbCidades.getSelectedRow();
        int codigo = (Integer)this.tbCidades.getValueAt(linha, 0);
        try {
            this.modelCidade = this.controllerCidade.getCidadeController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelCidade.getCodigo()));
            this.tfCidade.setText(this.modelCidade.getNome());
            this.cbEstado.setSelectedItem(this.controllerEstados.getEstadoController(this.modelCidade.getFk_cod_estado()).getNome());
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void novaCidade() {
        this.habilitarCampos(true);
        this.tfCodigo.setText("Novo");
        this.listarEstados();
        this.tfCidade.setText("");
        this.tipoCadastro = "novo";
    }

    private void habilitarCampos(boolean pStatus) {
        this.tfCidade.setEditable(pStatus);
        this.cbEstado.setEnabled(pStatus);
        this.btSalvar.setEnabled(pStatus);
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
            Logger.getLogger(ViewCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewCidade().setVisible(true);
            }
        });
    }

    private void listarEstados() {
        this.listaModelEstados = this.controllerEstados.getListaEstadoController();
        this.cbEstado.removeAllItems();
        for (int i = 0; i < this.listaModelEstados.size(); ++i) {
            this.cbEstado.addItem(this.listaModelEstados.get(i).getNome());
        }
    }

}

