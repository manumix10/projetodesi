/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerProdutos;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelProdutos;

public class ViewPesquisarProdutoPDV
extends JDialog {
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private JButton cancelButton;
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    private JTable jtProdutos;
    private JTextField jtfProduto;
    private JButton okButton;
    private int returnStatus = 0;

    public ViewPesquisarProdutoPDV(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.carregarProdutos();
        String cancelName = "cancel";
        InputMap inputMap = this.getRootPane().getInputMap(1);
        inputMap.put(KeyStroke.getKeyStroke(27, 0), cancelName);
        ActionMap actionMap = this.getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewPesquisarProdutoPDV.this.doClose(0);
            }
        });
    }

    public int getReturnStatus() {
        return this.returnStatus;
    }

    private void initComponents() {
        this.okButton = new JButton();
        this.cancelButton = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.jtProdutos = new JTable();
        this.jtfProduto = new JTextField();
        this.jLabel1 = new JLabel();
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent evt) {
                ViewPesquisarProdutoPDV.this.closeDialog(evt);
            }
        });
        this.okButton.setText("OK");
        this.okButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPesquisarProdutoPDV.this.okButtonActionPerformed(evt);
            }
        });
        this.cancelButton.setText("Cancel");
        this.cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewPesquisarProdutoPDV.this.cancelButtonActionPerformed(evt);
            }
        });
        this.jtProdutos.setAutoCreateRowSorter(true);
        this.jtProdutos.setModel(new DefaultTableModel(new Object[][]{{null, null}}, new String[]{"C\u00f3digo", "Nome"}){
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
        this.jtProdutos.setAutoResizeMode(0);
        this.jtProdutos.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.jtProdutos);
        if (this.jtProdutos.getColumnModel().getColumnCount() > 0) {
            this.jtProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
            this.jtProdutos.getColumnModel().getColumn(1).setMinWidth(500);
            this.jtProdutos.getColumnModel().getColumn(1).setMaxWidth(500);
        }
        this.jtfProduto.setFont(new Font("Tahoma", 0, 24));
        this.jtfProduto.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent evt) {
                ViewPesquisarProdutoPDV.this.jtfProdutoKeyReleased(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Descri\u00e7\u00e3o produto:");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 613, 32767).addComponent(this.jtfProduto).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addGroup(layout.createSequentialGroup().addGap(214, 214, 214).addComponent(this.okButton, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cancelButton, -2, 100, -2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.linkSize(0, this.cancelButton, this.okButton);
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfProduto, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 372, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cancelButton, -2, 40, -2).addComponent(this.okButton, -2, 40, -2)).addContainerGap()));
        this.getRootPane().setDefaultButton(this.okButton);
        this.pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        this.doClose(1);
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void closeDialog(WindowEvent evt) {
        this.doClose(0);
    }

    private void jtfProdutoKeyReleased(KeyEvent evt) {
        DefaultTableModel tabela = (DefaultTableModel)this.jtProdutos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tabela);
        this.jtProdutos.setRowSorter(sorter);
        String text = this.jtfProduto.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }

    private void doClose(int retStatus) {
        int codigo;
        int linha = this.jtProdutos.getSelectedRow();
        this.returnStatus = codigo = ((Integer)this.jtProdutos.getValueAt(linha, 0));
        this.setVisible(false);
        this.dispose();
    }

    private void carregarProdutos() {
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ArrayList listamModelProdutos = new ArrayList();
        listamModelProdutos = controllerProdutos.getListaProdutosController();
        DefaultTableModel modelo = (DefaultTableModel)this.jtProdutos.getModel();
        modelo.setNumRows(0);
        int cont = listamModelProdutos.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{((ModelProdutos)listamModelProdutos.get(i)).getCodigo(), ((ModelProdutos)listamModelProdutos.get(i)).getNome()});
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
            Logger.getLogger(ViewPesquisarProdutoPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewPesquisarProdutoPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewPesquisarProdutoPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewPesquisarProdutoPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewPesquisarProdutoPDV dialog = new ViewPesquisarProdutoPDV(new JFrame(), true);
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

