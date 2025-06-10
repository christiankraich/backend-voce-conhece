package com.voceconhece.service;

import com.voceconhece.model.OrganizacaoBeneficente;

import java.util.ArrayList;
import java.util.List;

public class CadastroBeneficenteService {

    private List<OrganizacaoBeneficente> beneficentes;

    public CadastroBeneficenteService() {
        beneficentes = new ArrayList<>();
        beneficentes.add(new OrganizacaoBeneficente("1","WWF","01234567890123","Não-governamental","Meio ambiente"));
    }

    public String cadastroBeneficente(OrganizacaoBeneficente beneficente) {
        // TDD08
        if (beneficente == null) {
            return "Erro: dados obrigatórios ausentes";
        }
        // TDD02
        if (beneficente.getNome() == null || beneficente.getNome().isEmpty()) {
            return "Erro: nome da organização é obrigatório";
        }
        // TDD03
        if (beneficente.getCnpj() == null || beneficente.getCnpj().isEmpty()) {
            return "Erro: CNPJ obrigatório";
        }
        // TDD04
        if (!beneficente.getCnpj().matches("^\\d{14}$")) {
            return "Erro: CNPJ inválido";
        }
        // TDD05
        for (OrganizacaoBeneficente ob : beneficentes) {
            if (ob.getCnpj().equals(beneficente.getCnpj())) {
                return "Erro: CNPJ já está cadastrado";
            }
        }
        // TDD06
        if (beneficente.getTipoRegistro() == null || beneficente.getTipoRegistro().isEmpty()) {
            return "Erro: insira o tipo de organização";
        }
        // TDD07
        if (beneficente.getAtividade() == null || beneficente.getAtividade().isEmpty()) {
            return "Erro: atividade da organização obrigatória";
        }
        // TDD01
        return "Sucesso: cadastro completo, a análise será feita em 24h";
    }

}
