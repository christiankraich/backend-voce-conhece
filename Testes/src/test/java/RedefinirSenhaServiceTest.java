import com.voceconhece.service.RedefinirSenhaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedefinirSenhaServiceTest {

    private RedefinirSenhaService service;

    @BeforeEach
    public void setUp() {
        service = new RedefinirSenhaService();
    }

    @Test // UT01_RF021.1
    public void emailExistente() {
        assertEquals("Sucesso: e-mail cadastrado", service.verificarEmail("teste@valido.com"));
    }

    @Test // UT02_RF021.1
    public void rejeitarEmailInexistente() {
        assertEquals("Erro: e-mail não cadastrado", service.verificarEmail("teste@inexistente.com"));
    }

    @Test // UT03_RF021.1
    public void rejeitarEmailInvalido() {
        assertEquals("Erro: e-mail inválido", service.verificarEmail("teste.teste.com"));
    }

    @Test // UT04_RF021.1
    public void rejeitarEmailVazio() {
        assertEquals("Erro: digite o e-mail", service.verificarEmail(""));
    }

    @Test // UT01_RF021.2
    public void aceitarNovaSenha() {
        assertEquals("Sucesso: nova senha definida", service.redefinirSenha("teste@valido.com", "2@Abc"));
    }

    @Test // UT02_RF021.2
    public void rejeitarSenhaFraca() {
        assertEquals("Erro: senha fraca", service.redefinirSenha("teste@valido.com", "1234"));
    }

    @Test // UT03_RF021.2
    public void rejeitarMesmaSenha() {
        assertEquals("Erro: senha nova é igual a senha atual", service.redefinirSenha("teste@valido.com", "1@Abc"));
    }

    @Test // UT04_RF021.2
    public void rejeitarSenhaVazia() {
        assertEquals("Erro: insira uma senha", service.redefinirSenha("teste@valido.com", ""));
    }

}
