USE epam_testtask;
DELETE FROM employees;
DELETE FROM departments;

COMMIT;

INSERT INTO departments (id,departmentName) VALUES
  (1,'Administration'),
  (2,'IT'),
  (3,'Finance'),
  (4,'HR_DEPARTMENT');
COMMIT;


INSERT INTO employees (id, DEPARTMENT_ID, fullname, birthday, salary) VALUES
  (1,1, 'admin1','1970-05-05 00:0:00',1000),
  (2,1,'admin2','1971-05-05 00:0:00',1050),
  (3,2,'dev1','1990-01-01 00:0:00',700),
  (4,2,'dev2','1991-02-02 00:0:00',1500),
  (5,3, 'financier','1985-06-06 00:0:00',550),
  (6,4,'hr','1992-09-09 00:0:00',600);
COMMIT;
