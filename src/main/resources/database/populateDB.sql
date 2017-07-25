DELETE FROM employe;
DELETE FROM department;

COMMIT;

INSERT INTO department (departmentName) VALUES
  ('Administration'),
  ('IT'),
  ('Finance'),
  ('HR');
COMMIT;


INSERT INTO employe ( departmentName, fullname, birthday, salary) VALUES
  ('Administration', 'admin1','1970-05-05',1000),
  ('Administration','admin2','1971-05-05',1050),
  ('IT','dev1','1990-01-01',700),
  ('IT','dev2','1991-02-02',1500),
  ('Finance', 'financier','1985-06-06',550),
  ('HR','hr','1992-09-09',600);

COMMIT;