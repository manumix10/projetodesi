/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOCliente;
import java.util.ArrayList;
import model.ModelCliente;
import relatorios.DAORelatorios;

public class ControllerCliente {
    private DAOCliente daoCliente = new DAOCliente();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    public ModelCliente getClienteController(int pCodigo) {
        return this.daoCliente.getClienteDAO(pCodigo);
    }

    public ModelCliente getClienteController(String pNome) {
        return this.daoCliente.getClienteDAO(pNome);
    }

    public ArrayList<ModelCliente> getListaClienteController() {
        return this.daoCliente.getListaClienteDAO();
    }

    public boolean atualizarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    public boolean excluirClienteController(int pCodigo) {
        return this.daoCliente.excluirClienteDAO(pCodigo);
    }

    public boolean gerarRelatorioCliente() {
        return this.dAORelatorios.gerarRelatorioCliente();
    }

    public boolean gerarRelatorioClienteIndividual(int pCodigoCliente) {
        return this.dAORelatorios.gerarRelatorioClienteIndividual(pCodigoCliente);
    }

    public boolean gerarRelatorioCompraEstoque(int pCodigoCliente) {
        return this.dAORelatorios.gerarRelatorioCompraEstoque(pCodigoCliente);
    }
}

