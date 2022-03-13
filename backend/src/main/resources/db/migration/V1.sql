CREATE SCHEMA IF NOT EXISTS ecomm


CREATE TABLE IF NOT  EXISTS ecomm.cart (
    id uuid NOT NULL,
    user_id uuid NOT NULL,
    primary key (id),
    foreign key (user_id) references ecomm.user(id)
)

CREATE TABLE IF NOT EXISTS ecomm.cart.item(
    cart_id uuid NOT null,
    item_id uuid NOT null,
    foreign key (cart_id) references ecomm.cart
    foreign  key (item_id) references ecomm.Item

)
CREATE TABLE ID NOT EXISTS ecomm.Item (

)