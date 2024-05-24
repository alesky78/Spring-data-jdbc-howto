--Create the table at the startup of the DB

--------------------
-- simplecrud
--------------------

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_AUTO_ID (
   id IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_MANUAL_ID_BY_CALL_BACK (
   id varchar(250) NOT NULL,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (id)
);
