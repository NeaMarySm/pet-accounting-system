DROP DATABASE IF EXISTS pet_accounting;
CREATE DATABASE pet_accounting;
USE pet_accounting;

DROP TABLE IF EXISTS animal_types;
CREATE TABLE animal_types(
	id INT AUTO_INCREMENT NOT NUll UNIQUE PRIMARY KEY,
	name VARCHAR(255) NOT NUll,
	animal_type ENUM('pet','pack')
);

INSERT INTO animal_types VALUES 
	(1, 'cat', 'pet'),
	(2, 'dog', 'pet'),
	(3, 'hamster', 'pet'),
	(4, 'camel', 'pack'),
	(5, 'donkey', 'pack'),
	(6, 'horse', 'pack');

DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id INT AUTO_INCREMENT NOT NUll UNIQUE PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255) NOT NUll,
	phone VARCHAR(255) NOT NUll,
	adress VARCHAR(255)
);
INSERT INTO owners VALUES 
(1, 'John', 'Baggins', '+29903432', 'New New York'),
(2, 'Vassily', 'Smith', '+139904312', 'Tokyo'),
(3, 'Eva', 'Adams', '+50003432', 'Athens'),
(4, 'Ignat', 'Zoidberg', '+99903432', 'Metropolis'),
(6, 'Olga', 'Grey', '+7890343342', 'Saratov'),
(7, 'Woo', 'Lee', '+1990343233', 'Dallas'),
(8, 'Colin', 'Mask', '+623903432', 'Narnia');

DROP TABLE IF EXISTS animals;
CREATE TABLE animals(
	id INT AUTO_INCREMENT NOT NUll UNIQUE PRIMARY KEY,
	name VARCHAR(255) NOT NUll,
	animal_type_id INT NOT NULL,
	birth_date DATE NOT NULL,
	gender ENUM('male','female','unknown'),
	owner_id INT NOT NULL,
	FOREIGN KEY (animal_type_id) references animal_types(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO animals VALUES 
(221, 'FIDO', 2, '2020-01-10', 'male', 1),
(222, 'GVIDO', 2, '2020-01-10', 'male', 1),
(223, 'WHISKERTON', 1, '2019-05-15', 'male', 6),
(224, 'HAMMY JOSEPH III', 3, '2021-03-10', 'unknown', 3),
(225, 'FINDUS', 1, '2023-02-20', 'male', 8),
(226, 'PUMBA', 3, '2021-08-03', 'female', 8),
(227, 'ASTRA', 2, '2023-04-11', 'female', 6),
(228, 'LILLY', 1, '2020-06-18', 'female', 4),
(229, 'SANDY', 4, '2015-07-21', 'female', 7),
(230, 'MUSTAFA', 4, '2018-12-12', 'male', 7),
(231, 'IKKY', 5, '2017-09-18', 'male', 4),
(232, 'DIZZY', 5, '2018-04-19', 'female', 8),
(233, 'BURITTO', 5, '2019-01-23', 'male', 8),
(234, 'MURKA', 6, '2019-01-23', 'female', 2),
(235, 'HUBERT', 6, '2020-08-25', 'male', 3),
(236, 'STORM 3000', 6, '2018-01-21', 'male', 6);
DROP TABLE IF EXISTS pets;
CREATE TABLE pets(
	animal_id INT NOT NULL UNIQUE,
	breed VARCHAR(255),
	color VARCHAR(255),
	`size` ENUM ('small','medium','big', 'standard'),
	PRIMARY KEY(animal_id),
	FOREIGN KEY (animal_id) references animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO pets VALUES 
(221, 'SHI-TSU', 'white', 'small'),
(222, 'SHI-TSU', 'white', 'small'),
(223, 'BRITISH', 'smoke-grey', 'standard'),
(224, 'CHINESE', 'white', 'standard'),
(225, 'MONGREL', 'brindle','standard'),
(226, 'CAMPBELL', 'brown', 'standard'),
(227, 'HUSKY', 'black-white', 'big'),
(228, 'SPHINX', 'beige', 'standard');

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals(
	animal_id INT NOT NULL UNIQUE,
	pack_size INT,
	max_load INT,
	hump_count INT,
	breed VARCHAR(255),
	PRIMARY KEY(animal_id),
	FOREIGN KEY (animal_id) references animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO pack_animals VALUES 
(229, 4, 250, 2, 'arabian'),
(230, 3, 200, 1, 'dromedar'),
(231, 1, 120, NULL, 'unknown'),
(232, 1, 100, NULL, 'unknown'),
(233, 1, 120, NULL, 'unknown'),
(234, 4, 90, NULL, 'arabian'),
(235, 4, 90, NULL, 'mustang'),
(236, 4, 90, NULL, 'arabian');
DROP TABLE IF EXISTS commands;
CREATE TABLE commands(
	id INT AUTO_INCREMENT NOT NUll UNIQUE PRIMARY KEY,
	command VARCHAR(255) NOT NUll
);
INSERT INTO commands VALUES 
(1, 'eat'),
(2, 'sleep'),
(3, 'purr'),
(4, 'scratch'),
(5, 'fetch'),
(6, 'play'),
(7, 'run in wheel'),
(8, 'carry load'),
(9, 'travel in desert'),
(10, 'transport goods'),
(11, 'gallop'),
(12, 'pull cart'),
(13, 'bark');

DROP TABLE IF EXISTS commands_animal_types;
CREATE TABLE commands_animal_types(
	command_id INT NOT NULL,
	animal_type_id INT NOT NULL,
	PRIMARY KEY (command_id, animal_type_id),
	FOREIGN KEY (command_id) references commands(id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (animal_type_id) references animal_types(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO commands_animal_types VALUES 
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(3,1),
(4,1),
(5,1),
(5,2),
(5,3),
(6,1),
(6,2),
(6,3),
(7,3),
(8,4),
(8,5),
(8,6),
(9,4),
(10,5),
(11,6),
(12,6),
(13,2);

DELETE FROM animals WHERE animal_type_id = 4;
SELECT 
	a.name as name, 
	a.birth_date as `date of birth`, 
	at2.name as `type`,
	o.last_name as owner,
	pa.max_load as `max load`
FROM
	animals a
JOIN
	animal_types at2 
ON 
	a.animal_type_id = at2.id 
JOIN 
	owners o 
ON
	a.owner_id = o.id 
JOIN 
	pack_animals pa 
ON
	a.id  = pa.animal_id;
CREATE OR REPLACE VIEW animals_full AS 
SELECT 
	a.name as name, 
	a.birth_date as date_of_birth, 
	at2.name as `type`,
	o.last_name as owner
FROM
	animals a
JOIN
	animal_types at2 
ON 
	a.animal_type_id = at2.id 
JOIN 
	owners o 
ON
	a.owner_id = o.id;
	
CREATE OR REPLACE VIEW young_animals AS 
SELECT 
	*,
	TIMESTAMPDIFF(MONTH, date_of_birth, CURDATE()) AS age_in_months
FROM 
	animals_full
HAVING
	age_in_months <= 36;
	
