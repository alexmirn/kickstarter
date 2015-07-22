DROP TABLE "quote" CASCADE;
DROP TABLE "category" CASCADE;
DROP TABLE "project" CASCADE;
DROP TABLE "users" CASCADE;


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
    user_name VARCHAR(30) NOT NULL
);

ALTER TABLE "users"
 ADD CONSTRAINT unique_user_id UNIQUE (user_id);
ALTER TABLE "users"
 ADD CONSTRAINT unique_user_login UNIQUE (user_login);

ALTER TABLE "project" ADD CONSTRAINT "fk_category_project_id" 
FOREIGN KEY ("category_id") REFERENCES "category" ("category_id");

ALTER TABLE "project" ADD CONSTRAINT "fk_users_project_id"
FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

INSERT INTO "quote" (quote_name) VALUES
('Impossible is nothing'),
('Smile makes you better'),
('Just do it!!!');

INSERT INTO "category" (category_name) VALUES
('Medicine'),
('Music');

INSERT INTO "users" (user_login, user_password, user_email, user_name) VALUES
('admin', 'admin', 'alex_mirn@ukr.net', 'admin_name'),
('user', 'user', 'alexmirn2@gmail.com', 'user_name'),
('user1', 'user1', 'alexmirn2@gmail.com', 'user_name1');


INSERT INTO "project" (project_name, project_description, project_total_sum,
project_pledged, project_days_left, category_id, user_id) VALUES
('Alco Tester', 'Phenomenal alco test just by scanning your eyes', 
50000, 23000, 15, 1, 1),
('Eyes training device', 'Get 100% sight', 100000, 15000, 24, 1, 1),
('Sing Melody','Sing melody and hear how it sounds in different musical instruments', 
15000, 22000, 110, 2, 2);

UPDATE "project" SET project_video_link="www.glaz.ua" WHERE project_id=2;

select project_id, project.category_id, category.category_name, 
project_name, project_description, 
project_total_sum, project_pledged, project_days_left, 
project_history, project_video_link 
from project
natural join category
order by project_id;


select project_id, project.category_id, 
category.category_name, project_name, 
project_description, project_total_sum, 
project_pledged, project_days_left, 
project_history, project_video_link 
from project
natural join category
where project_id = 2;