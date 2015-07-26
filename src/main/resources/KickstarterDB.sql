DROP TABLE "quote" CASCADE;
DROP TABLE "category" CASCADE;
DROP TABLE "project" CASCADE;
DROP TABLE "users" CASCADE;
DROP TABLE "question" CASCADE;
DROP TABLE "answer" CASCADE;
DROP TABLE "userrole" CASCADE;


CREATE TABLE "quote" (
    "quote_id" SERIAL PRIMARY KEY,
    "quote_name" text
);

CREATE TABLE "category" (
    "category_id" SERIAL PRIMARY KEY,
    "category_name" varchar(255)
);

CREATE TABLE "project" (
    "project_id" SERIAL PRIMARY KEY,
    "project_name" varchar(255),
    "project_description" text,
    "project_total_sum" integer,
    "project_pledged" integer,
    "project_days_left" integer,
    "project_history" text,
    "project_video_link" varchar(255),
    "category_id" integer,
    "user_id" integer
);

CREATE TABLE "users"
(
    user_id SERIAL PRIMARY KEY NOT NULL,
    user_login VARCHAR(15) NOT NULL,
    user_password VARCHAR(15) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    userrole_id INTEGER
);

CREATE TABLE "question"
(
    "question_id" SERIAL PRIMARY KEY,
    "question_name" text,
    "project_id" INTEGER ,
    "user_id" INTEGER
);

CREATE TABLE "answer" (
    "answer_id" SERIAL PRIMARY KEY,
    "answer_name" text,
    "user_id" INTEGER ,
    "question_id" INTEGER
);

CREATE TABLE "userrole" (
    "userrole_id" SERIAL PRIMARY KEY,
    "userrole_name" text
);

ALTER TABLE "users"
 ADD CONSTRAINT unique_user_id UNIQUE (user_id);
ALTER TABLE "users"
 ADD CONSTRAINT unique_user_login UNIQUE (user_login);

ALTER TABLE "project" ADD CONSTRAINT "fk_category_project_id" 
FOREIGN KEY ("category_id") REFERENCES "category" ("category_id");

ALTER TABLE "project" ADD CONSTRAINT "fk_users_project_id"
FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "question" ADD CONSTRAINT "fk_project_question_id"
FOREIGN KEY ("project_id") REFERENCES "project" ("project_id");

ALTER TABLE "question" ADD CONSTRAINT "fk_users_question_id"
FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "answer" ADD CONSTRAINT "fk_users_answer_id"
FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "answer" ADD CONSTRAINT "fk_question_answer_id"
FOREIGN KEY ("question_id") REFERENCES "question" ("question_id");

ALTER TABLE "users" ADD CONSTRAINT "fk_userrole_users_id"
FOREIGN KEY ("userrole_id") REFERENCES "userrole" ("userrole_id");

INSERT INTO "quote" (quote_name) VALUES
('Impossible is nothing'),
('Smile makes you better'),
('Just do it!!!');

INSERT INTO "category" (category_name) VALUES
('Medicine'),
('Music');

INSERT INTO "userrole" (userrole_name) VALUES
('ADMIN_ROLE'),
('USER_ROLE');

INSERT INTO "users" (user_login, user_password, user_email, user_name, userRole_id) VALUES
('admin', 'admin', 'alex_mirn@ukr.net', 'admin_name', 1),
('user', 'user', 'alexmirn2@gmail.com', 'user_name', 2),
('user1', 'user1', 'alexmirn2@gmail.com', 'user_name1', 2);

INSERT INTO "project" (project_name, project_description, project_total_sum,
project_pledged, project_days_left, category_id, user_id, project_history, project_video_link) VALUES
('Alco Tester', 'Phenomenal alco test just by scanning your eyes', 
50000, 23000, 15, 1, 1, 'far-far away an alco test was', 'https://www.youtube.com/watch?v=UA6C_0ERHww'),
('Eyes training device', 'Get 100% sight', 100000, 15000, 24, 1, 1, 'I was always in glasses', 'https://www.youtube.com/watch?v=TpurRoigVmg'),
('Sing Melody','Sing melody and hear how it sounds in different musical instruments', 
15000, 22000, 110, 2, 2, 'I love to sing', 'https://www.youtube.com/watch?v=f4Mc-NYPHaQ');

INSERT INTO "question" (question_name, project_id, user_id) VALUES
('question1', 1, 1),
('question2', 2, 1),
('question3', 3, 2);


INSERT INTO "answer" (answer_name, user_id, question_id) VALUES
('answer1', 2, 1),
('answer2', 2, 2),
('answer3', 1, 3);
