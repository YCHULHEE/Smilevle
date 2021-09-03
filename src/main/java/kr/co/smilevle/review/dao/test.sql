select * from 
	(select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt
				from 
					(select * from tbl_review 
							  order by review_no desc) 
				where rownum <= ?)
	 where rnum >= ?;

select * from 
	(select rownum as rnum, review_no, writer_id, writer_name, title, areacode, location_name, rate, content, regdate, moddate, read_cnt, photo_url from 
					(select * from tbl_review rv natural join tbl_review_attach ac order by review_no desc) 
				where rownum <= 4)
	 where rnum >= 1;	 
	 
select * from tbl_review, tbl_review_attach where tbl_review.review_no = tbl_review_attach.review_no;