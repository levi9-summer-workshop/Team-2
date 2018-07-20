INSERT INTO role(type) VALUES ('ROLE_ADMIN');
INSERT INTO role(type) VALUES ('ROLE_USER');

INSERT INTO user(email,password,username,blocked) VALUES ('admin@example.com','admin','admin', false);
INSERT INTO user(email,password,username,blocked) VALUES ('danila@example.com','danilino','danila', false);
INSERT INTO user(email,password,username,blocked) VALUES ('viktorija@example.com','cokolino','viktorija', false);

INSERT INTO user_roles(user_id,role_id)VALUES(1, 1);
INSERT INTO user_roles(user_id,role_id)VALUES(1, 2);
INSERT INTO user_roles(user_id,role_id)VALUES(2, 2);
INSERT INTO user_roles(user_id,role_id)VALUES(3, 2);
