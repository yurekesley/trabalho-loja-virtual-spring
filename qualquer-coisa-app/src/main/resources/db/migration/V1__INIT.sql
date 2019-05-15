CREATE TABLE loja.tbl_clientes (
	id int8 NOT NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT tbl_clientes_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;


CREATE TABLE loja.tbl_estoque (
	id int8 NOT NULL,
	CONSTRAINT tbl_estoque_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE loja.tbl_pedidos (
	id int8 NOT NULL,
	status varchar(255) NULL,
	cliente_id int8 NOT NULL,
	CONSTRAINT tbl_pedidos_pkey PRIMARY KEY (id),
	CONSTRAINT fk37aqxfco7o7ywtfuww99xvels FOREIGN KEY (cliente_id) REFERENCES loja.tbl_clientes(id)
)
WITH (
	OIDS=FALSE
) ;



CREATE TABLE loja.tbl_produtos (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	valor float8 NULL,
	CONSTRAINT tbl_produtos_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;


CREATE TABLE loja.tbl_reposicoes (
	id int8 NOT NULL,
	status varchar(255) NULL,
	CONSTRAINT tbl_reposicoes_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE loja.tbm_item_pedido (
	id int8 NOT NULL,
	quantidade int4 NULL,
	poduto_id int8 NULL,
	CONSTRAINT tbm_item_pedido_pkey PRIMARY KEY (id),
	CONSTRAINT fkpobyd6b1x8xycfaom8ka0k6xa FOREIGN KEY (poduto_id) REFERENCES loja.tbl_produtos(id)
)
WITH (
	OIDS=FALSE
) ;

