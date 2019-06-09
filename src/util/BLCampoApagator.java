/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.toedter.calendar.JDateChooser
 */
package util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Container;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BLCampoApagator {
    public void limparCampos(Container container) {
        Component[] campos;
        for (Component componente : campos = container.getComponents()) {
            if (componente instanceof JTextField) {
                JTextField jtf = (JTextField)componente;
                jtf.setText("");
                continue;
            }
            if (componente instanceof JFormattedTextField) {
                JFormattedTextField jftf = (JFormattedTextField)componente;
                jftf.setValue(null);
                continue;
            }
            if (componente instanceof JTextArea) {
                JTextArea jta = (JTextArea)componente;
                jta.setText("");
                continue;
            }
            if (!(componente instanceof JDateChooser)) continue;
            JDateChooser jdc = (JDateChooser)componente;
            jdc.setDate(null);
        }
    }

    public void apagarBotoes(Container container) {
        Component[] campos;
        for (Component componente : campos = container.getComponents()) {
            if (!(componente instanceof JButton)) continue;
            JButton jButton = (JButton)componente;
            jButton.setEnabled(false);
        }
    }

    public void ativaBotoes(Container container) {
        Component[] campos;
        for (Component componente : campos = container.getComponents()) {
            if (!(componente instanceof JButton)) continue;
            JButton jButton = (JButton)componente;
            jButton.setEnabled(true);
        }
    }

    public void limparDadosTabela(JTable pTabela) {
        DefaultTableModel modelo = (DefaultTableModel)pTabela.getModel();
        modelo.setNumRows(0);
    }
}

