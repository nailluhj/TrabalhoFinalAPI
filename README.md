# TrabalhoFinalAPI
API DE REDE SOCIAL SIMPLES

ENTIDADES:

1. **Usuário (User):**
   - A entidade de usuário deve conter informações como nome, sobrenome, endereço de e-mail, senha, data de nascimento, etc.

2. **Postagem (Post):**
   - A entidade de postagem pode incluir campos como o conteúdo da postagem, data/hora de criação, autor (referência ao usuário que a criou), comentários (em que você pode usar um relacionamento de um-para-muitos), etc.

3. **Relacionamento (Relacionamento):**
   - Essa entidade pode ser usada para registrar os relacionamentos entre os usuários, como seguidores e seguidos. Ela terá duas referências de usuário, uma representando o seguidor e outra representando o seguido.


POSSÍVEIS RELACIONAMENTOS PARA AS ENTIDADES LISTADAS ACIMA:

- Um **Usuário** pode ter várias **Postagens**, portanto, você teria um relacionamento de um-para-muitos entre Usuário e Postagem.
- Um **Usuário** pode seguir vários outros **Usuários**, criando assim um relacionamento de muitos-para-muitos entre Usuário e Relacionamento. Para registrar quem segue quem, você pode incluir campos como "seguidor" e "seguido" na entidade Relacionamento.
- Uma **Postagem** pode ter vários **Comentários**, criando um relacionamento de um-para-muitos entre Postagem e Comentário.
Requisitos para o trabalho final da disciplina de Desenvolvimento de API Restful

TAREFAS: 

- Desenvolver as classes de domínio/modelo da aplicação.

- Desenvolver a criação do banco de dados (O banco de dados a ser escolhido ficará a critério da escolha de cada grupo com o qual se sentir mais confortável. Recomendações: H2 ou Postgre)

- Criar as classes dos repositórios pertinentes.

- Criar as classes de serviços pertinentes.

- Criar as classes de controle pertinentes.

- Realizar o tratamento de erros durante o consumo da API 

- Possuir sistema de autenticação e autorização para poder consumir a API (fica
a critério usar roles/perfis)

- Criar a documentação da API (swagger).

- Utilizar o máximo de recursos aprendidos durante as aulas (paginação, querys
nativas, jpql, spring).

- Fica a critério do grupo a utilização do Flyway

● A organização do código será critério de pontuação também (código organizado, reutilização de código sempre que possível, código indentado corretamente.).


● Desafios:
1 - Implementação da foto para a tabela User. (0,5 pts)
2 - Implementação do comentário relacionado a um usuário que o fez. (0,5). 
3 - Deixar somente quem me segue comentar (0.5)

![DiagramaUML](https://github.com/nailluhj/TrabalhoFinalAPI/assets/142450314/caebbb18-64f0-44b3-bc49-01734dcbf7e8)
