/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.lowagie.text.Chunk
 *  com.lowagie.text.Document
 *  com.lowagie.text.Element
 *  com.lowagie.text.Image
 *  com.lowagie.text.PageSize
 *  com.lowagie.text.Paragraph
 *  com.lowagie.text.Phrase
 *  com.lowagie.text.Rectangle
 *  com.lowagie.text.pdf.BarcodeEAN
 *  com.lowagie.text.pdf.PdfContentByte
 *  com.lowagie.text.pdf.PdfWriter
 */
package view;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class ViewCodigobarras
extends JFrame {
    ArrayList<String> listaCodigos = new ArrayList();
    ArrayList<String> listaTipos = new ArrayList();
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JButton jbAdicionar;
    private JButton jbgerar;
    private JComboBox jcbTipoCodigo;
    private JTable jtCodigos;
    private JFormattedTextField jtfCodigoBarras;
    private JButton jtfExcluir;

    public ViewCodigobarras() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jbgerar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jtCodigos = new JTable();
        this.jbAdicionar = new JButton();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jtfExcluir = new JButton();
        this.jcbTipoCodigo = new JComboBox();
        this.jLabel2 = new JLabel();
        this.jtfCodigoBarras = new JFormattedTextField();
        this.setDefaultCloseOperation(2);
        this.setTitle("Gerador de c\u00f3digo de barras");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.jbgerar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Report.png")));
        this.jbgerar.setText("Gerar C\u00f3digo");
        this.jbgerar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCodigobarras.this.jbgerarActionPerformed(evt);
            }
        });
        this.jtCodigos.setModel(new DefaultTableModel(new Object[0][], new String[]{"C\u00f3digo de barras"}){
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
        this.jScrollPane1.setViewportView(this.jtCodigos);
        if (this.jtCodigos.getColumnModel().getColumnCount() > 0) {
            this.jtCodigos.getColumnModel().getColumn(0).setResizable(false);
        }
        this.jbAdicionar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.jbAdicionar.setText("Adicionar c\u00f3digo");
        this.jbAdicionar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCodigobarras.this.jbAdicionarActionPerformed(evt);
            }
        });
        this.jLabel1.setText("Digite aqui o c\u00f3digo de barras:");
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.jButton1.setText("Cancelar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCodigobarras.this.jButton1ActionPerformed(evt);
            }
        });
        this.jtfExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Remove.png")));
        this.jtfExcluir.setText("Excluir c\u00f3digo da tabela");
        this.jtfExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewCodigobarras.this.jtfExcluirActionPerformed(evt);
            }
        });
        this.jcbTipoCodigo.setModel(new DefaultComboBoxModel<String>(new String[]{"EAN13", "EAN8", "UPCA", "UPCE"}));
        this.jLabel2.setText("Padr\u00e3o de c\u00f3digo de barras");
        this.jtfCodigoBarras.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###"))));
        this.jtfCodigoBarras.setHorizontalAlignment(0);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfExcluir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jbgerar)).addGroup(layout.createSequentialGroup().addComponent(this.jtfCodigoBarras).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jbAdicionar)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jcbTipoCodigo, -2, 185, -2).addComponent(this.jLabel2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jcbTipoCodigo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jbAdicionar).addComponent(this.jtfCodigoBarras, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 257, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jbgerar).addComponent(this.jButton1).addComponent(this.jtfExcluir)).addContainerGap()));
        this.pack();
    }

    private void jbgerarActionPerformed(ActionEvent evt) {
        this.listaCodigos = new ArrayList();
        for (int i = 0; i < this.jtCodigos.getRowCount(); ++i) {
            this.listaCodigos.add((String)this.jtCodigos.getValueAt(i, 0));
        }
        this.gerarCodigoBarras(this.listaCodigos);
    }

    private void jbAdicionarActionPerformed(ActionEvent evt) {
        if (this.jcbTipoCodigo.getSelectedItem().toString() == "EAN13" && this.jtfCodigoBarras.getText().length() != 13) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve digitar 13 n\u00fameros para este padr\u00e3o de c\u00f3digo de barras");
        } else if (this.jcbTipoCodigo.getSelectedItem().toString() == "EAN8" && this.jtfCodigoBarras.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve digitar 8 n\u00fameros para este padr\u00e3o de c\u00f3digo de barras");
        } else {
            DefaultTableModel modelo = (DefaultTableModel)this.jtCodigos.getModel();
            int cont = 0;
            for (int i = 0; i < cont; ++i) {
                modelo.setNumRows(0);
            }
            modelo.addRow(new Object[]{this.jtfCodigoBarras.getText()});
        }
    }

    private void jtfExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = this.jtCodigos.getSelectedRow();
        if (linhaSelecionada < 0) {
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel)this.jtCodigos.getModel();
        modelo.removeRow(linhaSelecionada);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel)this.jtCodigos.getModel();
        modelo.setNumRows(0);
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
            Logger.getLogger(ViewCodigobarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewCodigobarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewCodigobarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewCodigobarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewCodigobarras().setVisible(true);
            }
        });
    }

    public void gerarCodigoBarras(ArrayList<String> pListaCodigos) {
        System.out.println("Barcode Linha de C\u00f3digo ");
        Document document = new Document(PageSize.A4, 50.0f, 50.0f, 50.0f, 50.0f);
        try {
            PdfWriter writer = PdfWriter.getInstance((Document)document, (OutputStream)new FileOutputStream("C://BLVendasMEI//Codigo_Barra_Java_Linha_Codigo.pdf"));
            document.open();
            for (int i = 0; i < pListaCodigos.size(); ++i) {
                document.add((Element)new Paragraph("C\u00d3DIGOS DE BARRA"));
                document.add((Element)new Paragraph("    "));
                document.add((Element)new Paragraph("    "));
                PdfContentByte cb = writer.getDirectContent();
                BarcodeEAN codeEAN = new BarcodeEAN();
                if (this.jcbTipoCodigo.getSelectedItem().toString() == "EAN13") {
                    codeEAN.setCodeType(1);
                } else if ("EAN8".equals(this.jcbTipoCodigo.getSelectedItem().toString())) {
                    codeEAN.setCodeType(2);
                } else if ("UPCA".equals(this.jcbTipoCodigo.getSelectedItem().toString())) {
                    codeEAN.setCodeType(3);
                } else if ("UPCE".equals(this.jcbTipoCodigo.getSelectedItem().toString())) {
                    codeEAN.setCodeType(4);
                }
                codeEAN.setCode("1234567890123");
                Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
                document.add((Element)new Phrase(new Chunk(imageEAN, 0.0f, 0.0f)));
            }
            File file = new File("C://BLVendasMEI//Codigo_Barra_Java_Linha_Codigo.pdf");
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception de) {
            de.printStackTrace();
        }
        document.close();
    }

}

