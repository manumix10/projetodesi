/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelCliente {
    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private String cep;
    private String telefone;
    private String telefone2;
    private String cpfCNPJ;
    private String observacao;

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

    public void setEndereco(String pEndereco) {
        this.endereco = pEndereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setBairro(String pBairro) {
        this.bairro = pBairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setCodCidade(int pCidade) {
        this.codCidade = pCidade;
    }

    public int getCodCidade() {
        return this.codCidade;
    }

    public void setCodEstado(int pUf) {
        this.codEstado = pUf;
    }

    public int getCodEstado() {
        return this.codEstado;
    }

    public void setCep(String pCep) {
        this.cep = pCep;
    }

    public String getCep() {
        return this.cep;
    }

    public void setTelefone(String pTelefone) {
        this.telefone = pTelefone;
    }

    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone2(String pTelefone2) {
        this.telefone2 = pTelefone2;
    }
    
    public String getTelefone2() {
        return this.telefone2;
    }

    public String toString() {
        return "ModelCliente {::codigo = " + this.codigo + "::nome = " + this.nome + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::cidade = " + this.codCidade + "::uf = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone + "::telefone2 = " + this.telefone2 + "}";
    }

    public String getCpfCNPJ() {
        return this.cpfCNPJ;
    }

    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

