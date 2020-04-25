package com.pycogroup.superblog.repository;

import com.pycogroup.superblog.model.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ArticleRepository extends MongoRepository<Article, ObjectId>,
                                            CustomArticleRepository,
                                            QuerydslPredicateExecutor<Article> {
    void removeByTitle(String title);
    void removeById(ObjectId id);

    void removeArticleByTitle(String title);


}
