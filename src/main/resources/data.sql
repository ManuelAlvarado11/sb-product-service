INSERT INTO tbl_categories (id, name) VALUES (4, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (5, 'books');
INSERT INTO tbl_categories (id, name) VALUES (6, 'electronics');

INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (4, 'adidas Cloudfoam Ultimate','Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',1);

INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (5, 'under armour Men ''s Micro G Assert – 7','under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',1);


INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (6, 'Spring Boot in Action','under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);