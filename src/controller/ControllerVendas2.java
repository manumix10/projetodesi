/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOVendas;
import DAO.DAOVendas2;
import java.util.ArrayList;
import model.ModelVendas2;
import relatorios.DAORelatorios;

public class ControllerVendas2 {
    private DAOVendas2 daoVendas = new DAOVendas2();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarVendasController(ModelVendas2 pModelVendas2) {
        return this.daoVendas.salvarVendasDAO(pModelVendas2);
    }

    public ModelVendas2 getVendasController(int pCodigo) {
        return this.daoVendas.getVendasDAO(pCodigo);
    }

    public ArrayList<ModelVendas2> getListaPedidosController() {
        return this.daoVendas.getListaPedidosDAO();
    }

    public ArrayList<ModelVendas2> getListaOrcamentoController() {
        return this.daoVendas.getListaOrcamentoDAO();
    }

    public ArrayList<ModelVendas2> getListaVendasController(int pCodigo) {
        return this.daoVendas.getListaVendasDAO(pCodigo);
    }

    public boolean atualizarVendasController(ModelVendas2 pModelVendas2) {
        return this.daoVendas.atualizarVendasDAO(pModelVendas2);
    }

    public boolean excluirVendasController(int pCodigo) {
        return this.daoVendas.excluirVendasDAO(pCodigo);
    }

    public boolean salvarVendasProdutosController(ModelVendas2 modelVendas2) {
        return this.daoVendas.salvarProdutosVendasDAO(modelVendas2);
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

    public ArrayList<ModelVendas2> getListaPedidosController(ModelVendas2 pMdelVendas2) {
        return this.daoVendas.getListaPedidosDAO(pMdelVendas2);
    }

    public boolean desaprovarPedidoController(int pCodigo) {
        return this.daoVendas.desaprovarPedidoDAO(pCodigo);
    }
}

