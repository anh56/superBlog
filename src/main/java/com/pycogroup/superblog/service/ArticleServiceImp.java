package com.pycogroup.superblog.service;

import com.pycogroup.superblog.model.Article;
import com.pycogroup.superblog.model.Category;
import com.pycogroup.superblog.model.QArticle;
import com.pycogroup.superblog.model.QCategory;
import com.pycogroup.superblog.repository.ArticleRepository;
import com.pycogroup.superblog.repository.CategoryRepository;
import com.querydsl.core.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class ArticleServiceImp implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article createArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Article categorizeArticle(Article article, String categoryName) {
		if (articleRepository.findById(article.getId()) != null){
			article.setCategory(categoryRepository.findByName(categoryName));
			articleRepository.save(article);
			return article;
		}
		else return null;
	}

	@Override
	public void updateArticle(Article article) {
			articleRepository.updateArticle(article);

	}

	@Override
	public void deleteArticle(Article article) {
		articleRepository.delete(article);
	}

	@Override
	public void deleteArticlesWithKey(String key) {
		QArticle qArticle = QArticle.article;
		Iterable<Article> articlesToDelete = articleRepository.findAll(qArticle.title.equalsIgnoreCase(key));
		articleRepository.deleteAll(articlesToDelete);
	}

}
