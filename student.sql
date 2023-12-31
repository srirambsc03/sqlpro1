CREATE DATABASE XYZ_UNIVERSITY;
USE XYZ_UNIVERSITY;
CREATE TABLE STUDENTS(ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY(ID),F_NAME 
VARCHAR(50),L_NAME VARCHAR(50),AGE INT,GENDER VARCHAR(50),GRADUATION_YEAR 
VARCHAR(50),COURSE_NAME VARCHAR(50),BLOOD_GROUP VARCHAR(50),PERCENTAGE INT);
INSERT INTO STUDENTS (F_NAME,L_NAME,AGE,GENDER,GRADUATION_YEAR,COURSE_NAME,BLOOD_GROUP,PERCENTAGE) VALUES 
("ASHOK","KUMAR",27,"MALE",2018,"BE.EEE","O+",80),
("SURESH","KUMAR",26,"MALE",2016,"BE.ECE","B+",75),
("NAVEEN","KUMAR",26,"MALE",2016,"BE.ECE","B+",75),
("RANJITH","RAJ",28,"MALE",2018,"BE.ECE","O-",90),
("RAKESH","MANI",27,"MALE",2019,"BCA","B+",95),
("KATHIRESAN","RAJA",28,"MALE",2016,"DE.CIVIL","A+",91),
("VIJAYA","RAGAVAN",25,"MALE",2018,"BE.MECH","A-",93),
("DEVA","RAJ",25,"MALE",2020,"BE.CSE","A1+",89),
("VASANTH","KUMAR",27,"MALE",2015,"BBA","O-",86),
("SELVA","KUMAR",24,"MALE",2021,"BE.E&I","AB-",75),
("AGALYA","RAKESH",30,"FEMALE",2014,"B.ED","A+",96),
("SANTHI","KUMARI",23,"FEMALE",2022,"MCA","B-",65),
("ARUL","SELVAM",24,"MALE",2014,"BA","O+",69),
("KUMARESAN","ARUMUGAM",35,"MALE",2008,"BE.ECE","A+",97),
("RAHUL","SHARMA",22,"MALE",2022,"BBA","B+",75),
("SUREKHA","KOWSI",24,"FEMALE",2021,"B.SC","AB-",92),
("SHRUTHI","KUMARI",24,"FEMALE",2019,"BCA","AB+",80),
("RAM","KUMAR",31,"MALE",2023,"BE.MECH","A-",87),
("DEEPIKA","SHARMA",22,"FEMALE",2018,"BE.IT","B+",82),
("SUMAN","KUMAR",23,"MALE",2020,"MBA","B+",80),
("MALATHI","KUMARI",26,"FEMALE",2017,"BA,BL","O-",63),
("MANOJ","KUMAR",32,"MALE",2011,"B.SC","O+",69),
("RAJ","KUMAR",29,"MALE",2014,"BE.EEE","AB+",72),
("SUMATHI","SRI",25,"FEMALE",2018,"B.ED","B-",91),
("BOOPATHI","RAJA",22,"MALE",2021,"BE.IT","A+",60),
("SRI","KANTH",27,"MALE",2019,"BBA","O+",80),
("SOWMAYA","SRI",27,"FEMALE",2015,"BE.IT","A+",88),
("POOJA","SRI",21,"FEMALE",2022,"MBA","B+",65),
("DIVYA","NANDHAM",22,"MALE",2017,"CA","A-",78),
("RUBA","SRI",21,"FEMALE",2016,"BE.IT","AB-",55),
("DHARUN","BALA",28,"MALE",2019,"BE.CSE","O-",60),
("ARUL","TAMIL",26,"MALE",2018,"BE.EEE","O+",79),
("SURESH","KUMAR",21,"MALE",2022,"MCA","A-",56),
("ANANDH","RAJ",29,"MALE",2013,"CA","B-",83),
("NANDHA","KUMAR",30,"MALE",2014,"BE.MECH","AB+",95),
("RAJA","RAM",33,"MALE",2010,"B.SC","O+",78),
("RENUGA","DEVI",29,"FEMALE",2014,"BA","B+",90),
("MALAR","KOZHDI",31,"FEMALE",2013,"BCA","O+",87),
("RAVI","KRISHNAN",29,"MALE",2019,"BE.ECE","B-",85),
("KALAI","SELVAM",28,"MALE",2018,"BE.EEE","A+",89),
("MANI","KANDAN",26,"MALE",2015,"MCA","O-",75),
("SUNIL","KUMAR",34,"MALE",2011,"BE.IT","AB-",65),
("DIVYA","SRI",25,"FEMALE",2020,"BE.CSE","B+",86),
("SANTHOSH","KUMAR",25,"MALE",2018,"BE.EEE","O+",95),
("KAVIYA","MARAN",31,"FEMALE",2019,"MBA","A+",62),
("GOWTHAM","RAJ",27,"MALE",2016,"CA","AB-",55),
("PRAVEEN","KUMAR",23,"MALE",2015,"BBA","O+",78),
("SUSHMA","KUMARI",27,"FEMALE",2019,"BE.IT","AB-",64),
("PRIYA","ANANDH",32,"FEMALE",2019,"BA","B+",57),
("KIRUBHA","SRI",21,"FEMALE",2021,"MBA","O-",87),
("SIVA","SWAMY",26,"MALE",2019,"BE.EEE","B+",75);
-- commit;
SELECT * FROM STUDENTS;
-- select distinct(age) from students where age >=35 group by age;
-- delete from students where age >=35;
-- drop database xyz_university;

