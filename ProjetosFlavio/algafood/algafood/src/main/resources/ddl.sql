
    create table cidade (
       id bigint not null auto_increment,
        nome varchar(255),
        estado_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table cozinha (
       id bigint not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table estado (
       id bigint not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table forma_pagamento (
       id bigint not null auto_increment,
        descricao varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table grupo (
       id bigint not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table grupo_permissao (
       grupo_id bigint not null,
        permissao_id bigint not null
    ) engine=InnoDB

    create table permissao (
       id bigint not null auto_increment,
        descricao varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table produto (
       id bigint not null auto_increment,
        ativo bit not null,
        descricao varchar(255),
        nome varchar(255),
        preco decimal(19,2),
        restaurante_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table restaurante (
       id bigint not null auto_increment,
        data_atualizacao datetime(6) not null,
        data_cadastro datetime(6) not null,
        endereco_bairro varchar(255),
        endereco_cep varchar(255),
        endereco_complemento varchar(255),
        endereco_logadouro varchar(255),
        endereco_numero varchar(255),
        nome varchar(255),
        taxa_frete decimal(19,2) not null,
        cozinha_id bigint not null,
        endereco_cidade_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table restaurante_forma_pagamento (
       restaurante_id bigint not null,
        forma_pagamento_id bigint not null
    ) engine=InnoDB

    create table usuario (
       id bigint not null auto_increment,
        data_cadastro datetime(6) not null,
        email varchar(255),
        nome varchar(255),
        senha varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table usuario_grupo (
       usuario_id bigint not null,
        grupo_id bigint not null
    ) engine=InnoDB

    alter table cidade 
       add constraint FKkworrwk40xj58kevvh3evi500 
       foreign key (estado_id) 
       references estado (id)

    alter table grupo_permissao 
       add constraint FKh21kiw0y0hxg6birmdf2ef6vy 
       foreign key (permissao_id) 
       references permissao (id)

    alter table grupo_permissao 
       add constraint FKta4si8vh3f4jo3bsslvkscc2m 
       foreign key (grupo_id) 
       references grupo (id)

    alter table produto 
       add constraint FKb9jhjyghjcn25guim7q4pt8qx 
       foreign key (restaurante_id) 
       references restaurante (id)

    alter table restaurante 
       add constraint FK76grk4roudh659skcgbnanthi 
       foreign key (cozinha_id) 
       references cozinha (id)

    alter table restaurante 
       add constraint FKbc0tm7hnvc96d8e7e2ulb05yw 
       foreign key (endereco_cidade_id) 
       references cidade (id)

    alter table restaurante_forma_pagamento 
       add constraint FK7aln770m80358y4olr03hyhh2 
       foreign key (forma_pagamento_id) 
       references forma_pagamento (id)

    alter table restaurante_forma_pagamento 
       add constraint FKa30vowfejemkw7whjvr8pryvj 
       foreign key (restaurante_id) 
       references restaurante (id)

    alter table usuario_grupo 
       add constraint FKk30suuy31cq5u36m9am4om9ju 
       foreign key (grupo_id) 
       references grupo (id)

    alter table usuario_grupo 
       add constraint FKdofo9es0esuiahyw2q467crxw 
       foreign key (usuario_id) 
       references usuario (id)
insert into cozinha (nome) values ('tailandeza')
insert into cozinha (nome) values ('Chinesa')
insert into cozinha (nome) values ('Indiana')
insert into cozinha (nome) values ('Brasileira')
insert into forma_pagamento (descricao) values ('pix')
insert into forma_pagamento (descricao) values ('Crédito')
insert into forma_pagamento (descricao) values ('Débito')
insert into permissao (nome, descricao) values ('cozinheiro', 'pleno')
insert into permissao (nome, descricao) values ('caixa', 'Junior')
insert into permissao (nome, descricao) values ('Gerente', 'Senior')
insert into estado (nome) values ('SP')
insert into estado (nome) values ('SC')
insert into estado (nome) values ('PR')
insert into estado (nome) values ('BH')
insert into cidade (nome, estado_id) values ('São Paulo', 1)
insert into cidade (nome, estado_id) values ('Florianópolis', 2)
insert into cidade (nome, estado_id) values ('curitiba', 3)
insert into cidade (nome, estado_id) values ('Belo Horizonte', 4)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logadouro, endereco_numero, endereco_complemento, endereco_bairro) values ('Coxinhas Prime', '10', 1, now(), now(), 1, '06551-060', 'Rua Antonio julio dos Santos', '201', 'AP 501 bl5', 'paraisópolis')
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Pizzas Hut', '9.50', 2, now(), now())
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Zé do Churras', '15', 3, now(), now())
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3)
