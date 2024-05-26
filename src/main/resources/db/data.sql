--------------------
-- idStrategy tables
--------------------
INSERT INTO SIMPLE_CRUD_AUTO_ID (NAME) VALUES ('simple entity pre inserted with auto id');


--------------------------
-- createRepository tables
--------------------------
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',1,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',2,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',3,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',4,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',5,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',6,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',7,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',8,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',9,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('A',10,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',1,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',2,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',3,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',4,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',5,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',6,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',7,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',8,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',9,'SAME');
INSERT INTO PAGEABLE_AND_SORTABLE (DISCRIMINATOR, NUMBER, COMMON) VALUES ('B',10,'SAME');



---------------------------
-- defineQueryMethod tables
---------------------------
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Aldric',1,'2023-05-01','NONE');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Andy',2,'2022-05-01','NONE');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Marc',18,'2004-05-01','STUDENT');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Luc',19,'2003-02-01','STUDENT');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Maria',20,'2002-03-06','STUDENT');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Alex',21,'2001-08-06','STUDENT');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Maria',21,'2001-10-10','STUDENT');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Frank',38,'1984-09-08','DOCTOR');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Maria',42,'1980-10-10','DIRECTOR');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Laura',72,'1950-10-10','PENSION');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Chris',73,'1949-10-10','PENSION');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Igor',74,'1948-10-10','PENSION');
INSERT INTO QUERY_BY_METHOD (NAME, AGE, BIRTH_DATE, JOB) VALUES ('Matusalemme',969 ,'1053-01-01','PENSION');

INSERT INTO PROPERTY_EXPRESSIONS_ROOT (ID, NAME) VALUES (1,'Aldric');
INSERT INTO PROPERTY_EXPRESSIONS_NESTED (ID, PROPERTY_EXPRESSIONS_ROOT, ADDRESS) VALUES (1,1,'Boulevard General Louis');



