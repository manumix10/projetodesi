/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerUnidadeMedia;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.ModelUnidadeMedia;

public class ViewUnidadeMedia
extends JFrame {
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
    ArrayList<ModelUnidadeMedia> listaModelUnidadeMedias = new ArrayList();
    String tipoCadastro;
    private JButton btAlterar;
    private JButton btCancelar;
    private JButton btExcluir;
    private JButton btNovo;
    private JButton btSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTable tbUnidadeMedida;
    private JTextField tfAbreviacao;
    private JTextField tfCodigo;
    private JTextField tfDescricao;

    public ViewUnidadeMedia() {
        this.initComponents();
        this.desabilitarCampos();
        this.carregarUnidadesMedidas();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.tfCodigo = new JTextField();
        this.jLabel1 = new JLabel();
        this.tfAbreviacao = new JTextField();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.tfDescricao = new JTextField();
        this.btCancelar = new JButton();
        this.btNovo = new JButton();
        this.btSalvar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.tbUnidadeMedida = new JTable();
        this.btExcluir = new JButton();
        this.btAlterar = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Unidade de Medida");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.tfCodigo.setEditable(false);
        this.jLabel1.setText("C\u00f3digo");
        this.jLabel2.setText("Abrevia\u00e7\u00e3o");
        this.jLabel3.setText("Descri\u00e7\u00e3o");
        this.btCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.btCancelar.setText("Cancelar");
        this.btCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUnidadeMedia.this.btCancelarActionPerformed(evt);
            }
        });
        this.btNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.btNovo.setText("Novo");
        this.btNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUnidadeMedia.this.btNovoActionPerformed(evt);
            }
        });
        this.btSalvar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.btSalvar.setText("Salvar");
        this.btSalvar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUnidadeMedia.this.btSalvarActionPerformed(evt);
            }
        });
        this.tbUnidadeMedida.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo", "Abrevia\u00e7\u00e3o", "Descri\u00e7\u00e3o"}){
            
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane1.setViewportView(this.tbUnidadeMedida);
        if (this.tbUnidadeMedida.getColumnModel().getColumnCount() > 0) {
            this.tbUnidadeMedida.getColumnModel().getColumn(0).setMinWidth(80);
            this.tbUnidadeMedida.getColumnModel().getColumn(0).setPreferredWidth(80);
            this.tbUnidadeMedida.getColumnModel().getColumn(0).setMaxWidth(80);
            this.tbUnidadeMedida.getColumnModel().getColumn(1).setMinWidth(80);
            this.tbUnidadeMedida.getColumnModel().getColumn(1).setPreferredWidth(80);
            this.tbUnidadeMedida.getColumnModel().getColumn(1).setMaxWidth(80);
        }
        this.btExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.btExcluir.setText("Excluir");
        this.btExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUnidadeMedia.this.btExcluirActionPerformed(evt);
            }
        });
        this.btAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.btAlterar.setText("Alterar");
        this.btAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUnidadeMedia.this.btAlterarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(87, 87, 87).addComponent(this.jLabel2)).addComponent(this.jLabel3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.btCancelar).addGap(5, 5, 5).addComponent(this.btExcluir).addGap(7, 7, 7).addComponent(this.btAlterar).addGap(5, 5, 5).addComponent(this.btNovo).addGap(59, 59, 59).addComponent(this.btSalvar)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.tfCodigo, -2, 110, -2).addGap(10, 10, 10).addComponent(this.tfAbreviacao)).addComponent(this.tfDescricao, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 511, 32767)))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jLabel1)).addComponent(this.jLabel2)).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.tfCodigo, -2, -1, -2)).addComponent(this.tfAbreviacao, -2, -1, -2)).addGap(11, 11, 11).addComponent(this.jLabel3).addGap(6, 6, 6).addComponent(this.tfDescricao, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 280, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btCancelar).addComponent(this.btExcluir).addComponent(this.btAlterar).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btNovo).addComponent(this.btSalvar))).addContainerGap()));
        this.pack();
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        this.desabilitarCampos();
    }

    private void btExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbUnidadeMedida.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.excluirUnidade();
        }
    }

    private void btAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.tbUnidadeMedida.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.novaUnidade();
            this.btSalvar.setEnabled(true);
            this.habilitarCampos();
            this.recuperarUnidade();
            this.tipoCadastro = "alteracao";
        }
    }

    private void btNovoActionPerformed(ActionEvent evt) {
        this.novaUnidade();
        this.carregarUnidadesMedidas();
    }

    private void btSalvarActionPerformed(ActionEvent evt) {
        if (this.tipoCadastro.equals("novo")) {
            this.salvarUnidade();
            this.btSalvar.setEnabled(false);
            this.carregarUnidadesMedidas();
        } else if (this.tipoCadastro.equals("alteracao")) {
            this.alterarUnidade();
            this.btSalvar.setEnabled(false);
            this.carregarUnidadesMedidas();
        }
    }

    private boolean salvarUnidade() {
        this.modelUnidadeMedia.setAbreviacao(this.tfAbreviacao.getText());
        this.modelUnidadeMedia.setDescricao(this.tfDescricao.getText());
        if (this.controllerUnidadeMedia.salvarUnidadeMediaController(this.modelUnidadeMedia) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregarUnidadesMedidas();
            this.limparDados();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
        return false;
    }

    private boolean alterarUnidade() {
        this.modelUnidadeMedia.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
        this.modelUnidadeMedia.setAbreviacao(this.tfAbreviacao.getText());
        this.modelUnidadeMedia.setDescricao(this.tfDescricao.getText());
        if (this.controllerUnidadeMedia.atualizarUnidadeMediaController(this.modelUnidadeMedia)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregarUnidadesMedidas();
            this.limparDados();
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", 0);
        return false;
    }

    private boolean recuperarUnidade() {
        int linha = this.tbUnidadeMedida.getSelectedRow();
        int codigo = (Integer)this.tbUnidadeMedida.getValueAt(linha, 0);
        try {
            this.modelUnidadeMedia = this.controllerUnidadeMedia.getUnidadeMediaController(codigo);
            this.tfCodigo.setText(String.valueOf(this.modelUnidadeMedia.getCodigo()));
            this.tfAbreviacao.setText(this.modelUnidadeMedia.getAbreviacao());
            this.tfDescricao.setText(this.modelUnidadeMedia.getDescricao());
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    private void excluirUnidade() {
        int linha = this.tbUnidadeMedida.getSelectedRow();
        String nome = (String)this.tbUnidadeMedida.getValueAt(linha, 2);
        int codigo = (Integer)this.tbUnidadeMedida.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro \nNome: " + nome + " ?", "Aten\u00e7\u00e3o", 0);
        if (opcao == 0) {
            if (this.controllerUnidadeMedia.excluirUnidadeMediaController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarUnidadesMedidas();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao e os dados!", "ERRO", 0);
            }
        }
    }

    private void desabilitarCampos() {
        this.tfCodigo.setEnabled(false);
        this.tfAbreviacao.setEnabled(false);
        this.tfDescricao.setEnabled(false);
        this.btSalvar.setEnabled(false);
        this.carregarUnidadesMedidas();
    }

    private void limparDados() {
        this.tfCodigo.setText("");
        this.tfAbreviacao.setText("");
        this.tfDescricao.setText("");
    }

    private void habilitarCampos() {
        this.tfCodigo.setEnabled(true);
        this.tfAbreviacao.setEnabled(true);
        this.tfDescricao.setEnabled(true);
    }

    private void novaUnidade() {
        this.habilitarCampos();
        this.tfCodigo.setText("Novo");
        this.tfAbreviacao.setText("");
        this.tfDescricao.setText("");
        this.tipoCadastro = "novo";
        this.btSalvar.setEnabled(true);
    }

    private void carregarUnidadesMedidas() {
        this.listaModelUnidadeMedias = this.controllerUnidadeMedia.getListaUnidadeMediaController();
        DefaultTableModel modelo = (DefaultTableModel)this.tbUnidadeMedida.getModel();
        modelo.setNumRows(0);
        int cont = this.listaModelUnidadeMedias.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{this.listaModelUnidadeMedias.get(i).getCodigo(), this.listaModelUnidadeMedias.get(i).getAbreviacao(), this.listaModelUnidadeMedias.get(i).getDescricao()});
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
            Logger.getLogger(ViewUnidadeMedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewUnidadeMedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewUnidadeMedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewUnidadeMedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewUnidadeMedia().setVisible(true);
            }
        });
    }

}

