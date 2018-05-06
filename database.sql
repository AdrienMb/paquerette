CREATE TABLE IF NOT EXISTS job (
job_id SERIAL PRIMARY KEY NOT NULL,
job_name char(200) NULL
);

CREATE TABLE IF NOT EXISTS parcours (
parcours_id SERIAL PRIMARY KEY NOT NULL,
parcours_name char(200) NULL,
parcours_link_isep TEXT NULL
);

CREATE TABLE IF NOT EXISTS job_parcours (
job_id INT NOT NULL,
parcours_id INT NOT NULL
);
