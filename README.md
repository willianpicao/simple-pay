# PicPay Simplified Backend Challenge

## Project Description (EN)

This project is a backend solution for the PicPay Simplified Challenge, a simplified payment transfer platform. The project focuses on implementing a RESTful API to handle money transfers between users, applying best development practices and fulfilling the proposed requirements.

[Challenge link](https://github.com/PicPay/picpay-desafio-backend)

---

## Requirements Implemented (EN)

* ✅ User registration with unique CPF and email.
* ✅ Two user types: Common and Merchant, with enforced business rules:

  * Common users can send and receive money.
  * Merchant users can only receive money.
* ✅ Balance validation before processing transfers.
* ✅ Integration with external authorization service (GET request to `https://util.devi.tools/api/v2/authorize`).
* ✅ Transfer operations are transactional to ensure rollback in case of failure.
* ✅ Sending notifications through an external service (POST request to `https://util.devi.tools/api/v1/notify`).
* ✅ Exception handling for authorization and notification failures.
* ✅ Well-structured project with clear layer separation:

  * Controller
  * Service
  * Repository
  * DTO
  * Config
  * Exceptions
* ✅ Docker used to provision the MySQL database.
* ✅ Persistence using Spring Data JPA.
* ✅ FeignClient used for communication with external services.
* ✅ RESTful API with clearly mapped endpoints.

---

## Technologies Used (EN)

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Cloud OpenFeign
* MySQL 8
* Docker
* Lombok

---

## Project Architecture (EN)

The project is organized with a **modular structure and clear separation of responsibilities.**

```
src/main/java/br/com/willianpicao/picpay_simplificado
├── clients       # Communication with external APIs
├── config        # Configuration and initial data load
├── controller    # API entry points
├── dto           # Data Transfer Objects
├── entity        # JPA Models
│   ├── users     # User hierarchy
├── exception     # Custom exceptions
├── repository    # Persistence interfaces
├── service       # Business logic
```

> The structure follows best practices for Spring Boot projects.

---

## Best Practices Applied (EN)

* ✔️ Clear layer separation: Controller, Service, Repository.
* ✔️ Use of `@Transactional` to ensure atomicity in transfers.
* ✔️ Business rule validation in the Service Layer.
* ✔️ Centralized exception handling with `@ControllerAdvice`.
* ✔️ Decoupled external service communication using FeignClient.
* ✔️ Docker used to isolate the database environment.
* ✔️ SOLID principles applied:

  * Single Responsibility in each class.
  * Low coupling between layers.
* ✔️ Object-oriented modeling with inheritance (Users).
* ✔️ Persistence with Spring Data JPA following best repository practices.
* ✔️ Semantic commits and organized Git repository.

---

## API Endpoint (EN)

### POST `/transfer`

Performs value transfer between users.

**Request Body:**

```json
{
  "value": 100.0,
  "payer": 1,
  "payee": 2
}
```

**Response:**

```http
202 Accepted
```

---


---

# Desafio Backend PicPay Simplificado

## Descrição do Projeto (PT-BR)

Este projeto é uma solução backend para o Desafio PicPay Simplificado, uma plataforma simplificada de transferências financeiras. O foco foi implementar a API RESTful para realizar transferências de valores entre usuários, aplicando boas práticas de desenvolvimento e atendendo aos requisitos propostos.

[Link do desafio](https://github.com/PicPay/picpay-desafio-backend)

---

## Requisitos Atendidos (PT-BR)

* ✅ Cadastro de usuários com CPF e e-mail únicos.
* ✅ Dois tipos de usuários: Comum e Lojista, com regras de negócio aplicadas:

  * Usuário Comum pode enviar e receber dinheiro.
  * Usuário Lojista pode apenas receber dinheiro.
* ✅ Validação de saldo antes da transferência.
* ✅ Integração com serviço autorizador externo (GET para `https://util.devi.tools/api/v2/authorize`).
* ✅ Operação de transferência é transacional, garantindo rollback em caso de falha.
* ✅ Envio de notificação via serviço externo (POST para `https://util.devi.tools/api/v1/notify`).
* ✅ Tratamento de falhas na autorização e notificação.
* ✅ Estrutura de projeto bem organizada por camadas:

  * Controller
  * Service
  * Repository
  * DTO
  * Config
  * Exceptions
* ✅ Utilização de Docker para provisionamento do banco MySQL.
* ✅ Persistência com Spring Data JPA.
* ✅ Utilização de FeignClient para comunicação com serviços externos.
* ✅ API RESTful com mapeamento claro dos endpoints.

---

## Tecnologias Utilizadas (PT-BR)

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Cloud OpenFeign
* MySQL 8
* Docker
* Lombok

---

## Arquitetura do Projeto (PT-BR)

O projeto está organizado com uma **estrutura modular e bem separada por responsabilidades.**

```
src/main/java/br/com/willianpicao/picpay_simplificado
├── clients       # Comunicação com APIs externas
├── config        # Configurações e carga inicial
├── controller    # Entrada da API
├── dto           # Data Transfer Objects
├── entity        # Modelos JPA
│   ├── users     # Hierarquia de usuários
├── exception     # Exceções customizadas
├── repository    # Interfaces de persistência
├── service       # Lógica de negócio
```

> Estrutura alinhada com boas práticas de projetos Spring Boot.

---

## Boas Práticas Aplicadas (PT-BR)

* ✔️ Separação clara de camadas: Controller, Service, Repository.
* ✔️ Uso de `@Transactional` para garantir atomicidade nas transferências.
* ✔️ Validação das regras de negócio na Service Layer.
* ✔️ Tratamento centralizado de exceções com `@ControllerAdvice`.
* ✔️ Comunicação com serviços externos desacoplada via FeignClient.
* ✔️ Uso de Docker para isolar o ambiente do banco de dados.
* ✔️ Aplicação dos princípios SOLID:

  * Responsabilidade única em cada classe.
  * Baixo acoplamento entre as camadas.
* ✔️ Modelagem orientada a objetos com herança (Users).
* ✔️ Persistência com Spring Data JPA e boas práticas de repositórios.
* ✔️ Commits semânticos e repositório Git bem organizado.

---

## Endpoint da API (PT-BR)

### POST `/transfer`

Realiza a transferência de valores entre usuários.

**Request Body:**

```json
{
  "value": 100.0,
  "payer": 1,
  "payee": 2
}
```

**Response:**

```http
202 Accepted
```

---

