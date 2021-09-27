package com.smilevle.review.comment.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentVO {
	private Integer comment_no;
	private Date regdate;
	private Integer review_no;
	private String writer_id;
	private String content;
}
