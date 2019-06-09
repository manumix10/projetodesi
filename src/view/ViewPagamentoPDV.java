/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.ControllerFormaPagamento;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.ModelFormaPagamento;
import util.BLMascaras;

/**
 *
 * @author Administrador
 */
public class ViewPagamentoPDV extends javax.swing.JDialog {
    
    private float valorTotal;
    private float desconto;
    private float valorRecebido;
    private float troco;
    private float totalPagar;
    private String tipoPagamento;
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    
    /**
     * Creates new form ViewPagamentoPDV
     */
    public ViewPagamentoPDV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.listarTipoPagamento();
        setLocationRelativeTo(null);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbTipoPagamento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlfValorPagar = new javax.swing.JLabel();
        jlRS = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfTroco = new javax.swing.JTextField();
        jtfValorRecebido = new javax.swing.JTextField();
        jtfDesconto = new javax.swing.JTextField();
        jtfSubtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Pagamento");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 190, 50));
        getRootPane().setDefaultButton(okButton);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pagamento:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jcbTipoPagamento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jcbTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 350, 39));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Desconto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Subtotal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 90, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Valor Recebido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total a pagar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jlfValorPagar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlfValorPagar.setForeground(new java.awt.Color(0, 153, 102));
        jlfValorPagar.setText("valor");

        jlRS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlRS.setForeground(new java.awt.Color(0, 153, 102));
        jlRS.setText("R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(jlRS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlfValorPagar)
                .addGap(216, 216, 216))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlfValorPagar)
                    .addComponent(jlRS))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, 547, 130));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Troco:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jtfTroco.setEditable(false);
        jtfTroco.setBackground(new java.awt.Color(255, 204, 204));
        jtfTroco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTrocoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 243, 50));

        jtfValorRecebido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfValorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfValorRecebidoFocusLost(evt);
            }
        });
        jtfValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValorRecebidoKeyReleased(evt);
            }
        });
        getContentPane().add(jtfValorRecebido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 170, 50));

        jtfDesconto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDescontoFocusLost(evt);
            }
        });
        jtfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyReleased(evt);
            }
        });
        getContentPane().add(jtfDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 170, 50));

        jtfSubtotal.setEditable(false);
        jtfSubtotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jtfSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 170, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagamento.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        float ptroco = Float.parseFloat(this.jtfTroco.getText());
        if (ptroco < 0.0f) {
            JOptionPane.showMessageDialog(null, "Valor recebido n\u00e3o \u00e9 o suficiente para pagar a venda!", "Aten\u00e7\u00e3o", 1);
        } else {
            this.desconto = this.jtfDesconto.getText().equals("") ? 0.0f : Float.parseFloat(this.jtfDesconto.getText());
            this.valorRecebido = Float.parseFloat(this.jtfValorRecebido.getText());
            this.troco = ptroco;
            this.totalPagar = Float.parseFloat(this.jlfValorPagar.getText());
            this.tipoPagamento = this.jcbTipoPagamento.getSelectedItem().toString();
           this.limparTabela();
            this.doClose(1);
            
        } 
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jtfTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTrocoActionPerformed

    private void jtfValorRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorRecebidoFocusLost
        // TODO add your handling code here:
        this.jlfValorPagar.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.calcularDesconto()));
        this.jtfTroco.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.calcularTroco()));
    }//GEN-LAST:event_jtfValorRecebidoFocusLost

    private void jtfValorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorRecebidoKeyReleased
        // TODO add your handling code here:
        this.jtfValorRecebido.setText(new BLMascaras().converterVirgulaParaPonto(this.jtfValorRecebido.getText()));
    }//GEN-LAST:event_jtfValorRecebidoKeyReleased

    private void jtfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDescontoFocusLost
        // TODO add your handling code here:
        this.jlfValorPagar.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.calcularDesconto()));
        this.jtfTroco.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.calcularTroco()));
    }//GEN-LAST:event_jtfDescontoFocusLost

    private void jtfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyReleased
        // TODO add your handling code here:
        this.jtfDesconto.setText(new BLMascaras().converterVirgulaParaPonto(this.jtfDesconto.getText()));
    }//GEN-LAST:event_jtfDescontoKeyReleased
    
     private void limparTabela() {
      
        this.jtfValorRecebido.setText("");
        this.jtfDesconto.setText("");
        this.jtfTroco.setText("0.0");
        this.jlfValorPagar.setText("0.0");
   
       
    }
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    
    private float calcularDesconto(){
        float pSubTotal, pDesconto = 0;
        if(this.jtfSubtotal.getText().equals("")){
            pSubTotal = 0;
        }else{
            pSubTotal = Float.parseFloat(this.jtfSubtotal.getText());
        }
        if(this.jtfDesconto.getText().equals("")){
            pDesconto = 0;
        }else{
            pDesconto = Float.parseFloat(this.jtfDesconto.getText());
        }
        valorTotal = pSubTotal - pDesconto;
        return valorTotal;   
    }
    
    private float calcularTroco(){
        float pValorRecebid = 0;
        if(this.jtfValorRecebido.getText().equals("")){
            pValorRecebid = 0;
        }else{
            pValorRecebid = Float.parseFloat(this.jtfValorRecebido.getText());
        }
        return pValorRecebid - valorTotal;
    }
   
    private void listarTipoPagamento(){
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        jcbTipoPagamento.removeAllItems();
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++){
            jcbTipoPagamento.addItem(listaModelTipoPagamentos.get(i).getDescricao());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPagamentoPDV dialog = new ViewPagamentoPDV(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcbTipoPagamento;
    private javax.swing.JLabel jlRS;
    private javax.swing.JLabel jlfValorPagar;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfSubtotal;
    private javax.swing.JTextField jtfTroco;
    private javax.swing.JTextField jtfValorRecebido;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
   public void setTextFildValorTotal(){
       this.jtfSubtotal.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.valorTotal));
   }
   
   public void setTextFildValorRecebido(){
       this.jtfValorRecebido.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.valorRecebido));
   }
   
   public void setTextFildValorDesconto(){
       this.jtfDesconto.setText("" + new BLMascaras().arredondamentoComPontoDuasCasas(this.desconto));
   }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the valorRecebido
     */
    public float getValorRecebido() {
        return valorRecebido;
    }

    /**
     * @param valorRecebido the valorRecebido to set
     */
    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    /**
     * @return the troco
     */
    public float getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(float troco) {
        this.troco = troco;
    }

    /**
     * @return the totalPagar
     */
    public float getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the tipoPagamento
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
