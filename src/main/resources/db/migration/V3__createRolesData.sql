INSERT INTO roles (name) VALUES ('ROLE_User');
INSERT INTO roles (name) VALUES ('ROLE_Admin');

INSERT INTO roles_has_users (user_id, role_id) VALUES (1, 1);
INSERT INTO roles_has_users (user_id, role_id) VALUES (1, 2);
INSERT INTO roles_has_users (user_id, role_id) VALUES (2, 1);