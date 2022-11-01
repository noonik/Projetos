    create table cidade (
       id bigint not null auto_increment,
        nome varchar(100),
        estado_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table estado (
       id bigint not null auto_increment,
        nome varchar(60),
        primary key (id)
    ) engine=InnoDB;

    create table forma_pagamento (
       id bigint not null auto_increment,
        descricao varchar(60),
        primary key (id)
    ) engine=InnoDB;

    create table grupo (
       id bigint not null auto_increment,
        nome varchar(60),
        primary key (id)
    ) engine=InnoDB;

    create table grupo_permissao (
       grupo_id bigint not null,
        permissao_id bigint not null
    ) engine=InnoDB;

    create table permissao (
       id bigint not null auto_increment,
        descricao varchar(120),
        nome varchar(60),
        primary key (id)
    ) engine=InnoDB;

    create table produto (
       id bigint not null auto_increment,
        ativo bit not null,
        descricao varchar(120),
        nome varchar(60),
        preco decimal(19,2),
        restaurante_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table restaurante (
       id bigint not null auto_increment,
        data_atualizacao datetime(6) not null,
        data_cadastro datetime(6) not null,
        endereco_bairro varchar(120),
        endereco_cep varchar(10),
        endereco_complemento varchar(120),
        endereco_logadouro varchar(120),
        endereco_numero varchar(120),
        nome varchar(60),
        taxa_frete decimal(19,2) not null,
        cozinha_id bigint not null,
        endereco_cidade_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table restaurante_forma_pagamento (
       restaurante_id bigint not null,
        forma_pagamento_id bigint not null
    ) engine=InnoDB;

    create table usuario (
       id bigint not null auto_increment,
        data_cadastro datetime(6) not null,
        email varchar(60),
        nome varchar(120),
        senha varchar(60),
        primary key (id)
    ) engine=InnoDB;

    create table usuario_grupo (
       usuario_id bigint not null,
        grupo_id bigint not null
    ) engine=InnoDB;

    alter table cidade 
       add constraint FKcidade_estado
       foreign key (estado_id) 
       references estado (id)
    ;

    alter table grupo_permissao 
       add constraint FKgrupo_permissao_permissao
       foreign key (permissao_id) 
       references permissao (id)
	;
       
    alter table grupo_permissao 
       add constraint FKgrupo_permissao_grupo 
       foreign key (grupo_id) 
       references grupo (id)
	;
       
    alter table produto 
       add constraint FKproduto_restaurante
       foreign key (restaurante_id) 
       references restaurante (id)
	;
       	
    alter table restaurante 
       add constraint FKrestaurante_cozinha
       foreign key (cozinha_id) 
       references cozinha (id)
	;
       
    alter table restaurante 
       add constraint FKrestaurante_cidade
       foreign key (endereco_cidade_id) 
       references cidade (id)
	;
       
    alter table restaurante_forma_pagamento 
       add constraint FKrest_form_pagt_form_pagt
       foreign key (forma_pagamento_id) 
       references forma_pagamento (id)
	;
       
    alter table restaurante_forma_pagamento 
       add constraint FKrest_form_pagt_form_rest 
       foreign key (restaurante_id) 
       references restaurante (id)
	;
       
    alter table usuario_grupo 
       add constraint FKusuario_grupo_grupo 
       foreign key (grupo_id) 
       references grupo (id)
	;
	
    alter table usuario_grupo 
       add constraint FKusuario_grupo_usuario
       foreign key (usuario_id) 
       references usuario (id)
    ;   