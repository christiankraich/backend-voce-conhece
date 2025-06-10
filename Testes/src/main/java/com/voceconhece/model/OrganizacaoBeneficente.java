package com.voceconhece.model;

public class OrganizacaoBeneficente {

    private String id;
    private String nome;
    private String cnpj;
    private String tipoRegistro;
    private String atividade;

    public OrganizacaoBeneficente(String id, String nome, String cnpj, String tipoRegistro, String atividade) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.tipoRegistro = tipoRegistro;
        this.atividade = atividade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public String getAtividade() {
        return atividade;
    }
}
