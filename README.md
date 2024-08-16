# ESCOLA DEV 🧑🏼‍🎓

Projeto de uma aplicação para cadastrar, listar, alterar e deletar **(CRUD)** instrutores e alunos de um banco de dados. Esse projeto foi criado a partir do desafio do Curso "Spring Boot 3: desenvolva uma API Rest em Java", da [Alura](https://www.alura.com.br/). Nesse projeto, é possível cadastrar alunos que estudem Frontend, Backend, FullStack, QA, Mobile e iOS, e os instrutores dessas mesmas especialidades. Todo cadastro é salvo no **banco de dados MySQL** a partir das informações dadas pelo usuário. Aqui, utilizamos o [Insomnia](https://insomnia.rest/download) para informar os dados dos alunos e instrutores para o BD. 

## **Como rodar o projeto: ✅**
Necessário alterar o arquivo "application.properties" com os seus dados do banco de dados:
```
spring.datasource.url=jdbc:mysql://${DB_HOST}/escoladev_api
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

Utilizando o Insomnia, criamos as seguintes requisições REST:

![image](https://github.com/user-attachments/assets/9344a111-c947-4497-aa0b-8fd5044162c2)

Para testar o cadastro de *instrutores*, pode usar o seguinte JSON:
```
{
"nome": "Maria Sá",
"email": "maria-sa@escoladev.admin",
"materia": "BACKEND",
"endereco": {
    "logradouro": "rua 3",
    "bairro": "bairrex",
    "cep": "88888880",
    "cidade": "Brasilia",
    "uf": "DF",
		"complemento": "casa",
    "numero": "1"
    }
}
```

Para testar o cadastro de *alunos*, pode usar o seguinte JSON:
```
{
"nome": "Antonio Silva",
"email": "antonio-silva@escoladev.admin",
"dataNascimento": "12/10/2000",
"materia": "IOS",
"endereco": {
    "logradouro": "rua 3",
    "bairro": "bairrex",
    "cep": "88888880",
    "cidade": "Brasilia",
    "uf": "DF",
		"complemento": "casa",
    "numero": "1"
    }
}
```

Para testar a alteração de dados de *instrutores*, pode usar o seguinte JSON:
```
{
"id": "1",
"nome": "Maria Santana"
}
```

Para testar a alteração de dados de *alunos*, pode usar o seguinte JSON:
```
{
"id": "1",
"email": "antonio-antonio@escoladev.admin"
}
```


## **Para criar o projeto, fiz o seguinte passo a passo:**
📌 criar as classes de Instrutor, Alunos e Endereço, com todos os atributos que desejo que tenham, utilizando as anotações de banco de dados para nomear a tabela, gerar id, etc;

📌 criar o Enum para apenas declarar as matérias;

📌 criar os records de Instrutor e Aluno, de forma separada para cada ação, ou seja:
1 para cadastrar aluno/instrutor;
1 para alterar dados do aluno/instrutor; e
1 para listar o aluno/instrutor.

📌 criar as interfaces Repository tanto para Aluno, quanto para Instrutor;

📌 criar as classes Controller tanto para Aluno, quanto para Instrutor;

📌 criar duas db.migration, uma para a tabela 'instrutor' e outra para a tabela 'aluno'.

Através desse projeto, pude consolidar meus conhecimentos em **CRUD** e **API REST**, fazendo o uso do aplicativo Insomnia. Além disso, tive a oportunidade de ter meu primeiro contato com **MySQL** e conhecer mais sobre as migrations de **Flyway**. Nesse projeto, apliquei as boas práticas de programação e mantive separado os pacotes de "controller", "dto", "model" e "repository", facilitando eventual manutenção ao código.

## **Problema enfrentado** ⚠️
#### Alteração do arquivo dentro de 'db.migration' após ter rodado a aplicação:
* **Como solucionei:** O erro de "flyway" deixou claro o que havia acontecido. Na primeira vez que aconteceu o erro, acessei o terminal dentro do IntelliJ e fiz o seguinte passo a passo:
```
mysql.exe -u nome_do_usuario -p;
USE nome_do_banco_de_dados;
SELECT * FROM flyway_schema_history;
DELETE FROM flyway_schema_history script LIKE '%nome_da_migration%';
EXIT;
```
Depois de selecionado o "flyway_schema_history", outra opção seria:
```
DELETE FROM flyway_schema_history WHERE success = 0;
```
Se o bug for maior 💥 e não funcionar como o esperado, pode recomeçar do zero, deletando seu banco de dados e criando-o novamente:
```
mysql.exe -u nome_do_usuario -p;
USE nome_do_banco_de_dados;
DROP database nome_do_banco_de_dados;
CREATE TABLE nome_do_banco_de_dados;
EXIT;
```

## **Tecnologias utilizadas:** 
* [Java](https://www.java.com/pt-BR/)
* [Spring Boot 3](https://spring.io/projects/spring-boot) e suas dependências Flyway, Hibernate, Migration e Lombok.
* [MySQL](https://www.mysql.com/)

## ⏭️ Próximos passos:
Criar uma aplicação que implemente um mecanismo de autenticação 🗝 na API.
