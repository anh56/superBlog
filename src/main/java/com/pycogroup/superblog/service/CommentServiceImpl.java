package com.pycogroup.superblog.service;

import com.pycogroup.superblog.model.Article;
import com.pycogroup.superblog.model.Comment;
import com.pycogroup.superblog.model.QArticle;
import com.pycogroup.superblog.model.QComment;
import com.pycogroup.superblog.repository.ArticleRepository;
import com.pycogroup.superblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void postComment(Comment comment) {
        commentRepository.save(comment);
    }


    @Override
    public void deleteCommentOfArticle(Comment comment) {
        commentRepository.delete(comment);
    }


    @Override
    public void deleteCommentByKey(String  key) {
        QComment qComment = QComment.comment;
        commentRepository.deleteAll((Iterable<? extends Comment>) qComment.content.contains(key));

    }
}
