/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOEmpresaCidadeEstado;
import java.util.ArrayList;
import model.ModelEmpresaCidadeEstado;

public class ControllerEmpresaCidadeEstado {
    private DAOEmpresaCidadeEstado daoEmpresaCidadeEstado = new DAOEmpresaCidadeEstado();

    public ModelEmpresaCidadeEstado getEmpresaCidadeEstadoController(int pCodigo) {
        return this.daoEmpresaCidadeEstado.getEmpresaCidadeEstadoDAO(pCodigo);
    }

    public ArrayList<ModelEmpresaCidadeEstado> getListaEmpresaCidadeEstadoController() {
        return this.daoEmpresaCidadeEstado.getListaEmpresaCidadeEstadoDAO();
    }
}

