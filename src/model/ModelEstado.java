/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelEstado {
    private int codigo;
    private String uf;
    private String nome;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setUf(String pUf) {
        this.uf = pUf;
    }

    public String getUf() {
        return this.uf;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return "ModelEstado {::codigo = " + this.codigo + "::uf = " + this.uf + "::nome = " + this.nome + "}";
    }
}

