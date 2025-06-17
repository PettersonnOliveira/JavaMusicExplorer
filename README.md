# 🎵 JavaMusicExplorer

JavaMusicExplorer é uma aplicação de linha de comando desenvolvida com Spring Boot para gerenciar artistas e suas músicas favoritas, com persistência de dados em banco de dados relacional (PostgreSQL) e integração com a API do ChatGPT para obter informações sobre os artistas.

## 🚀 Funcionalidades

- 📁 Cadastrar novos artistas (Solo, Dupla ou Banda)
- 🎶 Cadastrar músicas associadas a artistas
- 📜 Listar todas as músicas
- 🔍 Buscar músicas por nome do artista
- 🤖 Obter informações de um artista via ChatGPT

## 🧠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- API OpenAI (ChatGPT)
- Jakarta Persistence (JPA)
- Maven

## 📦 Estrutura do Projeto

```
JavaMusicExplorer/
├── model/
│   ├── Artista.java
│   ├── Musica.java
│   └── TipoArtista.java
├── repository/
│   ├── ArtistaRepository.java
├── service/
│   └── ConsultaChatGPT.java
├── Principal.java
└── JavaMusicExplorerApplication.java
```

## 🛠️ Como executar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/JavaMusicExplorer.git
```

2. Configure o banco de dados PostgreSQL:

Crie um banco com o nome desejado e configure o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/javamusic
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Configure a chave da API OpenAI:

Adicione a variável de ambiente com sua chave:

```bash
export OPENAI_APIKEY=sk-*************
```

4. Execute o projeto:

```bash
./mvnw spring-boot:run
```

Ou rode a `JavaMusicExplorerApplication` pela sua IDE.

## 📌 Observações

- Só é possível cadastrar músicas de artistas já cadastrados.
- O projeto utiliza o padrão `CommandLineRunner` para um menu interativo via terminal.
- A busca de informações do artista usa o modelo `text-davinci-003` da OpenAI.

## 📚 Exemplo de uso

```
Selecione uma opção:
1. Cadastrar Artistas
2. Cadastrar Músicas
3. Listar Músicas
4. Buscar Músicas por Artista
5. Buscar informações de um Artista
6. Sair
```

## 👨‍💻 Autor

Feito por **Petterson Oliveira**  
Aluno do programa **Oracle Next Education - ONE** e **Tecnólogo da faculdade Celso Lisboa** 🚀  
