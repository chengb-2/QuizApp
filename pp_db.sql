CREATE DATABASE IF NOT EXISTS pp_db;
USE pp_db;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE IF NOT EXISTS User (
	id 			int auto_increment PRIMARY KEY,
    username 	varchar(42),
    password 	varchar(42),
    is_admin 	bool,
    is_active	bool,
    firstname	varchar(42),
    lastname	varchar(42),
    address		varchar(42),
    phone		varchar(42),
    email		varchar(42)
);

insert into User (username, password, is_admin, is_active, firstname, lastname, address, phone, email) values
("1", "1", true, true, "1", "1", "1", "1", "1");
-- ("andyb", "1234", true, true, "Andy", "Bao", "10th Ave", "1234567890", "cjbxb0302@gmail.com"),
-- ("zhangsan", "1234", false, true, "San", "Zhang", "9th Ave", "2234567890", "123@gmail.com");

CREATE TABLE IF NOT EXISTS Feedback (
	id 		int auto_increment PRIMARY KEY,
    message varchar(42),
    rating 	int,
    date 	timestamp
);

CREATE TABLE IF NOT EXISTS Contact (
	id 			int auto_increment PRIMARY KEY,
    firstname 	varchar(42),
    lastname 	varchar(42),
    message 	varchar(42)
);

CREATE TABLE IF NOT EXISTS Quiz (
	id 			int auto_increment PRIMARY KEY,
    quizname	varchar(42),
    category	varchar(42),
    username 	varchar(42),
    time_start 	timestamp,
    time_end	timestamp,
    score		int
);


CREATE TABLE IF NOT EXISTS quiz_question (
	id 				int auto_increment PRIMARY KEY,
    quiz_id 		int,
    question_id		int,
    user_choice_id	int
);


CREATE TABLE IF NOT EXISTS Question (
	id 			int auto_increment PRIMARY KEY,
    category	varchar(42),
    statement	varchar(42),
    is_active	bool
);

CREATE TABLE IF NOT EXISTS Choice (
	id 			int auto_increment PRIMARY KEY,
    question_id int,
    statement	varchar(42),
    is_correct	bool
);


insert into Question (category, statement, is_active) values
("Math", "0 + 1 = ?", true),
("Math", "0 + 2 = ?", true),
("Math", "0 + 3 = ?", true),
("Math", "0 + 4 = ?", true),
("Math", "0 + 5 = ?", true),
("Math", "0 + 6 = ?", true),
("Math", "0 + 7 = ?", true),
("Math", "0 + 8 = ?", true),
("Math", "0 + 9 = ?", true),
("Math", "1 + 0 = ?", true),
("Chemistry", "H is : ", true),
("Chemistry", "He is : ", true),
("Chemistry", "Li is : ", true),
("Chemistry", "Be is : ", true),
("Chemistry", "B is : ", true),
("Chemistry", "C is : ", true),
("Chemistry", "N is : ", true),
("Chemistry", "O is : ", true),
("Chemistry", "F is : ", true),
("Chemistry", "Ne is : ", true),
("Chemistry II", "Na is : ", true),
("Chemistry II", "Mg is : ", true),
("Chemistry II", "Al is : ", true),
("Chemistry II", "Si is : ", true),
("Chemistry II", "P is : ", true),
("Chemistry II", "S is : ", true),
("Chemistry II", "Cl is : ", true),
("Chemistry II", "Ar is : ", true),
("Chemistry II", "K is : ", true),
("Chemistry II", "Ca is : ", true);

-- insert into Choice (question_id, statement, is_correct) values
-- (1, "0 + 7 = ?", true),

insert into Choice (question_id, statement, is_correct) values
(1, "1", true),
(1, "2", false),
(1, "3", false),
(1, "4", false),
(2, "2", true),
(2, "3", false),
(2, "4", false),
(2, "5", false),
(3, "3", true),
(3, "4", false),
(3, "5", false),
(3, "6", false),
(4, "4", true),
(4, "5", false),
(4, "6", false),
(4, "7", false),
(5, "5", true),
(5, "6", false),
(5, "7", false),
(5, "8", false),
(6, "6", true),
(6, "7", false),
(6, "8", false),
(6, "9", false),
(7, "7", true),
(7, "8", false),
(7, "9", false),
(7, "10", false),
(8, "8", true),
(8, "9", false),
(8, "10", false),
(8, "11", false),
(9, "9", true),
(9, "10", false),
(9, "11", false),
(9, "12", false),
(10, "1", true),
(10, "2", false),
(10, "3", false),
(10, "4", false),
(11, "Hydrogen", true),
(11, "mumbo jumbo: 11-1", false),
(11, "mumbo jumbo: 11-2", false),
(11, "mumbo jumbo: 11-3", false),
(12, "Helium", true),
(12, "mumbo jumbo: 12-1", false),
(12, "mumbo jumbo: 12-2", false),
(12, "mumbo jumbo: 12-3", false),
(13, "Lithium", true),
(13, "mumbo jumbo: 13-1", false),
(13, "mumbo jumbo: 13-2", false),
(13, "mumbo jumbo: 13-3", false),
(14, "Beryllium", true),
(14, "mumbo jumbo: 14-1", false),
(14, "mumbo jumbo: 14-2", false),
(14, "mumbo jumbo: 14-3", false),
(15, "Boron", true),
(15, "mumbo jumbo: 15-1", false),
(15, "mumbo jumbo: 15-2", false),
(15, "mumbo jumbo: 15-3", false),
(16, "Carbon", true),
(16, "mumbo jumbo: 16-1", false),
(16, "mumbo jumbo: 16-2", false),
(16, "mumbo jumbo: 16-3", false),
(17, "Nitrogen", true),
(17, "mumbo jumbo: 17-1", false),
(17, "mumbo jumbo: 17-2", false),
(17, "mumbo jumbo: 17-3", false),
(18, "Oxygen", true),
(18, "mumbo jumbo: 18-1", false),
(18, "mumbo jumbo: 18-2", false),
(18, "mumbo jumbo: 18-3", false),
(19, "Fluorine", true),
(19, "mumbo jumbo: 19-1", false),
(19, "mumbo jumbo: 19-2", false),
(19, "mumbo jumbo: 19-3", false),
(20, "Neon", true),
(20, "mumbo jumbo: 20-1", false),
(20, "mumbo jumbo: 20-2", false),
(20, "mumbo jumbo: 20-3", false),
(21, "Sodium", true),
(21, "mumbo jumbo: 21-1", false),
(21, "mumbo jumbo: 21-2", false),
(21, "mumbo jumbo: 21-3", false),
(22, "Magnesium", true),
(22, "mumbo jumbo: 22-1", false),
(22, "mumbo jumbo: 22-2", false),
(22, "mumbo jumbo: 22-3", false),
(23, "Aluminium", true),
(23, "mumbo jumbo: 23-1", false),
(23, "mumbo jumbo: 23-2", false),
(23, "mumbo jumbo: 23-3", false),
(24, "Silicon", true),
(24, "mumbo jumbo: 24-1", false),
(24, "mumbo jumbo: 24-2", false),
(24, "mumbo jumbo: 24-3", false),
(25, "Phosphorus", true),
(25, "mumbo jumbo: 25-1", false),
(25, "mumbo jumbo: 25-2", false),
(25, "mumbo jumbo: 25-3", false),
(26, "Sulfur", true),
(26, "mumbo jumbo: 26-1", false),
(26, "mumbo jumbo: 26-2", false),
(26, "mumbo jumbo: 26-3", false),
(27, "Chlorine", true),
(27, "mumbo jumbo: 27-1", false),
(27, "mumbo jumbo: 27-2", false),
(27, "mumbo jumbo: 27-3", false),
(28, "Argon", true),
(28, "mumbo jumbo: 28-1", false),
(28, "mumbo jumbo: 28-2", false),
(28, "mumbo jumbo: 28-3", false),
(29, "Potassium", true),
(29, "mumbo jumbo: 29-1", false),
(29, "mumbo jumbo: 29-2", false),
(29, "mumbo jumbo: 29-3", false),
(30, "Calcium", true),
(30, "mumbo jumbo: 30-1", false),
(30, "mumbo jumbo: 30-2", false),
(30, "mumbo jumbo: 30-3", false);




















