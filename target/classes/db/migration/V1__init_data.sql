create table categories(id bigserial primary key, title varchar(255));
insert into categories(title)
values
('Foods'),
('Electronics'),
('Clothing');

create table products(id bigserial primary key, title varchar(255), price decimal, category_id bigint references categories(id));
insert into products(title, price, category_id)
values
('Cola', 120.99, 1),
('Fanta', 110.45, 1),
('Sprite', 112.33, 1),
('Beef', 432.99, 1),
('Cheese', 123.44, 1),
('Fresh Green Bell Pepper', 443.44, 1),
('Laptop', 87000.89, 2),
('TV', 45654.00, 2),
('Home audio', 12000.24, 2),
('Camera', 19543.65, 2),
('Cell phone', 10456.49, 2),
('Headphone', 2000.54, 2),
('Jeans', 3000.98, 3),
('T-Shirt', 1045.45, 3),
('Polo', 3654.76, 3),
('Shorts', 900.12, 3);