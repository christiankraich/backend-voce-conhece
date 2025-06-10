import com.voceconhece.service.AutenticadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutenticadorServiceTest {

    private AutenticadorService autenticador;

    @BeforeEach
    void setUp() {
        autenticador = new AutenticadorService();
    }

    @Test // UT01_RF001
    void autenticarCliente() {
        assertEquals("cliente", autenticador.autenticarUsuario("cliente@test.com", "123456"));
    }

    @Test // UT02_RF001
    void autenticarDonoDeNegocio() {
        assertEquals("dono de negócio", autenticador.autenticarUsuario("dono@test.com", "123456"));
    }

    @Test // UT03_RF001
    void autenticarBeneficente() {
        assertEquals("beneficente", autenticador.autenticarUsuario("beneficente@test.com", "123456"));
    }

    @Test // UT04_RF001
    void rejeitarSenhaClienteIncorreta() {
        assertEquals("Erro: senha inválida", autenticador.autenticarUsuario("cliente@test.com", "1234"));
    }

    @Test // UT04_RF001
    void rejeitarSenhaDonoIncorreta() {
        assertEquals("Erro: senha inválida", autenticador.autenticarUsuario("dono@test.com", "1234"));
    }

    @Test // UT04_RF001
    void rejeitarSenhaBeneficenteIncorreta() {
        assertEquals("Erro: senha inválida", autenticador.autenticarUsuario("beneficente@test.com", "1234"));
    }

    @Test // UT05_RF001
    void rejeitarUsuarioInexistente() {
        assertEquals("Erro: usuário não encontrado", autenticador.autenticarUsuario("desconhecido@x.com", "1234"));
    }

    @Test //UT06_RF001
    void rejeitarEmailSenhaVazios() {
        assertEquals("Erro: campos em branco", autenticador.autenticarUsuario("", ""));
    }

    @Test // UT07_RF001
    void rejeitarEmailVazio() {
        assertEquals("Erro: campo e-mail obrigatório", autenticador.autenticarUsuario("", "123456"));
    }

    @Test // UT08_RF001
    void rejeitarSenhaVazia() {
        assertEquals("Erro: campo senha obrigatório", autenticador.autenticarUsuario("cliente@teste.com", ""));
    }

    @Test // UT09_RF001
    void rejeitarEmailInvalido() {
        assertEquals("Erro: e-mail inválido", autenticador.autenticarUsuario("clienteteste.com", "1234"));
    }
}
