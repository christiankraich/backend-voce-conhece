//RF041 - "O sistema deve permitir o cadastro de organizações beneficentes, solicitando nome, CNPJ,
//registro governamental/não-governamental e atividade."

//Test-Driven Development

import com.voceconhece.model.OrganizacaoBeneficente;
import com.voceconhece.service.CadastroBeneficenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroBeneficenteServiceTest {

    private CadastroBeneficenteService service;

    @BeforeEach
    void setUp() {
        service = new CadastroBeneficenteService();
    }
    // TDD01 - cadastro completo
    @Test
    void permitirCadastro() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("2","Cruz Vermelha",
                "11111111111111", "Governamental","Saúde");
        assertEquals("Sucesso: cadastro completo, a análise será feita em 24h", service.cadastroBeneficente(beneficente));
    }

    // TDD02 - cadastro faltando nome
    @Test
    void rejeitarCadastroSemNome() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "","22222222222222",
                "Governamental","Saúde");
        assertEquals("Erro: nome da organização é obrigatório", service.cadastroBeneficente(beneficente));
    }

    // TDD03 - cadastro faltando CNPJ
    @Test
    void rejeitarCadastroSemCnpj() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "Médico Sem Fronteiras","",
                "Governamental","Saúde");
        assertEquals("Erro: CNPJ obrigatório", service.cadastroBeneficente(beneficente));
    }

    // TDD04 - cadastro CNPJ inválido
    @Test
    void rejeitarCadastroComCnpjInvalido() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "Médico Sem Fronteiras","213",
                "Governamental","Saúde");
        assertEquals("Erro: CNPJ inválido", service.cadastroBeneficente(beneficente));
    }

    // TDD05 - cadastro CNPJ duplicado
    @Test
    void rejeitarCadastroCnpjDuplicado() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "Médico Sem Fronteiras",
                "01234567890123","Governamental","Saúde");
        assertEquals("Erro: CNPJ já está cadastrado", service.cadastroBeneficente(beneficente));
    }

    // TDD06 - cadastro sem registro da organização
    @Test
    void rejeitarCadastroOrganizacaoSemRegistro() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "Médico Sem Fronteiras",
                "22222222222222","","Saúde");
        assertEquals("Erro: insira o tipo de organização", service.cadastroBeneficente(beneficente));
    }

    // TDD07 - cadastro faltando atividade
    @Test
    void rejeitarCadastroSemAtividade() {
        OrganizacaoBeneficente beneficente = new OrganizacaoBeneficente("3", "Médico Sem Fronteiras",
                "22222222222222","Governamental","");
        assertEquals("Erro: atividade da organização obrigatória", service.cadastroBeneficente(beneficente));
    }

    // TDD08 - cadastro com todos os campos em branco
    @Test
    void rejeitarCadastroBeneficenteNulo() {
        assertEquals("Erro: dados obrigatórios ausentes", service.cadastroBeneficente(null));
    }
}
