## Sistema de Gerenciamento de Assinaturas - Em desenvolvimento

**Visão Geral**  
O Sistema de Gerenciamento de Assinaturas é uma plataforma para criação, administração e controle de planos de assinatura. Ele permite pagamentos recorrentes e únicos, notificações de vencimentos, gerenciamento de usuários e cupons promocionais.

### Tecnologias Utilizadas:
- **Back-end**: Spring Boot
- **Front-end**: React
- **Banco de Dados**: PostgreSQL
- **Autenticação**: JWT, OAuth2
- **Pagamentos**: Stripe, Mercado Pago, PayPal

### Funcionalidades Principais:
- **Gerenciamento de planos de assinatura**
- **Integração com múltiplos métodos de pagamento**
- **Notificações automáticas sobre vencimentos e renovações**
- **Painel administrativo com métricas detalhadas**
- **API para integração com outras plataformas**
- **Segurança avançada em pagamentos e autenticação**

### Modelagem do Banco de Dados:
O sistema conta com tabelas para:
- **Usuários**: Cadastro e controle de acessos
- **Assinaturas**: Configuração de planos
- **Pagamentos**: Registro de transações
- **Cupons de desconto**: Aplicação de promoções
- **Logs de auditoria**: Registro de ações no sistema

### Como Rodar o Projeto:

**Pré-requisitos:**
- Java 17+
- Node.js 18+
- PostgreSQL

**Passos:**
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Configure o banco de dados no `application.properties` do Spring Boot.

3. Instale as dependências do backend e rode o servidor:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

### Docker Hub:
A imagem Docker para o Sistema de Gerenciamento de Assinaturas está disponível no Docker Hub. Para puxar a imagem, execute o seguinte comando:
```bash
docker pull 01923483102/gerenciador-de-assinaturas:0.2.0
```
Acesse o repositório no Docker Hub para mais detalhes: [Docker Hub - Gerenciador de Assinaturas](https://hub.docker.com/repository/docker/01923483102/gerenciador-de-assinaturas)

### Licença:
Este projeto está sob a licença **Creative Commons Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)**. Você pode compartilhar e adaptar este código para fins não comerciais, desde que forneça crédito apropriado ao autor original. Consulte o arquivo LICENSE para mais detalhes.
