INSERT INTO privileges(privilege) VALUES ('CUSTOMER');
INSERT INTO privileges(privilege) VALUES ('ADMIN');
INSERT INTO privileges(privilege) VALUES ('WAREHOUSE_MANAGER');


INSERT INTO users(name, email, phone, password, active) VALUES ('Maria Granados', 'mariafgrana2@gmail.com', '8120403291', 'passWORD24', 1);
INSERT INTO users(name, email, phone, password, active) VALUES ('Fernanda Arreguin', '2206mariferga@gmail.com', '8120204040', 'passWORD24', 0);


INSERT INTO user_has_privilege(user_user_id, privileges_id) VALUES (1, 1);
INSERT INTO user_has_privilege(user_user_id, privileges_id) VALUES (1, 2);


INSERT INTO categories(name_category) VALUES ('ropa deportiva');
INSERT INTO categories(name_category) VALUES ('equpamiento básico');
INSERT INTO categories(name_category) VALUES ('accesorios');
INSERT INTO categories(name_category) VALUES ('productos de recuperación');


INSERT INTO products(name, description, price, image_url, stock, pieces, fk_category_id) VALUES ('Conjunto Running Black', 'Conjunto deportivo Black de dos piezas para correr', 449.00, '/public/imgs/set-negro.png', 12, 2, 1 );
INSERT INTO products(name, description, price, image_url, stock, pieces, fk_category_id) VALUES ('Kit entrenamiento en casa', 'Incluye liga y banda de baja resistencia, par de mancuernas de 3 kg y pesa rusa de 8 kg', 399.00, '/public/imgs/kit-basico.png', 20, 3, 3 );

INSERT INTO status(statuses) VALUES ('en proceso');
INSERT INTO status(statuses) VALUES ('entrega realizada');

INSERT INTO orders(fk_user_id, fk_status_id, total, order_date) VALUES ( 1, 1, 449.00, '2024-11-08T11:13:14');
INSERT INTO orders(fk_user_id, fk_status_id, total, order_date) VALUES ( 1, 2, 449.00, '2024-11-08T11:13:14');
INSERT INTO orders(fk_user_id, fk_status_id, total, order_date) VALUES ( 1, 1, 399.00, '2024-11-08T11:13:14');
INSERT INTO orders(fk_user_id, fk_status_id, total, order_date) VALUES ( 1, 2, 399.00, '2024-11-08T11:13:14');

INSERT INTO order_has_products(order_id, product_id, quantity, order_sold) VALUES (1, 1, 1, 449.00);
INSERT INTO order_has_products(order_id, product_id, quantity, order_sold) VALUES (2, 1, 1, 449.00);
INSERT INTO order_has_products(order_id, product_id, quantity, order_sold) VALUES (3, 2, 1, 399.00);
INSERT INTO order_has_products(order_id, product_id, quantity, order_sold) VALUES (4, 2, 1, 399.00);




