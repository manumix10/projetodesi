/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOVendas;
import java.util.ArrayList;
import model.ModelVendas;
import relatorios.DAORelatorios;

public class ControllerVendas {
    private DAOVendas daoVendas = new DAOVendas();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    public ModelVendas getVendasController(int pCodigo) {
        return this.daoVendas.getVendasDAO(pCodigo);
    }

    public ArrayList<ModelVendas> getListaPedidosController() {
        return this.daoVendas.getListaPedidosDAO();
    }

    public ArrayList<ModelVendas> getListaOrcamentoController() {
        return this.daoVendas.getListaOrcamentoDAO();
    }

    public ArrayList<ModelVendas> getListaVendasController(int pCodigo) {
        return this.daoVendas.getListaVendasDAO(pCodigo);
    }

    public boolean atualizarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    public boolean excluirVendasController(int pCodigo) {
        return this.daoVendas.excluirVendasDAO(pCodigo);
    }

    public boolean salvarVendasProdutosController(ModelVendas modelVendas) {
        return this.daoVendas.salvarProdutosVendasDAO(modelVendas);
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVenda(pCodigo);
    }
    
    public boolean gerarRelatorioVenda2(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVenda2(pCodigo);
    }

    public boolean gerarRelatorioOrcamento(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioOrcamento(pCodigo);
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioPDV(pCodigo);
    }

    public boolean gerarRelatorioVendasCliente(java.sql.Date pDataInicial, java.sql.Date dataFinal, int codigoCliente) {
        return this.dAORelatorios.gerarRelatorioVendasCliente(pDataInicial, dataFinal, codigoCliente);
    }

    public boolean gerarRelatorioVendaTodosCliente(java.sql.Date dataInicial, java.sql.Date dataFinal) {
        return this.dAORelatorios.gerarRelatorioVendaTodosCliente(dataInicial, dataFinal);
    }

    public boolean excluirProdutoVendasController(int pCodigo) {
        return this.daoVendas.excluirProdutoVendasDAO(pCodigo);
    }

    public ArrayList<ModelVendas> getListaPedidosController(ModelVendas pMdelVendas) {
        return this.daoVendas.getListaPedidosDAO(pMdelVendas);
    }

    public boolean desaprovarPedidoController(int pCodigo) {
        return this.daoVendas.desaprovarPedidoDAO(pCodigo);
    }
}

