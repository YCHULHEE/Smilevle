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
	private Integer commentNo;
	private Date regdate;
	private Integer reviewNo;
	private String writerId;
	private String content;
}
