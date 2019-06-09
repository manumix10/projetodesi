/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOContaPagar;
import java.util.ArrayList;
import java.util.Date;
import model.ModelContaPagar;
import relatorios.DAORelatorios;

public class ControllerContaPagar {
    private DAOContaPagar daoContaPagar = new DAOContaPagar();
    private DAORelatorios daoRelatorios = new DAORelatorios();

    public int salvarContaPagarController(ModelContaPagar pModelContaPagar) {
        return this.daoContaPagar.salvarContaPagarDAO(pModelContaPagar);
    }

    public ModelContaPagar getContaPagarController(int pCodigo) {
        return this.daoContaPagar.getContaPagarDAO(pCodigo);
    }

    public ArrayList<ModelContaPagar> getListaContaPagarController() {
        return this.daoContaPagar.getListaContaPagarDAO();
    }

    public ArrayList<ModelContaPagar> getListaContaPagarController(int pStatus) {
        return this.daoContaPagar.getListaContaPagarDAO(pStatus);
    }

    public ArrayList<ModelContaPagar> getListaContasController(int pStatus) {
        return this.daoContaPagar.getListaContasDAO(pStatus);
    }

    public boolean atualizarContaPagarController(ModelContaPagar pModelContaPagar) {
        return this.daoContaPagar.atualizarContaPagarDAO(pModelContaPagar);
    }

    public boolean pagarContaPagarController(ModelContaPagar pModelConta) {
        return this.daoContaPagar.pagarContaPagarDAO(pModelConta);
    }

    public boolean excluirContaPagarController(int pCodigo) {
        return this.daoContaPagar.excluirContaPagarDAO(pCodigo);
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaPagar(pCodigo);
    }

    public ArrayList<ModelContaPagar> getListaContasController(ModelContaPagar pModelContaPagar) {
        return this.daoContaPagar.getListaContasDAO(pModelContaPagar);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    public boolean gerarRelatorioContasPagarFornecedor(int pCodigoFornecedor, int pStatus, java.sql.Date pDataInicial, java.sql.Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarFornecedor(pCodigoFornecedor, pStatus, pDataInicial, pDataFinal);
    }

    public boolean gerarRelatorioContasPagarTODAS(int pStatus, java.sql.Date pDataInicial, java.sql.Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarTODAS(pStatus, pDataInicial, pDataFinal);
    }
    public boolean gerarRelatorioFornecedorTODAS(int pStatus, java.sql.Date pDataInicial, java.sql.Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarTODAS(pStatus, pDataInicial, pDataFinal);
    }
}

