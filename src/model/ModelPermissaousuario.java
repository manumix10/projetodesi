/*
 * Decompiled with CFR 0_122.
 */
package model;

import java.util.ArrayList;

public class ModelPermissaousuario {
    private int codigo;
    private int codigo_usuario;
    private String permissao;
    private ArrayList<ModelPermissaousuario> listaModelPermissaousuarios;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo_usuario(int pCodigo_usuario) {
        this.codigo_usuario = pCodigo_usuario;
    }

    public int getCodigo_usuario() {
        return this.codigo_usuario;
    }

    public void setPermissao(String pPermissao) {
        this.permissao = pPermissao;
    }

    public String getPermissao() {
        return this.permissao;
    }

    public String toString() {
        return "ModelPermissaousuario {::codigo = " + this.codigo + "::codigo_usuario = " + this.codigo_usuario + "::permissao = " + this.permissao + "}";
    }

    public ArrayList<ModelPermissaousuario> getListaModelPermissaousuarios() {
        return this.listaModelPermissaousuarios;
    }

    public void setListaModelPermissaousuarios(ArrayList<ModelPermissaousuario> listaModelPermissaousuarios) {
        this.listaModelPermissaousuarios = listaModelPermissaousuarios;
    }
}

