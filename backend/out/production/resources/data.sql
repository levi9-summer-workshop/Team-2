INSERT INTO role(type) VALUES ('ROLE_ADMIN');
INSERT INTO role(type) VALUES ('ROLE_USER');

INSERT INTO user(id, email,password,username,blocked) VALUES (1, 'admin@example.com','admin','admin', false);

INSERT INTO user_roles(user_id, role_id) VALUES(1, 1);