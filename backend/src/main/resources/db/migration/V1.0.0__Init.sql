create schema if not exists ecomm;

create TABLE IF NOT EXISTS ecomm.product (
	id uuid NOT NULL DEFAULT random_uuid(),
	name varchar(56) NOT NULL,
	description varchar(200),
	price numeric(16, 4) DEFAULT 0 NOT NULL,
	count numeric(8, 0),
	image_url varchar(40),
	PRIMARY KEY(id)
);







insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")), 'book');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f602',"-","")), 'psychology');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f603',"-","")), 'influence');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f604',"-","")), 'wisdom');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f605',"-","")), 'startup');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f606',"-","")), 'investing');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f607',"-","")), 'lessions');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f608',"-","")), 'history');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f609',"-","")), 'howto');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f610',"-","")), 'journey');
insert into ecomm.tag (id, name) values (unhex(replace('b5c6-4896-987c-f30f3678f611',"-","")), 'decision');

insert into ecomm.product_tag values (unhex(replace('6d62d909-f957-430e-8689-b5129c0bb75e',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f602',"-","")));
insert into ecomm.product_tag values (unhex(replace('6d62d909-f957-430e-8689-b5129c0bb75e',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")));
insert into ecomm.product_tag values (unhex(replace('a0a4f044-b040-410d-8ead-4de0446aec7e',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f608',"-","")));
insert into ecomm.product_tag values (unhex(replace('a0a4f044-b040-410d-8ead-4de0446aec7e',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")));
insert into ecomm.product_tag values (unhex(replace('808a2de1-1aaa-4c25-a9b9-6612e8f29a38',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f602',"-","")));
insert into ecomm.product_tag values (unhex(replace('808a2de1-1aaa-4c25-a9b9-6612e8f29a38',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")));
insert into ecomm.product_tag values (unhex(replace('808a2de1-1aaa-4c25-a9b9-6612e8f29a38',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f607',"-","")));
insert into ecomm.product_tag values (unhex(replace('808a2de1-1aaa-4c25-a9b9-6612e8f29a38',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f611',"-","")));
insert into ecomm.product_tag values (unhex(replace('510a0d7e-8e83-4193-b483-e27e09ddc34d',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f602',"-","")));
insert into ecomm.product_tag values (unhex(replace('510a0d7e-8e83-4193-b483-e27e09ddc34d',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")));
insert into ecomm.product_tag values (unhex(replace('510a0d7e-8e83-4193-b483-e27e09ddc34d',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f610',"-","")));
insert into ecomm.product_tag values (unhex(replace('03fef6ac-1896-4ce8-bd69-b798f85c6e0b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f602',"-","")));
insert into ecomm.product_tag values (unhex(replace('03fef6ac-1896-4ce8-bd69-b798f85c6e0b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f603',"-","")));
insert into ecomm.product_tag values (unhex(replace('d3588630-ad8e-49df-bbd7-3167f7efb246',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f604',"-","")));
insert into ecomm.product_tag values (unhex(replace('d3588630-ad8e-49df-bbd7-3167f7efb246',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f607',"-","")));
insert into ecomm.product_tag values (unhex(replace('819e1fbf-8b7e-4f6d-811f-693534916a8b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f605',"-","")));
insert into ecomm.product_tag values (unhex(replace('819e1fbf-8b7e-4f6d-811f-693534916a8b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f606',"-","")));
insert into ecomm.product_tag values (unhex(replace('819e1fbf-8b7e-4f6d-811f-693534916a8b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f607',"-","")));
insert into ecomm.product_tag values (unhex(replace('3395a42e-2d88-40de-b95f-e00e1502085b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f604',"-","")));
insert into ecomm.product_tag values (unhex(replace('3395a42e-2d88-40de-b95f-e00e1502085b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f607',"-","")));
insert into ecomm.product_tag values (unhex(replace('3395a43e-2d88-40de-b95f-e00e1502085b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f611',"-","")));
insert into ecomm.product_tag values (unhex(replace('3395a43e-2d88-40de-b95f-e00e1502085b',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f609',"-","")));
insert into ecomm.product_tag values (unhex(replace('837ab141-399e-4c1f-9abc-bace40296bac',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f609',"-","")));
insert into ecomm.product_tag values (unhex(replace('837ab141-399e-4c1f-9abc-bace40296bac',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f605',"-","")));
insert into ecomm.product_tag values (unhex(replace('837ab141-399e-4c1f-9abc-bace40296bac',"-","")), unhex(replace('b5c6-4896-987c-f30f3678f601',"-","")));


insert into ecomm.users (id, username, password, first_name, last_name, email, phone, user_status) values(unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38222',"-","")), 'test', 'pwd', 'Test', 'User', 'test@user.com', '234234234', 'ACTIVE');
insert into ecomm.users (id, username, password, first_name, last_name, email, phone, user_status) values(unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38223',"-","")), 'test', 'pwd', 'Test2', 'User2', 'test2@user.com', '234234234', 'ACTIVE');
INSERT INTO ecomm.address VALUES (unhex(replace('a731fda1-aaad-42ea-bdbc-a27eeebe2cc0',"-","")), 'oslo','Norway','0988','8989''Oslo','oslo', 'torgrata');
INSERT INTO ecomm.address VALUES (unhex(replace('a731fda1-aaad-42ea-bdbc-a27eeebe2cc0',"-","")), '9I-999', 'Fraser Suites Le Claridge', 'Champs-Elysees', 'Paris', 'Île-de-France', 'France', '75008');

insert into ecomm.user_address values (unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38222',"-","")), unhex(replace('a731fda1-aaad-42ea-bdbc-a27eeebe2cc0',"-","")));
INSERT INTO ecomm.card VALUES (unhex(replace('618ffaff-cbcd-48d4-8848-a15601e6725b',"-","")), '999-999-999-999',unhex(replace( 'a1b9b31d-e73c-4112-af7c-b68530f38222',"-","")), 'User', '12/28', '0000');
insert into ecomm.cart values (unhex(replace('cacab31d-e73c-4112-af7c-b68530f38222',"-","")), unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38222',"-","")));
insert into ecomm.cart values (unhex(replace('cacab31d-e73c-4112-af7c-b68530f38223',"-","")), unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38223',"-","")));
insert into ecomm.item(id,product_id,quantity,unit_price) values(unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad702',"-","")), unhex(replace('6d62d909-f957-430e-8689-b5129c0bb75e',"-","")), 1, 17.15);
insert into ecomm.cart_item values (unhex(replace('cacab31d-e73c-4112-af7c-b68530f38222',"-","")), unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad702',"-","")));
insert into ecomm.item (id,product_id,quantity,unit_price)values(unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad703',"-","")), unhex(replace('d3588630-ad8e-49df-bbd7-3167f7efb246',"-","")), 1, 10.99);
insert into ecomm.cart_item values (unhex(replace('cacab31d-e73c-4112-af7c-b68530f38222',"-","")), unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad703',"-","")));
insert into ecomm.orders(id, customer_id, address_id, card_id, order_date, total, payment_id, shipment_id, status) values (unhex(replace('0a59ba9f-629e-4445-8129-b9bce1985d6a',"-","")),unhex(replace('a1b9b31d-e73c-4112-af7c-b68530f38222',"-","")), unhex(replace('a731fda1-aaad-42ea-bdbc-a27eeebe2cc0',"-","")), unhex(replace('618ffaff-cbcd-48d4-8848-a15601e6725b',"-","")), current_timestamp, 38.14, NULL, NULL, 'CREATED');
INSERT INTO ecomm.item (id,product_id,quantity,unit_price)VALUES
  (unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad704',"-","")), unhex(replace('6d62d909-f957-430e-8689-b5129c0bb75e',"-","")), 1, 17.15),
  (unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad705',"-","")), unhex(replace('3395a42e-2d88-40de-b95f-e00e1502085b',"-","")), 1, 20.99);
INSERT INTO ecomm.order_item VALUES
  (unhex(replace('66682caa-a6d8-46ed-a173-ff822f754e1c',"-","")), unhex(replace('0a59ba9f-629e-4445-8129-b9bce1985d6a',"-","")), unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad704',"-",""))),
  (unhex(replace('efeefa71-2760-412a-9ec8-0a040d90f02c',"-","")), unhex(replace('0a59ba9f-629e-4445-8129-b9bce1985d6a',"-","")), unhex(replace('a7384042-e4aa-4c93-85ae-31a346dad705',"-","")));

