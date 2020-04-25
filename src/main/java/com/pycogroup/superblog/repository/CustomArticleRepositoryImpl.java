package com.pycogroup.superblog.repository;

import com.pycogroup.superblog.model.Article;
import com.pycogroup.superblog.model.Category;
import com.pycogroup.superblog.model.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CustomArticleRepositoryImpl implements CustomArticleRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomArticleRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    @Override
    public void updateArticle(Article article) {
        Query query = new Query(Criteria.where("id").is(article.getId()));
        Update update = new Update();
        update.set("title", article.getTitle());
        update.set("author", article.getAuthor());
        update.set("categoryId", article.getCategory());
        update.set("removed", article.getRemoved());
        mongoTemplate.updateFirst(query, update, Category.class);
    }


}
