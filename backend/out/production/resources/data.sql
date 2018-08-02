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

INSERT INTO user(blocked, email, password, username) VALUES (false, 'dnml@gmail.com', 'danilino', 'danila');

INSERT INTO survey_privacy(privacy_type) VALUES ('PUBLIC');
INSERT INTO survey_privacy(privacy_type) VALUES ('PRIVATE');

INSERT INTO survey_status(status_type) VALUES ('CLOSE');
INSERT INTO survey_status(status_type) VALUES ('OPEN');

<<<<<<< HEAD
INSERT INTO survey(creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '2');
INSERT INTO survey(creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '2');
INSERT INTO survey(creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '2');


INSERT INTO question(is_required, title, type, survey_id) VALUES (true ,'title', 'singlechoice', '1');
INSERT INTO question(is_required, title, type, survey_id) VALUES (true ,'title', 'singlechoice', '1');
=======
--INSERT INTO survey(id, creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('1', '2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '1');
--INSERT INTO survey(id, creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('2', '2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '1');
--INSERT INTO survey(id, creation_date, description, expiration_date, title, survey_privacy, survey_status, user_id) VALUES ('3', '2018-08-08', 'description', '2018-08-09', 'title', '1', '1', '1');
--
--INSERT INTO question(id, is_required, title, type, survey_id) VALUES ('1', true ,'title', 'singlechoice', '1');
--INSERT INTO question(id, is_required, title, type, survey_id) VALUES ('2', true ,'title', 'singlechoice', '1');
--
--INSERT INTO choices(id, text, result, question_id) VALUES ('1', 'choice1', '0', '1');
--INSERT INTO choices(id, text, result, question_id) VALUES ('2', 'choice2', '0', '1');
>>>>>>> 6f3d45c8110e99da6544ac1e88c9b798850f0e6f

INSERT INTO choices(text, result, question_id) VALUES ('choice1', '0', '1');
INSERT INTO choices(text, result, question_id) VALUES ('choice2', '0', '1');


