package com.voceconhece.service;

import com.voceconhece.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RedefinirSenhaService {

    private List<Usuario> usuarios;

    public RedefinirSenhaService() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("1","João","teste@valido.com","1@Abc"));
    }

    public String verificarEmail(String email) {
        // UT04_RF021.1
        if (email == null || email.isEmpty())  return "Erro: digite o e-mail";
        // UT03_RF021.1
        if (!email.contains("@")) return "Erro: e-mail inválido";
        // UT01_RF021.1
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return "Sucesso: e-mail cadastrado";
            }
        }
        // UT02_RF021.1
        return "Erro: e-mail não cadastrado";
    }

    public Usuario getUsuario(String email) {
        Usuario userEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                userEncontrado = u;
                break;
            }
        }
        return userEncontrado;
    }

    public String redefinirSenha(String email, String novaSenha) {
        // UT04_RF021.2
        if (novaSenha == null || novaSenha.isEmpty()) {
            return "Erro: insira uma senha";
        }

        Usuario userEncontrado = getUsuario(email);

        if (userEncontrado == null) {
            return "Erro: usuário não encontrado";
        }
        // UT03_RF021.2
        if (novaSenha.equals(userEncontrado.getSenha())) {
            return "Erro: senha nova é igual a senha atual";
        }
        // UT02_RF021.2
        if (!isSenhaForte(novaSenha)) {
            return "Erro: senha fraca";
        }
        // UT01_RF021.2
        userEncontrado.setSenha(novaSenha);
        return "Sucesso: nova senha definida";
    }

    private boolean isSenhaForte(String senha) {
        return senha.length() >= 5
                && senha.matches(".*[A-Z].*")
                && senha.matches(".*[a-z].*")
                && senha.matches(".*[0-9@#?!].*");
    }

}
