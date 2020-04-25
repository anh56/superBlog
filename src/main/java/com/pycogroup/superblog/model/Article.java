package com.pycogroup.superblog.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
@Builder
@QueryEntity
public class Article {
	@Id
	@Getter
	private ObjectId id;

	@Getter
	@Setter
	private String title;


	@Getter
	@Setter
	private String content;

	@Getter
	@Setter
	@DBRef
	private User author;

	@Getter
	@Setter
	@DBRef
	private Category category;

	@Getter
	@Setter
	private Boolean removed = false;

}
