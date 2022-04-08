# A5SolutionsApiLocadora
## Api de locação de filmes

### Executando o projeto

#### Pré-requisitos:
• Ter a jdk 8 instalada no computador.

  link para download da jdk8: https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html
  
  após instalado execute "java -version" no seu bash para conferir se está instalado corretamente.

• Tenha Maven intalado na máquina.

  link para download do maven: https://maven.apache.org/download.cgi
  
  após instalado execute "mvn -version" no seu bash para conferir se está instalado corretamente.

#### Executando 
• Entre no diretorio raiz do projeto (/A5SolutionsApiLocadora/godzillaLocalFilmes)

• Execute em um bash os seguintes comandos:

   "mvn clean install" para buildar o Projeto.
   
   "cd target/" pois agora foi gerado um executável do projeto para ser utilizado
   
   "java -jar godzillaLocalFilmes-0.0.1-SNAPSHOT.jar" para executar o .jar

#### Acessando endpoints 
1. localhost:8080/usuario
>Cadastro de usuario metodo POST que recebe um json:
>
>{
>    "email": "guilherme.vicari@gmail.com",
>    "senha": "123456",
>    "senha": gui123
>}
>
>Retorna um token que será utilizado na locação de um fime!
>
>{
>    "id": 1,
>    "email": "guilherme.vicari@gmail.com",
>    "nome": "guilherme",
>    "senha": "senha criptografada",
>    "token": "nkt2xo0g1qivp0h15g74"
>}
>
2. localhost:8080/filmes
• Metodo GET que retorna dados de todos os filmes da locadora 

3. localhost:8080/filme
>Cadastro de um novo filme, metodo POST que Recebe um json como o abaixo:
>
>{
>    "titulo": "Harry Potter e a pedra filosofal",
>    "diretor": "alfonso cuaráon",
>    "estoque": 20,
>    "ano":2001
>}
>
>Retorno:
>
>{
>    "filmeId": 4,
>    "titulo": "Harry Potter e a pedra filosofal",
>    "diretor": "alfonso cuaráon",
>    "estoque": 20,
>    "ano": 2001
>}
>

4. localhost:8080/filmes/titulo/<nome de filme>
• Metodo GET que retorna todos os filmes que contém esse o título passado na URI, se você passar "harry", aparecerão filmes relacionados ao mesmo.

5. localhost:8080/filmes/ano/2001
• Metodo GET que retorna todos os filmes que contém o ano "2001".

6. localhost:8080/aluguel/nkt2xo0g1qivp0h15g74/4
• Metodo GET que realiza a locação de um filme passado na URI junto com o token do usuário.
• "4 seria o id do filme e "nkt2xo0g1qivp0h15g74" o token do usuario
>Retorno 1
>Caso haja filme no estoque para locação:
>
>{
>    "id": 1,
>    "idFilme": 1,
>    "tokenUsuario": "nkt2xo0g1qivp0h15g74"
>}
>
>Retorno 2 
>
>Caso não tenha o filme em estoque será retornado um body com a mensagem: "Filme fora de estoque!!" e status 403 - Forbidden
>
