--CREATE or replace view tbl_user_view as 
--select * from TBL_USER;

drop table tbl_user;

CREATE TABLE tbl_user (
	id varchar(40) not null,
	username varchar(45) not null,
	password varchar(45) not null
);