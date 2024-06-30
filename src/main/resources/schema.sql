DROP TABLE IF EXISTS Run;

CREATE TABLE IF NOT EXISTS Run (
   id INT NOT NULL,
   title varchar(250) NOT NULL,
   start_time timestamp NOT NULL,
   end_time timestamp NOT NULL,
   miles INT NOT NULL,
   location varchar(10) NOT NULL,
   version INT,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS my_user;

CREATE TABLE IF NOT EXISTS my_user (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    version INT
);