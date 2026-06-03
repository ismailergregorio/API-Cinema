# 🎬 Cinema API

API REST desenvolvida com Spring Boot e MongoDB para gerenciamento de filmes, categorias, sessões, usuários e favoritos.

## 📋 Sobre o Projeto

O objetivo desta API é fornecer um backend para aplicações de catálogo de filmes, permitindo:

* Cadastro de usuários
* Login de usuários
* Gerenciamento de filmes
* Gerenciamento de categorias
* Gerenciamento de sessões
* Sistema de favoritos
* Persistência de dados utilizando MongoDB

---

# 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data MongoDB
* Spring Web
* Maven
* MongoDB
* Lombok
* Swagger/OpenAPI

---

# 📂 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── com.example.cinema
│   │       ├── controllers
│   │       ├── services
│   │       ├── repository
│   │       ├── entity
│   │       ├── dto
│   │       └── config
│   └── resources
│       └── application.properties
└── test
```

---

# 🗄️ Banco de Dados

MongoDB

Coleções utilizadas:

```text
filmes
categorias
usuarios
favoritos
sessoes
```

---

# 📚 Entidades

## 🎥 Filme

```java
{
  "id": "string",
  "adult": false,
  "backdropPath": "string",
  "genreIds": [28, 12],
  "title": "Avatar",
  "originalLanguage": "en",
  "originalTitle": "Avatar",
  "overview": "Descrição do filme",
  "popularity": 100.5,
  "posterPath": "/poster.jpg",
  "releaseDate": "2025-01-01",
  "softcore": false,
  "video": false,
  "voteAverage": 8.5,
  "voteCount": 1500
}
```

---

## 🏷️ Categoria

```java
{
  "id": 28,
  "name": "Ação"
}
```

---

## 👤 Usuário

```java
{
  "id": "string",
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

---

## ❤️ Favorito

```java
{
  "id": "string",
  "usuarioId": "string",
  "filmeId": "string"
}
```

---

## 🎫 Sessão

```java
{
  "id": "string",
  "sala": "Sala 01",
  "horario": "20:00",
  "preco": 25.90
}
```

---

# ⚙️ Configuração do MongoDB

## application.properties

```properties
spring.application.name=cinema-api

spring.data.mongodb.uri=mongodb://localhost:27017/cinema
```

---

# ▶️ Como Executar o Projeto

## 1 - Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/cinema-api.git
```

```bash
cd cinema-api
```

---

## 2 - Instalar Dependências

```bash
mvn clean install
```

---

## 3 - Iniciar MongoDB

Linux:

```bash
sudo systemctl start mongod
```

Windows:

```bash
net start MongoDB
```

---

## 4 - Executar a Aplicação

```bash
mvn spring-boot:run
```

ou

```bash
java -jar target/cinema-api.jar
```

---

# 📖 Documentação Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🔐 Usuários

## Criar Usuário

```http
POST /user
```

Body:

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```

---

## Login

```http
POST /user/login
```

Body:

```json
{
  "email": "joao@email.com",
  "senha": "123456"
}
```

---

# 🎥 Filmes

## Listar Filmes

```http
GET /filmes
```

## Buscar Filme

```http
GET /filmes/{id}
```

## Buscar Filme por Nome

```http
GET /filmes/nome/{nome}
```

## Buscar Filmes por Categoria

```http
GET /filmes/categoria/{id}
```

## Criar Filme

```http
POST /filmes
```

## Criar Lista de Filmes

```http
POST /filmes/lista
```

## Atualizar Filme

```http
PUT /filmes/{id}
```

## Excluir Filme

```http
DELETE /filmes/{id}
```

---

# 🏷️ Categorias

## Listar Categorias

```http
GET /categorias
```

## Buscar Categoria

```http
GET /categorias/{id}
```

## Criar Categoria

```http
POST /categorias
```

## Criar Lista de Categorias

```http
POST /categorias/lista
```

## Atualizar Categoria

```http
PUT /categorias/{id}
```

## Excluir Categoria

```http
DELETE /categorias/{id}
```

---

# ❤️ Favoritos

## Listar Favoritos

```http
GET /favoritos
```

## Buscar Favorito

```http
GET /favoritos/{id}
```

## Criar Favorito

```http
POST /favoritos
```

Body:

```json
{
  "usuarioId": "ID_USUARIO",
  "filmeId": "ID_FILME"
}
```

## Excluir Favorito

```http
DELETE /favoritos/{id}
```

---

# 🎫 Sessões

## Listar Sessões

```http
GET /sessao
```

## Buscar Sessão

```http
GET /sessao/{id}
```

## Criar Sessão

```http
POST /sessao
```

## Atualizar Sessão

```http
PUT /sessao/{id}
```

## Excluir Sessão

```http
DELETE /sessao/{id}
```

---

# 📌 Funcionalidades

* CRUD de Filmes
* CRUD de Categorias
* CRUD de Sessões
* Cadastro de Usuários
* Login de Usuários
* Sistema de Favoritos
* Busca de Filmes por Nome
* Busca de Filmes por Categoria
* Persistência em MongoDB
* Documentação automática com Swagger

---
