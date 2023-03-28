create database if not exists qlns ;
use qlns;

create table if not exists admins(
	adminID int PRIMARY KEY AUTO_INCREMENT,
	userAd varchar(10),
	passwordAd varchar(10)
);
INSERT INTO admins(userAd,passwordAd) VALUES 
	('admin','admin'),
	('huyn29','1');

create table if not exists departments(
	depID int NOT NULL PRIMARY KEY,
	depName varchar(30) NOT NULL,
	numberMember int NOT NULL,
	depManagerID INT
);

create table if not exists employees(
	empID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	empName varchar(40) NOT NULL,
	empPhone varchar(11),
	email varchar(30),
	salary decimal(10,2),
	managerID int,
	depID int,
	CONSTRAINT FK_employees_departments FOREIGN KEY (depID) REFERENCES departments(depID)
);
