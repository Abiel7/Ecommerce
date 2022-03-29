create schema if not exists ecomm;

create table if not exists ecomm.product (
    id uuid not null ,
    name varchar(56) not null,
    description varchar(200),
    price numeric(16,4) default 0 not null,
    count numeric(8,0),
    image_url  varchar(40),
    primary key (id)
);

create table if not exists ecomm.tag
(
    id   uuid not null ,
    name varchar(20),
    primary key (id)

);

create table if not exists ecomm.product_tag (
    product_id uuid not null ,
    tag_id uuid not null,
    foreign key (product_id) references product(id),
    foreign key (tag_id) references  tag(id)
);

insert into ecomm.product values ('6d62d909-f957-430e-8689-b5129c0bb75e', 'Antifragile', 'Antifragile - Things that gains from disorder. By Nassim Nicholas Taleb', 17.15, 33, '/images/Antifragile.jpg');
insert into ecomm.product values ('a0a4f044-b040-410d-8ead-4de0446aec7e', 'The Alchemist', 'The Alchemist - A journey through the world of pure imagination. By Paulo Coelho', 17.15, 33, '/images/TheAlchemist.jpg');



