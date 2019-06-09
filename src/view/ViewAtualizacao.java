/*
 * Decompiled with CFR 0_122.
 */
package view;

import controller.ControllerAtualizacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import util.AguardeDownload;

public class ViewAtualizacao
extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaDadosSoftware;
    private JTextField jtfStatus;

    public ViewAtualizacao() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.jTextAreaDadosSoftware = new JTextArea();
        this.jLabel2 = new JLabel();
        this.jtfStatus = new JTextField();
        this.jLabel3 = new JLabel();
        this.jButton2 = new JButton();
        this.setDefaultCloseOperation(3);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Sync.png")));
        this.jButton1.setText("Atualizar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtualizacao.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel1.setText("Dados do software:");
        this.jTextAreaDadosSoftware.setEditable(false);
        this.jTextAreaDadosSoftware.setColumns(20);
        this.jTextAreaDadosSoftware.setFont(new Font("Monospaced", 1, 14));
        this.jTextAreaDadosSoftware.setRows(5);
        this.jScrollPane1.setViewportView(this.jTextAreaDadosSoftware);
        this.jLabel2.setText("Situa\u00e7\u00e3o atual do software:");
        this.jtfStatus.setEditable(false);
        this.jtfStatus.setFont(new Font("Tahoma", 1, 12));
        this.jtfStatus.setForeground(new Color(51, 102, 0));
        this.jLabel3.setFont(new Font("Tahoma", 0, 12));
        this.jLabel3.setForeground(new Color(204, 0, 51));
        this.jLabel3.setText("Aten\u00e7\u00e3o para executar a atualiza\u00e7\u00e3o \u00e9 necessario est\u00e1 conectado a internet.");
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/OK.png")));
        this.jButton2.setText("Ok");
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtualizacao.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel1).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jButton1)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfStatus)).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.jButton2, -2, 117, -2).addGap(0, 0, 32767))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 156, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jtfStatus, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.atualizarSoftware();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String[] args) {
        ViewAtualizacao atualizacao = new ViewAtualizacao();
        atualizacao.setVisible(true);
        atualizacao.atualizarSoftware();
    }

    public void atualizarSoftware() {
        String nomeArquivo = "BLVendasMEI.exe";
        String caminhoAtualizacao = "C:\\BLVendasMEI\\atualizacao\\";
        String caminhoNovoArquivo = "C:\\BLVendasMEI\\";
        final ControllerAtualizacao controllerAtualizacao = new ControllerAtualizacao();
        final AguardeDownload carregando = new AguardeDownload();
        carregando.setVisible(true);
        Thread t = new Thread(){

            @Override
            public void run() {
                boolean copiouArquivo = false;
                boolean baixou = controllerAtualizacao.gravaArquivoDeURLBoolean("http://blsoft.com.br/atualizacoes/download/blvendasmei.atu", "C:\\BLVendasMEI\\atualizacao\\", "blsoft", "$ENHA123");
                if (baixou) {
                    File jarAtualizado = new File("C:\\BLVendasMEI\\atualizacao\\BLVendasMEI.exe");
                    File destino = new File("C:\\BLVendasMEI\\BLVendasMEI.exe");
                    try {
                        copiouArquivo = ViewAtualizacao.this.copyFile(jarAtualizado, destino);
                    }
                    catch (IOException ex) {
                        Logger.getLogger(ViewAtualizacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "N\u00e3o foi poss\u00edvel atualizar o software.\nCheque a conex\u00e3o com a internet.", "ERRO", 0);
                }
                carregando.dispose();
                if (copiouArquivo) {
                    JOptionPane.showMessageDialog(null, "O software foi atualizado!", "Aten\u00e7\u00e3o!", 2);
                    JOptionPane.showMessageDialog(null, "Execute novamente o software", "Aten\u00e7\u00e3o!", 2);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "N\u00e3o foi poss\u00edvel atualizar o software.\nO arquivo de atualiza\u00e7\u00e3o n\u00e3o pode ser copiado.", "ERRO", 0);
                }
            }
        };
        t.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }
        FileChannel sourceChannel = null;
        AbstractInterruptibleChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), (WritableByteChannel)((Object)destinationChannel));
            boolean bl = true;
            return bl;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

}

