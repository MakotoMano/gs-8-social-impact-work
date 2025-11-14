# GS 8 – Social Impact Work

API Java Spring Boot desenvolvida como parte da Global Solution de **Microservices and Web Engineering – 3SIR**, com foco em **modelos de trabalho baseados em impacto social e sustentabilidade**.

---

## 👥 Membros do grupo

- **Diogo Makoto Mano** – RM98446  
- **Victor Espanhol Henrique Santos** – RM552532  

---

## 🎯 Tema escolhido

**8. Modelos de trabalho baseados em impacto social e sustentabilidade**

O projeto aborda como organizações podem estruturar modelos de trabalho que gerem resultado econômico, mas também promovam impacto social positivo e práticas sustentáveis.  
A API serve como ponto de integração para aplicações que desejem consultar informações sobre o tema e utilizá-las em outros serviços ou front-ends.

---

## 🧩 Finalidade da API

Esta API expõe um endpoint simples, voltado à integração com outros sistemas, contendo:

- Identificação do tema da Global Solution  
- Nomes dos membros do grupo  
- Uma breve descrição textual do tema e de seu propósito  

Endpoint principal:

- `GET /info`  
  Retorna um JSON no seguinte formato:

```json
{
  "tema": "Modelos de trabalho baseados em impacto social e sustentabilidade",
  "membro1": "Diogo Makoto Mano",
  "membro2": "Victor Espanhol Henrique Santos",
  "descricao": "API que descreve modelos de trabalho focados em impacto social e sustentabilidade, mostrando como organizações podem alinhar resultados econômicos com impacto social positivo."
}
```

A documentação da API é disponibilizada automaticamente via **Swagger / OpenAPI**, permitindo que outros times ou serviços consultem e testem o endpoint pela interface web.

---

## ▶️ Como executar o projeto localmente

### ✅ Pré-requisitos

- **Java 17**  
- **Maven 3.9+**  
- **Docker** (opcional, apenas se quiser rodar via container)

### 🔧 Execução com Maven

Na raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada na porta **8081**.

- API: [http://localhost:8081/info](http://localhost:8081/info)  
- Swagger UI: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

### 🐳 Execução com Docker

1. Baixar a imagem do Docker Hub:

```bash
docker pull makotomano/gs-8-social-impact-work:latest
```

2. Executar o container:

```bash
docker run --rm -p 8081:8081 makotomano/gs-8-social-impact-work:latest
```

A API estará acessível em:

- [http://localhost:8081/info](http://localhost:8081/info)  
- [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

## 🌐 URL da imagem no Docker Hub

A imagem Docker deste projeto está disponível em:

`https://hub.docker.com/r/makotomano/gs-8-social-impact-work`

---

## ⚙️ Workflows CI/CD (GitHub Actions)

O projeto utiliza **GitHub Actions** para automatizar versionamento, integração contínua e entrega contínua.

---

### 🔢 1. Versionamento – `versioning.yml`

- **Disparo:** `push` na branch `main`  
- **Responsabilidades:**
  - Busca a última tag existente no repositório (formato `vX.Y.Z`)  
  - Incrementa automaticamente a versão de *patch* (por exemplo, `v0.0.0` → `v0.0.1`)  
  - Cria uma nova **tag** no repositório  
  - Cria uma **Release** no GitHub com notas geradas automaticamente  

Esse workflow garante o histórico de versões da API de forma padronizada, atendendo ao requisito de **automação de versão (versioning)** da Global Solution.

---

### 🧪 2. Continuous Integration (CI) – `ci.yml`

- **Disparo:** `push` nas branches:
  - `feature/**`
  - `release`
  - `hotfix`
- **Responsabilidades:**
  - Configura o ambiente com **JDK 17**  
  - Executa:
    - `./mvnw clean verify` (build + testes)  
    - `docker build -t gs-8-social-impact-work .` (build da imagem Docker para validação)  

Esse workflow assegura que qualquer alteração em branches de desenvolvimento, release ou correção não quebre o build nem a imagem Docker da aplicação, atendendo ao requisito de **Continuous Integration (CI)**.

---

### 🚀 3. Continuous Delivery (CD) – `cd.yml`

- **Disparo:** **pull requests com base na branch `develop`**  
  (por exemplo, PR de `feature/alguma-coisa` → `develop`)
- **Responsabilidades:**
  - Realiza build do projeto com Maven (`./mvnw clean package -DskipTests`)  
  - Faz login no Docker Hub usando *secrets*:
    - `DOCKERHUB_USERNAME`
    - `DOCKERHUB_TOKEN`
  - Constrói e envia a imagem Docker para o Docker Hub com as tags:
    - `makotomano/gs-8-social-impact-work:latest`
    - `makotomano/gs-8-social-impact-work:<SHA do commit>`  

Esse workflow garante que, ao aprovar PRs para `develop`, a imagem Docker seja atualizada automaticamente no Docker Hub, atendendo ao requisito de **Continuous Delivery (CD)** da Global Solution.

---

## 📌 Resumo

Este repositório entrega:

- API Java Spring Boot simples, porém alinhada ao tema **impacto social e sustentabilidade**  
- Endpoint `GET /info` documentado via Swagger  
- Dockerfile e imagem publicada no Docker Hub (`makotomano/gs-8-social-impact-work`)  
- Três workflows GitHub Actions cobrindo:
  - **Versionamento automático**
  - **Integração contínua (CI)**
  - **Entrega contínua da imagem (CD)**  
