INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'YURE');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'KESLEY');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'MOREIRA');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'PLÁCIDO');

INSERT INTO TBL_ESTOQUE (id, localizacao) VALUES(nextval ('estoque_id_seq'), 'SEDE');
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'CD DREAM THEATER', 20.00);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'CAMISA REAL MADRID', 15.00);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'PILHA PALITO', 0.85);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'SAPATO NIKE', 400.00);

INSERT INTO TBL_ITEM_ESTOQUE (id, estoque_id, produto_id, quantidade) VALUES (nextval ('item_estoque_id_seq'), 1, 1, 51);
INSERT INTO TBL_ITEM_ESTOQUE (id, estoque_id, produto_id, quantidade) VALUES (nextval ('item_estoque_id_seq'), 1, 2, 12);
INSERT INTO TBL_ITEM_ESTOQUE (id,estoque_id, produto_id, quantidade) VALUES (nextval ('item_estoque_id_seq'), 1, 3, 14);
INSERT INTO TBL_ITEM_ESTOQUE (id,estoque_id, produto_id, quantidade) VALUES (nextval ('item_estoque_id_seq'), 1, 4, 3);


