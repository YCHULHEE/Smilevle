select * from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc);

select * 
			from (select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt, photo_url 
					from (select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc) 
						where rownum <= 2) 
			where rnum >= 1;