/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelCidade;

public class DAOCidade
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarCidadeDAO(ModelCidade pModelCidade) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO cidade (nome,fk_cod_estado) VALUES ('" + pModelCidade.getNome() + "'," + "'" + pModelCidade.getFk_cod_estado() + "'" + ") RETURNING codigo;");
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
    public ModelCidade getCidadeDAO(int pCodigo) {
        ModelCidade modelCidade;
        modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,fk_cod_estado FROM cidade WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelCidade getCidadeDAO(String pNome) {
        ModelCidade modelCidade;
        modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,fk_cod_estado FROM cidade WHERE nome = '" + pNome + "'" + ";");
            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelCidade> getListaCidadeDAO() {
        ArrayList<ModelCidade> listamodelCidade;
        listamodelCidade = new ArrayList<ModelCidade>();
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,fk_cod_estado FROM cidade;");
            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                listamodelCidade.add(modelCidade);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelCidade> getListaCidadePorEstadoDAO(int pCodigoEstado) {
        ArrayList<ModelCidade> listamodelCidade;
        listamodelCidade = new ArrayList<ModelCidade>();
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,fk_cod_estado FROM cidade where fk_cod_estado = '" + pCodigoEstado + "';");
            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                listamodelCidade.add(modelCidade);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarCidadeDAO(ModelCidade pModelCidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE cidade SET codigo = '" + pModelCidade.getCodigo() + "'," + "nome = '" + pModelCidade.getNome() + "'," + "fk_cod_estado = '" + pModelCidade.getFk_cod_estado() + "'" + " WHERE " + "codigo = '" + pModelCidade.getCodigo() + "'" + ";");
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
    public boolean excluirCidadeDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM cidade  WHERE codigo = '" + pCodigo + "'" + ";");
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

