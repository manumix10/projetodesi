/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOEstado;
import java.util.ArrayList;
import model.ModelEstado;

public class ControllerEstado {
    private DAOEstado daoEstado = new DAOEstado();

    public int salvarEstadoController(ModelEstado pModelEstado) {
        return this.daoEstado.salvarEstadoDAO(pModelEstado);
    }

    public ModelEstado getEstadoController(int pCodigo) {
        return this.daoEstado.getEstadoDAO(pCodigo);
    }

    public ModelEstado getEstadoController(String pNome) {
        return this.daoEstado.getEstadoDAO(pNome);
    }

    public ModelEstado getEstadoUFController(String pUF) {
        return this.daoEstado.getEstadoUFDAO(pUF);
    }

    public ArrayList<ModelEstado> getListaEstadoController() {
        return this.daoEstado.getListaEstadoDAO();
    }

    public boolean atualizarEstadoController(ModelEstado pModelEstado) {
        return this.daoEstado.atualizarEstadoDAO(pModelEstado);
    }

    public boolean excluirEstadoController(int pCodigo) {
        return this.daoEstado.excluirEstadoDAO(pCodigo);
    }
}

