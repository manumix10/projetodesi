/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelEstado;

public class DAOEstado
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarEstadoDAO(ModelEstado pModelEstado) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO estado (codigo,uf,nome) VALUES ('" + pModelEstado.getCodigo() + "'," + "'" + pModelEstado.getUf() + "'," + "'" + pModelEstado.getNome() + "'" + ");");
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
    public ModelEstado getEstadoDAO(int pCodigo) {
        ModelEstado modelEstado;
        modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,uf,nome FROM estado WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelEstado;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelEstado getEstadoDAO(String pNome) {
        ModelEstado modelEstado;
        modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,uf,nome FROM estado WHERE nome = '" + pNome + "';");
            while (this.getResultSet().next()) {
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelEstado;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelEstado getEstadoUFDAO(String pNome) {
        ModelEstado modelEstado;
        modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,uf,nome FROM estado WHERE uf = '" + pNome + "';");
            while (this.getResultSet().next()) {
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelEstado;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelEstado> getListaEstadoDAO() {
        ArrayList<ModelEstado> listamodelEstado;
        listamodelEstado = new ArrayList<ModelEstado>();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,uf,nome FROM estado;");
            while (this.getResultSet().next()) {
                modelEstado = new ModelEstado();
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
                listamodelEstado.add(modelEstado);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelEstado;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarEstadoDAO(ModelEstado pModelEstado) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE estado SET codigo = '" + pModelEstado.getCodigo() + "'," + "uf = '" + pModelEstado.getUf() + "'," + "nome = '" + pModelEstado.getNome() + "'" + " WHERE " + "codigo = '" + pModelEstado.getCodigo() + "'" + ";");
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
    public boolean excluirEstadoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM estado  WHERE codigo = '" + pCodigo + "'" + ";");
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

