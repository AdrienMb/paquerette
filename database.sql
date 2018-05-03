IF db_id('paquerette') IS NULL 
    CREATE DATABASE paquerette

GO

CREATE TABLE IF NOT EXISTS Job (
job_id int NOT NULL AUTO INCREMENT,
job_name char(20) NULL, 
PRIMARY KEY (job_id) 
);
