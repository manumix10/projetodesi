/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelUnidadeMedia;

public class DAOUnidadeMedia
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarUnidadeMediaDAO(ModelUnidadeMedia pModelUnidadeMedia) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO unidade_medida (abreviacao,descricao) VALUES ('" + pModelUnidadeMedia.getAbreviacao() + "'," + "'" + pModelUnidadeMedia.getDescricao() + "'" + ") RETURNING codigo;");
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
    public ModelUnidadeMedia getUnidadeMediaDAO(int pCodigo) {
        ModelUnidadeMedia modelUnidadeMedia;
        modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,abreviacao,descricao FROM unidade_medida WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelUnidadeMedia getUnidadeMediaDAO(String pNome) {
        ModelUnidadeMedia modelUnidadeMedia;
        modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,abreviacao,descricao FROM unidade_medida WHERE abreviacao = '" + pNome + "'" + ";");
            while (this.getResultSet().next()) {
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelUnidadeMedia> getListaUnidadeMediaDAO() {
        ArrayList<ModelUnidadeMedia> listamodelUnidadeMedia;
        listamodelUnidadeMedia = new ArrayList<ModelUnidadeMedia>();
        ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,abreviacao,descricao FROM unidade_medida;");
            while (this.getResultSet().next()) {
                modelUnidadeMedia = new ModelUnidadeMedia();
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
                listamodelUnidadeMedia.add(modelUnidadeMedia);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelUnidadeMedia;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarUnidadeMediaDAO(ModelUnidadeMedia pModelUnidadeMedia) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE unidade_medida SET codigo = '" + pModelUnidadeMedia.getCodigo() + "'," + "abreviacao = '" + pModelUnidadeMedia.getAbreviacao() + "'," + "descricao = '" + pModelUnidadeMedia.getDescricao() + "'" + " WHERE " + "codigo = '" + pModelUnidadeMedia.getCodigo() + "'" + ";");
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
    public boolean excluirUnidadeMediaDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM unidade_medida  WHERE codigo = '" + pCodigo + "'" + ";");
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

