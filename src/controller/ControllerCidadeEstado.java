/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOCidadeEstado;
import java.util.ArrayList;
import model.ModelCidadeEstado;

public class ControllerCidadeEstado {
    private DAOCidadeEstado daoCidadeEstado = new DAOCidadeEstado();

    public ArrayList<ModelCidadeEstado> getListaCidadeEstadoController() {
        return this.daoCidadeEstado.getListaCidadeEstadoDAO();
    }
}

