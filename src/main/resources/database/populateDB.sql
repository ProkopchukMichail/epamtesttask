DELETE FROM employe;
DELETE FROM department;

COMMIT;

INSERT INTO department (departmentName) VALUES
  ('Administration'),
  ('IT'),
  ('Finance'),
  ('HR_DEPARTMENT');
COMMIT;


INSERT INTO employe ( departmentName, fullname, birthday, salary) VALUES
  ('Administration', 'admin1','1970-05-05 00:0:00',1000),
  ('Administration','admin2','1971-05-05 00:0:00',1050),
  ('IT','dev1','1990-01-01 00:0:00',700),
  ('IT','dev2','1991-02-02 00:0:00',1500),
  ('Finance', 'financier','1985-06-06 00:0:00',550),
  ('HR_DEPARTMENT','hr','1992-09-09 00:0:00',600);
