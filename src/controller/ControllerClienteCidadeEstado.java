/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOClienteCidadeEstado;
import java.util.ArrayList;
import model.ModelClienteCidadeEstado;

public class ControllerClienteCidadeEstado {
    private DAOClienteCidadeEstado dAOClienteCidadeEstado = new DAOClienteCidadeEstado();

    public ArrayList<ModelClienteCidadeEstado> getListaClienteCidadeEstadoController() {
        return this.dAOClienteCidadeEstado.getListaClienteCidadeEstadoDAO();
    }
}

