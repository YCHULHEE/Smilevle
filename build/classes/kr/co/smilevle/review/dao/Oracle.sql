create table tbl_review(
	review_no number constraint review_no_pk primary key,
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

select * from tbl_review;

create table tbl_review_attach(
photo_no number constraint review_photo_no_pk primary key,
review_no number,
photo_url long
);

create sequence photo_seq;

alter table tbl_review_attach
	add foreign key (review_no)
	references tbl_review(review_no)
	on delete cascade;

// 리뷰 이의의 데이터 쿼리문
CREATE TABLE STAY (        
    "STAY_ID" NUMBER(12,0),
    "TITLE" VARCHAR2(600 BYTE),
    "AREACODE" VARCHAR2(10 BYTE),
    "ADDRESS" VARCHAR2(400 BYTE),
    "FIRST_IMAGE" VARCHAR2(100 BYTE),
    "CONTENT_ID" NUMBER(12,0),
    "MAP_X" VARCHAR2(30 BYTE),
    "MAP_Y" VARCHAR2(30 BYTE),
    "TEL" VARCHAR2(300 BYTE),
    "READ_CNT" NUMBER(*,0)
   );
   
CREATE TABLE TRAVEL_DEST(   
  TRAVEL_DEST_ID NUMBER(12)
, TITLE VARCHAR2(600 BYTE)
, AREACODE VARCHAR2(10 BYTE)
, ADDRESS VARCHAR2(400 BYTE)
, FIRST_IMAGE VARCHAR2(100 BYTE)
, CONTENT_ID NUMBER(12)
, MAP_X VARCHAR2(30 BYTE)
, MAP_Y VARCHAR2(30 BYTE)
, TEL VARCHAR2(300 BYTE)
, READ_CNT NUMBER(*, 0)
, CONTENT_TYPE_ID NUMBER(12)
);

create table member(
memberid varchar(50) primary key,
name varchar(50) not null,
password varchar(10) not null,
regdate timestamp not null,
email varchar(50) not null,
gender varchar(5) not null,
birthday varchar(12) not null,
phonenum varchar(15) not null
);

CREATE  SEQUENCE STAY_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 5000
CYCLE;

CREATE  SEQUENCE travel_dest_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 5000
CYCLE;



select * from member;

// 사용하지 않는 쿼리문

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
select * from review;