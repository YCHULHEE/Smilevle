create table review(
	review_no number not null primary key,
	writer_id varchar2(50) not null,
	writer_name varchar2(50) not null,
	title varchar2(255) not null,
	areacode varchar2(10) not null,
	location_name varchar2(255) not null,
	rate varchar2(10) not null,
	content long,
	regdate timestamp not null,
	moddate timestamp not null,
	read_cnt number
);

create sequence review_seq;

select * from review;