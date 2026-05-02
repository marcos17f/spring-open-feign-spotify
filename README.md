# 🎧 Spotify Albums API

API REST desenvolvida em Java com Spring Boot para integração com a API do Spotify, permitindo a busca de álbuns por artista de forma dinâmica.

---

## 🚀 Funcionalidades

- 🔍 Busca de álbuns por nome do artista
- 🔐 Autenticação com Spotify (Client Credentials)
- 📦 Retorno estruturado com DTO
- 📄 Paginação com `limit` e `offset`
- ⚡ Integração com API externa usando OpenFeign

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- OpenFeign
- Maven
- API do Spotify

---

## 🔑 Autenticação

A API utiliza o fluxo **Client Credentials** da API do Spotify, com envio de credenciais codificadas em Base64 via header:



---

## 📡 Endpoint

### Buscar álbuns


### Parâmetros:

| Parâmetro | Tipo | Descrição |
|----------|------|----------|
| artist   | String | Nome do artista |
| limit    | int    | Quantidade de resultados |
| offset   | int    | Paginação |

### Exemplo:


http://localhost:8080/spotify/api/albums?artist=drake&limit=10&offset=0



---

## 📦 Exemplo de resposta

```json
[
  {
    "album": "Global Warming",
    "artist": "Pitbull"
  }
]


# Clonar o repositório
git clone https://github.com/seu-usuario/spotify-api.git

# Entrar na pasta
cd spotify-api

# Rodar o projeto
./mvnw spring-boot:run
