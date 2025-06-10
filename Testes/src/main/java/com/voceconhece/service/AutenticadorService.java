package com.voceconhece.service;

public class AutenticadorService {

    public String autenticarUsuario(String email, String senha) {
        // UT06_RF001
        if ((email == null || email.isEmpty()) && (senha == null || senha.isEmpty())) return "Erro: campos em branco";
        // UT07_RF001
        if (email == null || email.isEmpty()) return "Erro: campo e-mail obrigatório";
        // UT08_RF001
        if (senha == null || senha.isEmpty()) return "Erro: campo senha obrigatório";
        // UT09_RF001
        if (!email.contains("@")) return "Erro: e-mail inválido";

        // usuários cadastrados
        // UT01_RF001
        if (email.equals("cliente@test.com")) {
            return senha.equals("123456") ? "cliente" : "Erro: senha inválida"; // Erro = UT04_RF001
        }
        // UT02_RF001
        if (email.equals("dono@test.com")) {
            return senha.equals("123456") ? "dono de negócio" : "Erro: senha inválida"; // Erro = UT04_RF001
        }
        // UT03_RF001
        if (email.equals("beneficente@test.com")) {
            return senha.equals("123456") ? "beneficente" : "Erro: senha inválida"; // Erro = UT04_RF001
        }
        // UT05_RF001
        return "Erro: usuário não encontrado";
    }
}
