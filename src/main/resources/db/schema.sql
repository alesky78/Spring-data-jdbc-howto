--Create the table at the startup of the DB

--------------------
-- simplecrud
--------------------
CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_AUTO_ID (
   ID IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_MANUAL_ID (
   ID IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (id)
);
