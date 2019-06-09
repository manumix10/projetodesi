/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerCidade;
import controller.ControllerEmpresa;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerEstado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.ModelCidade;
import model.ModelEmpresa;
import model.ModelEmpresaCidadeEstado;
import model.ModelEstado;
import util.TiraAcentos;
import view.ViewCidade;

public class ViewEmpresa
extends JFrame {
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ArrayList<ModelCidade> listaModelCidades = new ArrayList();
    ArrayList<ModelEstado> listaModelEstados = new ArrayList();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList();
    ArrayList<ModelEmpresaCidadeEstado> listaEmpresaCidadeEstados = new ArrayList();
    ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btLocalizarImagem;
    private JButton btNovaCidade;
    private JButton btSalvar;
    private JComboBox cbCidade;
    private JComboBox cbEstado;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane2;
    private JTable tblEmpresa;
    protected JTextField tfBairro;
    private JTextField tfCNPJ;
    protected JTextField tfCep;
    private JTextField tfCodigo;
    protected JTextField tfEndereco;
    private JTextField tfLogomarca;
    protected JTextField tfNomeFantasia;
    private JTextField tfRazaoSocial;
    protected JTextField tfTelefone;

    public ViewEmpresa() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarEmpresa();
        this.listarEstados();
        this.listarCidades();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.tfNomeFantasia = new JTextField();
        this.jLabel2 = new JLabel();
        this.tfEndereco = new JTextField();
        this.tfBairro = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.tfCep = new JTextField();
        this.tfTelefone = new JTextField();
        this.jLabel7 = new JLabel();
        this.btAlterar = new JButton();
        this.btCancelar = new JButton();
        this.btSalvar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.tblEmpresa = new JTable();
        this.tfCodigo = new JTextField();
        this.jLabel8 = new JLabel();
        this.cbEstado = new JComboBox();
        this.cbCidade = new JComboBox();
        this.btNovaCidade = new JButton();
        this.jLabel9 = new JLabel();
        this.tfRazaoSocial = new JTextField();
        this.jLabel10 = new JLabel();
        this.tfLogomarca = new JTextField();
        this.btLocalizarImagem = new JButton();
        this.jLabel11 = new JLabel();
        this.tfCNPJ = new JTextField();
        this.setDefaultCloseOperation(2);
        this.setTitle("Empresa");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jLabel1.setText("Nome fantasia:");
        this.tfNomeFantasia.setEditable(false);
        this.tfNomeFantasia.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewEmpresa.this.tfNomeFantasiaFocusLost(evt);
            }
        });
        this.jLabel2.setText("Endere\u00e7o:");
        this.tfEndereco.setEditable(false);
        this.tfEndereco.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewEmpresa.this.tfEnderecoFocusLost(evt);
            }
        });
        this.tfBairro.setEditable(false);
        this.tfBairro.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewEmpresa.this.tfBairroFocusLost(evt);
            }
        });
        this.jLabel3.setText("Bairro:");
        this.jLabel4.setText("Cidade:");
        this.jLabel5.setText("UF:");
        this.jLabel6.setText("CEP:");
        this.tfCep.setEditable(false);
        this.tfTelefone.setEditable(false);
        this.jLabel7.setText("Telefone:");
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEmpresa.this.btAlterarActionPerformed(evt);
            }
        });
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEmpresa.this.btCancelarActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar altera\u00e7\u00e3o");
        this.btSalvar.setEnabled(false);
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEmpresa.this.btSalvarActionPerformed(evt);
            }
        });
        this.tblEmpresa.setAutoCreateRowSorter(true);
        this.tblEmpresa.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo", "Nome", "Cidade", "Estado"}){
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
        this.tblEmpresa.setAutoResizeMode(0);
        this.tblEmpresa.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.tblEmpresa);
        if (this.tblEmpresa.getColumnModel().getColumnCount() > 0) {
            this.tblEmpresa.getColumnModel().getColumn(1).setPreferredWidth(250);
            this.tblEmpresa.getColumnModel().getColumn(2).setMinWidth(150);
            this.tblEmpresa.getColumnModel().getColumn(2).setPreferredWidth(150);
            this.tblEmpresa.getColumnModel().getColumn(3).setMinWidth(150);
            this.tblEmpresa.getColumnModel().getColumn(3).setPreferredWidth(150);
        }
        this.tfCodigo.setEditable(false);
        this.tfCodigo.setEnabled(false);
        this.jLabel8.setText("C\u00f3digo:");
        this.cbEstado.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewEmpresa.this.cbEstadoPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        this.btNovaCidade.setText("+");
        this.btNovaCidade.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEmpresa.this.btNovaCidadeActionPerformed(evt);
            }
        });
        this.jLabel9.setText("Raz\u00e3o social:");
        this.tfRazaoSocial.setEditable(false);
        this.tfRazaoSocial.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ViewEmpresa.this.tfRazaoSocialFocusLost(evt);
            }
        });
        this.jLabel10.setText("Logomarca:");
        this.tfLogomarca.setEditable(false);
        this.tfLogomarca.setFont(new Font("Tahoma", 1, 11));
        this.tfLogomarca.setForeground(new Color(255, 0, 0));
        this.tfLogomarca.setText("TAMANHO IDEAL 323X80");
        this.btLocalizarImagem.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Find.png")));
        this.btLocalizarImagem.setText("Localizar Logo");
        this.btLocalizarImagem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEmpresa.this.btLocalizarImagemActionPerformed(evt);
            }
        });
        this.jLabel11.setText("CNPJ");
        this.tfCNPJ.setEditable(false);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.tfEndereco, -2, 266, -2).addGap(4, 4, 4).addComponent(this.tfBairro)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cbEstado, -2, 72, -2).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.cbCidade, -2, 214, -2)).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btNovaCidade).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.tfCep, -2, 95, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.tfTelefone, -2, 142, -2))).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.btCancelar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btAlterar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btSalvar)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(221, 221, 221).addComponent(this.jLabel3))).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.tfLogomarca, -2, 328, -2).addGap(14, 14, 14).addComponent(this.btLocalizarImagem, -2, 168, -2)))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfCodigo, -2, 73, -2).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(0, 0, 32767)).addComponent(this.tfNomeFantasia))))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.tfRazaoSocial, -2, 351, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tfCNPJ)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel11).addGap(197, 197, 197))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfNomeFantasia, -2, -1, -2).addComponent(this.tfCodigo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jLabel11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfRazaoSocial, -2, -1, -2).addComponent(this.tfCNPJ, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3)).addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfEndereco, -2, -1, -2).addComponent(this.tfBairro, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel7)).addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbEstado, -2, -1, -2).addComponent(this.cbCidade, -2, -1, -2)).addComponent(this.tfTelefone, -2, -1, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel6).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfCep, -2, -1, -2).addComponent(this.btNovaCidade))))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel5))).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.tfLogomarca, -2, -1, -2).addComponent(this.btLocalizarImagem)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btAlterar).addComponent(this.btCancelar).addComponent(this.btSalvar)).addContainerGap(18, 32767)));
        this.pack();
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.desabilitarCampos();
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

    private void btAlterarActionPerformed(ActionEvent evt) {
        this.novo();
        this.habilitarCampos();
        this.recuperarEmpresa();
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        this.alterarEmpresa();
    }

    private boolean alterarEmpresa() {
        this.modelEmpresa.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
        this.modelEmpresa.setNomeFantasia(this.tfNomeFantasia.getText());
        this.modelEmpresa.setRazaoSocial(this.tfRazaoSocial.getText());
        this.modelEmpresa.setCnpj(this.tfCNPJ.getText());
        this.modelEmpresa.setEndereco(this.tfEndereco.getText());
        this.modelEmpresa.setBairro(this.tfBairro.getText());
        this.modelEmpresa.setCodCidade(this.controllerCidade.getCidadeController(this.cbCidade.getSelectedItem().toString()).getCodigo());
        this.modelEmpresa.setCodEstado(this.controllerEstado.getEstadoUFController(this.cbEstado.getSelectedItem().toString()).getCodigo());
        this.modelEmpresa.setCep(this.tfCep.getText());
        this.modelEmpresa.setTelefone(this.tfTelefone.getText());
        if (this.controllerEmpresa.atualizarEmpresaController(this.modelEmpresa)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregarEmpresa();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", 0);
        return false;
    }

    private boolean recuperarEmpresa() {
        int codigo = (Integer)this.tblEmpresa.getValueAt(0, 0);
        try {
            this.modelEmpresa = this.controllerEmpresa.getEmpresaController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelEmpresa.getCodigo()));
            this.tfNomeFantasia.setText(this.modelEmpresa.getNomeFantasia());
            this.tfRazaoSocial.setText(this.modelEmpresa.getRazaoSocial());
            this.tfEndereco.setText(this.modelEmpresa.getEndereco());
            this.tfBairro.setText(this.modelEmpresa.getBairro());
            this.cbEstado.setSelectedItem(this.controllerEstado.getEstadoController(this.modelEmpresa.getCodEstado()).getUf());
            this.listarCidades();
            this.cbCidade.setSelectedItem(this.controllerCidade.getCidadeController(this.modelEmpresa.getCodCidade()).getNome());
            this.tfCep.setText(this.modelEmpresa.getCep());
            this.tfTelefone.setText(this.modelEmpresa.getTelefone());
            this.tfCNPJ.setText(this.modelEmpresa.getCnpj());
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void carregarEmpresa() {
        this.modelEmpresaCidadeEstado = this.controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
        DefaultTableModel modelo = (DefaultTableModel)this.tblEmpresa.getModel();
        modelo.setNumRows(0);
        modelo.addRow(new Object[]{this.modelEmpresaCidadeEstado.getModelEmpresa().getCodigo(), this.modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia(), this.modelEmpresaCidadeEstado.getModelCidade().getNome(), this.modelEmpresaCidadeEstado.getModelEstado().getUf()});
    }

    private void novo() {
        this.habilitarCampos();
        this.tfCodigo.setText("Novo");
        this.tfNomeFantasia.setText("");
        this.tfRazaoSocial.setText("");
        this.tfEndereco.setText("");
        this.tfBairro.setText("");
        this.tfCep.setText("");
        this.tfTelefone.setText("");
        this.tfCNPJ.setText("");
    }

    protected boolean verificarCampos() {
        if (!this.tfNomeFantasia.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    private void habilitarCampos() {
        this.tfNomeFantasia.setEditable(true);
        this.tfRazaoSocial.setEditable(true);
        this.tfEndereco.setEditable(true);
        this.tfBairro.setEditable(true);
        this.cbCidade.setEnabled(true);
        this.tfCep.setEditable(true);
        this.cbEstado.setEnabled(true);
        this.tfTelefone.setEditable(true);
        this.tfCNPJ.setEditable(true);
        this.btSalvar.setEnabled(true);
    }

    protected void desabilitarCampos() {
        this.tfNomeFantasia.setEditable(false);
        this.tfRazaoSocial.setEditable(true);
        this.tfEndereco.setEditable(false);
        this.tfBairro.setEditable(false);
        this.cbCidade.setEnabled(false);
        this.tfCep.setEditable(false);
        this.cbEstado.setEnabled(false);
        this.tfTelefone.setEditable(false);
        this.tfCNPJ.setEditable(false);
        this.btSalvar.setEnabled(false);
        this.tfCodigo.setText("");
        this.tfNomeFantasia.setText("");
        this.tfRazaoSocial.setText("");
        this.tfEndereco.setText("");
        this.tfBairro.setText("");
        this.tfCep.setText("");
        this.tfTelefone.setText("");
        this.tfCNPJ.setText("");
    }

    private void tfNomeFantasiaFocusLost(FocusEvent evt) {
        this.tfNomeFantasia.setText(this.tfNomeFantasia.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfNomeFantasia.setText(blTiraAcentos.TiraAcentos(this.tfNomeFantasia.getText()));
    }

    private void cbEstadoPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.cbEstado.isPopupVisible()) {
            this.listarCidades();
        }
    }

    private void btNovaCidadeActionPerformed(ActionEvent evt) {
        new ViewCidade().setVisible(true);
    }

    private void btLocalizarImagemActionPerformed(ActionEvent evt) {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this.btLocalizarImagem);
            File file = chooser.getSelectedFile();
            String l = file.getAbsolutePath();
            String caminhoImagem = "C:/BLVendasMEI/src/imagens/processimg.png";
            FileInputStream fisDe = new FileInputStream(l);
            FileOutputStream fisPara = new FileOutputStream(caminhoImagem);
            FileChannel fcPara = fisDe.getChannel();
            FileChannel fcDe = fisPara.getChannel();
            this.tfLogomarca.setText(caminhoImagem);
            if (fcPara.transferTo(0, fcPara.size(), fcDe) == 0) {
                fcPara.close();
                fcDe.close();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tfRazaoSocialFocusLost(FocusEvent evt) {
        this.tfRazaoSocial.setText(this.tfRazaoSocial.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfRazaoSocial.setText(blTiraAcentos.TiraAcentos(this.tfRazaoSocial.getText()));
    }

    private void tfEnderecoFocusLost(FocusEvent evt) {
        this.tfEndereco.setText(this.tfEndereco.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfEndereco.setText(blTiraAcentos.TiraAcentos(this.tfEndereco.getText()));
    }

    private void tfBairroFocusLost(FocusEvent evt) {
        this.tfBairro.setText(this.tfBairro.getText().toUpperCase());
        TiraAcentos blTiraAcentos = new TiraAcentos();
        this.tfBairro.setText(blTiraAcentos.TiraAcentos(this.tfBairro.getText()));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewEmpresa().setVisible(true);
            }
        });
    }

}

