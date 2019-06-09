/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelPermissaousuario;

public class DAOPermissaousuario
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelPermissaousuario.getListaModelPermissaousuarios().size();
            for (i = 0; i < sizeLista; ++i) {
                this.insertSQL("INSERT INTO usuario_permissao (fk_codigo_usuario,  permissao ) VALUES ('" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getCodigo_usuario() + "'," + "'" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getPermissao() + "'" + ") RETURNING pk_codigo;");
            }
            i = 1;
            return i;
        }
        catch (Exception e) {
            e.printStackTrace();
            int i = 0;
            return i;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelPermissaousuario getPermissaousuarioDAO(int pCodigo) {
        ModelPermissaousuario modelPermissaousuario;
        modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_usuario,permissao FROM usuario_permissao WHERE pk_codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO() {
        ArrayList<ModelPermissaousuario> listamodelPermissaousuario;
        listamodelPermissaousuario = new ArrayList<ModelPermissaousuario>();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_usuario,permissao FROM usuario_permissao;");
            while (this.getResultSet().next()) {
                modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE usuario_permissao SET pk_codigo = '" + pModelPermissaousuario.getCodigo() + "'," + "fk_codigo_usuario = '" + pModelPermissaousuario.getCodigo_usuario() + "'," + "permissao = '" + pModelPermissaousuario.getPermissao() + "'" + " WHERE " + "pk_codigo = '" + pModelPermissaousuario.getCodigo() + "'" + ";");
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
    public boolean excluirPermissaousuarioDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM usuario_permissao  WHERE fk_codigo_usuario = '" + pCodigo + "'" + ";");
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
    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO(int pCodigo) {
        ArrayList<ModelPermissaousuario> listamodelPermissaousuario;
        listamodelPermissaousuario = new ArrayList<ModelPermissaousuario>();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_usuario,permissao FROM usuario_permissao WHERE fk_codigo_usuario = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }
}

