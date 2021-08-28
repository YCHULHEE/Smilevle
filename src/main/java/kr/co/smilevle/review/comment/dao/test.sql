drop table tbl_review_comment;
drop sequence review_comment_seq;

create table tbl_review_comment(
	comment_no number constraint comment_no_pk primary key,
	review_no number constraint comment_review_no_fk references tbl_review,
	writer_id varchar2(50) not null,   
	regdate varchar2(50) not null,
	content long not null);  

create sequence review_comment_seq;

select * from tbl_review_comment;

insert into tbl_review_comment values(2, 1, 'example123', to_char(sysdate + 9/24,'yyyy-mm-dd hh24:mi:ss'), '댓글 테스트입니다.2');
