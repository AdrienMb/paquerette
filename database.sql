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

CREATE TABLE IF NOT EXISTS prerequis (
prerequis_id SERIAL PRIMARY KEY NOT NULL,
prerequis_name char(200) NULL,
typeEvaluation text NOT NULL,
requis INT NOT NULL
);

CREATE TABLE IF NOT EXISTS module_prerequis (
module_id INT NOT NULL,
prerequis_id INT NOT NULL,
PRIMARY KEY (module_id, prerequis_id),
CONSTRAINT fk_module FOREIGN KEY (module_id) REFERENCES module (module_id),
CONSTRAINT fk_prerequis FOREIGN KEY (prerequis_id) REFERENCES prerequis (prerequis_id)
);


