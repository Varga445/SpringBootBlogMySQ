Pentru a creea o baza de date in MySQL am folosit :
To create a DB in MySQL I've used the following code:


CREATE DATABASE restapi;
USE restapi;
CREATE TABLE blog (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(45) NOT NULL,
  content VARCHAR(500) NOT NULL
);



REMEBER THAT IN THE application.properties file you must use your own USERNAME and PASSWORD (FOR THE MySQL DB)

FOR THE REST CLIENT I'M USING POSTMAN
