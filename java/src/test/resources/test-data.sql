BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','password123','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','password456','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','password789','ROLE_USER');

COMMIT TRANSACTION;
