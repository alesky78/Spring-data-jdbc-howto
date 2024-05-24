--Create the table at the startup of the DB

--------------------
-- SimpleEntity test
--------------------
CREATE TABLE IF NOT EXISTS SIMPLE_CRUD (
   ID IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (id)
);
