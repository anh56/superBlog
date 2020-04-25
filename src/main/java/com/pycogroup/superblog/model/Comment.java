package com.pycogroup.superblog.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "comments")
@Builder
@QueryEntity
public class Comment {
    @Id
    @Getter
    private ObjectId id;


    @Getter
    @Setter
    private String content;


    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @DBRef
    private Article article;

    @Getter
    @Setter
    private Boolean removed = false;
}
