package com.pycogroup.superblog.service;

import com.pycogroup.superblog.model.Article;
import com.pycogroup.superblog.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    void postComment(Comment comment);
    void deleteCommentOfArticle(Comment comment);
    void deleteCommentByKey(String key);

}
