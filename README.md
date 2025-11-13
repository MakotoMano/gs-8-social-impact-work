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

# Swagger UI
http://localhost:8081/swagger-ui/index.html
