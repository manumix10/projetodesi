/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelCaixa;

public class DAOCaixa
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarCaixaDAO(ModelCaixa pModelCaixa) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO caixa (codigo,dinheiro,cheque,cartao,vale) VALUES ('" + pModelCaixa.getCodigo() + "'," + "'" + pModelCaixa.getDinheiro() + "'," + "'" + pModelCaixa.getCheque() + "'," + "'" + pModelCaixa.getCartao() + "'," + "'" + pModelCaixa.getVale() + "'" + ");");
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
    public ModelCaixa getCaixaDAO(int pCodigo) {
        ModelCaixa modelCaixa;
        modelCaixa = new ModelCaixa();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,dinheiro,cheque,cartao,vale FROM caixa WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setDinheiro(this.getResultSet().getFloat(2));
                modelCaixa.setCheque(this.getResultSet().getFloat(3));
                modelCaixa.setCartao(this.getResultSet().getFloat(4));
                modelCaixa.setVale(this.getResultSet().getFloat(5));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelCaixa;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelCaixa> getListaCaixaDAO() {
        ArrayList<ModelCaixa> listamodelCaixa;
        listamodelCaixa = new ArrayList<ModelCaixa>();
        ModelCaixa modelCaixa = new ModelCaixa();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,dinheiro,cheque,cartao,vale FROM caixa;");
            while (this.getResultSet().next()) {
                modelCaixa = new ModelCaixa();
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setDinheiro(this.getResultSet().getFloat(2));
                modelCaixa.setCheque(this.getResultSet().getFloat(3));
                modelCaixa.setCartao(this.getResultSet().getFloat(4));
                modelCaixa.setVale(this.getResultSet().getFloat(5));
                listamodelCaixa.add(modelCaixa);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelCaixa;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarCaixaDAO(ModelCaixa pModelCaixa) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE caixa SET codigo = '" + pModelCaixa.getCodigo() + "'," + "dinheiro = '" + pModelCaixa.getDinheiro() + "'," + "cheque = '" + pModelCaixa.getCheque() + "'," + "cartao = '" + pModelCaixa.getCartao() + "'," + "vale = '" + pModelCaixa.getVale() + "'" + " WHERE " + "codigo = '" + pModelCaixa.getCodigo() + "'" + ";");
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
    public boolean excluirCaixaDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM caixa  WHERE codigo = '" + pCodigo + "'" + ";");
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

