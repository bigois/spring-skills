-- Database seeding for product_groups
INSERT INTO product_groups (id, name) VALUES ('556dafde-1e8f-4a2e-889e-0597e6e3d791', 'Smartphones');
INSERT INTO product_groups (id, name) VALUES ('e9458f39-1e5c-442d-ac8e-315bc84a8a81', 'Notebooks');
INSERT INTO product_groups (id, name) VALUES ('3769bdd7-f5d7-49a1-8005-084587dda9ca', 'Accessories');
INSERT INTO product_groups (id, name) VALUES ('a6d3f25d-05c4-49e4-88ce-74c9a406b013', 'Monitors and Displays');
INSERT INTO product_groups (id, name) VALUES ('dd4da276-7ba2-4a10-b869-810e9726067e', 'Gaming Peripherals');

-- Database seeding for products (with product_group)
INSERT INTO products (id, description, price, type, group_id) VALUES ('8e4a0c22-df8b-48e5-9431-9de01ad5b72c', 'Android Smartphone', 2499.90, 'FP', '556dafde-1e8f-4a2e-889e-0597e6e3d791');
INSERT INTO products (id, description, price, type, group_id) VALUES ('1f2d8db0-4a4e-4a1d-932e-57f6d8b8e9d4', 'Intel i7 Notebook', 4599.00, 'KT', 'e9458f39-1e5c-442d-ac8e-315bc84a8a81');
INSERT INTO products (id, description, price, type, group_id) VALUES ('a7e3cb3e-c31d-4d61-89cf-c291b1acbf9d', 'Bluetooth Headphones', 399.50, 'FP', '3769bdd7-f5d7-49a1-8005-084587dda9ca');
INSERT INTO products (id, description, price, type, group_id) VALUES ('6c9d35cb-bd3c-45e4-9eae-e9f7155e6a4b', '4K Monitor', 1599.90, 'IP', 'a6d3f25d-05c4-49e4-88ce-74c9a406b013');
INSERT INTO products (id, description, price, type, group_id) VALUES ('d4b8c3e5-6781-4f17-9322-3be5392df66f', 'Mechanical Keyboard', 599.00, 'GN', 'dd4da276-7ba2-4a10-b869-810e9726067e');
