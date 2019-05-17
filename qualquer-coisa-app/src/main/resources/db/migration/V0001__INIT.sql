CREATE TABLE TBL_CLIENTES (
	ID int8 NOT NULL,
	NOME varchar(255) NOT NULL,
	CONSTRAINT TBL_CLIENTES_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_ESTOQUE (
	ID int8 NOT NULL,
	LOCALIZACAO varchar(255) NOT NULL,
	CONSTRAINT TBL_ESTOQUE_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_PRODUTOS (
	ID int8 NOT NULL,
	NOME varchar(255) NULL,
	VALOR float8 NULL,
	CONSTRAINT TBL_PRODUTOS_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
);

CREATE TABLE TBL_PEDIDOS (
	ID int8 NOT NULL,
	STATUS varchar(255) NULL,
	CLIENTE_ID int8 NOT NULL,
	CONSTRAINT TBL_PEDIDOS_PKEY PRIMARY KEY (ID))
WITH (
	OIDS=FALSE
);

CREATE TABLE TBL_ITEM(
	ID int8 NOT NULL,
	QUANTIDADE int4 NULL,
	PEDIDO_ID int8 NULL,
	PRODUTO_ID int8 NULL,
	CONSTRAINT PEDIDO_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
);

WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_REPOSICOES (
	ID int8 NOT NULL,
	STATUS varchar(255) NULL,
	CONSTRAINT TBL_REPOSICOES_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
) ;
       
CREATE SEQUENCE clientes_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE pedidos_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE estoque_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE item_pedido_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE produtos_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE reposicoes_id_seq
NO MINVALUE
NO MAXVALUE;
