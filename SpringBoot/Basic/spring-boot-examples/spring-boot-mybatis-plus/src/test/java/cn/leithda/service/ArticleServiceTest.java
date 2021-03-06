package cn.leithda.service;

import cn.leithda.SpringBootMybatisPlusApplication;
import cn.leithda.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMybatisPlusApplication.class)
class ArticleServiceTest {


    @Autowired
    private ArticleService articleService;

    @Test
    void add() {
        Article article = new Article();
        article.setTitle("Java编程思想");
        article.setContent("关于Java的编程技巧");
        articleService.add(article);

        Article article2 = new Article();
        article2.setTitle("Java从入门到放弃");
        article2.setContent("放弃吧");
        articleService.add(article2);
    }

    @Test
    void deleteById() {
        articleService.deleteById(2);
    }

    @Test
    void updateById() {
        Article article = new Article();
        article.setId(3);
        article.setTitle("Java从入门到放弃");
        article.setContent("我选择放弃");
        articleService.updateById(article);
    }

    @Test
    void findAll() {
        articleService.findAll().forEach(System.out::print);
    }

    @Test
    void findById() {
        Article art1 = articleService.findById(2);
        Article art2 = articleService.findById(3);
        System.out.println("art1: "+art1);
        System.out.println("art2: "+art2);
    }
}