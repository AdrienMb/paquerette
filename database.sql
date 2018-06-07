CREATE TABLE IF NOT EXISTS job (
job_id SERIAL PRIMARY KEY NOT NULL,
job_name char(200) NULL
);

CREATE TABLE IF NOT EXISTS parcours (
parcours_id SERIAL PRIMARY KEY NOT NULL,
parcours_name char(200) NULL,
parcours_link_isep TEXT NULL
);

CREATE TABLE IF NOT EXISTS domaine (
domaine_id SERIAL PRIMARY KEY NOT NULL,
domaine_name char(200) NULL
);

CREATE TABLE IF NOT EXISTS module (
module_id SERIAL PRIMARY KEY NOT NULL,
module_name char(200) NULL,
module_description text NULL
);

CREATE TABLE IF NOT EXISTS job_parcours (
job_id INT NOT NULL,
parcours_id INT NOT NULL,
PRIMARY KEY (job_id, parcours_id),
CONSTRAINT fk_job FOREIGN KEY (job_id) REFERENCES job (job_id),
CONSTRAINT fk_parcours FOREIGN KEY (parcours_id) REFERENCES parcours (parcours_id)
);

CREATE TABLE IF NOT EXISTS job_domaine (
job_id INT NOT NULL,
domaine_id INT NOT NULL,
PRIMARY KEY (job_id, domaine_id),
CONSTRAINT fk_job FOREIGN KEY (job_id) REFERENCES job (job_id),
CONSTRAINT fk_domaine FOREIGN KEY (domaine_id) REFERENCES domaine (domaine_id)
);

CREATE TABLE IF NOT EXISTS module_parcours (
module_id INT NOT NULL,
parcours_id INT NOT NULL,
PRIMARY KEY (module_id, parcours_id),
CONSTRAINT fk_module FOREIGN KEY (module_id) REFERENCES module (module_id),
CONSTRAINT fk_parcours FOREIGN KEY (parcours_id) REFERENCES parcours (parcours_id)
);

CREATE TABLE IF NOT EXISTS "user" (
user_id SERIAL PRIMARY KEY NOT NULL,
user_name char(30) NULL,
user_password varchar(30) NULL,
);

INSERT INTO "user" (user_name) VALUES ('dylan');
INSERT INTO "user" (user_password) VALUES ('1234');

INSERT INTO job (job_name) VALUES ('dev');
INSERT INTO job (job_name) VALUES ('devops');
INSERT INTO job (job_name) VALUES ('teacher');

INSERT INTO domaine (domaine_name) VALUES ('Electronique');
INSERT INTO domaine (domaine_name) VALUES ('Informatique');
INSERT INTO domaine (domaine_name) VALUES ('Commercial');

INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur logiciel', 'https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-logiciel/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur numérique et santé', 'https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-numerique-et-sante/');

INSERT INTO module (module_name, module_description) VALUES ('Techno web', 'Etudier les technologies avec des technologies Java');
INSERT INTO module (module_name, module_description) VALUES ('Génie logiciel', 'Travailler la gestion de projet agile');

INSERT INTO job_parcours (job_id, parcours_id) VALUES ('1', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('1', '2');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('2', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('3', '2');

INSERT INTO job_domaine (job_id, domaine_id) VALUES ('3', '1');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('1', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('2', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('3', '3');

INSERT INTO module_parcours (module_id, parcours_id) VALUES ('1', '1');
INSERT INTO module_parcours (module_id, parcours_id) VALUES ('2', '1');
INSERT INTO module_parcours (module_id, parcours_id) VALUES ('2', '2');
