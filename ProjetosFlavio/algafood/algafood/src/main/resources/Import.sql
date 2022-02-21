insert into cozinha (nome) values ('tailandeza');
insert into cozinha (nome) values ('Chinesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Brasileira');

insert into forma_pagamento (descricao) values ('pix');
insert into forma_pagamento (descricao) values ('Crédito');
insert into forma_pagamento (descricao) values ('Débito');

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



insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Coxinhas Prime', '10', 1, 1)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Pizzas Hut', '9.50', 2, 1)
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Zé do Churras', '15', 3, 3)