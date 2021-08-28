create table tbl_review_comment(
	comment_no number constraint comment_no_pk primary key,
	review_no number constraint comment_review_no_fk references tbl_review,
	writer_id varchar2(50) not null,   
	regdate timestamp not null,
	content long not null);  

create sequence review_comment_seq;

insert into tbl_review_comment values(1, 1, 'example123', systimestamp, '댓글 테스트입니다.');

select * from tbl_review_comment;
