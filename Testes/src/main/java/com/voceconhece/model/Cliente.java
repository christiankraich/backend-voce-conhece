package com.voceconhece.model;

public class Cliente extends Usuario {

    private String cpf;
    private String geolocalizacao;

    public Cliente(String id, String nome, String email, String senha, String cpf, String geolocalizacao) {
        super(id, nome, email, senha);
        this.cpf = cpf;
        this.geolocalizacao = geolocalizacao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

}
