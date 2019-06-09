/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.util.ArrayList;
import model.ModelNotaFiscal;

/**
 *
 * @author MICRO-70
 */
public class DAONotaFiscal extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarNotaFiscalDAO(ModelNotaFiscal pModelNotaFiscal) {
        try {
            this.conectar();
            int n = this.insertSQL(
                    "INSERT INTO nota_fiscal ("
                        //    + "codigo_nota,"
                            + "numero_nota,"
                            + "data,"
                            + "quantidade,"
                            + "valor_nota, "
                            + "codigo_fornecedor) "
                            + "VALUES ("
                         //   + "'" + pModelNotaFiscal.getCodigoNota()+ "'," 
                            + "'" + pModelNotaFiscal.getNumeroNota()+ "'," 
                            + "'" + pModelNotaFiscal.getData()+ "'," 
                            + "'" + pModelNotaFiscal.getQuantidade()+ "'," 
                            + "'" + pModelNotaFiscal.getValorNota()+ "'," 
                            + "'" + pModelNotaFiscal.getCodigoFornecedor()+ "'" + ");");
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
    
    public boolean excluirNotaFiscalDAO(String numeronota ){
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM nota_fiscal  WHERE numero_nota = '" + numeronota + "'" + ";");
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

   
    public ArrayList<ModelNotaFiscal> getListaNotaFiscalDAO() {
        ArrayList<ModelNotaFiscal> listamodelnotafiscal;
        listamodelnotafiscal = new ArrayList<ModelNotaFiscal>();
        ModelNotaFiscal modelNotaFiscal = new ModelNotaFiscal();
        try {
            this.conectar();
            this.executarSQL("SELECT numero_nota,data,quantidade,valor_nota, codigo_fornecedor FROM nota_fiscal;");
            while (this.getResultSet().next()) {
                modelNotaFiscal = new ModelNotaFiscal();
            //    modelNotaFiscal.setCodigoNota(this.getResultSet().getInt(1));
                modelNotaFiscal.setNumeroNota(this.getResultSet().getString(1));
                modelNotaFiscal.setData(this.getResultSet().getDate(2));
                modelNotaFiscal.setQuantidade(this.getResultSet().getString(3));
                modelNotaFiscal.setValorNota(this.getResultSet().getString(4));
                modelNotaFiscal.setCodigoFornecedor(this.getResultSet().getInt(5));
                listamodelnotafiscal.add(modelNotaFiscal);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelnotafiscal;
    }

}
