/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOContaReceber;
import java.util.ArrayList;
import java.util.Date;
import model.ModelContaReceber;
import relatorios.DAORelatorios;

public class ControllerContaReceber {
    private DAOContaReceber daoContaReceber = new DAOContaReceber();
    private DAORelatorios daoRelatorios = new DAORelatorios();

    public int salvarContaReceberController(ModelContaReceber pModelContaCorrente) {
        return this.daoContaReceber.salvarContaReceberDAO(pModelContaCorrente);
    }

    public ModelContaReceber getContaPagarController(int pCodigo) {
        return this.daoContaReceber.getContaPagarDAO(pCodigo);
    }

    public ArrayList<ModelContaReceber> getListaContaPagarController() {
        return this.daoContaReceber.getListaContaPagarDAO();
    }

    public ArrayList<ModelContaReceber> getListaContaPagarController(int pStatus) {
        return this.daoContaReceber.getListaContaPagarDAO(pStatus);
    }

    public ArrayList<ModelContaReceber> getListaContaReceberController(int pStatus) {
        return this.daoContaReceber.getListaContaReceberDAO(pStatus);
    }

    public ArrayList<ModelContaReceber> getListaContasController(int pStatus) {
        return this.daoContaReceber.getListaContasDAO(pStatus);
    }

    public boolean atualizarContaReceberController(ModelContaReceber pModelContaReceber) {
        return this.daoContaReceber.atualizarContaReceberDAO(pModelContaReceber);
    }

    public boolean excluirContaReceberController(int pCodigo) {
        return this.daoContaReceber.excluirContaReceberDAO(pCodigo);
    }

    public boolean receberContaReceberController(ModelContaReceber pModelConta) {
        return this.daoContaReceber.receberContaReceberDAO(pModelConta);
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaReceber(pCodigo);
    }

    public ArrayList<ModelContaReceber> getListaContasController(ModelContaReceber pModelConta) {
        return this.daoContaReceber.getListaContasDAO(pModelConta);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    public boolean gerarRelatorioContasReceberCliente(int pCodigoCliente, int pStatus, java.sql.Date pDataInicial, java.sql.Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberCliente(pCodigoCliente, pStatus, pDataInicial, pDataFinal);
    }

    public boolean gerarRelatorioContasReceberTODAS(int pStatus, java.sql.Date pDataInicial, java.sql.Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberTODAS(pStatus, pDataInicial, pDataFinal);
    }
}

