DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;

CREATE TABLE departments
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  departmentName VARCHAR(45) NOT NULL UNIQUE
) ENGINE = InnoDB;


CREATE TABLE employees
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  department_id INT NOT NULL,
  fullname VARCHAR(45) NOT NULL,
  birthday DATE NOT NULL,
  salary INT(11) NOT NULL DEFAULT 500,
/*  KEY FK_10000 (department),*/
  CONSTRAINT FK_1 FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;



