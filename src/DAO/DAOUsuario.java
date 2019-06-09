/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelUsuario;

public class DAOUsuario
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO tbl_usuarios (nome,login,senha) VALUES ('" + pModelUsuario.getNome() + "'," + "'" + pModelUsuario.getLogin() + "'," + "'" + pModelUsuario.getSenha() + "'" + ") RETURNING pk_codigo;");
            return n;
        }
        catch (Exception e) {
            e.printStackTrace();
            int n = 0;
            return n;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelUsuario getUsuarioDAO(int pCodigo) {
        ModelUsuario modelUsuario;
        modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,nome,login,senha FROM tbl_usuarios WHERE pk_codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelUsuario getUsuarioDAO(String pLogin) {
        ModelUsuario modelUsuario;
        modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,nome,login,senha FROM tbl_usuarios WHERE login = '" + pLogin + "'" + ";");
            while (this.getResultSet().next()) {
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean getUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,nome,login,senha FROM tbl_usuarios WHERE login = '" + pModelUsuario.getLogin() + "' AND senha = '" + pModelUsuario.getSenha() + "' " + ";");
            if (this.getResultSet().next()) {
                boolean bl = true;
                return bl;
            }
            boolean bl = false;
            return bl;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema de conex\u00e3o com o banco de dados!.", "Erro", 0);
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario;
        listamodelUsuario = new ArrayList<ModelUsuario>();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,nome,login,senha FROM tbl_usuarios;");
            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_usuarios SET pk_codigo = '" + pModelUsuario.getCodigo() + "'," + "nome = '" + pModelUsuario.getNome() + "'," + "login = '" + pModelUsuario.getLogin() + "'," + "senha = '" + pModelUsuario.getSenha() + "'" + " WHERE " + "pk_codigo = '" + pModelUsuario.getCodigo() + "'" + ";");
            boolean bl = true;
            return bl;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean excluirUsuarioDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM tbl_usuarios  WHERE pk_codigo = '" + pCodigo + "'" + ";");
            boolean bl = true;
            return bl;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            this.fecharConexao();
        }
    }
}

