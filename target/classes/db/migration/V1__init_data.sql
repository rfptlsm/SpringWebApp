create table categories(id bigserial primary key, title varchar(255));
insert into categories(title)
values
('Food'),
('Electronic');

create table products(id bigserial primary key, title varchar(255), price int, category_id bigint references categories(id));
insert into products(title, price, category_id)
values
('Cola', 120, 1),
('Fanta', 110, 1),
('Sprite', 112, 1);