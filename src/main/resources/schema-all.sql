drop table people if exists;
create table people(
  id BIGINT IDENTITY NOT NULL PRIMARY KEY ,
  first_name VARCHAR (20),
  last_name varchar(20)
);

