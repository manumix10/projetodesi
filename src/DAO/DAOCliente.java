/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelCliente;

public class DAOCliente
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO clientes (nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cpf_cnpj,observacao,telefone2 ) VALUES ('" + pModelCliente.getNome() + "'," + "'" + pModelCliente.getEndereco() + "'," + "'" + pModelCliente.getBairro() + "'," + "'" + pModelCliente.getCodCidade() + "'," + "'" + pModelCliente.getCodEstado() + "'," + "'" + pModelCliente.getCep() + "'," + "'" + pModelCliente.getTelefone() + "'," + "'" + pModelCliente.getCpfCNPJ() + "'," + "'" + pModelCliente.getObservacao() + "'," + "'" + pModelCliente.getTelefone2() + "'" + ") RETURNING codigo;");
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
    public ModelCliente getClienteDAO(int pCodigo) {
        ModelCliente modelCliente;
        modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cpf_cnpj,observacao,telefone2  FROM clientes WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setEndereco(this.getResultSet().getString(3));
                modelCliente.setBairro(this.getResultSet().getString(4));
                modelCliente.setCodCidade(this.getResultSet().getInt(5));
                modelCliente.setCodEstado(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setTelefone2(this.getResultSet().getString(11));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelCliente getClienteDAO(String pNome) {
        ModelCliente modelCliente;
        modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cpf_cnpj,observacao,telefone2  FROM clientes WHERE nome = '" + pNome + "'" + ";");
            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setEndereco(this.getResultSet().getString(3));
                modelCliente.setBairro(this.getResultSet().getString(4));
                modelCliente.setCodCidade(this.getResultSet().getInt(5));
                modelCliente.setCodEstado(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setTelefone2(this.getResultSet().getString(11));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelCliente> getListaClienteDAO() {
        ArrayList<ModelCliente> listamodelCliente;
        listamodelCliente = new ArrayList<ModelCliente>();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,nome,endereco,bairro,cod_cidade,cod_estado,cep,telefone,cpf_cnpj,observacao,telefone2  FROM clientes;");
            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setEndereco(this.getResultSet().getString(3));
                modelCliente.setBairro(this.getResultSet().getString(4));
                modelCliente.setCodCidade(this.getResultSet().getInt(5));
                modelCliente.setCodEstado(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setTelefone2(this.getResultSet().getString(11));
                listamodelCliente.add(modelCliente);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE clientes SET codigo = '" + pModelCliente.getCodigo() + "'," + "nome = '" + pModelCliente.getNome() + "'," + "endereco = '" + pModelCliente.getEndereco() + "'," + "bairro = '" + pModelCliente.getBairro() + "'," + "cod_cidade = '" + pModelCliente.getCodCidade() + "'," + "cod_estado = '" + pModelCliente.getCodEstado() + "'," + "cep = '" + pModelCliente.getCep() + "'," + "telefone = '" + pModelCliente.getTelefone() + "'," + "cpf_cnpj = '" + pModelCliente.getCpfCNPJ() + "'," + "observacao = '" + pModelCliente.getObservacao() + "'," + "telefone2 = '" + pModelCliente.getTelefone2() + "'" + " WHERE " + "codigo = '" + pModelCliente.getCodigo() + "'" + ";");
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
    public boolean excluirClienteDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM clientes  WHERE codigo = '" + pCodigo + "'" + ";");
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

