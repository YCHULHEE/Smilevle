select * from member;

create table article (
	article_no int auto_increment primary key,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
	title varchar(255) not null,
	regdate datetime not null,
	moddate datetime not null,
	read_cnt int);
	
	select last_insert_id() from article;

create table article_content (
	article_no int primary key,
	content text
)

select * from article_content;

select moddate from article;

delete from member;
<!-- limit 시작번호, 사이즈 -->
select * from article order by article_no desc limit 0, 4;


update article set moddate = now() where article_no = 1;



