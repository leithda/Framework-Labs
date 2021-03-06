package cn.leithda.service;

import cn.leithda.entity.Article;
import cn.leithda.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 文章 Service
 */
@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public int add(Article article){
        return articleMapper.insert(article);
    }

    public int deleteById(Integer id){
        return articleMapper.deleteById(id);
    }

    public int updateById(Article article){
        return articleMapper.updateById(article);
    }

    public List<Article> findAll(){
        return articleMapper.selectList(null);
    }

    public Article findById(Integer id){
        return articleMapper.selectById(id);
    }





}
