CREATE TABLE instrutor(
        id bigint NOT NULL auto_increment,
        nome varchar(100) NOT NULL,
        email varchar(100) NOT NULL UNIQUE,
        materia varchar(100) NOT NULL,
        logradouro varchar(100) NOT NULL,
        bairro varchar(100) NOT NULL,
        cep varchar(9) NOT NULL,
        complemento varchar(100) NOT NULL,
        numero varchar(20) NOT NULL,
        uf char(2) NOT NULL,
        cidade varchar(100) NOT NULL,
        primary key(id)
);