    create table item_pedido (
       id bigint not null auto_increment,
        obervacao varchar(255),
        preco_total decimal(19,2) not null,
        preco_unitario decimal(19,2) not null,
        quantidade integer not null,
        pedido_id bigint not null,
        produto_id bigint not null,
        primary key (id)
    ) engine=InnoDB
	;

    create table pedido (
       id bigint not null auto_increment,
        data_cancelamento datetime,
        data_confirmacao datetime,
        data_criacao datetime not null,
        data_entrega datetime,
        endereco_bairro varchar(255) not null,
        endereco_cep varchar(255) not null,
        endereco_complemento varchar(255),
        endereco_logadouro varchar(255) not null,
        endereco_numero varchar(255) not null,
        sub_total decimal(19,2) not null,
        taxa_frete decimal(19,2) not null,
        valor_total decimal(19,2) not null,
        usuario_cliente_id bigint not null,
        endereco_cidade_id bigint not null,
        forma_pagamento_id bigint not null,
        restaurante_id bigint not null,
        primary key (id)
    ) engine=InnoDB
	;

    
    alter table item_pedido 
       add constraint FKitem_pedido_pedido 
       foreign key (pedido_id) 
       references pedido (id)
	;
	
    alter table item_pedido 
       add constraint FKitem_pedido_produto 
       foreign key (produto_id) 
       references produto (id)
	;
	
    alter table pedido 
       add constraint FKpedido_usuario_cliente 
       foreign key (usuario_cliente_id) 
       references usuario (id)
	;
	
    alter table pedido
       add constraint FKpedido_endereco_cidade 
       foreign key (endereco_cidade_id) 
       references cidade (id)
	;

    alter table pedido 
       add constraint FKpedido_forma_pagamento 
       foreign key (forma_pagamento_id) 
       references forma_pagamento (id)
	;

    alter table pedido 
       add constraint FKpedido_restaurante 
       foreign key (restaurante_id) 
       references restaurante (id)
	;