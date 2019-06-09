/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelCidade {
    private int codigo;
    private String nome;
    private int fk_cod_estado;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setFk_cod_estado(int pFk_cod_estado) {
        this.fk_cod_estado = pFk_cod_estado;
    }

    public int getFk_cod_estado() {
        return this.fk_cod_estado;
    }

    public String toString() {
        return "ModelCidade {::codigo = " + this.codigo + "::nome = " + this.nome + "::fk_cod_estado = " + this.fk_cod_estado + "}";
    }
}

