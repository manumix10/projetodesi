/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class criaTxt {
    public static void main(String[] args) {
    }

    public void criaTxt() {
        try {
            File arquivo = new File("/Iguana/comprovantes/comanda.txt");
            if (arquivo.exists()) {
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                linhasTxt.println("===========================================");
                linhasTxt.println("              Nome da empresa              ");
                linhasTxt.println("===========================================");
                linhasTxt.println("********** NAO E DOCUMENTO FISCAL *********");
                linhasTxt.println("===========================================");
                linhasTxt.println("PRODUTO      QTDE      VALOR UN.      VALOR");
                linhasTxt.println("===========================================");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");
                linhasTxt.println("===========================================");
                linhasTxt.println(" GARCOM  CONTA.DIV.  VAL.PESS. COVER  DESC.");
                linhasTxt.println();
                linhasTxt.println("===========================================");
                linhasTxt.println("                   ------------------------");
                linhasTxt.println("===========================================");
                linhasTxt.println("       MENSAGEM DA EMPRESA VAI AQUI        ");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");
                for (int i = 0; i < 10; ++i) {
                    linhasTxt.println();
                }
                arquivoTxt.close();
                this.emiteComanda();
            } else {
                arquivo.createNewFile();
                this.criaTxt();
            }
        }
        catch (IOException error) {
            System.out.println("nao encontrei arquivo");
        }
    }

    public void emiteComanda() {
        try {
            FileInputStream is = new FileInputStream("/Iguana/comprovantes/comanda.txt");
            Scanner sc = new Scanner(is);
            FileOutputStream fs = new FileOutputStream("LPT1:");
            PrintStream ps = new PrintStream(fs);
            while (sc.hasNextLine()) {
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }
    }
}

