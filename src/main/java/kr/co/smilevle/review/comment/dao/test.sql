drop table tbl_review_comment;
drop sequence review_comment_seq;

delete from TBL_REVIEW_COMMENT;

create table tbl_review_comment(
	comment_no number constraint comment_no_pk primary key,
	review_no number constraint comment_review_no_fk references tbl_review,
	writer_id varchar2(50) not null,   
	regdate timestamp not null,
	content long);  

create sequence review_comment_seq;

select * from tbl_review_comment;

insert into tbl_review_comment values(3, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.3');
insert into tbl_review_comment values(4, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.4');
insert into tbl_review_comment values(5, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.5');
insert into tbl_review_comment values(6, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.6');
insert into tbl_review_comment values(7, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.7');
insert into tbl_review_comment values(8, 61, 'example123', (systimestamp + 9/24), '댓글 테스트입니다.8');
