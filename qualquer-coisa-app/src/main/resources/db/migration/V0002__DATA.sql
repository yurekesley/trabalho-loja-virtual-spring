INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'YURE');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'KESLEY');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'MOREIRA');
INSERT INTO TBL_CLIENTES (id, nome) VALUES(nextval ('clientes_id_seq'), 'PLÁCIDO');

INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'CD DREAM THEATER', 20.00);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'CAMISA REAL MADRID', 15.00);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'PILHA PALITO', 0.85);
INSERT INTO TBL_PRODUTOS (id, nome, valor) VALUES(nextval ('produtos_id_seq'), 'SAPATO NIKE', 400.00);

INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 1);
INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 1);
INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 1);
INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 1);

INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 2);
INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 2);
INSERT INTO TBL_ITEM_ESTOQUE (id, produto_id) VALUES (nextval ('item_estoque_id_seq'), 3);

