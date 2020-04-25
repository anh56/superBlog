package com.pycogroup.superblog.service;

import com.pycogroup.superblog.model.Article;

import java.util.List;

public interface ArticleService {
	List<Article> getAllArticles();
	Article createArticle(Article article);
	Article categorizeArticle(Article article, String categoryName);
	void updateArticle(Article article);
	void deleteArticle(Article article);
	void deleteArticlesWithKey(String key);


}
