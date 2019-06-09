/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelCaixa {
    private int codigo;
    private float dinheiro;
    private float cheque;
    private float cartao;
    private float vale;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setDinheiro(float pDinheiro) {
        this.dinheiro = pDinheiro;
    }

    public float getDinheiro() {
        return this.dinheiro;
    }

    public void setCheque(float pCheque) {
        this.cheque = pCheque;
    }

    public float getCheque() {
        return this.cheque;
    }

    public void setCartao(float pCartao) {
        this.cartao = pCartao;
    }

    public float getCartao() {
        return this.cartao;
    }

    public void setVale(float pVale) {
        this.vale = pVale;
    }

    public float getVale() {
        return this.vale;
    }

    public String toString() {
        return "ModelCaixa {::codigo = " + this.codigo + "::dinheiro = " + this.dinheiro + "::cheque = " + this.cheque + "::cartao = " + this.cartao + "::vale = " + this.vale + "}";
    }
}

