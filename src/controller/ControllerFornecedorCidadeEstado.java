/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOFornecedorCidadeEstado;
import java.util.ArrayList;
import model.ModelFornecedorCidadeEstado;

public class ControllerFornecedorCidadeEstado {
    private DAOFornecedorCidadeEstado dAOFornecedorCidadeEstado = new DAOFornecedorCidadeEstado();

    public ArrayList<ModelFornecedorCidadeEstado> getlistaFornecedorCidadeEstados() {
        return this.dAOFornecedorCidadeEstado.getListaFornecedorCidadeEstadoDAO();
    }
}

