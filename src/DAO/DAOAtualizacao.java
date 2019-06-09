/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;

public class DAOAtualizacao
extends ConexaoFirebird {
    public String retornarNumeroAtualizacao() {
        String nome;
        nome = new String();
        try {
            this.conectar();
            this.executarSQL("SELECT numero_atualizacao FROM atualizacao;");
            while (this.getResultSet().next()) {
                nome = this.getResultSet().getString(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return nome;
    }

    public String retornarDadosAtualizacao() {
        String anotacaoes;
        anotacaoes = new String();
        try {
            this.conectar();
            this.executarSQL("SELECT anotacoes FROM atualizacao;");
            while (this.getResultSet().next()) {
                anotacaoes = this.getResultSet().getString(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return anotacaoes;
    }

    public String retornarVersaoSoftware() {
        String versao;
        versao = new String();
        try {
            this.conectar();
            this.executarSQL("SELECT versao FROM atualizacao;");
            while (this.getResultSet().next()) {
                versao = this.getResultSet().getString(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return versao;
    }
}

