/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelEmpresa;

public class DAOEmpresa
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarEmpresaDAO(ModelEmpresa pModelEmpresa) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO empresa (codigo,razao_social,nome_fantasia,endereco,bairro,cod_cidade,cod_estado,cep,telefone, cnpj ) VALUES ('" + pModelEmpresa.getCodigo() + "'," + "'" + pModelEmpresa.getRazaoSocial() + "'," + "'" + pModelEmpresa.getNomeFantasia() + "'," + "'" + pModelEmpresa.getEndereco() + "'," + "'" + pModelEmpresa.getBairro() + "'," + "'" + pModelEmpresa.getCodCidade() + "'," + "'" + pModelEmpresa.getCodEstado() + "'," + "'" + pModelEmpresa.getCep() + "'," + "'" + pModelEmpresa.getTelefone() + "'," + "'" + pModelEmpresa.getCnpj() + "'" + ");");
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
    public ModelEmpresa getEmpresaDAO(int pCodigo) {
        ModelEmpresa modelEmpresa;
        modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,razao_social,nome_fantasia,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cnpj  FROM empresa WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setBairro(this.getResultSet().getString(5));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(6));
                modelEmpresa.setCodEstado(this.getResultSet().getInt(7));
                modelEmpresa.setCep(this.getResultSet().getString(8));
                modelEmpresa.setTelefone(this.getResultSet().getString(9));
                modelEmpresa.setCnpj(this.getResultSet().getString(10));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelEmpresa;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelEmpresa> getListaEmpresaDAO() {
        ArrayList<ModelEmpresa> listamodelEmpresa;
        listamodelEmpresa = new ArrayList<ModelEmpresa>();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,razao_social,nome_fantasia,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cnpj  FROM empresa;");
            while (this.getResultSet().next()) {
                modelEmpresa = new ModelEmpresa();
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setBairro(this.getResultSet().getString(5));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(6));
                modelEmpresa.setCodEstado(this.getResultSet().getInt(7));
                modelEmpresa.setCep(this.getResultSet().getString(8));
                modelEmpresa.setTelefone(this.getResultSet().getString(9));
                modelEmpresa.setCnpj(this.getResultSet().getString(10));
                listamodelEmpresa.add(modelEmpresa);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelEmpresa;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarEmpresaDAO(ModelEmpresa pModelEmpresa) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE empresa SET codigo = '" + pModelEmpresa.getCodigo() + "'," + "razao_social = '" + pModelEmpresa.getRazaoSocial() + "'," + "nome_fantasia = '" + pModelEmpresa.getNomeFantasia() + "'," + "endereco = '" + pModelEmpresa.getEndereco() + "'," + "bairro = '" + pModelEmpresa.getBairro() + "'," + "cod_cidade = '" + pModelEmpresa.getCodCidade() + "'," + "cod_estado = '" + pModelEmpresa.getCodEstado() + "'," + "cep = '" + pModelEmpresa.getCep() + "'," + "telefone = '" + pModelEmpresa.getTelefone() + "'," + "cnpj = '" + pModelEmpresa.getCnpj() + "'" + " WHERE " + "codigo = '" + pModelEmpresa.getCodigo() + "'" + ";");
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
    public boolean excluirEmpresaDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM empresa  WHERE codigo = '" + pCodigo + "'" + ";");
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

