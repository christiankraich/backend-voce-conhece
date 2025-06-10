import com.voceconhece.model.Cliente;
import com.voceconhece.service.CadastroClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroClienteServiceTest {

    private CadastroClienteService service;

    @BeforeEach
    void setUp() {
        service = new CadastroClienteService();
    }

    @Test // UT01_RF002
    void devePermitirCadastro() {
        Cliente cliente = new Cliente("2","Maria","maria@teste.com","Senha@123","98765432100","Floripa");
        assertEquals("Sucesso: cadastro realizado", service.cadastrarCliente(cliente));
    }

    @Test // UT02_RF002
    void rejeitaCadastroSemNome() {
        Cliente cliente = new Cliente("3","", "teste@email.com", "Senha@123","00000000000","Palhoça");
        assertEquals("Erro: nome de usuário é obrigatório", service.cadastrarCliente(cliente));
    }

    @Test // UT03_RF002
    void rejeitarCadastroSemEmail() {
        Cliente cliente = new Cliente("3","Mario", "", "Senha@123","00000000000","Palhoça");
        assertEquals("Erro: e-mail é obrigatório", service.cadastrarCliente(cliente));
    }

    @Test // UT04_RF002
    void rejeitarCadastroEmailInvalido() {
        Cliente cliente = new Cliente("3","Mario", "teste.teste.com", "Senha@123","00000000000","Palhoça");
        assertEquals("Erro: e-mail inválido", service.cadastrarCliente(cliente));
    }

    @Test // UT05_RF002
    void rejeitarCadastroSemCpf() {
        Cliente cliente = new Cliente("3","Mario", "mario@teste.com", "Senha@123","","Palhoça");
        assertEquals("Erro: CPF é obrigatório", service.cadastrarCliente(cliente));
    }

    @Test // UT06_RF002
    void rejeitarCadastroCpfInvalido() {
        Cliente cliente = new Cliente("3","Mario", "mario@teste.com", "Senha@123","123","Palhoça");
        assertEquals("Erro: CPF inválido", service.cadastrarCliente(cliente));
    }

    @Test // UT07_RF002
    void rejeitarCadastroSemSenha() {
        Cliente cliente = new Cliente("3","Mario", "mario@teste.com", "","00000000000","Palhoça");
        assertEquals("Erro: senha é obrigatória", service.cadastrarCliente(cliente));
    }

    @Test // UT08_RF002
    void rejeitarCadastroSemLocalizacao() {
        Cliente cliente = new Cliente("3","Mario", "mario@teste.com", "Senha@123","00000000000","");
        assertEquals("Erro: geolocalização é obrigatória", service.cadastrarCliente(cliente));
    }

    @Test // UT09_RF002
    void rejeitarCadastroEmailDuplicado() {
        Cliente cliente = new Cliente("3","Mario", "joao@teste.com", "Senha@123","00000000000","Palhoça");
        assertEquals("Erro: e-mail já está cadastrado", service.cadastrarCliente(cliente));
    }

    @Test // UT10_RF002
    void rejeitarCadastroCpfDuplicado() {
        Cliente cliente = new Cliente("3","Mario", "mario@teste.com", "Senha@123","01234567890","Palhoça");
        assertEquals("Erro: CPF já está cadastrado", service.cadastrarCliente(cliente));
    }

    @Test // UT11_RF002
    void rejeitarCadastroClienteNulo() {
        assertEquals("Erro: dados obrigatórios ausentes", service.cadastrarCliente(null));
    }

}
