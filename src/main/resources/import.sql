-- pizze --
INSERT INTO pizzas (description, image, name, price) VALUES('pizza alle olive', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSi33D1miY2Chid2uyluVai6ump0cjXR5KbX8l0V9xNJA&s', 'pizza olive', 10.5);
INSERT INTO pizzas (description, image, name, price) VALUES('pizza classica senza niente', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1DpyNFHhc1ULvK1iH8d7CnFnqFVQgpsbFcqZJ5i5E8A&s', 'pizza margherita', 7.5);
INSERT INTO pizzas (description, image, name, price) VALUES('pizza con melanzane, zucchine e funghi', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1eMdIC8SmlfyKnY91AAvijv_aNGi3I4n7NG6wLPYZG8Xb_iD9Lhkgad5f2-lMOy5DARE&usqp=CAU', 'pizza boscaiola', 7.5);
INSERT INTO pizzas (description, image, name, price) VALUES('pizza carciofi, olive e funghi', 'https://pizzeriaborgoclio.com/wp-content/uploads/2021/03/01_pizze-33-cm_0096-web.gif', 'pizza montagnina', 7.5);



-- ingredienti --

INSERT INTO ingredients (name) VALUES('pomodoro');
INSERT INTO ingredients (name) VALUES('olive');
INSERT INTO ingredients (name) VALUES('funghi');
INSERT INTO ingredients (name) VALUES('peperoni');
INSERT INTO ingredients (name) VALUES('salsiccia');



-- offerte --

INSERT INTO offers (end_offer, start_offer, title, pizza_id) VALUES('2023-11-10', '2023-10-10', 'offertona', 2);
INSERT INTO offers (end_offer, start_offer, title, pizza_id) VALUES('2023-11-9', '2023-10-15', 'offertona 2', 1);



-- pizza_ingredienti --

INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(1, 2);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(1, 1);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(1, 5);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(2, 3);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(2, 2);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(3, 4);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(3, 1);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(3, 5);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(4, 2);
INSERT INTO pizzas_ingredients (pizzas_id, ingredients_id) VALUES(4, 3);



-- user --

INSERT INTO users (id, email, first_name, last_name, password) VALUES(1, 'pippo@mail.com', 'pippo', 'doggies', '{noop}pippo');
INSERT INTO users (id, email, first_name, last_name, password) VALUES(2, 'paperino@mail.com', 'paperino', 'paperis', '{noop}paperino');


-- role --

INSERT INTO roles (id, name) VALUES(1, 'user');
INSERT INTO roles (id, name) VALUES(2, 'admin');

-- role_user --

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);