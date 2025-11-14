# GS 8 - Social Impact Work

API Java Spring Boot desenvolvida para a Global Solution de Microservices and Web Engineering (3SIR),
sobre **modelos de trabalho baseados em impacto social e sustentabilidade**.

## 👥 Membros do grupo

- **Diogo Makoto Mano** – RM98446  
- **Victor Espanhol Henrique Santos** – RM552532  

## 🎯 Tema

**8. Modelos de trabalho baseados em impacto social e sustentabilidade**

## 🧩 Sobre a API

A API expõe um endpoint principal:

- `GET /info`  
  Retorna um JSON com:
  - `tema`
  - `membro1`
  - `membro2`
  - `descricao`

## ▶️ Como executar localmente

Requisitos:
- Java 17
- Maven 3.9+

```bash
# Rodar a aplicação
./mvnw spring-boot:run

# Acessar a API
http://localhost:8081/info

# Link do repositório DockerHub
https://hub.docker.com/r/makotomano/gs-8-social-impact-work

# Swagger UI
http://localhost:8081/swagger-ui/index.html
```
## ⚙️ Workflows CI/CD (GitHub Actions)

- **Versioning (versioning.yml)**  
  Disparado em `push` na branch `main`.  
  Gera automaticamente uma nova tag (`vX.Y.Z`) e uma Release no GitHub.

- **CI (ci.yml)**  
  Disparado em `push` nas branches `feature/**`, `release` e `hotfix`.  
  Executa:
  - Build da aplicação com Maven (`./mvnw clean verify`)
  - Testes
  - Build da imagem Docker (para validação do Dockerfile)

- **CD (cd.yml)**  
  Disparado em **pull requests com base na branch `develop`**.  
  Executa:
  - Build da aplicação (`./mvnw clean package -DskipTests`)
  - Login no Docker Hub
  - Build e push da imagem Docker:
    - `SEU_USUARIO/gs-8-social-impact-work:latest`
    - `SEU_USUARIO/gs-8-social-impact-work:<SHA do commit>`

