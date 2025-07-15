Descrição • Tecnologias • Funcionalidades • Estrutura do Projeto • Executar Localmente • Testes • Melhorias Futuras •

📖 Descrição
O Projeto Loja de Games é uma aplicação backend que simula o funcionamento de uma loja virtual de jogos. Desenvolvido em Java com Spring Boot, o projeto permite cadastrar, listar, atualizar e deletar jogos, oferecendo também filtros por nome e gênero. Foi criado como parte de uma atividade do bootcamp da Generation Brasil.

🚀 Tecnologias Utilizadas
Java 17
Spring Boot
Spring Data JPA
Maven
MySQL (banco de dados)
Insomnia (para teste de API)
📚 Funcionalidades
✅ Cadastro de novos jogos
✅ Listagem de todos os jogos
✅ Atualização de dados
✅ Deletar jogo
✅ Filtro por nome ou gênero
✅ Validações básicas nos campos
📂 Estrutura do Projeto
Projeto_Loja_De_Games/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/loja/games/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── Application.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql
├── pom.xml
└── README.md
🛠️ Como Executar o Projeto Localmente
Clone o repositório:
git clone https://github.com/LarissaSoaresSilva/Projeto_Loja_De_Games.git
Acesse o diretório:
cd Projeto_Loja_De_Games
Compile o projeto:
mvn clean install
Execute com:
mvn spring-boot:run
Acesse o sistema via navegador:
http://localhost:8080
📄 Para teste no Insomnia
Acesse a documentação da API para testar os endpoints: http://localhost:8080

✅ Requisitos
JDK 17 instalado

Maven instalado

💡 Melhorias Futuras
Integração com banco de dados PostgreSQL

Autenticação com Spring Security

Deploy em nuvem (Heroku, Render ou Railway)

Integração com frontend Angular ou React

👩🏻‍💻 Desenvolvedor
Rodrigo Henrique Dos Santos
