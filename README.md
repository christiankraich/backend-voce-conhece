# backend-voce-conhece

Backend Você Conhece?
API backend para plataforma de descoberta de locais e experiências urbanas.

🧩 Visão Geral
O "Você Conhece?" é uma plataforma mobile que conecta usuários a locais e eventos da cidade, resolvendo o problema da falta de informações confiáveis e centralizadas sobre experiências urbanas. O sistema organiza estabelecimentos por categorias, oferece recomendações personalizadas e incentiva o engajamento através de gamificação.

Problema Resolvido
Dificuldade em encontrar informações confiáveis sobre lugares e eventos
Falta de um espaço digital centralizado e atualizado
Repetição dos mesmos programas por falta de descoberta de novidades
Solução
Sistema que conecta usuários a locais baseado em preferências, localização e categorias de interesse, com sistema de gamificação e recompensas.

🎯 Objetivos do Sistema
Ajudar pessoas a encontrarem novas experiências locais
Incentivar o comércio e eventos locais a se promoverem digitalmente
Proporcionar recomendações personalizadas
Criar uma rede de avaliações e feedbacks reais dos usuários
👥 Perfis de Usuários
🛍 Cliente
Procura lugares e experiências
Faz avaliações e comentários
Salva favoritos
Ganha pontos por interações
Troca pontos por cupons de desconto
🏪 Dono de Negócio
Registra e promove seu local/evento
Escolhe entre planos Bronze, Prata ou Ouro
Acessa relatórios de desempenho
Gerencia promoções e campanhas
💎 Beneficente
Organizações beneficentes cadastradas
Participam do sistema de doações via pontos
Validação através de CNPJ e registro governamental
🔧 Administrador
Gerencia e mantém o sistema
Aprova cadastros de estabelecimentos
Modera conteúdo e usuários
🛠 Tecnologias Utilizadas
Java - Linguagem principal
Spring Boot - Framework backend
Spring Security - Autenticação e autorização
JPA/Hibernate - Mapeamento objeto-relacional
PostgreSQL - Banco de dados
JUnit 5 - Testes automatizados
JWT - Tokens de autenticação
Bean Validation - Validação de dados
✅ Funcionalidades Principais
Autenticação e Cadastro
RF001: Login com distinção de perfil (cliente, dono de negócio, beneficente)
RF002: Cadastro de clientes com validação de CPF e email
RF021: Sistema de redefinição de senha
RF041: Cadastro de organizações beneficentes com validação de CNPJ
Busca e Descoberta
Busca por locais com filtros de proximidade, categorias e palavras-chave
Geolocalização para mostrar locais próximos
Recomendações baseadas no histórico de uso
Interação Social

📦 Instalação
Pré-requisitos
Java 17 ou superior
Maven 3.6+
PostgreSQL 12+
IDE (IntelliJ IDEA, Eclipse, VS Code)
Configuração
Clone o repositório:
bash
git clone https://github.com/christiankraich/backend-voce-conhece.git
cd backend-voce-conhece
Configure o banco de dados:
bash

# PostgreSQL  
CREATE DATABASE voce_conhece;
Configure as variáveis de ambiente em application.yml:
yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/voce_conhece
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:password}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

jwt:
  secret: ${JWT_SECRET:seu-jwt-secret-aqui}
  expiration: 86400000

app:
  upload:
    path: ${UPLOAD_PATH:./uploads}
Execute o projeto:
bash
# Com Maven
mvn spring-boot:run

# Ou compile e execute
mvn clean package
java -jar target/backend-voce-conhece-1.0.0.jar
Execute os testes:
bash
mvn test
🧪 Testes Implementados
Autenticação (AutenticadorServiceTest)
✅ Autenticar diferentes perfis de usuário
✅ Validar senhas incorretas
✅ Rejeitar usuários inexistentes
✅ Validar campos obrigatórios
✅ Validar formato de email
Cadastro de Cliente (CadastroClienteServiceTest)
✅ Cadastro completo válido
✅ Validação de campos obrigatórios
✅ Validação de email e CPF únicos
✅ Validação de formatos (email, CPF)
Cadastro de Beneficente (CadastroBeneficenteServiceTest)
✅ Cadastro completo com CNPJ válido
✅ Validação de campos obrigatórios
✅ Validação de CNPJ único e formato
✅ Validação de tipo de organização
Redefinição de Senha (RedefinirSenhaServiceTest)
✅ Verificação de email existente
✅ Validação de nova senha
✅ Prevenção de reutilização de senha
✅ Validação de força da senha

⭐ Transformando a forma como as pessoas descobrem sua cidade!
