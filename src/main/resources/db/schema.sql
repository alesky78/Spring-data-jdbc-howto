--Create the table at the startup of the DB

--------------------
-- idStrategy tables
--------------------

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_AUTO_ID (
   ID IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_MANUAL_ID_BY_CALL_BACK (
   ID varchar(250) NOT NULL,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_MANUAL_ID_BY_PERSISTABLE (
   ID varchar(250) NOT NULL,
   NAME varchar(250) NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SIMPLE_CRUD_VERSIONED (
   ID IDENTITY NOT NULL PRIMARY KEY,
   NAME varchar(250) NOT NULL,
   VERSION INTEGER,
   PRIMARY KEY (ID)
);

--------------------------
-- createRepository tables
--------------------------

CREATE TABLE IF NOT EXISTS PAGEABLE_AND_SORTABLE (
   ID IDENTITY NOT NULL PRIMARY KEY,
   DISCRIMINATOR varchar(250) NOT NULL,
   NUMBER INTEGER,
   PRIMARY KEY (ID)
);

