create database if not exists qlns ;
use qlns;
UPDATE departments SET 
create table if not exists admins(
	adminID int PRIMARY KEY AUTO_INCREMENT,
	userAd varchar(10),
	passwordAd VARCHAR(20)
);
INSERT INTO admins(userAd,passwordAd) VALUES 
	('admin','adminadmin1'),
	('huyn29','adminadmin2');

CREATE TABLE IF NOT EXISTS departments(
	depID int NOT NULL PRIMARY KEY,
	depName varchar(30) NOT NULL,
	numberMember int NOT NULL,
	depManagerID INT
);
INSERT INTO departments(depID, depName, numberMember) VALUES
(110, 'admin', 1),
(111, 'java', 25),
(112, 'web', 22),
(113, 'IT', 27),
(114, 'HR',29),
(115, 'python', 21);

CREATE TABLE IF NOT EXISTS employees(
	empID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	empName varchar(40) NOT NULL,
	empPhone varchar(11),
	email varchar(30),
	salary decimal(10,2),
	managerID int,
	depID int,
	CONSTRAINT FK_employees_departments FOREIGN KEY (depID) REFERENCES departments(depID)
);
INSERT INTO employees(empName,empPhone,email, salary) VALUES
('Nguyen Huy', '0972484389', 'huy@gmail.com', 13.2 ),
('Tran Truong', '0934484389', 'truong@gmail.com', 11.2 ),
('Nguyen Anh', '0975654589', 'danh@gmail.com', 12.7 ),
('Dao Anh', '0374584389', 'hanh@gmail.com', 13.5 ),
('Do Dang', '0974678549', 'dang@gmail.com', 11.9 );

UPDATE departments SET depID = NULL WHERE depID = 4;
