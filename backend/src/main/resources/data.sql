
INSERT INTO role(type) VALUES ('ROLE_ADMIN');
INSERT INTO role(type) VALUES ('ROLE_USER');

INSERT INTO user(email,password,username) VALUES ('danilino@mail.com','danila','danilino');
INSERT INTO user(email,password,username) VALUES ('user@gmail.com','useruser','useruser');

INSERT INTO user_roles(user_id,role_id)VALUES(1, 1);
INSERT INTO user_roles(user_id,role_id)VALUES(1, 2);
INSERT INTO user_roles(user_id,role_id)VALUES(2, 2);