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
	CONSTRAINT TBL_ESTOQUE_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_PEDIDOS (
	ID int8 NOT NULL,
	STATUS varchar(255) NULL,
	CLIENTE_ID int8 NOT NULL,
	CONSTRAINT TBL_PEDIDOS_PKEY PRIMARY KEY (ID))
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
) ;

CREATE TABLE TBL_REPOSICOES (
	ID int8 NOT NULL,
	STATUS varchar(255) NULL,
	CONSTRAINT TBL_REPOSICOES_PKEY PRIMARY KEY (ID)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_ITEM_PEDIDO (
	ID int8 NOT NULL,
	QUANTIDADE int4 NULL,
	PRODUTO_ID int8 NULL,
	CONSTRAINT TBL_ITEM_PEDIDO_PKEY PRIMARY KEY (ID),
	CONSTRAINT fkpobyd6b1x8xycfaom8ka0k6xa FOREIGN KEY (PRODUTO_ID) REFERENCES TBL_PRODUTOS(ID)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE TBL_ESTOQUE_itens (
	ESTOQUE_ID int8 NOT NULL,
	PRODUTO_ID int8 NOT NULL
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE tbl_reposicoes_itens (
	REPOSICAO_ID int8 NOT NULL,
	PRODUTO_ID int8 NOT NULL
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE tbl_pedidos_itens (
	PEDIDO_ID int8 NOT NULL,
	PRODUTO_ID int8 NOT NULL
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

alter table tbl_pedidos_itens 
       add constraint UK_8nd89xlp0mq7r8vciqaiaf2ed unique (produto_id);

alter table tbl_reposicoes_itens 
       add constraint UK_65qwpix5t44efikin3jgx5152 unique (produto_id); 

alter table tbl_estoque_itens 
       add constraint FK8pc55x9tnxlhpbapne0mys69p 
       foreign key (produto_id) 
       references tbl_produtos;


alter table tbl_estoque_itens 
       add constraint FK8qg499t9cl056ax9whoy9x12t 
       foreign key (estoque_id) 
       references tbl_estoque;
       
  alter table tbl_pedidos 
       add constraint FK37aqxfco7o7ywtfuww99xvels 
       foreign key (cliente_id) 
       references tbl_clientes;
       
alter table tbl_pedidos_itens 
       add constraint FK9hw7wvpa1ye6fcatpfbac5ooy 
       foreign key (produto_id) 
       references tbl_item_pedido;
       
alter table tbl_pedidos_itens 
       add constraint FK84uyauq3jgu7vpljlev41979x 
       foreign key (pedido_id) 
       references tbl_pedidos;
       
   alter table tbl_reposicoes_itens 
       add constraint FK1lul318q06eao6g3a61sq4pqg 
       foreign key (produto_id) 
       references tbl_produtos;
       
 alter table tbl_reposicoes_itens 
       add constraint FK7xs8017yjww3k34i0yag4rvak 
       foreign key (reposicao_id) 
       references tbl_reposicoes;
       
CREATE SEQUENCE produtos_id_seq
NO MINVALUE
NO MAXVALUE;

CREATE SEQUENCE reposicoes_id_seq
NO MINVALUE
NO MAXVALUE;
