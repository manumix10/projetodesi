/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensagem {
    public static void Gravar(Component e) {
        JOptionPane.showMessageDialog(e, "Registro gravado com sucesso!", "Aviso", 1);
    }

    public static void CancelarOperacao(Component e) {
        JOptionPane.showMessageDialog(e, "Voc\u00ea cancelou a opera\u00e7\u00e3o!", "Aviso", 1);
    }

    public static void Alterar(Component e) {
        JOptionPane.showMessageDialog(e, "Registro alterado com sucesso!", "Aviso", 1);
    }

    public static void Excluir(Component e) {
        JOptionPane.showMessageDialog(e, "Registro excluido com sucesso!", "Aviso", 1);
    }

    public static void ErroGravar(Component e) {
        JOptionPane.showMessageDialog(e, "Erro ao gravar os dados!", "ERRO", 0);
    }

    public static void ErroAlterar(Component e) {
        JOptionPane.showMessageDialog(e, "Erro ao alterar os dados!", "ERRO", 0);
    }

    public static void ErroExcluir(Component e) {
        JOptionPane.showMessageDialog(e, "Erro ao excluir os dados!", "ERRO", 0);
    }

    public static void ErroRelatorio(Component e) {
        JOptionPane.showMessageDialog(e, "Erro ao gerar relat\u00f3rio!", "ERRO", 0);
    }

    public static void ErroClassNotFound(Component e) {
        JOptionPane.showMessageDialog(e, "Erro: ClassNotFound\n", "Erro referente ao banco de dados", 0);
    }

    public static void ErroSQLException(Component e) {
        JOptionPane.showMessageDialog(e, "Erro: SQL\n", "Erro referente ao banco de dados", 0);
    }

    public static void Erro(Component e, String msg) {
        JOptionPane.showMessageDialog(e, msg, "Erro", 0);
    }

    public static void Avisa(Component e, String msg) {
        JOptionPane.showMessageDialog(e, msg, "Aviso", 2);
    }

    public static void Atencao(Component e, String msg) {
        JOptionPane.showMessageDialog(e, msg, "Aten\u00e7\u00e3o", 2);
    }

    public static int mensagemYesNo(Component e, String msg) {
        int resp = JOptionPane.showConfirmDialog(e, msg, "Confirma\u00e7\u00e3o", 0);
        return resp;
    }

    public static String mensagemInput(String msg, String titulo, Component e) {
        String resp = null;
        resp = JOptionPane.showInputDialog(e, msg, titulo, 0);
        return resp.toString();
    }
}

