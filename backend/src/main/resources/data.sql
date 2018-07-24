INSERT INTO role(type) VALUES ('ROLE_ADMIN');
INSERT INTO role(type) VALUES ('ROLE_USER');

-- Check if admin already exists if not create new and limit to one
INSERT INTO user (blocked, email, password, username)
SELECT * FROM (SELECT false, 'admin@example.com', 'admin123', 'admin') AS tmp
WHERE NOT EXISTS (
SELECT username FROM user WHERE username='admin'
) LIMIT 1;

-- Ignore if role is already added to admin
INSERT IGNORE INTO user_roles(user_id, role_id) VALUES(1, 1);
INSERT IGNORE INTO user_roles(user_id, role_id) VALUES(1, 2);


