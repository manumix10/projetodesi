/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.ModelAberturaCaixaPDV;

public class DAOAberturaCaixaPDV
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarAberturaCaixaPDVDAO(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO abertura_caixa_pdv (codigo_usuario,valor_abertura,valor_fechamento,data,status) VALUES ('" + pModelAberturaCaixaPDV.getCodigoUsuario() + "'," + "'" + pModelAberturaCaixaPDV.getValorAbertura() + "'," + "'" + pModelAberturaCaixaPDV.getValorFechamento() + "'," + "'" + pModelAberturaCaixaPDV.getData() + "'," + "'" + pModelAberturaCaixaPDV.getStatus() + "'" + ") RETURNING codigo;");
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
    public ModelAberturaCaixaPDV getAberturaCaixaPDVDAO(int pCodigo) {
        ModelAberturaCaixaPDV modelAberturaCaixaPDV;
        modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_usuario,valor_abertura,valor_fechamento,data,status FROM abertura_caixa_pdv WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelAberturaCaixaPDV.setCodigo(this.getResultSet().getInt(1));
                modelAberturaCaixaPDV.setCodigoUsuario(this.getResultSet().getInt(2));
                modelAberturaCaixaPDV.setValorAbertura(this.getResultSet().getDouble(3));
                modelAberturaCaixaPDV.setValorFechamento(this.getResultSet().getDouble(4));
                modelAberturaCaixaPDV.setData(this.getResultSet().getDate(5));
                modelAberturaCaixaPDV.setStatus(this.getResultSet().getInt(6));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelAberturaCaixaPDV;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelAberturaCaixaPDV> getListaAberturaCaixaPDVDAO() {
        ArrayList<ModelAberturaCaixaPDV> listamodelAberturaCaixaPDV;
        listamodelAberturaCaixaPDV = new ArrayList<ModelAberturaCaixaPDV>();
        ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_usuario,valor_abertura,valor_fechamento,data,status FROM abertura_caixa_pdv;");
            while (this.getResultSet().next()) {
                modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
                modelAberturaCaixaPDV.setCodigo(this.getResultSet().getInt(1));
                modelAberturaCaixaPDV.setCodigoUsuario(this.getResultSet().getInt(2));
                modelAberturaCaixaPDV.setValorAbertura(this.getResultSet().getDouble(3));
                modelAberturaCaixaPDV.setValorFechamento(this.getResultSet().getDouble(4));
                modelAberturaCaixaPDV.setData(this.getResultSet().getDate(5));
                modelAberturaCaixaPDV.setStatus(this.getResultSet().getInt(6));
                listamodelAberturaCaixaPDV.add(modelAberturaCaixaPDV);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelAberturaCaixaPDV;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelAberturaCaixaPDV> getListaAberturaCaixaNomeUsuPDVDAO() {
        ArrayList<ModelAberturaCaixaPDV> listamodelAberturaCaixaPDV;
        listamodelAberturaCaixaPDV = new ArrayList<ModelAberturaCaixaPDV>();
        ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        try {
            this.conectar();
            this.executarSQL("SELECT abertura_caixa_pdv.codigo,abertura_caixa_pdv.codigo_usuario,abertura_caixa_pdv.valor_abertura,abertura_caixa_pdv.valor_fechamento,abertura_caixa_pdv.data,abertura_caixa_pdv.status,tbl_usuarios.nome FROM abertura_caixa_pdv INNER JOIN tbl_usuarios on tbl_usuarios.pk_codigo = abertura_caixa_pdv.codigo_usuario ;");
            while (this.getResultSet().next()) {
                modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
                modelAberturaCaixaPDV.setCodigo(this.getResultSet().getInt(1));
                modelAberturaCaixaPDV.setCodigoUsuario(this.getResultSet().getInt(2));
                modelAberturaCaixaPDV.setValorAbertura(this.getResultSet().getDouble(3));
                modelAberturaCaixaPDV.setValorFechamento(this.getResultSet().getDouble(4));
                modelAberturaCaixaPDV.setData(this.getResultSet().getDate(5));
                modelAberturaCaixaPDV.setStatus(this.getResultSet().getInt(6));
                modelAberturaCaixaPDV.setNomeUsuario(this.getResultSet().getString(7));
                listamodelAberturaCaixaPDV.add(modelAberturaCaixaPDV);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelAberturaCaixaPDV;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarAberturaCaixaPDVDAO(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE abertura_caixa_pdv SET codigo_usuario = '" + pModelAberturaCaixaPDV.getCodigoUsuario() + "'," + "valor_abertura = '" + pModelAberturaCaixaPDV.getValorAbertura() + "'," + "valor_fechamento = '" + pModelAberturaCaixaPDV.getValorFechamento() + "'," + "data = '" + pModelAberturaCaixaPDV.getData() + "'," + "status = '" + pModelAberturaCaixaPDV.getStatus() + "'" + " WHERE " + "codigo_usuario = '" + pModelAberturaCaixaPDV.getCodigoUsuario() + "' " + " AND status = 1" + ";");
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
    public boolean excluirAberturaCaixaPDVDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM abertura_caixa_pdv  WHERE codigo = '" + pCodigo + "'" + ";");
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
    public ModelAberturaCaixaPDV getDadosCaixaAtualPeloUsuarioDAO(int pCodigo) {
        ModelAberturaCaixaPDV modelAberturaCaixaPDV;
        modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        try {
            this.conectar();
            this.executarSQL("SELECT first 1codigo,codigo_usuario,valor_abertura,valor_fechamento,data,status FROM abertura_caixa_pdv WHERE codigo_usuario = '" + pCodigo + "'" + " ORDER BY codigo DESC" + ";");
            while (this.getResultSet().next()) {
                modelAberturaCaixaPDV.setCodigo(this.getResultSet().getInt(1));
                modelAberturaCaixaPDV.setCodigoUsuario(this.getResultSet().getInt(2));
                modelAberturaCaixaPDV.setValorAbertura(this.getResultSet().getDouble(3));
                modelAberturaCaixaPDV.setValorFechamento(this.getResultSet().getDouble(4));
                modelAberturaCaixaPDV.setData(this.getResultSet().getDate(5));
                modelAberturaCaixaPDV.setStatus(this.getResultSet().getInt(6));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelAberturaCaixaPDV;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarValorFechamentoCaixaDAO(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE abertura_caixa_pdv SET valor_fechamento = '" + pModelAberturaCaixaPDV.getValorFechamento() + "' " + " WHERE " + "codigo_usuario = '" + pModelAberturaCaixaPDV.getCodigoUsuario() + "' " + " AND status = 1" + ";");
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

