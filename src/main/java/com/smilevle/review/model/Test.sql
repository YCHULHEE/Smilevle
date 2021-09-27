select * from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc);

select * 
			from (select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt, photo_url 
					from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc) 
						where rownum <= 8) 
			where rnum >= 1;
drop sequence review_seq;
create sequence review_seq;
select * from member;
select * from tbl_review order by review_no desc;
select review_seq.nextVal from dual;
delete from tbl_review;

select * from tbl_review_comment;
insert into tbl_review_comment values (review_comment_seq.nextval, 77, 'example123', sysdate, '댓글테스트입니다2.');
select * from tbl_review_comment 
	where review_no = 78
	order by comment_no;
	
select count(*) from tbl_review where 1=1 and areacode=1;