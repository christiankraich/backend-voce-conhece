package com.voceconhece.service;

import com.voceconhece.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CadastroClienteService {

    private List<Cliente> clientes;

    public CadastroClienteService() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente("1","João","joao@teste.com","123456","01234567890","Joinville"));
    }

    public String cadastrarCliente(Cliente cliente) {
        // UT11_RF002
        if (cliente == null) {
            return "Erro: dados obrigatórios ausentes";
        }
        // UT02_RF002
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return "Erro: nome de usuário é obrigatório";
        }
        // UT03_RF002
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            return "Erro: e-mail é obrigatório";
        }
        // UT04_RF002
        if (!cliente.getEmail().contains("@")) return "Erro: e-mail inválido";
        // UT05_RF002
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            return "Erro: CPF é obrigatório";
        }
        // UT06_RF002
        if (!cliente.getCpf().matches("^\\d{11}$")) {
            return "Erro: CPF inválido";
        }
        // UT07_RF002
        if (cliente.getSenha() == null || cliente.getSenha().isEmpty()) {
            return "Erro: senha é obrigatória";
        }
        // UT08_RF002
        if (cliente.getGeolocalizacao() == null || cliente.getGeolocalizacao().isEmpty()) {
            return "Erro: geolocalização é obrigatória";
        }
        // UT09_RF002
        for (Cliente c : clientes) {
            if (c.getEmail().equals(cliente.getEmail())) {
                return "Erro: e-mail já está cadastrado";
            }
        }
        // UT10_RF002
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                return "Erro: CPF já está cadastrado";
            }
        }
        // UT01_RF002
        return "Sucesso: cadastro realizado";
    }

}
