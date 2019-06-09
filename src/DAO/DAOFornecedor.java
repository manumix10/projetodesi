/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelFornecedor;

public class DAOFornecedor
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO fornecedores (nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone) VALUES ('" + pModelFornecedor.getNome() + "'," + "'" + pModelFornecedor.getEndereco() + "'," + "'" + pModelFornecedor.getBairro() + "'," + "'" + pModelFornecedor.getCodCidade() + "'," + "'" + pModelFornecedor.getCodEstado() + "'," + "'" + pModelFornecedor.getCep() + "'," + "'" + pModelFornecedor.getTelefone() + "'" + ") RETURNING codigo;");
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
    public ModelFornecedor getFornecedorDAO(int pCodigo) {
        ModelFornecedor modelFornecedor;
        modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone FROM fornecedores WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelFornecedor getFornecedorProdutoDAO(int pCodigoProduto) {
        ModelFornecedor modelFornecedor;
        modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL("SELECT  fornecedores.codigo, fornecedores.nome, fornecedores.endereco, fornecedores.bairro, fornecedores.cod_cidade, fornecedores.cod_estado, fornecedores.cep, fornecedores.telefone FROM fornecedores INNER JOIN produtos ON produtos.fornecedores_codigo = fornecedores.codigo WHERE produtos.codigo =  '" + pCodigoProduto + "'" + ";");
            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelFornecedor getFornecedorDAO(String pNome) {
        ModelFornecedor modelFornecedor;
        modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone FROM fornecedores WHERE nome = '" + pNome + "'" + ";");
            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelFornecedor> getListaFornecedorDAO() {
        ArrayList<ModelFornecedor> listamodelFornecedor;
        listamodelFornecedor = new ArrayList<ModelFornecedor>();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone FROM fornecedores;");
            while (this.getResultSet().next()) {
                modelFornecedor = new ModelFornecedor();
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
                listamodelFornecedor.add(modelFornecedor);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelFornecedor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE fornecedores SET codigo = '" + pModelFornecedor.getCodigo() + "'," + "nome = '" + pModelFornecedor.getNome() + "'," + "endereco = '" + pModelFornecedor.getEndereco() + "'," + "bairro = '" + pModelFornecedor.getBairro() + "'," + "cod_cidade = '" + pModelFornecedor.getCodCidade() + "'," + "cod_estado = '" + pModelFornecedor.getCodEstado() + "'," + "cep = '" + pModelFornecedor.getCep() + "'," + "telefone = '" + pModelFornecedor.getTelefone() + "'" + " WHERE " + "codigo = '" + pModelFornecedor.getCodigo() + "'" + ";");
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
    public boolean excluirFornecedorDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM fornecedores  WHERE codigo = '" + pCodigo + "'" + ";");
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

