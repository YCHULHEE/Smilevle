select * from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc);

select * 
			from (select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt, photo_url 
					from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc) 
						where rownum <= 8) 
			where rnum >= 1;
drop sequence review_seq;
create sequence review_seq;
select * from member;
select * from tbl_review;
select review_seq.nextVal from dual;
delete from tbl_review;